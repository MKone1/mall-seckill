package com.mkone.mallauthservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.entity.UmsMember;
import com.mkone.ommonservice.util.R;
import org.springframework.stereotype.Service;

@Service
public interface MemberService extends IService<UmsMember> {
    /**
     * 模拟登录获取token
     * @param username
     * @param password
     * @return
     */
    R login(String username, String password);
}
