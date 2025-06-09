package com.demo.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.bootcamp.bc_forum.dto.CommentResDTO;
import com.demo.bootcamp.bc_forum.dto.ForumResDTO;

public interface ForumOperation {
  @GetMapping(value = "/jph/forum/DTO")
  List<ForumResDTO> getAllUsers();

  @GetMapping(value = "/jph/comments")
  List<CommentResDTO> getAllCommentsbyId(@RequestParam Long id);

}
