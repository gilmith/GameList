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

import gamelist.controller.FolderController;
import gamelist.controller.GamesDBController;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PanelPrincipal {

	private JFrame frmJavaScrapper;
	private JTextField txtRuta;
	private JTextField txtRutaGameList;
	private JTextField txtTitulo;
	private JTextField txtPlataforma;
	private JTextField txtSeleccionaUnaRom;
	private JTextField txtSeleccionaUnArchivo;
	private String rutaRoms; 
	private JTextField txtPublicadora;
	private JTextField txtResumen;
	private JTextField txtGenero;
	private JTextField txtJugadores;
	private JTextField txtLanzamiento;
	private JTextField txtNota;
	private JTextField txtPortada;
	private FolderController folderController;

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
		frmJavaScrapper.setBounds(100, 100, 860, 425);
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
		txtrRomsEncontradas.setLineWrap(true);
		txtrRomsEncontradas.setWrapStyleWord(true);
		txtrRomsEncontradas.setToolTipText("Roms encontradas en el autoexplore");
		txtrRomsEncontradas.setText("    Roms encontradas");
		txtrRomsEncontradas.setRows(20);
		txtrRomsEncontradas.setColumns(20);
		panelCentral.add(txtrRomsEncontradas);
		
		JButton btnTodasRoms = new JButton("Ejecutar todas las roms");
		btnTodasRoms.setToolTipText("ejecutar para todas las roms encontradas");
		panelCentral.add(btnTodasRoms);
		
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
		txtRuta.setToolTipText("Carpeta de las roms");
		txtRuta.setColumns(10);
		
						JButton bttnExplorar = new JButton("Explorar");
						bttnExplorar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
								jFileChooser.setDialogTitle("Selecciona carpeta de roms");
								jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
								int seleccion = jFileChooser.showOpenDialog(frmJavaScrapper);
								if(seleccion == JFileChooser.APPROVE_OPTION) {
									File f = jFileChooser.getSelectedFile();
									try {
										rutaRoms = f.getCanonicalPath();
										txtRuta.setText(rutaRoms);
										txtRutaGameList.setText(rutaRoms + System.getProperty("file.separator") + "gameList.xml");
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
				txtRutaGameList.setColumns(10);
				
				JButton btnBusquedaFolder = new JButton("Busqueda");
				btnBusquedaFolder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						folderController = new FolderController(rutaRoms);
						txtrRomsEncontradas.setText(folderController.getAutoExplore());
						
					}
				});
				btnBusquedaFolder.setToolTipText("Busqueda de roms sobre la carpeta");
				GridBagConstraints gbc_btnBusquedaFolder = new GridBagConstraints();
				gbc_btnBusquedaFolder.insets = new Insets(0, 0, 5, 5);
				gbc_btnBusquedaFolder.gridx = 4;
				gbc_btnBusquedaFolder.gridy = 0;
				panelAutoExplorar.add(btnBusquedaFolder, gbc_btnBusquedaFolder);
				
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
				
				JButton btnExplorarRomIso = new JButton("Rom/Iso");
				btnExplorarRomIso.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
						jFileChooser.setDialogTitle("Selecciona carpeta de roms");
						jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int seleccion = jFileChooser.showOpenDialog(frmJavaScrapper);
						if(seleccion == JFileChooser.APPROVE_OPTION) {
							File f = jFileChooser.getSelectedFile();
							try {
								rutaRoms = f.getCanonicalPath();
								txtRuta.setText(rutaRoms);
								txtRutaGameList.setText(rutaRoms + System.getProperty("file.separator") + "gameList.xml");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				GridBagConstraints gbc_btnExplorarRomIso = new GridBagConstraints();
				gbc_btnExplorarRomIso.insets = new Insets(0, 0, 0, 5);
				gbc_btnExplorarRomIso.gridx = 2;
				gbc_btnExplorarRomIso.gridy = 1;
				panelAutoExplorar.add(btnExplorarRomIso, gbc_btnExplorarRomIso);
				
				txtSeleccionaUnArchivo = new JTextField();
				txtSeleccionaUnArchivo.setText("Selecciona un archivo gamesList.xml");
				GridBagConstraints gbc_txtSeleccionaUnArchivo = new GridBagConstraints();
				gbc_txtSeleccionaUnArchivo.insets = new Insets(0, 0, 0, 5);
				gbc_txtSeleccionaUnArchivo.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSeleccionaUnArchivo.gridx = 3;
				gbc_txtSeleccionaUnArchivo.gridy = 1;
				panelAutoExplorar.add(txtSeleccionaUnArchivo, gbc_txtSeleccionaUnArchivo);
				txtSeleccionaUnArchivo.setColumns(10);
				
				JButton btnBusquedaFile = new JButton("Busqueda");
				btnBusquedaFile.setToolTipText("Busqueda en gamesdb");
				GridBagConstraints gbc_btnBusquedaFile = new GridBagConstraints();
				gbc_btnBusquedaFile.insets = new Insets(0, 0, 0, 5);
				gbc_btnBusquedaFile.gridx = 4;
				gbc_btnBusquedaFile.gridy = 1;
				panelAutoExplorar.add(btnBusquedaFile, gbc_btnBusquedaFile);
				
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
				txtTitulo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						txtTitulo.setText("");
						txtTitulo.repaint();
						txtTitulo.revalidate();
					}
				});
				txtTitulo.setToolTipText("Titulo del juego");
				txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
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
				txtPlataforma.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtPlataforma.setText("");
						txtPlataforma.repaint();
						txtPlataforma.revalidate();
					}
				});
				txtPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
				txtPlataforma.setToolTipText("Plataforma del juego");
				txtPlataforma.setText("Plataforma");
				GridBagConstraints gbc_txtPlataforma = new GridBagConstraints();
				gbc_txtPlataforma.insets = new Insets(0, 0, 5, 5);
				gbc_txtPlataforma.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPlataforma.gridx = 1;
				gbc_txtPlataforma.gridy = 4;
				panelManual.add(txtPlataforma, gbc_txtPlataforma);
				txtPlataforma.setColumns(10);
				
				JLabel lblPublicadora = new JLabel("Publicadora");
				GridBagConstraints gbc_lblPublicadora = new GridBagConstraints();
				gbc_lblPublicadora.insets = new Insets(0, 0, 5, 5);
				gbc_lblPublicadora.gridx = 0;
				gbc_lblPublicadora.gridy = 5;
				panelManual.add(lblPublicadora, gbc_lblPublicadora);
				
				txtPublicadora = new JTextField();
				txtPublicadora.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtPublicadora.setText("");
						txtPublicadora.repaint();
						txtPublicadora.revalidate();
					}
				});
				txtPublicadora.setHorizontalAlignment(SwingConstants.CENTER);
				txtPublicadora.setText("Publicadora");
				GridBagConstraints gbc_txtPublicadora = new GridBagConstraints();
				gbc_txtPublicadora.insets = new Insets(0, 0, 5, 5);
				gbc_txtPublicadora.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPublicadora.gridx = 1;
				gbc_txtPublicadora.gridy = 5;
				panelManual.add(txtPublicadora, gbc_txtPublicadora);
				txtPublicadora.setColumns(10);
				
				JLabel lblResumen = new JLabel("Resumen");
				GridBagConstraints gbc_lblResumen = new GridBagConstraints();
				gbc_lblResumen.insets = new Insets(0, 0, 5, 5);
				gbc_lblResumen.gridx = 0;
				gbc_lblResumen.gridy = 6;
				panelManual.add(lblResumen, gbc_lblResumen);
				
				txtResumen = new JTextField();
				txtResumen.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtResumen.setText("");
						txtResumen.repaint();
						txtResumen.revalidate();
					}
				});
				txtResumen.setHorizontalAlignment(SwingConstants.CENTER);
				txtResumen.setText("Resumen");
				GridBagConstraints gbc_txtResumen = new GridBagConstraints();
				gbc_txtResumen.insets = new Insets(0, 0, 5, 5);
				gbc_txtResumen.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtResumen.gridx = 1;
				gbc_txtResumen.gridy = 6;
				panelManual.add(txtResumen, gbc_txtResumen);
				txtResumen.setColumns(10);
				
				JLabel lblGenero = new JLabel("Genero");
				GridBagConstraints gbc_lblGenero = new GridBagConstraints();
				gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
				gbc_lblGenero.gridx = 0;
				gbc_lblGenero.gridy = 7;
				panelManual.add(lblGenero, gbc_lblGenero);
				
				txtGenero = new JTextField();
				txtGenero.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtGenero.setText("");
						txtGenero.repaint();
						txtGenero.revalidate();
					}
				});
				txtGenero.setHorizontalAlignment(SwingConstants.CENTER);
				txtGenero.setText("Genero");
				GridBagConstraints gbc_txtGenero = new GridBagConstraints();
				gbc_txtGenero.insets = new Insets(0, 0, 5, 5);
				gbc_txtGenero.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtGenero.gridx = 1;
				gbc_txtGenero.gridy = 7;
				panelManual.add(txtGenero, gbc_txtGenero);
				txtGenero.setColumns(10);
				
				JLabel lblJugadores = new JLabel("Jugadores");
				GridBagConstraints gbc_lblJugadores = new GridBagConstraints();
				gbc_lblJugadores.insets = new Insets(0, 0, 5, 5);
				gbc_lblJugadores.gridx = 0;
				gbc_lblJugadores.gridy = 8;
				panelManual.add(lblJugadores, gbc_lblJugadores);
				
				txtJugadores = new JTextField();
				txtJugadores.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtJugadores.setText("");
						txtJugadores.repaint();
						txtJugadores.revalidate();
					}
				});
				txtJugadores.setHorizontalAlignment(SwingConstants.CENTER);
				txtJugadores.setText("Jugadores");
				GridBagConstraints gbc_txtJugadores = new GridBagConstraints();
				gbc_txtJugadores.insets = new Insets(0, 0, 5, 5);
				gbc_txtJugadores.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtJugadores.gridx = 1;
				gbc_txtJugadores.gridy = 8;
				panelManual.add(txtJugadores, gbc_txtJugadores);
				txtJugadores.setColumns(10);
				
				JLabel lblLanzamiento = new JLabel("Lanzamiento");
				GridBagConstraints gbc_lblLanzamiento = new GridBagConstraints();
				gbc_lblLanzamiento.insets = new Insets(0, 0, 5, 5);
				gbc_lblLanzamiento.gridx = 0;
				gbc_lblLanzamiento.gridy = 9;
				panelManual.add(lblLanzamiento, gbc_lblLanzamiento);
				
				txtLanzamiento = new JTextField();
				txtLanzamiento.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtLanzamiento.setText("");
						txtLanzamiento.repaint();
						txtLanzamiento.revalidate();
					}
				});
				txtLanzamiento.setHorizontalAlignment(SwingConstants.CENTER);
				txtLanzamiento.setText("Lanzamiento");
				GridBagConstraints gbc_txtLanzamiento = new GridBagConstraints();
				gbc_txtLanzamiento.insets = new Insets(0, 0, 5, 5);
				gbc_txtLanzamiento.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLanzamiento.gridx = 1;
				gbc_txtLanzamiento.gridy = 9;
				panelManual.add(txtLanzamiento, gbc_txtLanzamiento);
				txtLanzamiento.setColumns(10);
				
				JLabel lblNota = new JLabel("Nota");
				GridBagConstraints gbc_lblNota = new GridBagConstraints();
				gbc_lblNota.insets = new Insets(0, 0, 5, 5);
				gbc_lblNota.gridx = 0;
				gbc_lblNota.gridy = 10;
				panelManual.add(lblNota, gbc_lblNota);
				
				txtNota = new JTextField();
				txtNota.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtNota.setText("");
						txtNota.repaint();
						txtNota.revalidate();
					}
				});
				txtNota.setHorizontalAlignment(SwingConstants.CENTER);
				txtNota.setText("Nota");
				GridBagConstraints gbc_txtNota = new GridBagConstraints();
				gbc_txtNota.insets = new Insets(0, 0, 5, 5);
				gbc_txtNota.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNota.gridx = 1;
				gbc_txtNota.gridy = 10;
				panelManual.add(txtNota, gbc_txtNota);
				txtNota.setColumns(10);
				
				JLabel lblPortada = new JLabel("Portada");
				GridBagConstraints gbc_lblPortada = new GridBagConstraints();
				gbc_lblPortada.insets = new Insets(0, 0, 5, 5);
				gbc_lblPortada.gridx = 0;
				gbc_lblPortada.gridy = 11;
				panelManual.add(lblPortada, gbc_lblPortada);
				
				txtPortada = new JTextField();
				txtPortada.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						txtPortada.setText("");
						txtPortada.repaint();
						txtPortada.revalidate();
					}
				});
				txtPortada.setHorizontalAlignment(SwingConstants.CENTER);
				txtPortada.setText("Portada");
				GridBagConstraints gbc_txtPortada = new GridBagConstraints();
				gbc_txtPortada.insets = new Insets(0, 0, 5, 5);
				gbc_txtPortada.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPortada.gridx = 1;
				gbc_txtPortada.gridy = 11;
				panelManual.add(txtPortada, gbc_txtPortada);
				txtPortada.setColumns(10);
				
				JButton btnExplorar = new JButton("Explorar");
				btnExplorar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
						jFileChooser.setDialogTitle("Selecciona carpeta de roms");
						jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int seleccion = jFileChooser.showOpenDialog(frmJavaScrapper);
						if(seleccion == JFileChooser.APPROVE_OPTION) {
							File f = jFileChooser.getSelectedFile();
							try {
								String rutaPortada = null;
								rutaPortada = f.getCanonicalPath();
								txtPortada.setText(rutaPortada);
								txtPortada.setText(rutaPortada);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});

				GridBagConstraints gbc_btnExplorar = new GridBagConstraints();
				gbc_btnExplorar.insets = new Insets(0, 0, 5, 0);
				gbc_btnExplorar.gridx = 2;
				gbc_btnExplorar.gridy = 11;
				panelManual.add(btnExplorar, gbc_btnExplorar);
				
				JButton btnEjecutar = new JButton("Ejecutar");
				btnEjecutar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GamesDBController gamesDBController = new GamesDBController();
						gamesDBController.procesa(folderController, rutaRoms + System.getProperty("file.separator") + "gamesList.xml", rutaRoms);
					}
				});
				btnEjecutar.setToolTipText("ejecutar para una rom individual");
				GridBagConstraints gbc_btnEjecutar = new GridBagConstraints();
				gbc_btnEjecutar.insets = new Insets(0, 0, 0, 5);
				gbc_btnEjecutar.gridx = 1;
				gbc_btnEjecutar.gridy = 12;
				panelManual.add(btnEjecutar, gbc_btnEjecutar);
				
				JScrollPane scrollPane = new JScrollPane(txtrRomsEncontradas);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				frmJavaScrapper.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
