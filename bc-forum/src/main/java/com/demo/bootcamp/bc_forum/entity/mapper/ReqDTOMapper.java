package com.demo.bootcamp.bc_forum.entity.mapper;

import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_forum.dto.request.PostReqDTO;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;

@Component
public class ReqDTOMapper {

  public PostEntity map(PostReqDTO postReqDTO, UserEntity userEntity) {
    return PostEntity.builder()
                      .title(postReqDTO.getTitle())
                      .body(postReqDTO.getBody())
                      .userEntity(userEntity)
                      .build();
  }
}
