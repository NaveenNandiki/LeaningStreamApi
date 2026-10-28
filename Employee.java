package gut.streams;

class Employee {
	private int empId;
	private String empName;
	private double salary;
	private int deptId;
	private int age;

	public Employee(int empId, String empName, double salary, int deptId, int age) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptId = deptId;
		this.age = age;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public double getSalary() {
		return salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return empName + " - " + salary;
	}
}
