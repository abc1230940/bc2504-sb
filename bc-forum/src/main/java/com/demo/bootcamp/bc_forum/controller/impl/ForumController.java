package com.demo.bootcamp.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.bc_forum.controller.ForumOperation;
import com.demo.bootcamp.bc_forum.dto.CommentResDTO;
import com.demo.bootcamp.bc_forum.dto.ForumResDTO;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.service.ForumService;

@RestController
public class ForumController implements ForumOperation {
  @Autowired
  private ForumService forumService;

  @Override
  public List<ForumResDTO> getAllUsers() {
    List<UserDTO> userDTOs = this.forumService.getUsers();
    List<PostDTO> postDTOs = this.forumService.getPosts();
    List<CommentDTO> commentDTOs = this.forumService.getComments();
    List<ForumResDTO> forumResDTOs = userDTOs.stream()
                                      .map(u -> {
                                        ForumResDTO.Address.Geo geo = ForumResDTO.Address.Geo.builder()
                                                                                              .lat(u.getAddress().getGeo().getLat())
                                                                                              .lng(u.getAddress().getGeo().getLng())
                                                                                              .build();
                                        ForumResDTO.Address address = ForumResDTO.Address.builder()
                                                                                          .street(u.getAddress().getStreet())
                                                                                          .suite(u.getAddress().getSuite())
                                                                                          .city(u.getAddress().getCity())
                                                                                          .zipcode(u.getAddress().getZipcode())
                                                                                          .geo(geo)
                                                                                          .build();
                                        List<ForumResDTO.Post> posts = postDTOs.stream()
                                                                        .filter(post -> post.getUserId().equals(u.getId()))
                                                                        .map(p -> {
                                                                          List<ForumResDTO.Post.Comment> comments = commentDTOs.stream()
                                                                                                                                .filter(comment -> comment.getPostId().equals(p.getId()))
                                                                                                                                .map(c -> {
                                                                                                                                  return ForumResDTO.Post.Comment.builder().id(c.getId()).name(c.getName()).email(c.getEmail()).body(c.getBody()).build();
                                                                                                                                })
                                                                                                                                .collect(Collectors.toList());
                                                                          return ForumResDTO.Post.builder().id(p.getId()).title(p.getTitle()).body(p.getBody()).comments(comments).build();
                                                                          })
                                                                          .collect(Collectors.toList());
                                        return ForumResDTO.builder().id(u.getId()).name(u.getName()).username(u.getUsername()).email(u.getEmail()).address(address).posts(posts).build();
                                        })
                                        .collect(Collectors.toList());
  return forumResDTOs;
  }

  @Override
  public List<CommentResDTO> getAllCommentsbyId(Long id) {
    if (id == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    List<UserDTO> userDTOs = this.forumService.getUsers();
    
    List<PostDTO> postDTOs = this.forumService.getPosts();
    List<CommentDTO> commentDTOs = this.forumService.getComments();
    List<CommentResDTO> commentResDTOs = userDTOs.stream()
                                          .filter(u -> u.getId().equals(id))
                                          .map(u -> {
                                            List<Long> postIds = postDTOs.stream()
                                                                    .filter(post -> post.getUserId().equals(u.getId()))
                                                                    .map(postDTO -> postDTO.getId())
                                                                    .collect(Collectors.toList());
                                            List<CommentResDTO.Comment> comments = commentDTOs.stream()
                                                                                    .filter(comment -> postIds.contains(comment.getPostId()))
                                                                                    .map(c -> {
                                                                                      return CommentResDTO.Comment.builder().name(c.getName()).email(c.getEmail()).body(c.getBody()).build();
                                          })
                                          .collect(Collectors.toList());
                                          return CommentResDTO.builder().id(id).username(u.getUsername()).comments(comments).build();
                                          })
                                          .collect(Collectors.toList());
  return commentResDTOs;                                        
  }
}
