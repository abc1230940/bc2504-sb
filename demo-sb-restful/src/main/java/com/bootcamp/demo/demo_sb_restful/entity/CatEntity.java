package com.bootcamp.demo.demo_sb_restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ! Use Java to write SQL (Create table)
// create table cats (id bigint primary key auto_increment, cat_name varchar(50), cat_age numberic(3,0));

// ! In entity, we never use primitive
// ! 傳輸用返Wrapper class -> 因為有null, 如果沒有DATA的話就會用NULL展示, primitive沒有這個concept

@Entity
@Table(name = "cats")
@Getter
@AllArgsConstructor
@NoArgsConstructor // ! Entity要寫呢個俾Spring
@Builder
public class CatEntity {

  // PK可以係任何type都得，但要在repository到改返<StaffEntity, XXXXX>
  @Id // Primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "cat_name", length = 50) // SQL coloumn改名 // ! default = 255
  private String name;
  @Column(name = "cat_age")
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "zoo_id") // cats.zoo_id (FK) join ZooEntity's PK in SQL
  private ZooEntity zooEntity; //交待邊隻貓屬於邊個動物園
}
