package com.bootcamp.demo.demo_sb_restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staffs")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StaffEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "staff_name")
  private String name;
  @Column(name = "staff_age")
  private Integer age;

}
