package com.qa.project.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "project")
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int id;
	
	@Column(name = "name", unique = true)
	private String name; 
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Employee> employees;
	
	public Project() {
		
	}
	
	public Project(String name) {
		super();
		this.name = name;
	}
	
	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public List<Employee> getEmployee(){
		return employees; 
	}
	
	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name !=null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

	

}
