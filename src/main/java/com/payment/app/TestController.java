package com.payment.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/")
	public String test () throws Exception {
		Map<String,Object> map =  new HashMap<String, Object>();
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("3",3);
		map.put("1",1);
		map.put("2", map2);
		System.out.println(map);
		System.out.println(map.get("2"));
		return "index";
	}
}
