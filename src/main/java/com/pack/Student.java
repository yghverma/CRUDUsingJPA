package com.pack;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "stud100")
//@DynamicInsert // only required insert query
//@DynamicUpdate
@NamedQueries({
	@NamedQuery(name="findPerson", query= "select s from Student s")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="findNativePerson", query= "select * from stud100", resultClass = Student.class)
})
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", gender=" + gender
				+ ", status=" + status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studId")
	private Integer id;
	
	@Column(name="stud_name")
	private String name;
	
	private Integer age;
	
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Transient
	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Student(Integer id, String name, Integer age, LocalDate dob, Gender gender, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
	}

	public Student() {
		super();
	}

	public Student(String name, Integer age, LocalDate dob, Gender gender, boolean status) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
	}
}