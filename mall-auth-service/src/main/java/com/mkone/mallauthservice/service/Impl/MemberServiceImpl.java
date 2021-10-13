package com.mkone.mallauthservice.service.Impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallauthservice.service.AuthGetAccessTokenService;
import com.mkone.mallauthservice.service.MemberService;
import com.mkone.ommonservice.constant.AuthConstant;
import com.mkone.ommonservice.dao.UmsMemberDao;
import com.mkone.ommonservice.entity.UmsMember;
import com.mkone.ommonservice.util.R;
import com.rabbitmq.client.impl.AMQImpl;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
@Slf4j
@Service("MemberService")
public class MemberServiceImpl  extends ServiceImpl<UmsMemberDao, UmsMember> implements MemberService{
    @Autowired
    AuthGetAccessTokenService authGetAccessTokenService;
    @Override
    public R login(String username, String password) {
        if (StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
            return R.error("用户名/密码不能为空");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("client_id", AuthConstant.PORTAL_CLIENT_ID);
        map.put("client_secret","123456");
        map.put("grant_type","password");
        map.put("username",username);
        map.put("password",password);
        //调用远程访问Feign Auth模块


        return null;
    }
}
