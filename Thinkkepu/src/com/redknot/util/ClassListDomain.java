package com.redknot.util;

public class ClassListDomain {
	private String name;
	private int id;

	public ClassListDomain(String name, int id) {
		this.setName(name);
		this.setId(id);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
