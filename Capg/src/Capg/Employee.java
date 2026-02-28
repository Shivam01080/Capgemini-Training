package Capg;

public class Employee {
	int empid;
	String name;
	public Employee(int empid, String name) {
		super();
		this.empid = empid;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + "]";
	}

}

