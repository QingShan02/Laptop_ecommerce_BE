package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.Config;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping
    public String payment(
        @RequestParam("vnp_Version") Optional<String> vnp_Version,
        @RequestParam("vnp_Command") Optional<String> vnp_Command,
        @RequestParam("vnp_TmnCode") Optional<String> vnp_TmnCode,
        @RequestParam("vnp_Amount") Optional<String> vnp_Amount,
        @RequestParam("vnp_CurrCode") Optional<String> vnp_CurrCode,
        @RequestParam("vnp_TxnRef") Optional<String> vnp_TxnRef,
        @RequestParam("vnp_OrderInfo") Optional<String> vnp_OrderInfo,
        @RequestParam("vnp_OrderType") Optional<String> vnp_OrderType,
        @RequestParam("vnp_Locale") Optional<String> vnp_Locale,
        @RequestParam("vnp_ReturnUrl") Optional<String> vnp_ReturnUrl,
        @RequestParam("vnp_CreateDate") Optional<String> vnp_CreateDate,
        @RequestParam("vnp_ExpireDate") Optional<String> vnp_ExpireDate,
        @RequestParam("vnp_Bill_Mobile") Optional<String> vnp_Bill_Mobile,
        @RequestParam("vnp_Bill_Email") Optional<String> vnp_Bill_Email,
        @RequestParam("vnp_Bill_FirstName") Optional<String> vnp_Bill_FirstName,
        @RequestParam("vnp_Bill_LastName") Optional<String> vnp_Bill_LastName,
        @RequestParam("vnp_Bill_Address") Optional<String> vnp_Bill_Address,
        @RequestParam("vnp_Bill_City") Optional<String> vnp_Bill_City,
        @RequestParam("vnp_Bill_Country") Optional<String> vnp_Bill_Country,
        @RequestParam("vnp_Bill_State") Optional<String> vnp_Bill_State,
        @RequestParam("vnp_Inv_Phone") Optional<String> vnp_Inv_Phone,
        @RequestParam("vnp_Inv_Email") Optional<String> vnp_Inv_Email,
        @RequestParam("vnp_Inv_Customer") Optional<String> vnp_Inv_Customer,
        @RequestParam("vnp_Inv_Address") Optional<String> vnp_Inv_Address,
        @RequestParam("vnp_Inv_Company") Optional<String> vnp_Inv_Company,
        @RequestParam("vnp_Inv_Taxcode") Optional<String> vnp_Inv_Taxcode,
        @RequestParam("vnp_Inv_Type") Optional<String> vnp_Inv_Type
    ) throws UnsupportedEncodingException {
        String queryUrl = "";
        String vnp_SecureHash = "";
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version.get());
        vnp_Params.put("vnp_Command", vnp_Command.get());
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode.get());
        vnp_Params.put("vnp_Amount", vnp_Amount.get());
        vnp_Params.put("vnp_CurrCode", vnp_CurrCode.get());
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef.get());
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo.get());
        vnp_Params.put("vnp_OrderType", vnp_OrderType.get());
        vnp_Params.put("vnp_Locale", vnp_Locale.get());
        vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl.get());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate.get());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate.get());
        vnp_Params.put("vnp_Bill_Mobile", vnp_Bill_Mobile.get());
        vnp_Params.put("vnp_Bill_Email", vnp_Bill_Email.get());
        // Build data to hash and querystring
        List fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                // Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                // Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }

        queryUrl = query.toString();
        vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }
}