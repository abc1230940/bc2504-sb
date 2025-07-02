package com.demo.bootcamp.bc_forum.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder

public class ShoppingMall {
  private String name;
  private Integer area;
  private Cinema cinemas;

  @AllArgsConstructor
  @Getter
  @Builder

  public static class Cinema {
    private String name;
    private LocalDate openedDate;
    private List<ReleasedFilm> releasedFilms;

    @AllArgsConstructor
    @Getter
    @Builder
    
    public static class ReleasedFilm {
      private String name;
      private LocalDate releaseDate;
    }
  }

  private List<String> shopCategory;

  public static enum ShopCategory {
    Sport,
    Food,
    Clothing;
  }
}
