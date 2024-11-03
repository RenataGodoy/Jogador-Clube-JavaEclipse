package model;

import java.io.Serializable;

public class Jogador implements Serializable {
	private String nome;
	private String apelido;
	private String posicao;
	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	//	private Clube clube;
	//

	public Jogador(String nome, String apelido, String posicao) throws ModelException {
		this.setNome(nome);
		this.setApelido(apelido);
		this.setPosicao(posicao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo!");
		if (nome.length() > 40)
			throw new ModelException("Nome só pode conter 40 caracteres");
	}

	public static void validarApelido(String apelido) throws ModelException {
		if (apelido == null || apelido.length() == 0)
			throw new ModelException("O apelido não pode ser nulo!");
		if (apelido.length() > 15)
			throw new ModelException("Nome só pode conter 40 caracteres");

		for (int i = 0; i < apelido.length(); i++) {
			char c = apelido.charAt(i);
			if (!Character.isAlphabetic(c))
				throw new ModelException("O caracter na posição " + i + " deve ser alabético");
		}
	}

	public static void validarPosicao(String posicao) throws ModelException {
		if (posicao == null || posicao.length() == 0)
			throw new ModelException("A posição não pode estar vazio!");

		if (!posicao.equals("Goleiro") && !posicao.equals("Defesa") && !posicao.equals("Meio Campo")
				&& !posicao.equals("Ataque")) {
			throw new ModelException("Deve ser um gênero musical ja existente!");
		}
	}
	
	public String toString() {
		return this.nome + "-" +
				this.apelido + "-"+
				this.posicao;
	}
}
