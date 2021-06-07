package com.ericsson.demoservice.DemoService;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
//http://localhost:8080/emp/create/objectKey?id=1&name=saif