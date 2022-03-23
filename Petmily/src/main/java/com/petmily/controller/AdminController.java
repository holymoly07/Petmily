package com.petmily.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petmily.dto.Admin;
import com.petmily.dto.PageInfo;
import com.petmily.dto.Product;
import com.petmily.dto.User;
import com.petmily.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminservice;

	@Autowired 
	ServletContext servletContext;

	@GetMapping(value = "/admin_membership")
	public String admin_membership(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model, @RequestParam(value = "mem_text", defaultValue = "") String mem_text) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Admin> admin = adminservice.membershipList(page, pageInfo, mem_text);
			model.addAttribute("mem_text", mem_text);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin", admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_membership";
	}

	@PostMapping(value = "UpdateMemStatus")
	public String updateMemStatus(@RequestParam Map<String,Object> map,@RequestParam(value = "ordercheck[]")String[] ordercheck) {
		try {
			map.put("array", ordercheck);
			adminservice.updateMemStatus(map);
			return "redirect:/admin_membership";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_membership";
	}
	
	
	@GetMapping(value = "/admin_product")
	public String admin_product(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model, @RequestParam(value = "search_prod", defaultValue = "") String search_prod) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Product> admin_product = adminservice.productList(page, pageInfo, search_prod);
			model.addAttribute("search_prod", search_prod);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin_product", admin_product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_product";
	}

	@GetMapping(value = "/admin_inventory")
	public String admin_inventory(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model, @RequestParam(value = "search_inven", defaultValue = "") String search_inven) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Product> admin_inventory = adminservice.inventoryList(page, pageInfo, search_inven);
			model.addAttribute("search_inven", search_inven);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin_inventory", admin_inventory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_inventory";
	}

	@GetMapping(value = "/admin_product_write")
	public String admin_product_write() {
		return "/admin_product_write";
	}

	@PostMapping(value = "/admin_product_write")
	public String product_write(@ModelAttribute Product product) {
		try {
			if (product.getFile().isEmpty()) {
				System.out.println("이미지를 등록해 주세요");
			} else {
				String path = servletContext.getRealPath("/upload/");
				File destFile = new File(path + product.getFile().getOriginalFilename());
				product.setProd_img(product.getFile().getOriginalFilename());
				product.getFile().transferTo(destFile);
				adminservice.productwrite(product);
				return "redirect:/admin_product";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_product_write";
	}

	@GetMapping(value = "/admin_product_modify")
	public String admin_product_modify(Model model, @RequestParam(value = "prod_num", required = false) int prod_num) {
		try {
			Product modi = adminservice.productDetail(prod_num);
			model.addAttribute("modi", modi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_product_modify";
	}

	@PostMapping(value = "/admin_product_modify")
	public String admin_product_modify(@ModelAttribute Product product) {
		try {
			adminservice.modifyproduct(product);
			return "redirect:/admin_product";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/admin_product";
	}

	@GetMapping(value = "admin_product_delete")
	public String admin_product_delete(@RequestParam(value = "prod_num", required = false) int prod_num) {
		try {
			adminservice.productDelete(prod_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_product";
	}

	@GetMapping(value = "/admin_order")
	public String admin_order(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model,
			@RequestParam(value = "search_text", defaultValue = "") String search_text) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Admin> admin_order = adminservice.orderList(page, pageInfo, search_text);
			model.addAttribute("search_text", search_text);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin_order", admin_order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_order";
	}
	

	@PostMapping(value="add_amount")
	public String add_amount(@ModelAttribute Product product) {
		try {
			adminservice.addAmount(product);
			return "redirect:/admin_inventory";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_inventory";
	}

	@PostMapping(value = "updateOrderStatus")
	public String updateOrderStatus(@RequestParam Map<String,Object> map,@RequestParam(value = "ordercheck[]")int[] ordercheck) {
		try {
			map.put("array", ordercheck);
			adminservice.updateOrderStatus(map);
			return "redirect:/admin_order";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin_order";
	}
	
	@GetMapping(value ="/admin_ship")
	public String admin_ship (@RequestParam(value="page", required=false, defaultValue="1")int page, Model model,
			@RequestParam(value = "search_text",defaultValue="")String search_text ) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Admin> admin_ship = adminservice.shipList(page,pageInfo,search_text);
			model.addAttribute("search_text", search_text);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin_ship", admin_ship);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_ship";
	}	
	
	@GetMapping(value ="/admin_mem_ship")
	public String admin_mem_ship (@RequestParam(value="page", required=false, defaultValue="1")int page, Model model,
			@RequestParam(value = "search_text",defaultValue="")String search_text ) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<Admin> admin_mem_ship = adminservice.memshipList(page,pageInfo,search_text);
			model.addAttribute("search_text", search_text);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("admin_mem_ship", admin_mem_ship);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_mem_ship";
	}	
	
	@GetMapping(value ="/admin_alluser")
	public String admin_alluser (@RequestParam(value="page", required=false, defaultValue="1")int page, Model model,
			@RequestParam(value = "mem_text",defaultValue="")String mem_text ) {
		PageInfo pageInfo = new PageInfo();
		try {
			List<User> user = adminservice.alluserList(page,pageInfo,mem_text);
			model.addAttribute("mem_text", mem_text);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin_alluser";
	}	
}
