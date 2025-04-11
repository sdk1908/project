package com.crud.rest.controller;

import com.crud.rest.entity.Department;
import com.crud.rest.entity.Profile;
import com.crud.rest.entity.User;
import com.crud.rest.repositroy.UserRepository;
import com.crud.rest.service.UserService;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControl {

    @Autowired
    UserService userService;
    
    @Autowired
    UserRepository userRepository;

    //@PostMapping("/register")
    @GetMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        System.out.println(user.toString()+":ttt:");
        User existingUser = userRepository.findByusername(user.getUsername());
    	if(existingUser != null )
    	{
    		return ResponseEntity.ok("Username already exists");
    	}
    	else {
    		//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    		user.setPassword(user.getPassword());
    		User users = userService.saveUser(user);
    		return ResponseEntity.status(201).body(users);
    	}
    }

   // @GetMapping("/get/{id}")
    @PostMapping("/get/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
 
        return ResponseEntity.ok( userService.getUser(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id)
    {
    	if(userService.getUser(id).isPresent())
    	{
    		userService.deleteUser(id);
    		return ResponseEntity.ok("User Deleted");
    	}
    	else
    		return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable  Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }
    
    @GetMapping("/list")
   public ResponseEntity<?> userList(@RequestParam(value="page",defaultValue="0") int page,@RequestParam(value="size",defaultValue="10")int size){   
    
    	//Sort sort = Sort.by(Sort.Direction.ASC,"name");
    	//Pageable pageable = PageRequest.of(page, size,sort);
    	Pageable pageable = PageRequest.of(page, size);
    	Page<User> userList = userService.findAll(pageable);
    	
    	if(userList.getSize() > 0)
    		return ResponseEntity.ok(userList);
    	else
    		return ResponseEntity.notFound().build();
    	
    	
    		
    }
}
