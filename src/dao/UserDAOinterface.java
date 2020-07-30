package dao;

import java.io.IOException;
import java.sql.SQLException;

import model.User;

public interface UserDAOinterface{
	 int signUp(User user) throws ClassNotFoundException, IOException, SQLException;
	 boolean loginUser(User user) throws ClassNotFoundException, IOException, SQLException;
}