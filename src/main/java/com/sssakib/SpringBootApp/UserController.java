package com.sssakib.SpringBootApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.net.URI;
import java.sql.Blob;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    @ResponseBody
    public ResponseModel register(@Validated @RequestBody User user) {
    	
    	ResponseModel model = new ResponseModel();

        List<User> users = userRepository.findAll();
        System.out.println("New User -> " + user);

        for (User u : users) {
            if (user.equals(u)) {
                System.out.println("User already exists!");
                model.setOutCode("1");
                model.setOutMessage("USER ALREADY EXISTS");
                
                return model;
            }
        }

        userRepository.save(user);
        
        model.setOutCode("0");
        model.setOutMessage("USER SAVE SUCCESSFULLY");
        return model;


    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@Validated @RequestBody User user) {
    	
    	
   
    	System.out.println("Current User -> " + user);
    	
    	String mobile=user.getMobile();
    	String password = user.getPassword();
    	
    	User temp = new User();

        List<User> users = userRepository.findAll();
        
        
        for (User u: users) {
            if (mobile.equals(u.getMobile()) && password.equals(u.getPassword()) ) {
            	
            	
            	 return temp = u;
            	 
                
                
            }
        }

        return new User();

    }
    
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user,  @PathVariable long id) {
    	
   
    	User u = new User();
    	
    	String email = user.getEmail();
    	String address = user.getAddress();
    	String password = user.getPassword();
    	String image=user.getImage();
    	
    	
    	
    	Optional<User> userOptional = this.userRepository.findById(id);
    	
    	
    	
    	
    	
    	if (userOptional.isPresent())
    	{
    		
    		u = userOptional.get();
    	    
    	    u.setName(u.getName());
    	    u.setMobile(u.getMobile());
    		u.setEmail(email);
    		u.setAddress(address);
    		u.setPassword(password);
    		u.setImage(image);
    		
    		
    		userRepository.save(u);
    		
    	}

		

		return u;
    }
    
    
    


}
