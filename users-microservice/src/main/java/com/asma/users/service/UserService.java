package com.asma.users.service;

import java.util.List;


import com.asma.users.entities.Role;
import com.asma.users.entities.User;

public interface UserService {
User saveUser(User user);
Role saveRole(Role role);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(long id, Role r);
List<User> findAllUsers();

void deleteUserById(Long id);
User findUserById(Long id);

List<Role> findAllRoles();

Role findRoleById(Long id);

Role updateRole(Role r);

void deleteRoleById(long id);
void deleteUser(long id);

User removeRoleFromUser(long id, Role r);

List<User> getUsers();



User ChangePassword(String oldPass ,String newPass, Long id);
User activateUser(String username , String code );


}