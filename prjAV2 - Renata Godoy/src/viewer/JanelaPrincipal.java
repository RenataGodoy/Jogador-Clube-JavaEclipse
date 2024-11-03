package viewer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final private CtrlPrograma ctrl;
	

	public JanelaPrincipal(CtrlPrograma c) {
		this.ctrl = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 183, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Jogador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoConsultarJogador();
			}
		});
		btnNewButton.setBounds(40, 68, 89, 92);
		contentPane.add(btnNewButton);
		
		JButton btnClube = new JButton("Clube");
		btnClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoConsultarClube();
			}
		});
		btnClube.setBounds(191, 68, 89, 92);
		contentPane.add(btnClube);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(112, 192, 89, 33);
		contentPane.add(btnFechar);
	}
}
