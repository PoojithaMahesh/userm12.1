package user.controller;

import java.util.Scanner;

import user.dao.UserDao;
import user.dto.User;

public class UserController {
public static void main(String[] args) {
	User user=new User();
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("Welcome to user application");
	System.out.println("please give id to be saved");
	int id=scanner.nextInt();
	System.out.println("please give name");
	String name=scanner.next();
	System.out.println("plase give address");
	String address=scanner.next();
	
	
	user.setId(id);
	user.setName(name);
	user.setAddress(address);
	
	
	
	UserDao dao=new UserDao();
	dao.saveUser(user);
}
}
