package com.mattztech.demo.springcloudconfig.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

  @Value("${user.password:notfound}")
  private String password;

  @Value("${message:notfound}")
  private String message;

  @GetMapping("/message")
  public String getMessage() {
    return "The encrypted password is: " + this.password + " and message is " + message;
  }
}
