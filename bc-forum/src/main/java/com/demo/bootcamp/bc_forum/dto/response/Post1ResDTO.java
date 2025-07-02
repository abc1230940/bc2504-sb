package com.demo.bootcamp.bc_forum.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class Post1ResDTO {
  private Long postId;
  private String title;
  private String body;
}
