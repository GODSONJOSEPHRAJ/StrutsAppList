package com.example.action;

import com.example.dao.UserDao;
import com.example.model.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private User user = new User();  
    private String oldName;         
    private List<User> users;        

    private static final UserDao userDao = new UserDao(); 

    // Add user
    public String add() {
        if (user != null && user.getName() != null && !user.getName().isEmpty()) {
            userDao.saveUser(user);
        }
        return SUCCESS;
    }

    // List all users
    public String list() {
        users = userDao.getAllUsers();
        return SUCCESS;
    }
    
    // Show form with user data for editing
    public String edit() {
        if (oldName != null) {
            this.user = userDao.getUserByName(oldName);
        }
        return "edit";
    }

    // Update user
    public String update() {
    	  if (oldName != null && user != null) {
    	        // Check that the user exists with the old name
    	        User existingUser = userDao.getUserByName(oldName);
    	        if (existingUser != null) {
    	            // Update the user with new values
    	            existingUser.setName(user.getName());
    	            existingUser.setEmail(user.getEmail());
    	        }
    	    }
    	    return SUCCESS;
    }

    // Delete user
    public String delete() {
        if (user != null && user.getName() != null) {
            userDao.deleteUser(user.getName());
        }
        return SUCCESS;
    }

    // Getters and setters (used by Struts2)

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
