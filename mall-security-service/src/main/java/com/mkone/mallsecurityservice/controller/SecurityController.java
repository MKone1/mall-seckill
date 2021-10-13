package com.mkone.mallsecurityservice.controller;

import com.mkone.ommonservice.constant.AuthConstant;
import com.mkone.ommonservice.constant.Oauth2TokenDto;
import com.mkone.ommonservice.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Map;

@RequestMapping("/oauth")
@RestController
public class SecurityController {
    @Resource
    TokenEndpoint tokenEndpoint;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public R postAccessToken(Principal principal,@RequestParam Map<String,String> map) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken token = tokenEndpoint.postAccessToken(principal, map).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(token.getValue())
                .refreshToken(token.getRefreshToken().getValue())
                .expiresIn(token.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
        return R.ok().setData(oauth2TokenDto);
    }

}
