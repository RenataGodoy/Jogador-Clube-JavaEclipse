package viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirClube;
import model.Clube;
import model.ModelException;

public class JanelaClube extends JFrame {

	private static final long serialVersionUID = 1L;
	final private CtrlIncluirClube ctrl;
	private JComboBox cbClube;
	private JPanel contentPane;
	private JTextField tFNome;
	private JTextField tFCidade;
	private JTextField tFUF;
	private JButton btnConsultarClube;
	private JButton btnSalvarClube;


	public JanelaClube(CtrlIncluirClube c) {
		this.ctrl = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 193, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Clube");
		lblNewLabel.setBounds(94, 11, 92, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTitulo = new JLabel("Nome:");
		lblTitulo.setBounds(39, 62, 92, 14);
		contentPane.add(lblTitulo);

		tFNome = new JTextField();
		tFNome.setBounds(162, 59, 86, 20);
		contentPane.add(tFNome);
		tFNome.setColumns(10);

		tFCidade = new JTextField();
		tFCidade.setColumns(10);
		tFCidade.setBounds(162, 91, 86, 20);
		contentPane.add(tFCidade);

		JLabel lblNewLabel_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1.setBounds(39, 94, 92, 14);
		contentPane.add(lblNewLabel_1_1);

		tFUF = new JTextField();
		tFUF.setColumns(10);
		tFUF.setBounds(162, 122, 86, 20);
		contentPane.add(tFUF);

		JLabel lblNewLabel_1_2 = new JLabel("UF:");
		lblNewLabel_1_2.setBounds(39, 125, 92, 14);
		contentPane.add(lblNewLabel_1_2);

		btnConsultarClube = new JButton("Consultar Clube");
		btnConsultarClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoConsultarClube();
			}
		});
		btnConsultarClube.setBounds(52, 200, 162, 23);
		contentPane.add(btnConsultarClube);

		btnSalvarClube = new JButton("Salvar Clube");
		btnSalvarClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tFNome.getText();
				String cidade = tFCidade.getText();
				String uf = tFUF.getText();
				try {
					Clube.validarNome(nome);
					Clube.validarCidade(cidade);
					Clube.validarUF(uf);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btnSalvarClube, "ERRO: " + me.getMessage());
					return;
				}
				ctrl.incluirClube(nome, cidade, uf);
			}

		});
		btnSalvarClube.setBounds(52, 166, 162, 23);
		contentPane.add(btnSalvarClube);
	}

	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
}
