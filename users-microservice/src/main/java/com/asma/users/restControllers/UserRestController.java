package com.asma.users.restControllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asma.users.entities.Role;
import com.asma.users.entities.User;
import com.asma.users.repos.userRepository;
import com.asma.users.service.UserService;
@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	 @Autowired
	    UserService userService;
	 @Autowired
		userRepository userRep;
	    @RequestMapping(path = "all", method = RequestMethod.GET)
	    public List<User> getAllUsers() {
	        return userService.findAllUsers();
	    }
	    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
		public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userRep.findById(id);
		 }
	    @RequestMapping(path="/getByusername/{username}",method = RequestMethod.GET)
		public User getUserByUsername(@PathVariable("username") String username) {
		return userService.findUserByUsername(username);
		 }

	    @RequestMapping(path="/addUser",method=RequestMethod.POST)
	    public User saveUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }
	  
	    @RequestMapping(path="addR",method=RequestMethod.POST)
	    public Role saveRole(@RequestBody Role rol) {
	        return userService.addRole(rol);
	    }
	    @RequestMapping(method = RequestMethod.PUT)
	    public Role updateRole(@RequestBody Role make) {
		 return userService.updateRole(make);
	 }
	    @RequestMapping(path="/deleteUser/{id}",method = RequestMethod.DELETE)
		public void deleteUser(@PathVariable("id") Long id)
		{
			//System.out.println("delete");
			userService.deleteUserById(id); 
		}
		
	 @RequestMapping(value="/{id}", method = RequestMethod.DELETE )
	 public void  deleteRole(@PathVariable("id") Long id) {
		 userService.deleteRoleById(id);
	 }
	    @RequestMapping(path="addRole/{id}",method=RequestMethod.POST)
	    public User addRoleToUser(@PathVariable long id,@RequestBody Role r) {
	        return userService.addRoleToUser(id, r);
	    }
	    
	    //je veut passer l id in the url
	    @RequestMapping(path="findUserById/{id}",method=RequestMethod.GET)
	    public User findUserById(@PathVariable Long id) {
	        return userService.findUserById(id);
	    }

	    @RequestMapping(path="allRoles",method=RequestMethod.GET)
	    public List<Role> getAllRoles() {
	        return userService.findAllRoles();
	    }

	    @RequestMapping(path="findRoleById/{id}",method=RequestMethod.GET)
	    public Role findRoleById(@PathVariable Long id) {
	        return userService.findRoleById(id);
	    }
	    @RequestMapping(path = "users",method = RequestMethod.GET)
		public List<User> getUsers() {
			return userService.getUsers();
		 }
	    @RequestMapping(path="deleteUserById/{id}",method=RequestMethod.DELETE)
	    public void deleteUserById(@PathVariable long id) {
	         userService.deleteUser(id);
	    }

	    @RequestMapping(path="removeRoleFromUer/{id}",method=RequestMethod.POST)
	    public User removeRole(@PathVariable long id,@RequestBody Role r)
	    {
	        return  userService.removeRoleFromUser(id,r);

	    }
		@RequestMapping(path = "activateUser/{username}/{code}", method = RequestMethod.GET)
	    public String activateUser(@PathVariable String username,@PathVariable String code ) {

	        System.out.println("user activated: " + code);
	        User user =userService.activateUser(username, code);
	        if (user!=null)
	            return "Your account has been verified ";
	        else
	           return "Your account has not been verified";

	    }
		
		
		
		@RequestMapping(path="/changePassword/{id}/{oldPass}/{newPass}",method = RequestMethod.PUT)
		public User ChangePassword(@PathVariable("oldPass") String oldPass,@PathVariable("newPass") 
		String newPass,@PathVariable("id") Long id) {
			System.out.println("old = "+oldPass + " new = "+newPass);
				return  userService.ChangePassword(oldPass,newPass,id);			
		}

}
