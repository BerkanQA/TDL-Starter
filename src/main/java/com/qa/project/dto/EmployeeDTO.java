package com.qa.project.dto;

import com.qa.project.model.Status;

public class EmployeeDTO {

	private int id;
	private String name;
	private String role;
	private String level;
	private Status status;
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(int id, String name, String role, String level) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.level = level;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31; 
		int result = 1;
		result = prime * result + ((role == null ? 0 : role.hashCode()));
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;				
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Status getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

}
