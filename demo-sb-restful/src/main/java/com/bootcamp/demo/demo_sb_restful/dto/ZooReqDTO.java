package com.bootcamp.demo.demo_sb_restful.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
// 不用寫equal, 不是用來check anything
// 只是要部分的資料，然後轉化成DTO

public class ZooReqDTO {
  private String name;
}
