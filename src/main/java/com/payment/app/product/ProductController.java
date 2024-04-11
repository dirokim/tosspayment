package com.payment.app.product;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	
	@GetMapping("list")
	public void getlist(Model model) throws Exception {
		Random random = new Random();
		String orderid = "TEST_1234abc-"+random.nextInt(9999);
		System.out.println(orderid);
		model.addAttribute("orderid",orderid);
	}
}
