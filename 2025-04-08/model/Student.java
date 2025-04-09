package lk.ac.vau.fas.ict.model;

public class Student {
	private String name;
	private int age;
	private String course;
	private String regNo;
	private double gpa;

	public Student(String name, int age, String course, String regNo,double gpa) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
		this.regNo = regNo;
		this.gpa=gpa;
	}
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
}
