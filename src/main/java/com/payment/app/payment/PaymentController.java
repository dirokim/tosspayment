package com.payment.app.payment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/payment/*")
@Slf4j
public class PaymentController {
	
	@Value("${payments.secret.key}")
	private String secretkey;
	@Value("${payments.client.key}")
	private String clientkey;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("confirm")
    public ResponseEntity<JSONObject> confirmPayment(@RequestBody String jsonBody) throws Exception {
        JSONParser parser = new JSONParser();
        String orderId;
        String amount;
        String paymentKey ;
        try {
            // 클라이언트에서 받은 JSON 요청 바디.
            JSONObject requestData = (JSONObject) parser.parse(jsonBody);
            paymentKey = (String) requestData.get("paymentKey"); //페이먼트 키
            orderId = (String) requestData.get("orderId");     //주문번호
            amount = (String) requestData.get("amount");  	   //금액
        } catch (ParseException e) {
            throw new RuntimeException(e);
        };
        JSONObject obj = new JSONObject();
        obj.put("orderId", orderId);
        obj.put("amount", amount);
        obj.put("paymentKey", paymentKey);
        String widgetSecretKey = secretkey;
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);
        URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);        
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(obj.toString().getBytes("UTF-8"));

        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;    //200 성공 
        System.out.println(code);
        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();
        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8); 	
        JSONObject	jsonObject = (JSONObject) parser.parse(reader);
        System.out.println(jsonObject.get("orderId"));
        System.out.println(jsonObject.get("amount"));
        System.out.println(jsonObject.get("paymentKey"));
        System.out.println(jsonObject.get("orderName"));
        System.out.println(jsonObject.get("requestedAt"));
        System.out.println(jsonObject.get("approvedAt"));
        responseStream.close();
        return ResponseEntity.status(code).body(jsonObject);
    }

    
    @GetMapping("success")
    public String paymentRequest(HttpServletRequest request, Model model) throws Exception {
        return "/payment/success";
    }

    

    @GetMapping("checkout")
    public String index(HttpServletRequest request, Model model) throws Exception {	
    	Random random = new Random();
    	String customerkey = "00c6c9-842956@"+ random.nextInt(999999);
    	String orderId = request.getParameter("orderId");
    	System.out.println(orderId);
    	String amount = request.getParameter("amount");
    	model.addAttribute("amount",amount); 
    	model.addAttribute("odrdeid",orderId);
    	model.addAttribute("customerkey","KTdYYwZjUp8sTL9WYhs_d");
    	model.addAttribute("clientkey",clientkey);
        return "/payment/checkout";
    }

 
    @GetMapping("/fail")
    public String failPayment(HttpServletRequest request, Model model) throws Exception {
        String failCode = request.getParameter("code");
        String failMessage = request.getParameter("message");
        return "/payment/fail";
    }
}