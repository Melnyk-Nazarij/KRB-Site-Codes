package ua.tntu.server.service;

import ua.tntu.server.dao.UserDAO;
import ua.tntu.server.model.User;

import java.util.List;

public class UserService {
    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void addUser(User user){
        userDAO.addUser(user);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }


    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
}
