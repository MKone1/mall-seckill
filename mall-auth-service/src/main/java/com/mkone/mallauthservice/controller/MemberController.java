package com.mkone.mallauthservice.controller;

import com.mkone.mallauthservice.service.MemberService;
import com.mkone.ommonservice.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    /**
     * 模拟登录验证获取token
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(@RequestParam String username, @RequestParam String password) {
        return memberService.login(username, password);
    }
}

