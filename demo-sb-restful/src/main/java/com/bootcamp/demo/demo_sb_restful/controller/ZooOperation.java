package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.dto.ZooReqDTO;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;

public interface ZooOperation {
   @PostMapping(value = "/zoo")
   ZooEntity create(@RequestBody ZooReqDTO dto); // 因為冇zoo冇貓又冇id, 佢俾唔到資料我哋

   @GetMapping(value = "/zoos")
   List<ZooReqDTO> getAll();

   @GetMapping(value = "/zoo/{id}")
   ZooReqDTO getById(@PathVariable Long id);

   @DeleteMapping(value = "/zoo/{id}")
   void delete(Long id);
   
}
