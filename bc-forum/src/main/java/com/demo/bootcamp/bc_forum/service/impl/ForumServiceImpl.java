package com.demo.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = new RestTemplate().getForObject(url, UserDTO[].class);
    return Arrays.asList(dtos);
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] dtos = new RestTemplate().getForObject(url, PostDTO[].class);
    return Arrays.asList(dtos);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] dtos = new RestTemplate().getForObject(url, CommentDTO[].class);
    return Arrays.asList(dtos);
  }
  
}
