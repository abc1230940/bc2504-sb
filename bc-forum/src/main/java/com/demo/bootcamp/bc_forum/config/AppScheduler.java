package com.demo.bootcamp.bc_forum.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.service.ForumService;

@Component
public class AppScheduler {
  @Autowired
  private ForumService forumService;
  
  @Scheduled(cron = "0 0 12,18 * * MON-FRI", zone ="Asia/Hong_Kong")
  public void update() {
    
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
