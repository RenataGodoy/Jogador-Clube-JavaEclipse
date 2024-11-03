package controller;

import model.DaoJogador;
import model.Jogador;
import viewer.JanelaConsultarJogador;

public class CtrlConsultarJogador {

	private CtrlPrograma               ctrlPai;
	private JanelaConsultarJogador janela;
	
	public CtrlConsultarJogador(CtrlPrograma c) {
		this.ctrlPai = c;		
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogador = dao.consultarJogador();
		this.janela = new JanelaConsultarJogador(this, listaJogador);
		this.janela.setVisible(true);
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoConsultarJogador();
	}

	public void iniciarCasoDeUsoIncluir() {
			ctrlPai.iniciarCasoDeUsoIncluirJogador();
	}
	public void iniciarCasoDeUsoExcluir() {
		ctrlPai.iniciarCasoDeUsoExcluirJogador();
	}
}
