package questao02.beans;

import java.time.LocalDate;

public abstract class Usuario {
	/*
	 * Atributos
	 */
	private String		email;
	private	String		nomeCompleto;
	private LocalDate	dataNascimento;
	/**
	 * @param email - Endereço de email (Torna usuário único)
	 * @param nomeCompleto - Nome completo do usuário
	 * @param dataNascimento - 
	 */
	public Usuario(String email, String nomeCompleto, LocalDate dataNascimento) {
		super();
		setEmail(email);
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
}
