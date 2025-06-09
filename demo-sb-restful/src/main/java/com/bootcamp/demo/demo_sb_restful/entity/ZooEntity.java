package com.bootcamp.demo.demo_sb_restful.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "zoos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ZooEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDateTime createDate; // 顯示創建時間

  @PrePersist
  public void onCreate() {
      this.createDate = LocalDateTime.now();
  } 
}