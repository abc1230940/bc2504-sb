package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.UserOperation;
import com.bootcamp.demo.demo_sb_restful.dto.UserResDTO;
import com.bootcamp.demo.demo_sb_restful.dto.UserResDTO.Address;
import com.bootcamp.demo.demo_sb_restful.dto.UserResDTO.Address.Geo;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restful.service.UserService;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  @Override
  public List<UserDTO> getUsers() {
    return this.userService.getUsers();
  }

  @Override
  public List<UserResDTO> getUsers2() {
    List<UserResDTO> resDTOs = this.userService.getUsers().stream()
                                .map(u -> {
                                  Geo geo = UserResDTO.Address.Geo.builder().lat(u.getAddress().getGeo().getLat()).lng(u.getAddress().getGeo().getLng()).build();
                                  Address address = UserResDTO.Address.builder().street(u.getAddress().getStreet()).suite(u.getAddress().getSuite()).city(u.getAddress().getCity()).zipcode(u.getAddress().getZipcode()).geo(geo).build();
                                  return UserResDTO.builder().name(u.getName()).username(u.getUsername()).email(u.getEmail()).address(address).build();
                                }).collect(Collectors.toList());
    return resDTOs;
  }
}
