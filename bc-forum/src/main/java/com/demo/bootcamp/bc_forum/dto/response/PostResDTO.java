package com.demo.bootcamp.bc_forum.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PostResDTO {
  private Long id;
  private String title;
  private String body;
  private List<Comment1ResDTO> comment1ResDTOs;
  
}

