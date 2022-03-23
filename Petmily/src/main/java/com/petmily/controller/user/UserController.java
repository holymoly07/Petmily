package com.petmily.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petmily.dto.Mail;
import com.petmily.dto.Membership;
import com.petmily.dto.User;
import com.petmily.service.MailService;
import com.petmily.service.MembershipService;
import com.petmily.service.UserService;

@Controller
public class UserController {

	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	@Autowired
	MembershipService membershipService;

	@PostMapping("join")
	public ModelAndView join(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView();
		Mail mail = new Mail();
		try {
			userService.makeUser(user);
			user = userService.accessUser(user.getUser_id(), user.getUser_pwd());
			if (user.getUser_type().equals("normal")) {
				mailService.joinMailSend(mail, user);
				System.out.println("메일전송성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("메일전송실패");
		}
		mav.setViewName("redirect:/");
		return mav;
	}

	@PostMapping("login")
	public ModelAndView login(@RequestParam String user_id, @RequestParam String user_pwd) {
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		try {
			User tmp = userService.accessUser(user_id, user_pwd);
			Membership memSilver = membershipService.getMembershipByidSilver(user_id);
			Membership memGold = membershipService.getMembershipByidGold(user_id);
			session.setAttribute("user_id", tmp.getUser_id());
			session.setAttribute("user_type", tmp.getUser_type());
			map.put("user_type", tmp.getUser_type());
			map.put("user_id", tmp.getUser_id());
			mav.addObject("userMap", map);
			mav.setViewName("redirect:/");
			System.out.println("로그인 성공");
			if (tmp.getUser_type().equals("admin")) {
				mav.setViewName("redirect:/admin_alluser");
			}
			try {
				if (memSilver.getMem_grade().equals("silver")) {
					membershipService.updateDateSilver(user_id);
				}
			} catch (NullPointerException e) {
			}
			try {
				if (memGold.getMem_grade().equals("gold")) {
					membershipService.updateDateGold(user_id);
				}
			} catch (NullPointerException e) {
			}
		}
		catch (Exception e) {
			mav.setViewName("login");
			e.printStackTrace();
			/* System.out.println("실패 뚜둥"); */
		}
		mav.setViewName("redirect:/");
		return mav;
	}

	@GetMapping("logout")
	public String logout() {
		session.removeAttribute("user_id");
		session.removeAttribute("user_type");
		System.out.println("로그아웃");
		return "redirect:/";
	}
	@ResponseBody
	@PostMapping(value = "/idoverlap")
	public String idOverlap(@RequestParam(value = "user_id") String user_id) {
		String result = null;
		try {
			if (!userService.userOverlapbyId(user_id)) {
				System.out.println(user_id);
				result = "false";
			} else {
				result = "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@ResponseBody
	@PostMapping(value = "/emailoverlap")
	public String emailOverlap(@RequestParam(value = "user_email") String user_email) {
		String result = null;
		try {
			if (!userService.userOverlapbyEmail(user_email)) {
				System.out.println(user_email);
				result = "false";
			} else {
				result = "true";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	// 미구현
	@RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
		System.out.println("#########" + code);
		String access_Token = userService.getAccessToken(code);
		HashMap<String, Object> userInfo = userService.getUserInfo(access_Token);
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		return "/kakaologin";
	}

	
	// 미구현
	// 지우지말아주세요
	@RequestMapping(value = "naverlogin", method = RequestMethod.GET)
	public String callBack() {
		return "naverlogin";
	}

}
