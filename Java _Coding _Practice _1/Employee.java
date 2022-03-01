public abstract class Employee{
	private int emp_id;
	private String name;
	private double salary = 0;
	private double deduction = 0;

	public Employee(){}
	public Employee(int emp_id, String name){
		this.emp_id = emp_id;
		this.name = name;
	}

	public int getEmpId(){ return emp_id; }
	public String getName(){ return name; }
	public double getSalary(){ return salary; }
	public double getDeduction(){ return deduction; }

	public void setEmpId(int emp_id){ this.emp_id = emp_id; }
	public void setName(String name){ this.name = name; }
	public void setSalary(double salary){ this.salary = salary; }
	public void setDeduction(double deduction){ this.deduction = deduction; }

	public String toString(){
		return "\n\nEmployee ID Number: " + getEmpId() + "\nName: " + getName();// + "\nSalary: " + getSalary();
	}

	public abstract double calculateSalary(double numDays);
	public abstract double calculateDeduction();
	public abstract double calculateNetPay();

}