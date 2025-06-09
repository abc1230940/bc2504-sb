package com.demo.bootcamp.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
