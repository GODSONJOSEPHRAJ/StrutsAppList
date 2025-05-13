package com.example.dao;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static List<User> userList = new ArrayList<>();

    // Save user to the in-memory list
    public void saveUser(User user) {
        userList.add(user);
    }

    // Get all users from the list
    public List<User> getAllUsers() {
        return userList;
    }

    // Find a user by name
    public User getUserByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    // Update user info
    public void updateUser(String oldName, User newUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(oldName)) {
                userList.set(i, newUser);
            }
        }
    }

    // Remove user from the list
    public void deleteUser(String name) {
        userList.removeIf(user -> user.getName().equals(name));
    }
}
