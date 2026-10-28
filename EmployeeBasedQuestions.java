package gut.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeBasedQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = Arrays.asList(new Employee(101, "Amit", 40000, 25, 1),
				new Employee(102, "Raj", 60000, 30, 2), new Employee(103, "Sai", 50000, 28, 1),
				new Employee(104, "Anil", 70000, 32, 2), new Employee(105, "Priya", 60000, 27, 1),
				new Employee(106, "Ravi", 35000, 24, 3), new Employee(107, "Amit", 45000, 26, 2),
				new Employee(108, "Neha", 80000, 35, 3));

		// 1. Find the employee with the highest salary.
		System.out.println("Employee with the highest salary");
		Employee maxEmp = employees.stream().max(Comparator.comparingDouble((Employee e) -> e.getSalary())).get();
		System.out.println(maxEmp);
		System.out.println("#####################");

		// 2.Find the second-highest distinct salary.
		System.out.println("Second-highest distinct salary");
		employees.stream().map(emp -> emp.getSalary()).distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1)
				.forEach(x -> System.out.println(x));

		System.out.println("-------2nd way with Emp details---------");
		employees.stream().sorted(Comparator.comparing((Employee e) -> e.getSalary()).reversed()).skip(1).limit(1)
				.forEach(System.out::println);
		System.out.println("#####################");

		// 3. Find the top three highest-paid employees.
		System.out.println("Top three highest-paid employees");

		employees.stream().map(emp -> emp.getSalary()).sorted(Comparator.reverseOrder()).limit(3)
				.forEach(System.out::println);
		System.out.println("#####################");

//		4. Sort employees by salary in descending order.
		System.out.println("Employees by salary in descending order.");
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
		System.out.println("#####################");

//		5. Find employees whose salary is greater than ₹50,000
		System.out.println("Employees whose salary is greater than ₹50,000");
		employees.stream().filter(emp -> emp.getSalary() > 50000).forEach(System.out::println);
		System.out.println("#####################");

//		6. Find duplicate employee names.
		System.out.println("Duplicate employee names.");
		employees.stream().collect(Collectors.groupingBy((Employee e) -> e.getEmpName())).entrySet().stream()
				.filter(x -> x.getValue().size() > 1).forEach(x -> System.out.print(x.getKey()));
		System.out.println("#####################");

//		7. Count the frequency of each employee name.
		System.out.println("Frequency of each employee name");
		employees.stream().map(emp -> emp.getEmpName())
				.collect(Collectors.groupingBy((x -> x), TreeMap::new, Collectors.counting())).entrySet()
				.forEach(System.out::println);
		System.out.println("#####################");

//		8. Find the average salary of all employees.
		System.out.println("Average salary of all employees");
		Double avgSal = employees.stream().collect(Collectors.averagingDouble((Employee e) -> e.getSalary()));
		System.out.println(avgSal);
	}

}
