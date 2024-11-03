package controller;

import viewer.JanelaConsultarClube;
import viewer.JanelaPrincipal;

public class CtrlPrograma {
	//
	// ATRIBUTOS
	//
	private JanelaPrincipal janela;

	private CtrlIncluirJogador ctrlIncluirJogador;
	private CtrlIncluirClube ctrlIncluirClube;

	private CtrlConsultarJogador ctrlConsultarJogador;
	private CtrlConsultarClube ctrlConsultarClube;

	private CtrlExcluirJogador ctrlExcluirJogador;
	private CtrlExcluirClube ctrlExcluirClube;
	
	private JanelaConsultarClube janelaConsultarClube;
	//
	// MÉTODOS
	//
	public CtrlPrograma() {
		this.janela = new JanelaPrincipal(this);
		this.janela.setVisible(true);
	}

	public void iniciarCasoDeUsoIncluirJogador() {
		if (this.ctrlIncluirJogador == null)
			this.ctrlIncluirJogador = new CtrlIncluirJogador(this);
	}

	public void encerrarCasoDeUsoIncluirJogador() {
		this.ctrlIncluirJogador = null;
	}

	public void iniciarCasoDeUsoExcluirJogador() {
		if (this.ctrlExcluirJogador == null)
			this.ctrlExcluirJogador = new CtrlExcluirJogador(this);
	}

	public void encerrarCasoDeUsoExcluirJogador() {
		this.ctrlExcluirJogador = null;
	}

	public void iniciarCasoDeUsoConsultarJogador() {
		this.ctrlConsultarJogador = new CtrlConsultarJogador(this);
	}

	public void encerrarCasoDeUsoConsultarJogador() {
		this.ctrlConsultarJogador = null;
	}

	public void iniciarCasoDeUsoIncluirClube() {
		if (this.ctrlIncluirClube == null)
			this.ctrlIncluirClube = new CtrlIncluirClube(this);
	}

	public void encerrarCasoDeUsoIncluirClube() {
		this.ctrlIncluirClube = null;
	}

	public void iniciarCasoDeUsoExcluirClube() {
		if (this.ctrlExcluirClube == null)
			this.ctrlExcluirClube = new CtrlExcluirClube(this);
	}

	public void encerrarCasoDeUsoExcluirClube() {
		this.ctrlExcluirClube = null;
	}

	public void iniciarCasoDeUsoConsultarClube() {
		this.ctrlConsultarClube = new CtrlConsultarClube(this);
	}

	public void encerrarCasoDeUsoConsultarClube() {
		this.ctrlConsultarClube = null;
	}

	public void encerrarPrograma() {
		System.exit(0);
	}

	public static void main(String[] args) {
		CtrlPrograma p = new CtrlPrograma();
	}
	public JanelaConsultarClube getJanelaConsultarClube() {
	    return this.janelaConsultarClube; // A janela que exibe os clubes
	}


}
