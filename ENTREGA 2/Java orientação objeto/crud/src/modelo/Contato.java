package modelo;

import java.util.Date;

public class Contato {
	private int id;
	private String nome;
	private String idade;
	private Date datacadastro;
	public Contato() {
		super();
	}
	public Contato(int id, String nome, String idade, Date datacadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.datacadastro = datacadastro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", idade=" + idade + ", datacadastro=" + datacadastro + "]";
	}
	

}
