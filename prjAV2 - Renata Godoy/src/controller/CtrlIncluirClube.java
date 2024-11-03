package controller;

import model.DaoClube;
import model.Clube;
import model.ModelException;
import viewer.JanelaClube;

public class CtrlIncluirClube {
	//
	// ATRIBUTOS
	//
	final private CtrlPrograma ctrlPai;
	final private JanelaClube janela;
	
	public CtrlIncluirClube(CtrlPrograma c) {
		this.ctrlPai = c;
		this.janela = new JanelaClube(this);
		this.janela.setVisible(true);
	}

	public void incluirClube(String codigo, String apelido, String posicao) {
		// Instanciando o objeto Clube
		Clube d;
		try {
			d = new Clube(codigo, apelido, posicao);
		}
		catch(ModelException me) {
			this.janela.notificar("ERRO: " + me.getMessage());
			return;
		}
		this.janela.notificar("Nova Clube Criada: " + d);

		// Guardar o objeto criado
		DaoClube dao = new DaoClube();
		dao.incluir(d);
		
		this.encerrarCasoDeUso();
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoIncluirClube();
	}

	public void iniciarCasoDeUsoConsultarClube() {
		this.ctrlPai.iniciarCasoDeUsoConsultarClube();
		
	}
}
