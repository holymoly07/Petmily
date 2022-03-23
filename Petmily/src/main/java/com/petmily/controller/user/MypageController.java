package com.petmily.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petmily.dto.Membership;
import com.petmily.dto.Order;
import com.petmily.dto.PageInfo;
import com.petmily.dto.User;
import com.petmily.service.MembershipService;
import com.petmily.service.MyPageService;

@Controller
public class MypageController {
	@Autowired
	MyPageService myPageService;
	@Autowired
	HttpSession session;
	@Autowired
	MembershipService membershipService;
	
   // 로그인 -> 마이페이지_나의정보, 구독내역, 주문내역, 배송내역 조회
   @GetMapping(value = "/mypageinfo")
      public ModelAndView mypage(@ModelAttribute Membership mem, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
         ModelAndView mav = new ModelAndView("mypageinfo");
         String user_id = (String) session.getAttribute("user_id");
         PageInfo pageInfo = new PageInfo();
         try {     	 
        	User user = myPageService.myPageInfo(user_id);
        	List<Membership> rmem = membershipService.membershipList(user_id);
        	List<Order> orderList = myPageService.orderDetail(user_id, page, pageInfo);
            myPageService.userAddressModify(user);
            user = myPageService.myPageInfo(user_id);
            mem.setUser_id(user_id); // 유저객체 아이디
            mav.addObject("user", user);
            mav.addObject("rmem", rmem);
            mav.addObject("orderList", orderList);
            mav.addObject("pageInfo", pageInfo);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return mav;
      }


	// 마이페이지_유저 수정(Get)
	@GetMapping(value = "usermodify")
	public ModelAndView userInfo(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("usermodify");
		String user_id = (String) session.getAttribute("user_id");
		try {
			user = myPageService.myPageInfo(user_id);
			user.setUser_id(user_id); // 유저객체 아이디
			mav.addObject("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 마이페이지_유저 수정(Post)
	@PostMapping(value = "usermodify") 
	public String userModify(@ModelAttribute User user, Model model) {
		String user_id = (String) session.getAttribute("user_id");
		try {
			user.setUser_id(user_id); // 유저객체 아이디
			myPageService.userModify(user);
			user = myPageService.myPageInfo(user_id);
			model.addAttribute("user", user);
			return "redirect:/mypageinfo";
		} catch (Exception e) {
			e.printStackTrace();
			return "usermodify";
		}
	}

	// 마이페이지_배송지정보 수정
	@PostMapping(value = "mypageinfo")
	public ModelAndView userAddressModify(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("mypageinfo");
		String user_id = (String) session.getAttribute("user_id");
		try {
			user.setUser_id(user_id); // 유저객체 아이디
			myPageService.userAddressModify(user);
			user = myPageService.myPageInfo(user_id);
			mav.addObject("user", user);
			mav.setViewName("redirect:/mypageinfo");     //redirect 하면 수정하고 값을 가지고 옴
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("err");
		}
		return mav;
	}
}
	

