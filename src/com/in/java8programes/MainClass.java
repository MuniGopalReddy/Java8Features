package com.in.java8programes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Alice", "HR", 50000),
				new Employee(2, "Bob", "IT", 75000), new Employee(3, "Charlie", "HR", 55000),
				new Employee(4, "David", "IT", 80000), new Employee(5, "Eva", "Finance", 60000),
				new Employee(6, "Frank", "Finance", 70000));
		// 1. Who is the employee with the highest salary overall?
		Optional<Employee> higestEmp = employees.stream().max(Comparator.comparing(Employee::getSalary));
		if (higestEmp.isPresent()) {
			System.out.println(higestEmp.get().getName());
		}
		// 2.Who is the highest paid employee in each department?
		Map<String, Optional<Employee>> highestPaidEmployee = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		highestPaidEmployee.forEach((dept, emp) -> 
	    System.out.println(dept + " => " + emp.get().getName()));
		
		//3.Filter employees earning more than 60,000
		List<Employee> filtered = employees.stream().filter(s-> s.getSalary() > 60000).collect(Collectors.toList());
		
		filtered.forEach(System.out::println);
		

	}
}
