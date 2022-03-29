package com.fis.spring.demoaccountspringjpa.controller;


import com.fis.spring.demoaccountspringjpa.service.IntergrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration")
public class IntergrationController {
    @Autowired
    IntergrationService intergrationService;
    @GetMapping("/getAllAcount")
    @ResponseBody
    public ResponseEntity<?> getAllAccount(){
        return ResponseEntity.ok(intergrationService.getAllAccount());
    }
}
