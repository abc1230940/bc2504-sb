package com.bootcamp.demo.demo_sb_restful.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restful.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = new RestTemplate().getForObject(url, UserDTO[].class);
    return Arrays.asList(dtos);
  }
}
