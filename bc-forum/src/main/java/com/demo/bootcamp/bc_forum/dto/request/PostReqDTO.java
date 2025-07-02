package com.demo.bootcamp.bc_forum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class PostReqDTO {
  private Long id;
  private String title;
  private String body;
}
