package com.demo.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.demo.bootcamp.bc_forum.dto.request.PostReqDTO;
import com.demo.bootcamp.bc_forum.dto.response.CommentResDTO;
import com.demo.bootcamp.bc_forum.dto.response.ForumResDTO;
import com.demo.bootcamp.bc_forum.dto.response.Post1ResDTO;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;

public interface ForumOperation {
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/jph/forum/DTO")
  List<ForumResDTO> getAllUsers();

  @GetMapping(value = "/jph/comments")
  List<CommentResDTO> getAllCommentsbyId(@RequestParam Long id);
  
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/users") 
  List<UserEntity> getUsers();

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/posts")
  List<PostEntity> getPosts();

  @ResponseStatus(value = HttpStatus.OK) // ! 暗示俾人聽我有用global exception handler
  @GetMapping(value = "/comments")
  List<CommentEntity> getComments();

  @GetMapping(value = "/users/{city}/city")
  UserEntity getUserByCity(@PathVariable String city);

  @PostMapping(value = "forum/user/{id}/post")
  PostEntity createPost(@PathVariable Long id, @RequestBody PostReqDTO postReqDTO);

  @GetMapping(value = "forum/user/{id}/posts")
  List<Post1ResDTO> getPostsByUserId(@PathVariable Long id);



}
