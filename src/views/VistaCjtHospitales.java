package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.Alignment;

/**
 * Vista principal del Conjunto de Hospitales
 * @author Alex Morral
 */
public class VistaCjtHospitales {
	/* Atributos y metodos privados */
	
	private CtrlPresentacion ctrlPresentacion;
	
	//-- Components --//
	private JFrame frameView = new JFrame("Gestion calendario");
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
		frameView.setTitle("Programador de Guardias");
		frameView.setMinimumSize(new Dimension(700,400));
		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = (JPanel) frameView.getContentPane();
		frameView.getContentPane().setLayout(null);
		panelContents.setBounds(0, 0, 700, 378);
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
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Hospital Del Mar", "Hospital De Bellvitge", "Hospital Sant Joan de Deu", "Hospital Quirón", "Hospital De Barcelona"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		mediumPanel.setPreferredSize(new Dimension(150, 0));
		
		midPanel.add(mediumPanel);
		mediumPanel.setLayout(new BoxLayout(mediumPanel, BoxLayout.X_AXIS));
		midPanel.add(panelRightButtons);
		panelRightButtons.setLayout(new GridLayout(0, 1, 0, 20));
		
		panelContents.add(bottomPanel);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	private void init_panelCalendar() {
//		panelCalendar.setPreferredSize(new Dimension(500,200));;
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
				// TODO Auto-generated method stub
				String texto = ((JButton) e.getSource()).getText();
				System.out.println("Has clickado el boton con texto: " + texto);
			}
		});
		
		btnEliminarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String texto = ((JButton) e.getSource()).getText();
				System.out.println("Has clickado el boton con texto: " + texto);
			}
		});
		
		btnImportarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String texto = ((JButton) e.getSource()).getText();
				System.out.println("Has clickado el boton con texto: " + texto);
			}
		});
		
		btnSeleccionarHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String texto = ((JButton) e.getSource()).getText();
				System.out.println("Has clickado el boton con texto: " + texto);
			}
		});
		
	}

	
	private void initComponents() {
		init_frameView();
		init_panelContents();
		init_panelCalendar();
		init_panelTopButtons();
		init_panelBottomButtons();
		init_panelRightButtons();
		assign_listenersComponents();
	}

	/* Constructoras y metodos publicos */
	public VistaCjtHospitales(CtrlPresentacion pCtrlVistaPrincipal) {
		ctrlPresentacion = pCtrlVistaPrincipal;
		initComponents();
	}

	public void showView() {
//		frameView.pack();
		frameView.setVisible(true);
	}

	public void enableView() {
		frameView.setEnabled(true);
	}

	public void disableView() {
		frameView.setEnabled(false);
	}

}
