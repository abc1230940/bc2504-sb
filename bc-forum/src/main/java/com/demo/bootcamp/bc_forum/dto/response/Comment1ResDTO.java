package com.demo.bootcamp.bc_forum.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class Comment1ResDTO {
  private Long id;
  private String name;
  private String email;
  private String body;
  
}