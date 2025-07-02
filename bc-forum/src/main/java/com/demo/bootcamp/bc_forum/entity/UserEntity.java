package com.demo.bootcamp.bc_forum.entity;

import java.io.Serializable;
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
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

// ! Table中不會有Table -> 所以要將所有內裡的class要攤返平
// ! 有D attributes不需要加coloumn落去，如果本身睇得明的話就可以直接用佢

public class UserEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String username;
  private String email;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "latitude")
  private String lat;
  @Column(name = "longitude")
  private String lng;
  private String phone;
  private String website;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "atchphrase")
  private String catchPhrase;
  private String bs;

}
