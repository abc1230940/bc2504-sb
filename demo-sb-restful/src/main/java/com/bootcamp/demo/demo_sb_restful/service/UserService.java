package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;

public interface UserService {
  List<UserDTO> getUsers();
}
