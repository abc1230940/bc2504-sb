package com.demo.bootcamp.bc_forum.entity.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.repository.PostRepository;
import com.demo.bootcamp.bc_forum.repository.UserRepository;

@Component
public class EntityMapper {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;

  public UserEntity map(UserDTO userDTO) {
    
    return UserEntity.builder().name(userDTO.getName())
        .username(userDTO.getUsername()).email(userDTO.getEmail())
        .street(userDTO.getAddress().getStreet())
        .suite(userDTO.getAddress().getSuite())
        .city(userDTO.getAddress().getCity())
        .zipcode(userDTO.getAddress().getZipcode())
        .lat(userDTO.getAddress().getGeo().getLat())
        .lng(userDTO.getAddress().getGeo().getLng()).phone(userDTO.getPhone())
        .website(userDTO.getWebsite())
        .companyName(userDTO.getCompany().getName())
        .catchPhrase(userDTO.getCompany().getCatchPhrase())
        .bs(userDTO.getCompany().getBs()).build();
  }

  public PostEntity map(PostDTO postDTO) {
    UserEntity userEntity = this.userRepository.findById(postDTO.getUserId()).orElse(null);
    return PostEntity.builder().title(postDTO.getTitle())
          .body(postDTO.getBody()).userEntity(userEntity) // FK
          .build();
  }

  public CommentEntity map(CommentDTO commentDTO) {
    PostEntity postEntity =
        this.postRepository.findById(commentDTO.getPostId()).orElse(null);
    if (postEntity != null) {
      return CommentEntity.builder().name(commentDTO.getName())
          .email(commentDTO.getEmail()).body(commentDTO.getBody())
          .postEntity(postEntity) // FK
          .build();
    }
    return null;
  }
}
