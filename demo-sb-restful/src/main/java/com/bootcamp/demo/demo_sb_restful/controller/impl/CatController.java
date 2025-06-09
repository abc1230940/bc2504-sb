package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.CatOperation;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.service.CatService;

// ! Controller per resource
// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
// @ResponseBody -> spring能夠將object轉返做JSON俾返個user

public class CatController implements CatOperation {
  @Autowired // dependency injection
  // ! A command to ask "spring Manager" to look up for a bean from Context
  private CatService catService; // ! the bean from spring context
  
  @Override
  public CatEntity create(Long zooId, Cat cat) {
    return this.catService.save(zooId, cat);
    // return Cat.cats.add(cat) ? cat : null;
  }

  @Override
  public List<CatEntity> getAll(Long zooId) {
    return this.catService.findAll().stream()
            .filter(e -> e.getZooEntity().getId().equals(zooId))
            .collect(Collectors.toList());
    // return Cat.cats;
  }

  @Override
  public CatEntity update(Cat cat, Long id) {
    return this.catService.updateById(cat, id);
  }
    //if (id != cat.getId())
      //return null; // throw
    //for (int i = 0; i < Cat.cats.size(); i++) {
      //if (Cat.cats.get(i).getId().equals(id)) {
        //Cat.cats.set(i, cat);
        //return cat;
      //}
    //}
    //return null;
    // throw new NotFoundException();
  
  @Override
  public CatEntity getById(Long id) {
    Optional<CatEntity> catEntity = this.catService.findById(id);
    if (catEntity.isPresent()) {
      return catEntity.get();
    }
    return null;
  }
    // update
    // delete
    //for (Cat cat : Cat.cats) {
      //if (cat.getId().equals(id)) {
        //return cat;
      //}
    //}
    //return null; // throw

  @Override
  public void deleteById(Long id) {
    this.catService.deleteById(id);
    //for (int i = 0; i < Cat.cats.size(); i++) {
      //if (Cat.cats.get(i).getId().equals(id)) {
        //Cat toBeRemoved = Cat.cats.get(i);
        //Cat.cats.remove(toBeRemoved);
        //return toBeRemoved;
      //}
    //}
    //return null; // throw
  //}
  }
  
  @Override
  public List<CatEntity> findByName(String name) {
    return this.catService.findByName(name);
  }
}

