package controller;

import model.DaoJogador;
import model.Jogador;
import model.ModelException;
import viewer.JanelaJogador;

public class CtrlIncluirJogador {
	//
	// ATRIBUTOS
	//
	final private CtrlPrograma ctrlPai;
	final private JanelaJogador janela;
	
	public CtrlIncluirJogador(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaJogador(this, null);
		this.janela.setVisible(true);
	}

	public void incluirJogador(String codigo, String apelido, String posicao) {
		// Instanciando o objeto Jogador
		Jogador d;
		try {
			d = new Jogador(codigo, apelido, posicao);
		}
		catch(ModelException me) {
			this.janela.notificar("ERRO: " + me.getMessage());
			return;
		}
		this.janela.notificar("Nova Jogador Criada: " + d);

		// Guardar o objeto criado
		DaoJogador dao = new DaoJogador();
		dao.incluir(d);
		
		this.encerrarCasoDeUso();
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoIncluirJogador();
	}

	public void iniciarCasoDeUsoConsultar() {
		this.ctrlPai.iniciarCasoDeUsoConsultarJogador();
		
	}
}
