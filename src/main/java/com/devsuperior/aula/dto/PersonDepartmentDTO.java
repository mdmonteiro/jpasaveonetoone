package com.devsuperior.aula.dto;

public class PersonDepartmentDTO {

	private Long id;

	private String name;

	private Double salary;

	private DepartmentDTO department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

}
