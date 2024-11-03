package controller;

import model.DaoClube;
import model.Clube;
import viewer.JanelaConsultarClube;

public class CtrlConsultarClube {

	private CtrlPrograma               ctrlPai;
	private JanelaConsultarClube janela;
	
	public CtrlConsultarClube(CtrlPrograma c) {
		this.ctrlPai = c;		
		DaoClube dao = new DaoClube();
		Clube[] listaClube = dao.consultarClube();
		this.janela = new JanelaConsultarClube(this, listaClube);
		this.janela.setVisible(true);
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoConsultarClube();
	}

	public void iniciarCasoDeUsoIncluir() {
			ctrlPai.iniciarCasoDeUsoIncluirClube();
	}

	public void iniciarCasoDeUsoExcluir() {
		ctrlPai.iniciarCasoDeUsoExcluirClube();
	}
	public void iniciarCasoDeUsoConsultar() {
		ctrlPai.iniciarCasoDeUsoConsultarClube();
	}
}
