package com.demo.bootcamp.bc_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ErrorDTO {
  private Long code;
  private String message;
}

