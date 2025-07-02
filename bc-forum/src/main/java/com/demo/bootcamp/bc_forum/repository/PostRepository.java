package com.demo.bootcamp.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.bootcamp.bc_forum.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  
  List<PostEntity> findByUserEntityId(Long id); // ! For FK
}
