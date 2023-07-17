package br.com.prog2.rh.view;

import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEstado;
	private JTextField txtNascimento;
	private JTable tblConsulta;
	private JTextField txtCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 454, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codigo = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String rg = tblConsulta.getValueAt(linha, 2).toString();
				String endereco = tblConsulta.getValueAt(linha, 3).toString();
				String bairro = tblConsulta.getValueAt(linha, 4).toString();
				String cidade = tblConsulta.getValueAt(linha, 5).toString();
				String estado = tblConsulta.getValueAt(linha, 6).toString();
				String cep = tblConsulta.getValueAt(linha, 7).toString();
				String nascimento = tblConsulta.getValueAt(linha, 8).toString();
				txtCodigo.setText(codigo);
				txtNome.setText(nome);
				txtRg.setText(rg);
				txtEndereco.setText(endereco);
				txtBairro.setText(bairro);
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
				txtCep.setText(cep);
				txtNascimento.setText(nascimento);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "RG", "Estado", "Cidade", "Endere\u00E7o", "Bairro", "CEP", "Nasc."
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		tblConsulta.getColumnModel().getColumn(8).setResizable(false);
		panel_2.add(tblConsulta);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				private JLabel lblMensagem;
				lblMensagem = new JLabel("Mensagem:");
				Cliente cli = new Cliente();
				ClienteController ec = new ClienteController();
				cli.setCodigo(txtCodigo.getText());
				cli.setNome(txtNome.getText());
				cli.setRg(txtRg.getText());
				cli.setEndereco(txtEndereco.getText());
				cli.setBairro(txtBairro.getText());
				cli.setCidade(txtCidade.getText());
				cli.setEstado(txtEstado.getText());
				cli.setCep(txtCep.getText());
				cli.setNascimento(txtNascimento.getText());
				lblMensagem.setText(ec.inserir(cli));
				pesquisar();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController ec = new ClienteController();
				cli.setCodigo(txtCodigo.getText());
				cli.setNome(txtNome.getText());
				cli.setRg(txtRg.getText());
				cli.setEndereco(txtEndereco.getText());
				cli.setBairro(txtBairro.getText());
				cli.setCidade(txtCidade.getText());
				cli.setEstado(txtEstado.getText());
				cli.setCep(txtCep.getText());
				cli.setNascimento(txtNascimento.getText());
				pesquisar();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController ec = new ClienteController();
				cli.setCodigo(txtCodigo.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir esse cliente: "+txtNome.getText()+"?","Exclusão",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
				lblMensagem.setText(ec.excluir(cli));
				}
				pesquisar();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Cliente> listaCli = new ArrayList();
				ClienteController ec = new ClienteController();
				listaCli = ec.listarTodos();
				DefaultTableModel tbm =(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
				int i = 0;
				for(Cliente ep : listaCli){
				tbm.addRow(new String[1]);
				tblConsulta.setValueAt(ep.getCodigo(), i, 0);
				tblConsulta.setValueAt(ep.getNome(), i, 1);
				tblConsulta.setValueAt(ep.getRg(), i, 2);
				tblConsulta.setValueAt(ep.getEndereco(), i, 3);
				tblConsulta.setValueAt(ep.getBairro(), i, 4);
				tblConsulta.setValueAt(ep.getCidade(), i, 5);
				tblConsulta.setValueAt(ep.getEstado(), i, 6);
				tblConsulta.setValueAt(ep.getCep(), i, 7);
				tblConsulta.setValueAt(ep.getNascimento(), i, 8);
				i++;
				}
			}
		});
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Limpar");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigo.setText("");
				txtNome.setText("");
				txtRg.setText("");
				txtEndereco.setText("");
				txtBairro.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
				txtCep.setText("");
				txtNascimento.setText("");
				DefaultTableModel tbm =
						(DefaultTableModel)tblConsulta.getModel();for(int i = tbm.getRowCount()-1; i >= 0; i--){
							tbm.removeRow(i);
							}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Código");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		
		JLabel lblNewLabel_5 = new JLabel("Cidade");
		
		JLabel lblNewLabel_4 = new JLabel("Bairro");
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		
		JLabel lblNewLabel_8 = new JLabel("Nascimento");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		txtNascimento = new JTextField();
		txtNascimento.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("CEP");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_4)
									.addComponent(lblNewLabel)
									.addComponent(lblNewLabel_1)
									.addComponent(lblNewLabel_2))
								.addGap(28))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_8)
								.addGap(18)))
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtCidade, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
										.addComponent(txtEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
										.addComponent(txtEstado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtBairro, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
									.addGap(117)))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtCep, Alignment.LEADING)
								.addComponent(txtNascimento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
							.addContainerGap(173, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtEndereco, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 2, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
