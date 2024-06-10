package user.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import user.dto.User;

public class UserDao {
	
	
public void saveUser(User user) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
}
public void updateUser(int userId,User user) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User dbUser=entityManager.find(User.class, userId);
	if(dbUser!=null) {
//		id is present
//		call merge method what it is going to do??
//		it will update the data
//		call merge
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		user.setId(userId);
		entityManager.merge(user);
		entityTransaction.commit();
	}else {
//		id is not present
//		call merge method what it is going to do ??
//		insert the data
		System.out.println("Sorry id is not present to update the data");
	}
}


public void findUser(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User user=entityManager.find(User.class, id);
	if(user!=null) {
		System.out.println(user);
	}else {
		System.out.println("Sorry id is not present");
	}
			
}
public void deleteUser(int id) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User user=entityManager.find(User.class, id);
	if(user!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is not present");
	}
}







}
