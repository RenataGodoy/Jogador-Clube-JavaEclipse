package viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlExcluirClube;
import model.Clube;

public class JanelaExcluirClube extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	// ATRIBUTOS
	//
	final private CtrlExcluirClube ctrl;
	private JPanel     contentPane;
	private JComboBox  cbClube;

	/**
	 * Create the frame.
	 */
	public JanelaExcluirClube(CtrlExcluirClube c, Clube[] listaClube) {
		this.ctrl = c;
		setTitle("Excluir Clube");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 214);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 183, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Colocamos um 'CASTING' na frente de 'getSelectedItem'
				// pois esse método devolve 'ponteiro para Object', mas
				// nós sabemos que o que está sendo devolvido é mais do
				// que um Object; é uma disciplina. Então avisamos ao 
				// compilador para ver o retorno como sendo um 'ponteiro
				// para Disciplina'
				Clube d = (Clube)cbClube.getSelectedItem();
				
				// Notifico ao controlador que o usuário quer
				// incluir uma pessoa
				ctrl.excluirClube(d);
			}
		});
		btOk.setBounds(78, 110, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btCancelar.setBounds(261, 110, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblNewLabel_3_1 = new JLabel("Selecione o Clube a ser Excluído:");
		lblNewLabel_3_1.setBounds(30, 31, 375, 14);
		contentPane.add(lblNewLabel_3_1);
		
		// Crio a combo box e passo quais são as disciplinas
		// que o usuário poderá escolher.
		cbClube = new JComboBox(listaClube);
		cbClube.setBounds(30, 64, 375, 22);
		contentPane.add(cbClube);
	}

	/**
	 * Coloca uma mensagem para o usuário
	 */
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);		
	}
}
