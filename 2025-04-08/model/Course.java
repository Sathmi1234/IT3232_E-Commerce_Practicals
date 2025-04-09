package lk.ac.vau.fas.ict.model;

public class Course {
	private String name;
	private int code;
	private String desc;
	private double duration;
	private int year;
	
	public Course(String name, int code, String desc, double duration, int year) {
		super();
		this.name = name;
		this.code = code;
		this.desc = desc;
		this.duration = duration;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
