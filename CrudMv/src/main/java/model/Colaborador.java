package model;

public class Colaborador {
	private int id;
	private String Nome;
	private String Cpf;
	private String Alimento;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getAlimento() {
		return Alimento;
	}
	public void setAlimento(String alimento) {
		Alimento = alimento;
	}
	
	@Override
	public String toString() {
		return "Colaboradores [id=" + id + ", Nome=" + Nome + ", Cpf=" + Cpf + ", Alimento=" + Alimento + ", getId()="
				+ getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getAlimento()=" + getAlimento()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
