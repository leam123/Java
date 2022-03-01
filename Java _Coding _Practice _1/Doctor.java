public class Doctor extends Employee{
	private String spec;

	public Doctor(int emp_id, String name, String spec){
		super.setEmpId(emp_id);
		super.setName(name);
		this.spec = spec;
	}

	public String getSpec(){ return spec; }
	public void setSpec(String spec){ this.spec = spec; }

	public void display(){
		System.out.print(super.toString() + "\nSpecialization: " + getSpec() + "\nSalary: " + super.getSalary() + "\nDeduction: " + super.getDeduction() + "\nNet Pay: " + calculateNetPay());
	}

	public double calculateSalary(double num_days){
		double sal = 0.0;

		if(getSpec().equalsIgnoreCase("Pediatrician")){
			sal = 2050 * num_days;
		}
		else if(getSpec().equalsIgnoreCase("Ob-Gynecologist")){
			sal = 2650 * num_days;
		}
		else if(getSpec().equalsIgnoreCase("Neurologist")){
			sal = 6575 * num_days;
		}
		else{
			sal = 0 * num_days;
		}

		super.setSalary(sal);
		calculateDeduction();

		return sal;
	}

	public double calculateDeduction(){
		double salary = super.getSalary();
		double sss=0.0, pagibig=0.0, wtax=0.0, philHealth=0.0, ded=0.0;

		if(salary <= 10000){
			sss = salary * 0.03;
			pagibig = salary * 0.02;
			wtax = salary * 0.05;
			philHealth = salary * 0.01;
		}
		else if(salary>10000 && salary<=20000){
			sss = salary * 0.05;
			pagibig = salary * 0.04;
			wtax = salary * 0.10;
			philHealth = salary * 0.025;
		}
		else if(salary>20000 && salary<=30000){
			sss = salary * 0.07;
			pagibig = salary * 0.07;
			wtax = salary * 0.15;
			philHealth = salary * 0.05;
		}
		else if(salary>30000){
			sss = salary * 0.10;
		   	pagibig = salary * 0.10;
			wtax = salary * 0.30;
		   	philHealth = salary * 0.08;
        }

        ded = sss + pagibig + wtax + philHealth;
		super.setDeduction(ded);
		calculateNetPay();

       	return ded;
	}

	public double calculateNetPay(){
		double x = super.getSalary() - super.getDeduction();
		return x;
	}
}