package br.ufrpe.ip2ArrayList;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SistemaRH {

	public static void imprimirFolha(List<Funcionario>funcionario) {
		double somaSalario  = 0;
		System.out.print("Folha de pagamento da empresa:");
		System.out.print("\nNome:            Salário:             Função:");
		for(Funcionario fun:funcionario) {
			System.out.println(fun.getNome()+"     "+fun.getSalario()+"      "+fun.getCargo());
			somaSalario+=fun.getSalario();
		}
		System.out.print("\n\nTotal da folha de pagamento: "+somaSalario);
	}
	
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		
		boolean status = true;
		int opcao = 0;

		GerenciadorFuncionarios g = new GerenciadorFuncionarios();

		while (status == true) {
			System.out.println("---------Bem vindo ao sistema de cadastro----------");
			System.out.println("---------    Escolha uma opção abaixo:    ----------");
			System.out.println("1- INSERIR FUNCIONARIO\n2- BUSCAR FUNCIONARIO\n"
					+ "3- REMOVER FUNCIONARIO\n4- ATUALIZAR FUNCIONARIO\n"
					+ "5- LISTAR FUNCIONARIO DE UM CARGO\n6- MEDIA SALARIAL POR CARGO\n"
					+ "7- LISTAR FUNCIONARIOS QUE GANHAM ACIMA DE UM SALARIO\n"
					+ "8- FUNCIONARIO MAIS ANTIGO\n9- FUNCIONARIO MAIS NOVO\n"
					+ "10- MEDIA SALARIAL POR PERIODO\n"
					+ "11- IMPRIMIR FOLHA DE PAGAMENTO\n12- SAIR ");
			opcao = entrada.nextInt();

			switch (opcao){
			case 1:
				Funcionario f1 = new Funcionario();

				System.out.print("\nCódigo:  ");
				int cod = entrada.nextInt();
				f1.setCodigo(cod);

				System.out.print("\nNome:  ");
				String nome = entrada.next();
				f1.setNome(nome);

				System.out.print("\nSalário:  ");
				double sal = entrada.nextDouble();
				f1.setSalario(sal);

				System.out.print("\nCargo (1-Motorista 2-Vendedor 3-Gerente):  ");
				int cargo = entrada.nextInt();
				f1.setCargo(cargo);

				System.out.print("\nData de admissão (yyyy-mm-dd):  ");
				String data = entrada.next();
				f1.setDataAdmissao(LocalDate.parse(data));
				
				g.inserir(f1);
				break;

			case 2:
				System.out.print("\nDigite o código do usuário a ser buscado: ");
				cod = entrada.nextInt();
				System.out.print(g.buscar(cod));
				System.out.print("\n\n");
				break;
				
			case 3:
				System.out.println("Digite o código do usuário a ser removido: ");
				cod = entrada.nextInt();
				System.out.println(g.remover(cod));
				System.out.print("\n\n");
				break;
				
			case 4:
				Funcionario f2 = new Funcionario();
				System.out.println("Nome novo funcionário:  ");
				nome = entrada.nextLine();
				f2.setNome(nome);

				System.out.println("Salário novo funcionário:  ");
				sal = entrada.nextDouble();
				f2.setSalario(sal);

				System.out.println("Cargo (1-Motorista 2-Vendedor 3-Gerente):  ");
				cargo = entrada.nextInt();
				f2.setCargo(cargo);

				System.out.println("Data de admissão (yyyy-mm-dd):  ");
				data = entrada.nextLine();
				f2.setDataAdmissao(LocalDate.parse(data));
				
				System.out.println("Digite o código do usuário a ser atualizado: ");
				cod = entrada.nextInt();
				System.out.println(g.atualizar(cod, f2));
				System.out.print("\n\n");
				break;
				
			case 5:
				System.out.println("Cargo a ser listado: ");
				String nomeCargo = entrada.nextLine();
				
				System.out.println(g.listarPorCargo(nomeCargo));
				System.out.print("\n\n");
				break;
			
			case 6:
				System.out.println("Cargo a ser listado: ");
				nomeCargo = entrada.nextLine();
				System.out.println("Media salarial do cargo: "+g.calcularMediaSalarialPorCargo(nomeCargo));
				System.out.print("\n\n");
				break;
			
			case 7:
				System.out.println("Digite o salário base: ");
				sal = entrada.nextDouble();
				System.out.println(g.ganhamAcimaDe(sal));
				System.out.print("\n\n");
				break;
			
			case 8:
				System.out.println("Funcionário mais antigo: "+g.obterFuncionarioMaisAntigo());
				System.out.print("\n\n");
				break;
			
			case 9:
				System.out.println("Funcionário mais novo: "+g.obterFuncionarioMaisNovo());
				System.out.print("\n\n");
				break;
				
			case 10:
				System.out.println("Digite a data de início (yyyy-mm-dd): ");
				data = entrada.nextLine();
				LocalDate dataInicio = LocalDate.parse(data);
				System.out.println("Digite a data de fim (yyyy-mm-dd): ");
				data = entrada.nextLine();
				LocalDate dataFim = LocalDate.parse(data);
				System.out.println(g.calcularMediaSalarialPorPeriodo(dataInicio, dataFim));
				System.out.print("\n\n");
			
			case 11:
				List<Funcionario>lista1 = g.ganhamAcimaDe(3000.00);
				imprimirFolha(lista1);
				System.out.print("\n\n");
				break;
			
			case 12:
				status = false;
				break;
			}
		}

	}

}
