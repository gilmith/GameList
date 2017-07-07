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
import javax.swing.JFileChooser;

import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class PanelPrincipal {

	private JFrame frmJavaScrapper;
	private JTextField txtRuta;
	private JTextField txtRutaGameList;
	private JTextField txtTitulo;
	private JTextField txtPlataforma;
	private JTextField txtSeleccionaUnaRom;
	private JTextField txtSeleccionaUnArchivo;

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
		frmJavaScrapper.setBounds(100, 100, 729, 481);
		frmJavaScrapper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmJavaScrapper.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem itemClear = new JMenuItem("Clear");
		itemClear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.ALT_MASK));
		itemClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRuta.setText("");
				txtRuta.repaint();
				txtRutaGameList.revalidate();
				txtRutaGameList.setText("");
				txtRutaGameList.repaint();
				txtRutaGameList.revalidate();
			}
		});
		menuFile.add(itemClear);
		
		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuFile.add(itemExit);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		JMenuItem PropertiesItem = new JMenuItem("Properties");
		menuEdit.add(PropertiesItem);
		frmJavaScrapper.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmJavaScrapper.getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JTextArea txtrRomsEncontradas = new JTextArea();
		txtrRomsEncontradas.setText("Roms encontradas");
		txtrRomsEncontradas.setEditable(false);
		txtrRomsEncontradas.setRows(20);
		txtrRomsEncontradas.setColumns(20);
		panelCentral.add(txtrRomsEncontradas);
		
		JPanel panelOeste = new JPanel();
		frmJavaScrapper.getContentPane().add(panelOeste, BorderLayout.WEST);
		panelOeste.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAutoExplorar = new JPanel();
		panelOeste.add(panelAutoExplorar, BorderLayout.NORTH);
		GridBagLayout gbl_panelAutoExplorar = new GridBagLayout();
		gbl_panelAutoExplorar.columnWidths = new int[]{149, 86, 73, 86, 89, 10, 0};
		gbl_panelAutoExplorar.rowHeights = new int[]{23, 0};
		gbl_panelAutoExplorar.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAutoExplorar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelAutoExplorar.setLayout(gbl_panelAutoExplorar);
		
		JLabel lblAutoexplorarRoms = new JLabel("AutoExplorar Carpeta de Roms");
		lblAutoexplorarRoms.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_lblAutoexplorarRoms = new GridBagConstraints();
		gbc_lblAutoexplorarRoms.anchor = GridBagConstraints.WEST;
		gbc_lblAutoexplorarRoms.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutoexplorarRoms.gridx = 0;
		gbc_lblAutoexplorarRoms.gridy = 0;
		panelAutoExplorar.add(lblAutoexplorarRoms, gbc_lblAutoexplorarRoms);
		
		txtRuta = new JTextField();
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.anchor = GridBagConstraints.WEST;
		gbc_txtRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtRuta.gridx = 1;
		gbc_txtRuta.gridy = 0;
		panelAutoExplorar.add(txtRuta, gbc_txtRuta);
		txtRuta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtRuta.setText("");
				txtRuta.repaint();
				txtRuta.revalidate();
			}
		});
		txtRuta.setToolTipText("Carpeta de las roms");
		txtRuta.setText("Carpeta de las roms");
		txtRuta.setColumns(10);
		txtRuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRuta.setText("");
				txtRuta.repaint();
				txtRuta.revalidate();
			}
		});
				
						
						
						JButton bttnExplorar = new JButton("Explorar");
						bttnExplorar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
								jFileChooser.setDialogTitle("Selecciona carpeta de roms");
								jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
								int seleccion = jFileChooser.showOpenDialog(frmJavaScrapper);
								if(seleccion == JFileChooser.APPROVE_OPTION) {
									System.out.println("Ha dado a aceptar");
									File f = jFileChooser.getSelectedFile();
									try {
										System.out.println(f.getCanonicalPath());
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						});
						GridBagConstraints gbc_bttnExplorar = new GridBagConstraints();
						gbc_bttnExplorar.anchor = GridBagConstraints.NORTHWEST;
						gbc_bttnExplorar.insets = new Insets(0, 0, 5, 5);
						gbc_bttnExplorar.gridx = 2;
						gbc_bttnExplorar.gridy = 0;
						panelAutoExplorar.add(bttnExplorar, gbc_bttnExplorar);
						bttnExplorar.setToolTipText("Explorar");
				panelAutoExplorar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblAutoexplorarRoms, txtRuta, bttnExplorar, txtRutaGameList}));
				
				txtRutaGameList = new JTextField();
				GridBagConstraints gbc_txtRutaGameList = new GridBagConstraints();
				gbc_txtRutaGameList.anchor = GridBagConstraints.WEST;
				gbc_txtRutaGameList.insets = new Insets(0, 0, 5, 5);
				gbc_txtRutaGameList.gridx = 3;
				gbc_txtRutaGameList.gridy = 0;
				panelAutoExplorar.add(txtRutaGameList, gbc_txtRutaGameList);
				txtRutaGameList.setToolTipText("Ruta del fichero de gameList.xml");
				txtRutaGameList.setText("Ruta del fichero de gameList.xml");
				txtRutaGameList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						txtRutaGameList.setText("");
						txtRutaGameList.repaint();
						txtRutaGameList.revalidate();
					}
				});
				txtRutaGameList.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						txtRutaGameList.setText("");
						txtRutaGameList.repaint();
						txtRutaGameList.revalidate();
					}
				});
				txtRutaGameList.setColumns(10);
				
				JButton btnNewButton_1 = new JButton("New button");
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_1.gridx = 4;
				gbc_btnNewButton_1.gridy = 0;
				panelAutoExplorar.add(btnNewButton_1, gbc_btnNewButton_1);
				
				JLabel lblNewLabel = new JLabel("Seleccionar rom");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panelAutoExplorar.add(lblNewLabel, gbc_lblNewLabel);
				
				txtSeleccionaUnaRom = new JTextField();
				txtSeleccionaUnaRom.setText("Selecciona una rom/iso");
				GridBagConstraints gbc_txtSeleccionaUnaRom = new GridBagConstraints();
				gbc_txtSeleccionaUnaRom.insets = new Insets(0, 0, 0, 5);
				gbc_txtSeleccionaUnaRom.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSeleccionaUnaRom.gridx = 1;
				gbc_txtSeleccionaUnaRom.gridy = 1;
				panelAutoExplorar.add(txtSeleccionaUnaRom, gbc_txtSeleccionaUnaRom);
				txtSeleccionaUnaRom.setColumns(10);
				
				JButton btnNewButton = new JButton("Explorar");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 2;
				gbc_btnNewButton.gridy = 1;
				panelAutoExplorar.add(btnNewButton, gbc_btnNewButton);
				
				txtSeleccionaUnArchivo = new JTextField();
				txtSeleccionaUnArchivo.setText("Selecciona un archivo gamesList.xml");
				GridBagConstraints gbc_txtSeleccionaUnArchivo = new GridBagConstraints();
				gbc_txtSeleccionaUnArchivo.insets = new Insets(0, 0, 0, 5);
				gbc_txtSeleccionaUnArchivo.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSeleccionaUnArchivo.gridx = 3;
				gbc_txtSeleccionaUnArchivo.gridy = 1;
				panelAutoExplorar.add(txtSeleccionaUnArchivo, gbc_txtSeleccionaUnArchivo);
				txtSeleccionaUnArchivo.setColumns(10);
				
				JButton btnNewButton_2 = new JButton("New button");
				GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
				gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton_2.gridx = 4;
				gbc_btnNewButton_2.gridy = 1;
				panelAutoExplorar.add(btnNewButton_2, gbc_btnNewButton_2);
				
				JPanel panelManual = new JPanel();
				panelOeste.add(panelManual, BorderLayout.CENTER);
				GridBagLayout gbl_panelManual = new GridBagLayout();
				gbl_panelManual.columnWidths = new int[]{113, 86, 86, 0};
				gbl_panelManual.rowHeights = new int[]{0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panelManual.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_panelManual.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panelManual.setLayout(gbl_panelManual);
				
				JLabel lblEdicionManual = new JLabel("Edicion Manual");
				GridBagConstraints gbc_lblEdicionManual = new GridBagConstraints();
				gbc_lblEdicionManual.insets = new Insets(0, 0, 5, 5);
				gbc_lblEdicionManual.gridx = 1;
				gbc_lblEdicionManual.gridy = 1;
				panelManual.add(lblEdicionManual, gbc_lblEdicionManual);
				
				JLabel lblTitulo = new JLabel("Titulo");
				GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
				gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
				gbc_lblTitulo.gridx = 0;
				gbc_lblTitulo.gridy = 3;
				panelManual.add(lblTitulo, gbc_lblTitulo);
				
				txtTitulo = new JTextField();
				txtTitulo.setText("Titulo");
				GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
				gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
				gbc_txtTitulo.gridx = 1;
				gbc_txtTitulo.gridy = 3;
				panelManual.add(txtTitulo, gbc_txtTitulo);
				txtTitulo.setColumns(10);
				
				JLabel lblPlataforma = new JLabel("Plataforma");
				GridBagConstraints gbc_lblPlataforma = new GridBagConstraints();
				gbc_lblPlataforma.insets = new Insets(0, 0, 5, 5);
				gbc_lblPlataforma.gridx = 0;
				gbc_lblPlataforma.gridy = 4;
				panelManual.add(lblPlataforma, gbc_lblPlataforma);
				
				txtPlataforma = new JTextField();
				txtPlataforma.setText("Plataforma");
				GridBagConstraints gbc_txtPlataforma = new GridBagConstraints();
				gbc_txtPlataforma.insets = new Insets(0, 0, 5, 5);
				gbc_txtPlataforma.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPlataforma.gridx = 1;
				gbc_txtPlataforma.gridy = 4;
				panelManual.add(txtPlataforma, gbc_txtPlataforma);
				txtPlataforma.setColumns(10);
				
				JButton btnEjecutar = new JButton("Ejecutar");
				GridBagConstraints gbc_btnEjecutar = new GridBagConstraints();
				gbc_btnEjecutar.insets = new Insets(0, 0, 0, 5);
				gbc_btnEjecutar.gridx = 1;
				gbc_btnEjecutar.gridy = 12;
				panelManual.add(btnEjecutar, gbc_btnEjecutar);
	}

}
