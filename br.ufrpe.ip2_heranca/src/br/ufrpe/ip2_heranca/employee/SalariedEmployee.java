package br.ufrpe.ip2_heranca.employee;

public class SalariedEmployee extends Employee {
	
	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary = weeklySalary;
	}
	
	// configura o salário
	 public void setWeeklySalary(double weeklySalary)
	 {
		 if (weeklySalary < 0.0)throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		 this.weeklySalary = weeklySalary;
	 }
	
	 // retorna o salário
	 public double getWeeklySalary()
	 {
		 return weeklySalary;
	 }
	
	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f",
		super.toString(), "weekly salary", getWeeklySalary()); 
	}
	
	public double earnings() {
		return getWeeklySalary();
	}
	
	/* calcula vencimentos: implementa o método Payable da interface
	que era abstrata na superclasse Employee */
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}

}
