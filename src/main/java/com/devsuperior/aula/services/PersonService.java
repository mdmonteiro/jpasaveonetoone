package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aula.dto.DepartmentDTO;
import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

		Person person = new Person(dto.getId(), dto.getName(), dto.getSalary(),
				new Department(dto.getDepartment().getId(), dto.getDepartment().getName()));

		personRepository.save(person);

		return convertEntityToDTO(person);
	}

	@Transactional
	public PersonDTO insert(PersonDTO dto) {

		Department department = departmentRepository.getReferenceById(dto.getDepartmentId());

		Person person = new Person(dto.getId(), dto.getName(), dto.getSalary(), department);

		personRepository.save(person);

		return new PersonDTO(person);
	}

	private PersonDepartmentDTO convertEntityToDTO(Person person) {

		Department department = departmentRepository.getReferenceById(person.getDepartment().getId());

		return new PersonDepartmentDTO(person.getId(), person.getName(), person.getSalary(),
				new DepartmentDTO(department.getId(), department.getName()));

	}

}
