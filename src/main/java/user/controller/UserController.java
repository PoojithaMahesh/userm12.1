package user.controller;

import java.util.Scanner;

import user.dao.UserDao;
import user.dto.User;

public class UserController {
public static void main(String[] args) {
	boolean value=true;
	do {
		UserDao dao=new UserDao();
		System.out.println("WElcome to User APplication");
		System.out.println("Please enter 1 to save the data");
		System.out.println("please enter 2 to update the data");
		System.out.println("Please enter 3 to find the dATA");
		System.out.println("Please enter 4 to delete the data");
		System.out.println("please enter 5 to exit");
		Scanner scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:{
//			save the data
			System.out.println("please enter your id");
			int id=scanner.nextInt();
			System.out.println("please enter your name");
			String name=scanner.next();
			System.out.println("please enter your address");
			String address=scanner.next();
			User user=new User();
			user.setId(id);
			user.setName(name);
			user.setAddress(address);
//			now i want to call save method
			dao.saveUser(user);
			System.out.println("user data saved successfully");
		}
			break;

		case 2 :{
			System.out.println("please enter your id");
			int id=scanner.nextInt();
			System.out.println("please enter your name");
			String name=scanner.next();
			System.out.println("please enter your address");
			String address=scanner.next();
			User user=new User();
			user.setName(name);
			user.setAddress(address);
			dao.updateUser(id, user);
			System.out.println("User data updated successfully");
		}break;
		case 3:{
			System.out.println("please enter your id");
			int id=scanner.nextInt();
			dao.findUser(id);
			System.out.println("User data fetched successfully");
		}break;
		case 4:{
			System.out.println("please enter your id");
			int id=scanner.nextInt();
			dao.deleteUser(id);
			System.out.println("user data deleted successfully");
			
		}break;
		case 5:{
			value=false;
			System.out.println("Thank you visit again");
		}
		}
	
	} while (value);
}
}