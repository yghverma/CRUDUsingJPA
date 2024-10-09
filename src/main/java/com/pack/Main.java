package com.pack;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-info");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
	//	Student s1 = new Student("Tanisha Verma", 2, LocalDate.parse("2022-08-01"), Gender.FEMALE, true);
	//	Student s1 = new Student("Dadi", 59, LocalDate.parse("1960-08-09"), Gender.FEMALE, true);
	//	em.persist(s1);
		
		// find and updat
		//Student s1 = em.find(Student.class, 3);
		///s1.setGender(Gender.MALE);
		//em.persist(s1);
		//et.commit();
		//System.out.println(s1);
		
	//	Student s1 = em.find(Student.class, 3);
//		em.remove(s1);
	//	et.commit();
	//	System.out.println(s1);
		
		
		
	// to fetch all
	//	Query query = em.createQuery("select s from Student s");
		//List<Student> ls =  query.getResultList();
		//for(Student s : ls) {
			//System.out.println(s.getName() + " :: " + s.getAge());
		//}
		// we can also use positional param like ?1 and ?2 in the query
	/*
	 * Query query = em.createQuery("select s from Student s where s.id=:z");
	 * query.setParameter("z", 1); Student s = (Student) query.getSingleResult();
	 * System.out.println(s.getName() + " :: " + s.getAge());
	 */
	
	/*
	 * Query query1 = em.createNativeQuery("select * from stud100"); List ls =
	 * query1.getResultList(); Iterator i = ls.iterator(); while(i.hasNext()) {
	 * Object[] s1 = (Object[]) i.next(); System.out.println(s1[0] + " :: " +
	 * s1[1]); }
	 */
	
		// Using JPAL query
		/*
		 * Query query1 = em.createNamedQuery("findPerson"); List<Student> ls =
		 * query1.getResultList(); // Get a list of Student objects Iterator<Student> i
		 * = ls.iterator(); // Iterator for Student objects
		 * 
		 * while (i.hasNext()) { Student s1 = i.next(); // Get the next Student object
		 * 
		 * // Assuming your Student class has methods like getId() and getName()
		 * System.out.println(s1.getId() + " :: " + s1.getName()); // Adjust field
		 * accessors as per your class }
		 */
		
		
		Query query1 = em.createNamedQuery("findNativePerson");
		List<Student> ls = query1.getResultList();  // Get a list of Student objects
		Iterator<Student> i = ls.iterator();        // Iterator for Student objects

		while (i.hasNext()) {
		    Student s1 = i.next();  // Get the next Student object

		    // Assuming your Student class has methods like getId() and getName()
		    System.out.println(s1.getId() + " :: " + s1.getName());  // Adjust field accessors as per your class
		}
		
		et.commit();
		//System.out.println("Success");
		em.close();
		emf.close();
		
	}
}