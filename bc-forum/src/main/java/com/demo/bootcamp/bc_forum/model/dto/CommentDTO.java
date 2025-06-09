package com.demo.bootcamp.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class CommentDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
