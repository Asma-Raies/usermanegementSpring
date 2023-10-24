package com.asma.users.restControllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asma.users.entities.Role;
import com.asma.users.entities.User;
import com.asma.users.service.UserService;
@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	 @Autowired
	    UserService userService;
	    @RequestMapping(path = "all", method = RequestMethod.GET)
	    public List<User> getAllUsers() {
	        return userService.findAllUsers();
	    }

	    @RequestMapping(path="add",method=RequestMethod.POST)
	    public User saveUser(@RequestBody User user) {
	        return userService.saveUser(user);
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

	    @RequestMapping(path="deleteUserById/{id}",method=RequestMethod.DELETE)
	    public void deleteUserById(@PathVariable long id) {
	         userService.deleteUser(id);
	    }

	    @RequestMapping(path="removeRoleFromUer/{id}",method=RequestMethod.POST)
	    public User removeRole(@PathVariable long id,@RequestBody Role r)
	    {
	        return  userService.removeRoleFromUser(id,r);

	    }

}
