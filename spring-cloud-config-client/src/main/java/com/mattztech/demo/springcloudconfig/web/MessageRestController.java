package com.mattztech.demo.springcloudconfig.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

  @Value("${user.password:notthere}")
  private String password;

  @GetMapping("/message")
  public String getMessage() {
    return "The encrypted password is: " + this.password;
  }
}
