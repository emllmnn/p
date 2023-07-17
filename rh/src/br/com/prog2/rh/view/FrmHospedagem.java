package br.com.prog2.rh.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmHospedagem extends JFrame {
	private JFormattedTextFieldtxtDataNascimento;
	private MaskFormatter mascaraData = null;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTable table;
	private JTable tblConsulta;
	private JComboBox cbxCliente;
	private JLabel lblMensagem;
	private JComboBox cbxGrau;
	private List<Cliente> listaCli;
	
	public void mostrarDados() {
		List<Hospedagem> listaHos = new ArrayList<>();
		HospedagemController dc = new HospedagemController();
		listaHos = dc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
		tbm.removeRow(i);
		}
		int i = 0;
		for (Hospedagem dp : listaHos) {
		tbm.addRow(new String[1]);
		tblConsulta.setValueAt(dp.getCodCliente(), i, 0);
		tblConsulta.setValueAt(dp.getNome(), i, 1);
		tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(dp.getDataNascimento()), i, 2);
		i++;
		}
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
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
	public FrmHospedagem() {
		
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
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = table.getSelectedRow();
				String codCliente = table.getValueAt(linha, 0).toString();String nome = table.getValueAt(linha, 1).toString();
				String dataNasc = table.getValueAt(linha, 3).toString();
				txtNome.setText(nome);
				txtDataNascimento.setText(dataNasc);
				Integer pos = 0;
				for (Cliente e1 : listaCli) {
				if (e1.getCodCliente().equals(table.getValueAt(linha,0).toString())) {
					pos = listaCli.indexOf(e1);
				}
				}
				cbxCliente.setSelectedItem(listaCli.get(pos).getNome());
				}
			}
				});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "Nome", "Data Nasc."
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(99)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(325, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(15)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				Integer pos = 0;
				for (Cliente e1 : listaCli) {
				if (e1.getNome().equals(cbxCliente.getSelectedItem())) {
				pos = listaCli.indexOf(e1);
				}
				}
				hos.setCodCliente(listaCli.get(pos).getCodCliente());
				hos.setNome(txtNome.getText());
				int[] dataFormatada =Util.formatarDataDeGuiParaLocalDate(txtDataNascimento.getText());
				hos.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				lblMensagem.setText(dc.inserir(hos));
				mostrarDados();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				Integer pos = 0;
				for (Cliente e1 : listaCli) {
				if (e1.getNome().equals(cbxCliente.getSelectedItem())) {
				pos = listaCli.indexOf(e1);
				}
				}
				hos.setCodCliente(listaCli.get(pos).getCodCliente());
				hos.setNome(txtNome.getText());
				int[] dataFormatada =Util.formatarDataDeGuiParaLocalDate(txtDataNascimento.getText());
				hos.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				lblMensagem.setText(dc.alterar(hos));
				mostrarDados();
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("Pesquisar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDados();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Limpar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNome.setText("");
				txtDataNascimento.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
				tbm.removeRow(i);
				}
			}
		});
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Excluir");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hos = new Hospedagem();
				HospedagemController dc = new HospedagemController();
				Integer pos = 0;
				for (Cliente e1 : listaCli) {
				if (e1.getNome().equals(cbxCliente.getSelectedItem())) {
				pos = listaCli.indexOf(e1);
				}
				}
				hos.setCodCliente(listaCli.get(pos).getCodCliente());
				hos.setNome(txtNome.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir essa hospedagem: " + txtNome.getText() + "?",
				"Exclusão", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if (JOptionPane.YES_OPTION == i) {
				lblMensagem.setText(dc.excluir(hos));
				}
				mostrarDados();
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_4)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_4))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		
		JComboBox cbxCliente = new JComboBox();
		ClienteController ec = new ClienteController();
		listaCli = ec.listarTodos();
		cbxCliente = new JComboBox();
		for(Cliente e : listaCli){
		cbxCliente.addItem(e.getNome());
		}
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento");
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
			System.err.println(e.getMessage());
			}
		JFormattedTextField TxtDataNascimento = new JFormattedTextField(mascaraData);
		
		JLabel lblNewLabel_3 = new JLabel("Mensagem:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_3)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cbxCliente, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(TxtDataNascimento, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addGap(202)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cbxCliente, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(TxtDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
