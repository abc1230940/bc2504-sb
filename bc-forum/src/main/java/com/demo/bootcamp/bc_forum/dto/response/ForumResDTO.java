package com.demo.bootcamp.bc_forum.dto.response;

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

  private List<PostResDTO> postResDTOs;
 }
    

