public class Programmer extends Employee{
	private String language;

	public Programmer(){}
	public Programmer(int emp_id, String name, String language){
		super.setEmpId(emp_id);
		super.setName(name);
		this.language = language;
	}

	public String getLanguage(){ return language; }
	public void setLanguage(String language){ this.language = language; }

	public void display(){
		System.out.print(super.toString() + "\nSpecialization: " + getLanguage() + "\nSalary: " + super.getSalary() + "\nDeduction: " + super.getDeduction() + "\nNet Pay: " + calculateNetPay());
	}

	public double calculateSalary(double num_days){
		double sal = 950 * num_days;

		super.setSalary(sal);
		calculateDeduction();

		return sal;
	}

	public double calculateDeduction(){
		double salary = super.getSalary();

		double sss = salary * 0.05;
		double pagibig = salary * 0.03;
		double wtax = salary * 0.08;
		double philHealth = salary * 0.03;

		double ded = sss + pagibig + wtax + philHealth;

		super.setDeduction(ded);
		calculateNetPay();

		return ded;
	}

	public double calculateNetPay(){
		double x = super.getSalary() - super.getDeduction();
		return x;
	}
}