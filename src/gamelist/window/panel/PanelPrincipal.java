package gamelist.window.panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal {

	private JFrame frmJavaScrapper;
	private JTextField txtRuta;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal window = new PanelPrincipal();
					window.frmJavaScrapper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavaScrapper = new JFrame();
		frmJavaScrapper.setTitle("Java Scrapper");
		frmJavaScrapper.setBounds(100, 100, 450, 300);
		frmJavaScrapper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmJavaScrapper.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem ClearItem = new JMenuItem("Clear");
		menuFile.add(ClearItem);
		
		JMenuItem ItemExit = new JMenuItem("Exit");
		menuFile.add(ItemExit);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		JMenuItem PropertiesItem = new JMenuItem("Properties");
		menuEdit.add(PropertiesItem);
		frmJavaScrapper.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmJavaScrapper.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setToolTipText("Lista de juegos");
		panelCentral.add(textPane);
		
		JPanel panelOeste = new JPanel();
		frmJavaScrapper.getContentPane().add(panelOeste, BorderLayout.WEST);
		
		txtRuta = new JTextField();
		txtRuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRuta.setText("");
			}
		});

		txtRuta.setToolTipText("Ruta absoluta de las roms");
		txtRuta.setText("Ruta de las roms");
		panelOeste.add(txtRuta);
		txtRuta.setColumns(10);
		
		JButton bttnExplorar = new JButton("Explorar");
		bttnExplorar.setToolTipText("Explorar");
		panelOeste.add(bttnExplorar);
		
		JSeparator separator = new JSeparator();
		panelOeste.add(separator);
		
		textField_1 = new JTextField();
		panelOeste.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelOeste.add(btnNewButton_1);
	}

}
