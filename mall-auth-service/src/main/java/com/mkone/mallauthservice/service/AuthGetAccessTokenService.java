package com.mkone.mallauthservice.service;

import com.mkone.ommonservice.util.R;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AuthGetAccessTokenService {
   R getAccessToken(Map<String,Object> params);
}
