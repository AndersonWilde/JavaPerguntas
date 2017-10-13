import java.awt.EventQueue;

import javax.swing.JFrame;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.renderable.RenderableImageOp;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;

public class JanelaPrincipal {

	private JFrame frmQuiz;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final Action action = new SwingAction();
	com.db4o.ObjectContainer recordset;
	boolean novoRegistro = false;
	Pergunta perguntaAtual;
	int palpite = 0;
	ObjectSet<Pergunta> perguntas;
	JRadioButton radios[] = new JRadioButton[5];  


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frmQuiz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuiz = new JFrame();
		frmQuiz.setTitle("Quiz");
		frmQuiz.setBounds(100, 100, 644, 416);
		frmQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuiz.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 12, 538, 338);
		frmQuiz.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Pergunta:");
		label.setBounds(0, 86, 90, 15);
		panel_1.add(label);
		
		JLabel label_6 = new JLabel("Resposta certa:");
		label_6.setBounds(12, 281, 141, 15);
		panel_1.add(label_6);
		

		
		JLabel lblResponta = new JLabel("Marque a resposta correta");
		lblResponta.setFont(new Font("Dialog", Font.BOLD, 16));
		lblResponta.setBounds(139, 12, 368, 41);
		panel_1.add(lblResponta);
		
		
		JLabel label_7 = new JLabel("Pergunta:");
		label_7.setBounds(84, 86, 442, 15);
		panel_1.add(label_7);

		JLabel label_1 = new JLabel("Resposta certa:");
		label_1.setBounds(139, 281, 141, 15);
		panel_1.add(label_1);
		
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setMnemonic('1');
		radioButton_1.setBounds(10, 108, 520, 23);
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				palpite = 1;
				radios[1].setSelected(false);
				radios[2].setSelected(false);
				radios[3].setSelected(false);
				radios[4].setSelected(false);
				label_1.setText("");
				
			}
		});
		
		panel_1.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setMnemonic('1');
		radioButton_2.setBounds(12, 135, 518, 23);
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				palpite = 2;
				radios[0].setSelected(false);
				radios[2].setSelected(false);
				radios[3].setSelected(false);
				radios[4].setSelected(false);
				label_1.setText("");
			}
		});
		panel_1.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("New radio button");
		radioButton_3.setMnemonic('1');
		radioButton_3.setBounds(12, 166, 514, 23);
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				palpite = 3;
				radios[0].setSelected(false);
				radios[1].setSelected(false);
				radios[3].setSelected(false);
				radios[4].setSelected(false);
				label_1.setText("");
			}
		});
		
		panel_1.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("New radio button");
		radioButton_4.setMnemonic('1');
		radioButton_4.setBounds(12, 193, 514, 23);
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radios[0].setSelected(false);
				radios[1].setSelected(false);
				radios[2].setSelected(false);
				radios[4].setSelected(false);
				palpite = 4;
				label_1.setText("");
			}
		});
		panel_1.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("New radio button");
		radioButton_5.setMnemonic('1');
		radioButton_5.setBounds(12, 216, 518, 23);
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				palpite = 5;
				radios[0].setSelected(false);
				radios[1].setSelected(false);
				radios[2].setSelected(false);
				radios[3].setSelected(false);
				label_1.setText("");
			}
		});
		panel_1.add(radioButton_5);
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (perguntaAtual.respostaCerta == palpite) {
					label_1.setText("Acertou!!!");
				}else
				{
					
					label_1.setText("Errou!!!");
					
				}
			}
		});
		btnConfirmar.setBounds(12, 301, 117, 25);
		panel_1.add(btnConfirmar);		
		
		JPanel panel = new JPanel();
		panel.setBounds(49, 0, 538, 338);
		frmQuiz.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTpico = new JLabel("Pergunta:");
		lblTpico.setBounds(0, 86, 90, 15);
		panel.add(lblTpico);
		
		JLabel lblResposta = new JLabel("Resposta 1:");
		lblResposta.setBounds(12, 125, 90, 15);
		panel.add(lblResposta);
		
		textField = new JTextField();
		textField.setBounds(75, 80, 422, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 113, 361, 27);
		panel.add(textField_1);
		
		JLabel lblResposta_1 = new JLabel("Resposta 2:");
		lblResposta_1.setBounds(12, 158, 90, 15);
		panel.add(lblResposta_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 146, 361, 27);
		panel.add(textField_2);
		
		JLabel lblResposta_2 = new JLabel("Resposta 3:");
		lblResposta_2.setBounds(12, 191, 90, 15);
		panel.add(lblResposta_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(104, 179, 361, 27);
		panel.add(textField_3);
		
		JLabel lblResposta_3 = new JLabel("Resposta 4:");
		lblResposta_3.setBounds(12, 221, 90, 15);
		panel.add(lblResposta_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 209, 361, 27);
		panel.add(textField_4);
		
		JLabel lblResposta_4 = new JLabel("Resposta 5:");
		lblResposta_4.setBounds(12, 254, 90, 15);
		panel.add(lblResposta_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 242, 361, 27);
		panel.add(textField_5);
		
		JLabel lblRespostaCerta = new JLabel("Resposta certa:");
		lblRespostaCerta.setBounds(12, 281, 141, 15);
		panel.add(lblRespostaCerta);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(5), new Integer(1)));
		spinner.setBounds(164, 279, 28, 20);
		panel.add(spinner);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (novoRegistro) {
					Pergunta p = new Pergunta();
					p.setPergunta(textField.getText(), 1, textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText());
					recordset.store(p);
					perguntaAtual = p;
					recordset.close();
				}else
				{
					
					ObjectSet<Pergunta> set = recordset.get(perguntaAtual); 
					if ( set.hasNext() ) {
						Pergunta p = (Pergunta)set.next();
						p.descricao = textField.getText();
						p.resposta1 = textField_1.getText();
						p.resposta2 = textField_2.getText();
						p.resposta3 = textField_3.getText();
						p.resposta4 = textField_4.getText();
						p.resposta5 = textField_5.getText();
						p.respostaCerta = (int)spinner.getValue();
						perguntaAtual = p;
						
						System.out.println("tentando salvar");
						recordset.set(p);
						recordset.commit();
					}
				}
				
				
			}
		});
		btnSalvar.setBounds(12, 301, 117, 25);
		panel.add(btnSalvar);
		
		JLabel lblCadastroDePergunta = new JLabel("Cadastro de Pergunta");
		lblCadastroDePergunta.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDePergunta.setBounds(139, 12, 291, 41);
		panel.add(lblCadastroDePergunta);
		
		JButton btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				spinner.setValue(1);
				novoRegistro = true;
			}
		});
		btnNova.setBounds(164, 301, 117, 25);
		panel.add(btnNova);
		
		JButton btnPrxima = new JButton("Próxima");
		btnPrxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (perguntas.hasNext()){
					Pergunta p = perguntas.next();
					perguntaAtual = p;
					label_7.setText(p.descricao);
					radioButton_1.setText(p.resposta1);
					radioButton_2.setText(p.resposta2);
					radioButton_3.setText(p.resposta3);
					radioButton_4.setText(p.resposta4);
					radioButton_5.setText(p.resposta5);
					label_1.setText("");
				}
				
			}
		});
		btnPrxima.setBounds(164, 301, 117, 25);
		panel_1.add(btnPrxima);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmQuiz.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Gerenciar Perguntas");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmManutencao = new JMenuItem("Menutenção");
		mntmManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		mnCadastro.add(mntmManutencao);
		
		JMenu mnJogar = new JMenu("Jogar");
		menuBar.add(mnJogar);
		
		JMenuItem mntmJogar = new JMenuItem("Jogar");
		mntmJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				perguntas = recordset.get(Pergunta.class);
				
				if (perguntas.hasNext()){
					Pergunta p = perguntas.next();
					perguntaAtual = p;
					label_7.setText(p.descricao);
					radioButton_1.setText(p.resposta1);
					radioButton_2.setText(p.resposta2);
					radioButton_3.setText(p.resposta3);
					radioButton_4.setText(p.resposta4);
					radioButton_5.setText(p.resposta5);
					label_1.setText("");
				}

			}
		});
		mnJogar.add(mntmJogar);
		
		radios[0] = radioButton_1;
		radios[1] = radioButton_2;
		radios[2] = radioButton_3;
		radios[3] = radioButton_4;
		radios[4] = radioButton_5;
		
		recordset = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco"); 
		Pergunta p = new Pergunta();
		
		panel.setVisible(true);
		panel_1.setVisible(false);
		try {
			ObjectSet<Pergunta> os = recordset.get(Pergunta.class);
			if (os.hasNext()){
				perguntaAtual = os.next();
				textField.setText(perguntaAtual.descricao);
				textField_1.setText(perguntaAtual.resposta1);
				textField_2.setText(perguntaAtual.resposta2);
				textField_3.setText(perguntaAtual.resposta3);
				textField_4.setText(perguntaAtual.resposta4);
				textField_5.setText(perguntaAtual.resposta5);
				spinner.setValue(perguntaAtual.respostaCerta);
				novoRegistro = false;
			} else
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				spinner.setValue(1);
				novoRegistro = true;
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
