package views;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Vista principal del Conjunto de Hospitales
 * @author Alex Morral
 */

// ID VISTA 1

public class VistaCjtHospitales {
	/* Atributos y metodos privados */
	
	private CtrlPresentacion ctrlPresentacion;
	private ArrayList<String> hospitales;
	

	
	//-- Components --//
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel panelRightButtons = new JPanel();
	private final JButton btnCrearHospital = new JButton("Crear Hospital");
	private final JButton btnEliminarHospital = new JButton("Eliminar Hospital");
	private final JButton btnImportarHospital = new JButton("Importar Hospital");
	private final JButton btnSeleccionarHospital = new JButton("Seleccionar Hospital");
	private final JList<String> list = new JList<String>();
	private final JScrollPane scrollPanel = new JScrollPane();
	private final JLabel titleLabel = new JLabel("Conjunto de Hospitales");
	private final JPanel bottomPanel = new JPanel();
	private final JPanel mediumPanel = new JPanel();
	private final JPanel panel = new JPanel();

	//-- Metodos privados --//
	private void init_frameView() {
		/*** DESCOMENTAR PARA EDITAR *
		frameView =  new JFrame("Programador Guardias");
		frameView.setMinimumSize(new Dimension(700, 400));
		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameView.getContentPane().setBackground(Color.WHITE);
		/*** END DESCOMENTAR PARA EDITAR */
		frameView = ctrlPresentacion.getFrame();
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.setLayout(null);
		panelContents.setBounds(0,0,700,378);
		contentPane.add(panelContents);
	}

	private void init_panelContents() {
		panelContents.setLayout(new BoxLayout(panelContents, BoxLayout.PAGE_AXIS));
		topPanel.setMinimumSize(new Dimension(0, 10));
		topPanel.setPreferredSize(new Dimension(10, 5));
		// Components
		panelContents.add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		
		topPanel.add(titleLabel);
		
		JPanel midPanel = new JPanel();
		midPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelContents.add(midPanel);
		midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
		panel.setPreferredSize(new Dimension(20, 10));
		
		midPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		scrollPanel.setPreferredSize(new Dimension(150, 10));
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		midPanel.add(scrollPanel);
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPanel.setViewportView(list);
		mediumPanel.setPreferredSize(new Dimension(150, 0));
		
		midPanel.add(mediumPanel);
		mediumPanel.setLayout(new BoxLayout(mediumPanel, BoxLayout.X_AXIS));
		midPanel.add(panelRightButtons);
		panelRightButtons.setLayout(new GridLayout(0, 1, 0, 20));
		
		panelContents.add(bottomPanel);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	private void init_panelTopButtons() {
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
	}

	private void init_panelBottomButtons() {
	}

	private void init_panelRightButtons() {
		panelRightButtons.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		panelRightButtons.add(btnCrearHospital);
		panelRightButtons.add(btnEliminarHospital);
		panelRightButtons.add(btnImportarHospital);
		panelRightButtons.add(btnSeleccionarHospital);
	}
	
	
	/** Asignacion de listeners **/
	
	private void assign_listenersComponents() {
		
		
		btnCrearHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaCrearHospital", panelContents);
			}
		});
		
		btnSeleccionarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(list.isSelectionEmpty()) throw new IOException("Debe seleccionar un hospital");
					String[] parts = (list.getSelectedValue()).split("-");
					String idHosp = parts[0];
					ctrlPresentacion.cargarHospital(Integer.parseInt(idHosp));
					ctrlPresentacion.changeView("vistaGestion", panelContents);
				} catch (IOException eX){
					JOptionPane.showMessageDialog(null, eX, "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
			
		});
		
		btnEliminarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Object[] options = {"Aceptar", "Cancelar"};
					int returnVal = JOptionPane.showOptionDialog(null,
							"Esta seguro de que quiere eliminar el Hospital?",
						    "Alert",
						    JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.WARNING_MESSAGE,
						    null,
						    options,
						    options[1]);
						if(returnVal == JOptionPane.YES_NO_CANCEL_OPTION) {
							//ctrlPresentacion.borrarHospital(list.getSelectedValue());
						}
				}
				});
		
		btnImportarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					/*FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "Text File (.txt)", "txt");
					  //  chooser.setFileFilter(filter);*/
					int returnVal = chooser.showOpenDialog(frameView);
					File f = chooser.getSelectedFile();
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						try{
					       ctrlPresentacion.importarHospital(f.getAbsolutePath());
					       loadHospitals();
						} catch(IOException eX) {
							JOptionPane.showMessageDialog(null, eX, "Error", JOptionPane.ERROR_MESSAGE); 

						}
					 }

				
			}
		});
		
	
		
	}

	
	private void initComponents() {
		init_frameView();
		init_panelContents();
		init_panelTopButtons();
		init_panelBottomButtons();
		init_panelRightButtons();
		assign_listenersComponents();
	}
	

	private void loadHospitals() {
		hospitales = new ArrayList<String>();
		try {
			hospitales = ctrlPresentacion.loadHospitals();
		} catch (IOException e) {
			hospitales.add("No hay hospitales disponibles");
		}
		
		DefaultListModel<String> model = new DefaultListModel<String>();
	    for(String st : hospitales){
	    	st = st.replace("%", " ");
	         model.addElement(st);
	    }    
	    list.setModel(model);  
	    list.revalidate();
		list.repaint();
		
	}
	
	/* Constructoras y metodos publicos */
	public VistaCjtHospitales(CtrlPresentacion pCtrlVistaPrincipal) {
		ctrlPresentacion = pCtrlVistaPrincipal;
		/*** DESCOMENTAR PARA EDITAR *
		 initComponents();
		 /*** END DESCOMENTAR PARA EDITAR */
	}
	
	public void init() {
		loadHospitals();
		initComponents();
	}
	
	public JPanel getPanel() {
		return panelContents;
	}

	public void showView() {
		frameView.setVisible(true);
	}
	
	public void hidePanel() {
		panelContents.setVisible(false);
	}
	public void showPanel() {
		loadHospitals();
		panelContents.setVisible(true);
	}
	
	public void hideView() {
		frameView.setVisible(false);
	}

	public void enableView() {
		frameView.setEnabled(true);
	}

	public void disableView() {
		frameView.setEnabled(false);
	}

}
