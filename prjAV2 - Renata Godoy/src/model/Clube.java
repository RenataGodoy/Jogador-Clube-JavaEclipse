package model;

import java.io.Serializable;

public class Clube implements Serializable {
	private String nome;
	private String cidade;
	private String UF;
	
	
	public Clube(String nome, String cidade, String uf)
	throws ModelException{
		this.setNome(nome);
		this.setCidade(cidade);
		this.setUF(uf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}
	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo!");
		if (nome.length() > 40)
			throw new ModelException("Nome só pode conter 40 caracteres");
	}
	
	public static void validarCidade(String cidade) throws ModelException {
		if (cidade == null || cidade.length() == 0)
			throw new ModelException("O cidade não pode ser nulo!");
		if (cidade.length() > 15)
			throw new ModelException("Nome só pode conter 40 caracteres");

		for (int i = 0; i < cidade.length(); i++) {
			char c = cidade.charAt(i);
			if (!Character.isAlphabetic(c))
				throw new ModelException("O caracter na posição " + i + " deve ser alabético");
		}
	}
	public static void validarUF(String uf)
	throws ModelException{
		if (uf == null || uf.length() == 0)
			throw new ModelException("O uf não pode ser nulo!");
		if(uf.length() > 2)
			throw new ModelException("O uf só pode ter 2 digitos!");
		for (int i = 0; i < 2; i++) {
			char c = uf.charAt(i);
			if (!Character.isUpperCase(c))
				throw new ModelException("O caracter na posição " + i + " deve ser maiusculo");
		}
	}
		
	@Override
	public String toString() {
		return this.nome + "-" +
				this.cidade + "-"+
				this.UF;
	}
	

	
	
}
