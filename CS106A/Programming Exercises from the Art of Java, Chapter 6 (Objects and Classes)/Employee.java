/*
 * File: Employee.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 8
 * -----------------
 *  Write the definition for a new class named Employee that stores the following data for a single employee:
 * 		• The name of the employee (a String)
 *  	• The name of the employee’s supervisor (also a String)
 *  	• The employee’s annual salary (a double)
 *  As with the other classes defined in this book, you should make sure that the instance variables containing these values are 
 *  private and instead provide get and set methods to retrieve or change any of the values. For example, if the variable emp is an employee, 
 *  you should be able to retrieve the name of the employee by writing
 *           emp.getName()
 *  or double the employee’s salary by writing
 *       emp.setSalary(emp.getSalary() * 2);
 *	You should also make sure that there is a constructor method that allows clients to initialize all these fields when a new Employee object is created, as in
 *       new Employee("Bob Cratchit", "Ebenezer Scrooge", 25.00)
 */

public class Employee {

/* Constructor */
	public Employee(String employee, String supervisor, double salary) {
		employeeName = employee; 
		supervisorName = supervisor; 
		salaryAmount = salary;	
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public  String setemployeeName(String employe) {
		return employeeName = employe;
	}
	
	public  String getSurpervisorName() {
		return supervisorName;
	}
	
	public String setSupervisorName(String supervisor) {
		return supervisorName = supervisor;
	}
	
	public  double getsalaryAmount() {
		return salaryAmount;
	}
	
	public double setSalary(double salary) {
		return salaryAmount = salary;
	}
	
	public String toString() {
		return employeeName + " is supervised by " + supervisorName + ", and earns $" + salaryAmount;
	}
	
/* Instance variables */
	private String employeeName;
	private String supervisorName;
	private double salaryAmount;
	
}
