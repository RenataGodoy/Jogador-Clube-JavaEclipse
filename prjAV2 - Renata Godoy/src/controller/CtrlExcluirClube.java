package controller;

import model.Clube;
import model.DaoClube;
import model.Clube;
import model.ModelException;
import viewer.JanelaExcluirClube;

public class CtrlExcluirClube {
	//
	// ATRIBUTOS
	//
	final private CtrlPrograma ctrlPai;
	final private JanelaExcluirClube janela;
	
	public CtrlExcluirClube(CtrlPrograma c) {
		this.ctrlPai = c;
		DaoClube dao = new DaoClube();
		Clube[] listaClube = dao.consultarClube();
		this.janela = new JanelaExcluirClube(this,listaClube);
		this.janela.setVisible(true);
	}

	public void excluirClube(Clube d) {
	    try {
	        DaoClube dao = new DaoClube();
	        dao.excluir(d); // Exclui o clube
	    } catch (ModelException me) {
	        this.janela.notificar("ERRO: " + me.getMessage());
	        return;
	    }
	    this.janela.notificar("Clube Excluída: " + d);

	    // Aqui você deve buscar a lista atualizada de clubes
	    DaoClube dao = new DaoClube();
	    Clube[] listaAtualizada = dao.consultarClube(); // Atualiza a lista

	    this.ctrlPai.getJanelaConsultarClube().atualizarDados(listaAtualizada);

	    this.encerrarCasoDeUso(); // Encerra o caso de uso
	}

	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoExcluirClube();
	}
	public void iniciarCasoDeUsoConsultar() {
		ctrlPai.iniciarCasoDeUsoConsultarClube();
	}
	public void iniciarCasoDeUsoExcluir() {
		ctrlPai.iniciarCasoDeUsoExcluirClube();
	}

}
