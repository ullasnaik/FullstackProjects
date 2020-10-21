package com.stackroute.fitnesszone.userservice.security;

import com.stackroute.fitnesszone.userservice.entity.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String, String> generateToken(User user);
}
