
  package com.mvc.jpa;
  
  import org.springframework.stereotype.Controller; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.RequestMapping;
  
  @Controller
  
  @RequestMapping("/") public class JpaPageController {
  
  @GetMapping("/tablerequest") public String tablerequest() { return
  "/user/tablerequest"; }
  
  @GetMapping("/tableresult") public String tableresult() { return
  "/user/tableresult"; }
  
  @GetMapping("/tabletrying") public String tabletrying() { return
  "/user/tabletrying"; }
  
  @GetMapping("/login") public String login() { return "/user/login"; }
  
  @GetMapping("/register") public String register() { return "/user/register";
  }
  
  @GetMapping("/password") public String password() { return "/user/password";
  }
  
  @GetMapping("/admin") public String admin() { return "/user/admin"; }
  
  }
 