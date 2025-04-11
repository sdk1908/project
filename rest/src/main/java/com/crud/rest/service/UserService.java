package com.crud.rest.service;

import com.crud.rest.entity.Profile;
import com.crud.rest.entity.User;
import com.crud.rest.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Isolation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   //@Transactional(isolation=Isolation.DEFAULT) //use when read & modify concurrently , takes default db isloation value if mysql it takes Repateable,sql server-read committed
    @Transactional
    public User saveUser(User user){

        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public ResponseEntity<?> updateUser(Long id, User user){

        Optional<User> getUser = userRepository.findById(id);
        System.out.println("update user:"+getUser.toString());
        if(getUser.isPresent()){
        	User existingUser = getUser.get();
        	existingUser.setCreatedBy(user.getCreatedBy());
        	existingUser.setPassword(user.getPassword());
        	
        	Profile existingProfile = existingUser.getProfile();
        	existingProfile.setFirstName(user.getProfile().getFirstName());
        	existingProfile.setLastName(user.getProfile().getLastName());
            existingProfile.setEmailId(user.getProfile().getEmailId());
            existingProfile.setAddress(user.getProfile().getAddress());
            existingProfile.setMobileNo(user.getProfile().getMobileNo());
            
            return ResponseEntity.ok(userRepository.save(existingUser));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

	public Page<User> findAll(Pageable pageable) {
		
		Page<User> listUser = userRepository.findAll(pageable);
		return listUser;
	}
}
