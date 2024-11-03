package controller;

import model.DaoJogador;
import model.Jogador;
import model.ModelException;
import viewer.JanelaExcluirJogador;

public class CtrlExcluirJogador {
	//
	// ATRIBUTOS
	//
	final private CtrlPrograma ctrlPai;
	final private JanelaExcluirJogador janela;
	
	public CtrlExcluirJogador(CtrlPrograma c) {
		this.ctrlPai = c;
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogador = dao.consultarJogador();
		this.janela = new JanelaExcluirJogador(this,listaJogador);
		this.janela.setVisible(true);
	}

	public void excluirJogador(Jogador d) {
		try {
			DaoJogador dao = new DaoJogador();
			dao.excluir(d);
		}
		catch(ModelException me) {
			this.janela.notificar("ERRO: " + me.getMessage());
			return;
		}
		this.janela.notificar("Jogador Excluída: " + d);
		
		this.encerrarCasoDeUso();
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoExcluirJogador();
	}
}
