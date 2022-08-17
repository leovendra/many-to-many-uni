package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class TestSaveTeacher {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Subject s1 = new Subject();
		s1.setName("DS");
		s1.setDays(50);
		
		Subject s2 = new Subject();
		s2.setName("English");
		s2.setDays(30);
		
		Subject s3 = new Subject();
		s3.setName("Maths");
		s3.setDays(365);
		 
		List<Subject> list = new ArrayList<Subject>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Teacher t1 = new Teacher();
		t1.setName("Priya");
		t1.setAge(24);
		t1.setSub(list);
		
		list.remove(s3);
		Teacher t2 = new Teacher();
		t2.setName("Divya");
		t2.setAge(19);
		t2.setSub(list);
		
		transaction.begin();
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(s1);
		manager.persist(s2);
		manager.persist(s3);
		transaction.commit();
		System.out.println("Done!!!");
	}

}
