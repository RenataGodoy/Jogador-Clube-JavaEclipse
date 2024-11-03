package viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CtrlConsultarJogador;
import controller.CtrlPrograma;
import model.Jogador;

public class JanelaConsultarJogador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//
	// ATRIBUTOS
	//
	final private CtrlConsultarJogador ctrl;
	final private CtrlPrograma ctrlMae;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarJogador(CtrlConsultarJogador c, Jogador[] listaJogador) {
		this.ctrl = c;
		this.ctrlMae = new CtrlPrograma();
		setTitle("Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 183, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados(listaJogador);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		
		
		btSair.setBounds(317, 227, 89, 23);
		contentPane.add(btSair);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoExcluir();
			}
		});
		btnExcluir.setBounds(177, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoIncluir();
			}
		});
		btnIncluir.setBounds(32, 227, 89, 23);
		contentPane.add(btnIncluir);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Jogador[] listaJogador) {
		HelperTableModel h = new HelperTableModel(listaJogador);
		if(tabela == null)
			tabela = new JTable(h.getTableModel());
		else
			tabela.setModel(h.getTableModel());
	}

	/**
	 * Coloca uma mensagem para o usuário
	 */
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
}
