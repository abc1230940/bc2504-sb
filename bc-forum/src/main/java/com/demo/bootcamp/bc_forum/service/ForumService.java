package com.demo.bootcamp.bc_forum.service;

import java.util.List;
import java.util.Optional;
import com.demo.bootcamp.bc_forum.dto.request.PostReqDTO;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;

public interface ForumService {
  List<UserDTO> getUsers();
  List<PostDTO> getPosts();
  List<CommentDTO> getComments();

  // ! fetch data from external API -> Entity -> 不需要人入任何一個id
  List<UserEntity> saveAllUsers(List<UserDTO> userDTOs);
  List<PostEntity> saveAllPosts(List<PostDTO> postDTOs);
  List<CommentEntity> saveAllComments(List<CommentDTO> commentDTOs);

  List<UserEntity> getAllUserEntities();
  List<PostEntity> getAllPostEntities();
  List<CommentEntity> getAllCommentEntities();
  Optional<UserEntity> findUserByID(Long id);
  Optional<UserEntity> findUserByCity(String city);
  List<PostEntity> findPostsByUserid(Long id);

  PostEntity create(Long id, PostReqDTO postReqDTO);



}
