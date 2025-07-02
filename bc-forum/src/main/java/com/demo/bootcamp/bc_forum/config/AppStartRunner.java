package com.demo.bootcamp.bc_forum.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.service.ForumService;

// Spring寫好咗的programme -> 會自動trigger
// @Autowired(required = false)
// private CommandLineRunner commanLineRunner;
// ! 寫bean俾人call

// if (commandLineRunner != null) {commandLineRunner.run(); }
// 有component時佢就自動出個impl出來

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private ForumService forumService;

    // ! Server start: Spring context manager triggers run()
  @Override
  // thread -> 寫咩要run的東西都可以的
  public void run(String... args) throws Exception {
    // Procedure
    // System.out.println("Hello World!!!"); // iterm開server會見到
    // ! Step 1: Call Json placeholder的網站
    // ! Step 2: Convert Entity
    // ! Step 3: Insert into DB (Users, Posts, Comments)
    // ! 以上STEPS只會做一次 -> 有問題就不能開server
    
    if (this.forumService.getAllUserEntities().isEmpty()) {
      List<UserDTO> userDTOs = this.forumService.getUsers();
      List<UserEntity> userEntities = this.forumService.saveAllUsers(userDTOs);
    }
    
    if (this.forumService.getAllPostEntities().isEmpty()) {
      List<PostDTO> postDTOs = this.forumService.getPosts();
      List<PostEntity> postEntities = this.forumService.saveAllPosts(postDTOs);
    }
    
    if (this.forumService.getAllCommentEntities().isEmpty()) {
      List<CommentDTO> commentDTOs = this.forumService.getComments();
      List<CommentEntity> commentEntities = this.forumService.saveAllComments(commentDTOs);
    }
  }
  
}
