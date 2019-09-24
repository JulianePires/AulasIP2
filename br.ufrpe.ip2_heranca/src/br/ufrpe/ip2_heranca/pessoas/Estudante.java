package br.ufrpe.ip2_heranca.pessoas;

public class Estudante extends Pessoa {
	private int				numCursos;
	private	String[]		cursos;
	private	int[]			notas;
	
	
	
	public Estudante() {
	}
	public Estudante(String nome, String endereco) {
		super(nome, endereco);
		this.cursos = new String[30];
		this.notas = new int[30];
		this.numCursos = 0;
	}
	
	public boolean addCursoNota(String curso, int nota) {
		boolean aux = false;
		for(String c: cursos) {
			for(int n: notas) {
				if()
			}
			
		}
	}

}
