package com.example.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

	@Autowired
	private MyRepo repo;
	public List<Employee> displayData()
	{
		return repo.findAll();
	}
	public void saveEmployee(Employee employee)
	{
		repo.save(employee);
	}
	public  Employee getPro(long id)
	{
		return repo.findById(id).get();
	}
	public void delete(long id)
	{
		repo.deleteById(id);
	}
}
