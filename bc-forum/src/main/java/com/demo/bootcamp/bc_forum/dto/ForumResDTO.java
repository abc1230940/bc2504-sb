package com.demo.bootcamp.bc_forum.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ForumResDTO {
  private long id;
  private String name;
  private String username;
  private String email;
  private Address address;

  @AllArgsConstructor
  @Getter
  @Builder

  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

      @AllArgsConstructor
      @Getter
      @Builder
        public static class Geo {
          private String lat;
          private String lng;
        }
  }

  private List<Post> posts;

  @AllArgsConstructor
  @Getter
  @Builder

  public static class Post {
    private long id;
    private String title;
    private String body;
    private List<Comment> comments;

    @AllArgsConstructor
    @Getter
    @Builder

    public static class Comment {
      private long id;
      private String name;
      private String email;
      private String body;
    }
  }
    
}
