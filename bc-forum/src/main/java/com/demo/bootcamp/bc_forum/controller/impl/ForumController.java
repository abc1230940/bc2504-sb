package com.demo.bootcamp.bc_forum.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bootcamp.bc_forum.controller.ForumOperation;
import com.demo.bootcamp.bc_forum.dto.mapper.DTOMapper;
import com.demo.bootcamp.bc_forum.dto.request.PostReqDTO;
import com.demo.bootcamp.bc_forum.dto.response.CommentResDTO;
import com.demo.bootcamp.bc_forum.dto.response.ForumResDTO;
import com.demo.bootcamp.bc_forum.dto.response.Post1ResDTO;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.exception.SysError;
import com.demo.bootcamp.bc_forum.exception.UserNotFoundException;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.service.ForumService;

@RestController
public class ForumController implements ForumOperation {
  @Autowired
  private ForumService forumService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<ForumResDTO> getAllUsers() {
    // List<UserDTO> userDTOs = this.forumService.getUsers();
    // List<PostDTO> postDTOs = this.forumService.getPosts();
    // List<CommentDTO> commentDTOs = this.forumService.getComments();
    
    // List<ForumResDTO> forumResDTOs = new ArrayList<>();
    //   for (UserDTO userDTO : userDTOs) {
    //     List<PostResDTO> postResDTOs = new ArrayList<>();
    //       for (PostDTO postDTO : postDTOs) { 
    //         if (postDTO.getUserId() == userDTO.getId()) {
    //           List<Comment1ResDTO> comment1ResDTOs = new ArrayList<>();
    //             for (CommentDTO commentDTO : commentDTOs) {
    //               if (commentDTO.getPostId() == postDTO.getId()) {
    //                 Comment1ResDTO comment1ResDTO = this.dtoMapper.map(commentDTO);
    //                 comment1ResDTOs.add(comment1ResDTO);
    //               }
    //             }
    //             PostResDTO postResDTO = this.dtoMapper.map(postDTO, comment1ResDTOs);
    //             postResDTOs.add(postResDTO);
    //         }
    //       }
    //       ForumResDTO forumResDTO = this.dtoMapper.map(userDTO, postResDTOs);
    //       forumResDTOs.add(forumResDTO);
    //     }
    //     return forumResDTOs;
    //   }
    List<CommentEntity> commentEntities = this.forumService.getAllCommentEntities();
    Map<Long, ForumResDTO> userMap = new HashMap<>();
    for (CommentEntity commentEntity : commentEntities) {
     PostEntity postEntity = commentEntity.getPostEntity();
     UserEntity userEntity = postEntity.getUserEntity();
     if (!userMap.containsKey(userEntity.getId())) {
      // add entry ForumRepDTO (posts list + current comment)
     }
    }
    return new ArrayList<>(userMap.values());

  }
   

  // ! String的話先可以catch到userId係咪valid input
  // long uId = Long.ParseLong(userId); // conversion
  // 這裡不再用try catch -> Spring boot的特色


  @Override
  public List<CommentResDTO> getAllCommentsbyId(Long id) {
    if (id == null || id <= 0) {
      throw new UserNotFoundException(SysError.USER_NOT_FOUND);
    }
    List<UserDTO> userDTOs = this.forumService.getUsers();

    List<PostDTO> postDTOs = this.forumService.getPosts();
    List<CommentDTO> commentDTOs = this.forumService.getComments();
    List<CommentResDTO> commentResDTOs =
        userDTOs.stream().filter(u -> u.getId().equals(id)).map(u -> {
          List<Long> postIds = postDTOs.stream()
              .filter(post -> post.getUserId().equals(u.getId()))
              .map(postDTO -> postDTO.getId()).collect(Collectors.toList());
          List<CommentResDTO.Comment> comments = commentDTOs.stream()
              .filter(comment -> postIds.contains(comment.getPostId()))
              .map(c -> {
                return CommentResDTO.Comment.builder().name(c.getName())
                    .email(c.getEmail()).body(c.getBody()).build();
              }).collect(Collectors.toList());
          return CommentResDTO.builder().id(id).username(u.getUsername())
              .comments(comments).build();
        }).collect(Collectors.toList());
    return commentResDTOs;
  }

  @Override
  public List<UserEntity> getUsers() {
    return this.forumService.getAllUserEntities();
  }
  @Override
  public List<PostEntity> getPosts() {
    return this.forumService.getAllPostEntities();
  }
  @Override
  public List<CommentEntity> getComments() {
    return this.forumService.getAllCommentEntities();
  }

  @Override
  public UserEntity getUserByCity(String city) {
    Optional<UserEntity> userEntity = this.forumService.findUserByCity(city);
    if (userEntity.isPresent()) {
      return userEntity.get();
    }
    return null;
  }

  @Override
  public PostEntity createPost(Long id, PostReqDTO postReqDTO) {
    return this.forumService.create(id, postReqDTO);
  }

  @Override
  public List<Post1ResDTO> getPostsByUserId(Long id) {
    List<PostEntity> postEntities = this.forumService.findPostsByUserid(id);
    List<Post1ResDTO> post1ResDTOs = new ArrayList<>();
    for (PostEntity postEntity : postEntities) {
      post1ResDTOs.add(this.dtoMapper.map(postEntity));
    }
    return post1ResDTOs;
      
    
  }

}

