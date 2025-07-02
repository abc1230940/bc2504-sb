package com.demo.bootcamp.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.demo.bootcamp.bc_forum.dto.request.PostReqDTO;
import com.demo.bootcamp.bc_forum.entity.CommentEntity;
import com.demo.bootcamp.bc_forum.entity.PostEntity;
import com.demo.bootcamp.bc_forum.entity.UserEntity;
import com.demo.bootcamp.bc_forum.entity.mapper.EntityMapper;
import com.demo.bootcamp.bc_forum.entity.mapper.ReqDTOMapper;
import com.demo.bootcamp.bc_forum.exception.SysError;
import com.demo.bootcamp.bc_forum.exception.UserNotFoundException;
import com.demo.bootcamp.bc_forum.model.dto.CommentDTO;
import com.demo.bootcamp.bc_forum.model.dto.PostDTO;
import com.demo.bootcamp.bc_forum.model.dto.UserDTO;
import com.demo.bootcamp.bc_forum.repository.CommentRepository;
import com.demo.bootcamp.bc_forum.repository.PostRepository;
import com.demo.bootcamp.bc_forum.repository.UserRepository;
import com.demo.bootcamp.bc_forum.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
  // @Value -> check dependency with yml file
  @Value("${service-url.users}")
  private String url;

  @Value("${service-url.posts}")
  private String url2;

  @Value("${service-url.comments}")
  private String url3;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ReqDTOMapper reqDTOMapper;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<UserDTO> getUsers() {
    // String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = this.restTemplate.getForObject(this.url, UserDTO[].class);
    return List.of(dtos); // ! 固定！用List.of就可以
  }

  @Override
  public List<PostDTO> getPosts() {
    // String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] dtos = this.restTemplate.getForObject(this.url2, PostDTO[].class);
    return List.of(dtos); // ! 固定！用List.of就可以
  }

  @Override
  public List<CommentDTO> getComments() {
    // String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] dtos =
        this.restTemplate.getForObject(this.url3, CommentDTO[].class);
    return List.of(dtos); // ! 固定！用List.of就可以
  }

  @Override
  public List<UserEntity> saveAllUsers(List<UserDTO> userDTOs) {
    if (userDTOs == null || userDTOs.isEmpty()) {
      throw new IllegalArgumentException("userDTOs cannot be null or empty");
    }
    List<UserEntity> userEntities = new ArrayList<>();
      for (UserDTO userDTO : userDTOs) {
        if (userDTO != null) {
          userEntities.add(this.entityMapper.map(userDTO));
        }
          
      }    
    return this.userRepository.saveAll(userEntities);
  }

  @Override
  public List<PostEntity> saveAllPosts(List<PostDTO> postDTOs) {
    if (postDTOs == null || postDTOs.isEmpty()) {
      throw new IllegalArgumentException("userId or postDTOs cannot be null");
    }
    List<PostEntity> postEntities = new ArrayList<>();
    for (PostDTO postDTO : postDTOs) {
        postEntities.add(this.entityMapper.map(postDTO));
      }
    return this.postRepository.saveAll(postEntities);
  }

  @Override
  public List<CommentEntity> saveAllComments(List<CommentDTO> commentDTOs) {
    if (commentDTOs == null || commentDTOs.isEmpty()) {
      throw new IllegalArgumentException(
          "PostId or commentDTOs cannot be null or empty.");
    }
    List<CommentEntity> commentEntities = new ArrayList<>();
    for (CommentDTO commentDTO : commentDTOs) {
        commentEntities.add(this.entityMapper.map(commentDTO));
      }
    return this.commentRepository.saveAll(commentEntities);

  }

  @Override
  public List<UserEntity> getAllUserEntities() {
    return this.userRepository.findAll();
  }
  @Override
  public List<PostEntity> getAllPostEntities() {
    return this.postRepository.findAll();
  }
  @Override
  public List<CommentEntity> getAllCommentEntities() {
    return this.commentRepository.findAll();
  }

  @Override
  public Optional<UserEntity> findUserByID(Long id) {
    return this.userRepository.findById(id);
  }

  @Override
  public List<PostEntity> findPostsByUserid(Long id) {
    return this.postRepository.findByUserEntityId(id);
  }

  @Override
  public Optional<UserEntity> findUserByCity(String city) {
    return this.userRepository.findByCity(city);
  }

  @Override
  public PostEntity create(Long id, PostReqDTO postReqDTO) {
    // model -> entity -> service
    // dto -> entity -> controller
    UserEntity userEntity = this.userRepository.findById(id)
                            .orElseThrow(() -> new UserNotFoundException(SysError.USER_NOT_FOUND));
    PostEntity postEntity = this.reqDTOMapper.map(postReqDTO, userEntity);
    return this.postRepository.save(postEntity);
  }



}

