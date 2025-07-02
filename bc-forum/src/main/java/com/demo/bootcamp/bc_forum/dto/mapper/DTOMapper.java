package com.demo.bootcamp.bc_forum.dto.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_forum.dto.response.Comment1ResDTO;
import com.demo.bootcamp.bc_forum.dto.response.CommentResDTO;
import com.demo.bootcamp.bc_forum.dto.response.ForumResDTO;
import com.demo.bootcamp.bc_forum.dto.response.Post1ResDTO;
import com.demo.bootcamp.bc_forum.dto.response.PostResDTO;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;

// ! Utility
@Component // 將自己class變成bean
// @Configuration -> 將公用好出名好有功能的class轉成bean
public class DTOMapper {

  public ForumResDTO map(UserDTO userDTO, List<PostResDTO> postResDTOs) {
    ForumResDTO.Address.Geo geo = ForumResDTO.Address.Geo.builder()
        .lat(userDTO.getAddress().getGeo().getLat())
        .lng(userDTO.getAddress().getGeo().getLng()).build();
    ForumResDTO.Address address =
        ForumResDTO.Address.builder().street(userDTO.getAddress().getStreet())
            .suite(userDTO.getAddress().getSuite())
            .city(userDTO.getAddress().getCity())
            .zipcode(userDTO.getAddress().getZipcode()).geo(geo).build();

    return ForumResDTO.builder().id(userDTO.getId()).name(userDTO.getName())
        .username(userDTO.getUsername()).email(userDTO.getEmail())
        .address(address).postResDTOs(postResDTOs).build();
  }

  // PostDTO -> PostResDTO
  public PostResDTO map(PostDTO postDTO, List<Comment1ResDTO> comment1ResDTOs) {
    return PostResDTO.builder().id(postDTO.getId()).title(postDTO.getTitle())
        .body(postDTO.getBody()).comment1ResDTOs(comment1ResDTOs).build();

  }

  // CommentDTO -> CommentResDTO
  public Comment1ResDTO map(CommentDTO commentDTO) {
    return Comment1ResDTO.builder().id(commentDTO.getId())
        .name(commentDTO.getName()).email(commentDTO.getEmail())
        .body(commentDTO.getBody()).build();
  }

  public Post1ResDTO map(PostEntity postEntity) {
    return Post1ResDTO.builder().postId(postEntity.getId())
        .title(postEntity.getTitle()).body(postEntity.getBody()).build();
  }

  public ForumResDTO map(UserEntity userEntity, List<PostResDTO> postResDTOs) {
    return ForumResDTO.builder().id(userEntity.getId())
        .name(userEntity.getName()).username(userEntity.getUsername())
        .email(userEntity.getEmail())
        .address(ForumResDTO.Address.builder().street(userEntity.getStreet())
            .suite(userEntity.getSuite()).city(userEntity.getCity())
            .zipcode(userEntity.getZipcode())
            .geo(ForumResDTO.Address.Geo.builder().lat(userEntity.getLat())
                .lng(userEntity.getLng()).build())
            .build())
        .postResDTOs(postResDTOs).build();

  }

  public PostResDTO map(PostEntity postEntity,
      List<Comment1ResDTO> comment1ResDTOs) {
    return PostResDTO.builder().id(postEntity.getId())
        .title(postEntity.getTitle()).body(postEntity.getBody())
        .comment1ResDTOs(comment1ResDTOs).build();
  }

  public Comment1ResDTO map(CommentEntity commentEntity) {
    return Comment1ResDTO.builder().id(commentEntity.getId())
        .name(commentEntity.getName()).email(commentEntity.getEmail())
        .body(commentEntity.getBody()).build();
  }

}
