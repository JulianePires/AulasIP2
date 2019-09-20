package br.ufrpe.ip2_heranca.employee;

public class PayrollSystemTest {

	public static void main(String[] args) {
		// criação de objetos de subclasse
		SalariedEmployee salariedEmployee = 
				new SalariedEmployee("João", "Costa", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee =
				new HourlyEmployee("Maria", "Silva", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = 
				new CommissionEmployee("Joana", "Medeiros", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = 
				new BasePlusCommissionEmployee("Pedro", "Marinho", "444-44-4444", 5000, .04, 300);

		System.out.println("Employees processados individualmente: ");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",
				salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", 
				hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", 
				commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", 
				basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
		
		//cria um array Employee de quatro elementos
		Employee[] employees = new Employee[4];
		
		//inicializa o array com employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		
		System.out.printf("Employees processados polimoficamente:%n%n");
		
		// processa genericamente cada um dos employees
		for(Employee currentEmployee: employees) {
			System.out.println(currentEmployee); //invoca toString
			
			//determina se elemento é um BsePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				//downcast da referência de Employee referência a BasePlusEmployee
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				employee.setBaseSalary(1.10*employee.getBaseSalary());	
				System.out.printf("new base salary with 10%% increase is : $%,.2f%n", employee.getBaseSalary());
			}
			
			System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
		}
		
		// obtém o nome do tipo de cada objeto no array employees
		for(int j = 0; j < employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
		}
	}
}
