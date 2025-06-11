package com.vau.app.model;

import java.sql.Date;

public class ViewDepartment extends Department {
	private int empcount;

	
	public ViewDepartment() {
		
	}

	public ViewDepartment(String id, String depName, Date established, int employees) {
		super(id,depName,established);
		this.empcount = employees;
	}
	
	public ViewDepartment(String id,int employees) {
		super(id);
		this.empcount = employees;
	}

	public int getEmpcount() {
		return empcount;
	}

	public void setEmpcount(int empcount) {
		this.empcount = empcount;
	}
	
	
}
