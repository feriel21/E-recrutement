package com.example.msregistrationfinale.service;


import com.example.msregistrationfinale.domain.Role;
import com.example.msregistrationfinale.domain.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);

    int enableUser(String email);

    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();;
}
