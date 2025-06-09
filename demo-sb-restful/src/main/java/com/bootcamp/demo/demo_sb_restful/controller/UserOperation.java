package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_sb_restful.dto.UserResDTO;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;

public interface UserOperation {
  @GetMapping(value ="/jph/users")
  List<UserDTO> getUsers();
  
  @GetMapping(value = "/jph/users/DTO")
  List<UserResDTO> getUsers2();
}
