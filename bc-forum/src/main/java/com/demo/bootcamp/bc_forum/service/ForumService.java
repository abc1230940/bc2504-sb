package com.demo.bootcamp.bc_forum.service;

import java.util.List;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;

public interface ForumService {
  List<UserDTO> getUsers();
  List<PostDTO> getPosts();
  List<CommentDTO> getComments();
}
