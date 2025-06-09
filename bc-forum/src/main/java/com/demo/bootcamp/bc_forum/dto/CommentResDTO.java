package com.demo.bootcamp.bc_forum.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class CommentResDTO {
  private Long id;
  private String username;
  private List<Comment> comments;

  @AllArgsConstructor
  @Getter
  @Builder

  public static class Comment {
      private String name;
      private String email;
      private String body;
    
  }
}
