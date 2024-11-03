package viewer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirJogador;
import model.Jogador;
import model.ModelException;

public class JanelaJogador extends JFrame {

	private static final long serialVersionUID = 1L;
	final private CtrlIncluirJogador ctrl;
	private JPanel contentPane;
	private JTextField tFNome;
	private JTextField tFApelido;
	private JButton btnConsultarJogador;
	private JButton btnSalvarJogador;

	public JanelaJogador(CtrlIncluirJogador c, Jogador[] listaJogador) {
		this.ctrl = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 193, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Jogador");
		lblNewLabel.setBounds(94, 11, 92, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTitulo = new JLabel("Nome:");
		lblTitulo.setBounds(39, 62, 92, 14);
		contentPane.add(lblTitulo);

		tFNome = new JTextField();
		tFNome.setBounds(162, 59, 86, 20);
		contentPane.add(tFNome);
		tFNome.setColumns(10);

		tFApelido = new JTextField();
		tFApelido.setColumns(10);
		tFApelido.setBounds(162, 91, 86, 20);
		contentPane.add(tFApelido);

		JLabel lblNewLabel_1_1 = new JLabel("Apelido:");
		lblNewLabel_1_1.setBounds(39, 94, 92, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Posicao");
		lblNewLabel_1_2.setBounds(39, 125, 92, 14);
		contentPane.add(lblNewLabel_1_2);

		btnConsultarJogador = new JButton("Consultar Jogador");
		btnConsultarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoConsultar();
			}
		});
		btnConsultarJogador.setBounds(52, 200, 162, 23);
		contentPane.add(btnConsultarJogador);
		
		JComboBox cBPosicao = new JComboBox();
		cBPosicao.setModel(new DefaultComboBoxModel(new String[] {"Goleiro", "Defesa", "Meio Campo", "Ataque"}));
		cBPosicao.setBounds(162, 122, 86, 22);
		contentPane.add(cBPosicao);

		btnSalvarJogador = new JButton("Salvar Jogador");
		btnSalvarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tFNome.getText();
				String apelido = tFApelido.getText();
				String posicao = (String) cBPosicao.getSelectedItem();
				try {
					Jogador.validarNome(nome);
					Jogador.validarApelido(apelido);
					Jogador.validarPosicao(posicao);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btnSalvarJogador, "ERRO: " + me.getMessage());
					return;
				}
				ctrl.incluirJogador(nome, apelido, posicao);
			}

		});
		btnSalvarJogador.setBounds(52, 166, 162, 23);
		contentPane.add(btnSalvarJogador);
		
	}

	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
}
