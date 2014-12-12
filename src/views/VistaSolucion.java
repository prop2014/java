package views;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Vista de una solucion
 * @author Alex Morral
 */

// ID VISTA 1

public class VistaSolucion {
	/* Atributos y metodos privados */
	
	private CtrlPresentacion ctrlPresentacion;
	private HashMap<Integer, ArrayList<String>> asign;

	
	//-- Components --//
	private JFrame frameView;
	private JPanel panelContents = new JPanel();
	private JPanel topPanel = new JPanel();
	private final JList<String> listAsig = new JList<String>();
	private final JScrollPane scrollDoc = new JScrollPane();
	private final JLabel titleLabel = new JLabel("Solucion");
	private final JPanel mediumPanel = new JPanel();
	private JPanel midPanel;
	private JScrollPane scrollTurn = new JScrollPane();
	private JButton btnAnadirTurno = new JButton("Añadir Turno");
	private JButton btnEliminarTurno = new JButton("Eliminar Turno");
	private JTextField txtNameSol = new JTextField();
	private JTextArea txtComent = new JTextArea();
	private JButton btnGuardar = new JButton("Guardar");
	private JButton btnCancelar = new JButton("Cancelar");
	private JList<String> listNoTurn = new JList<String>();

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
		panelContents.setLayout(null);
		topPanel.setBounds(0, 0, 700, 48);
		topPanel.setMinimumSize(new Dimension(0, 10));
		topPanel.setPreferredSize(new Dimension(10, 5));
		// Components
		panelContents.add(topPanel);
		topPanel.setLayout(null);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
		titleLabel.setBounds(107, 20, 70, 16);
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		
		topPanel.add(titleLabel);
		
		midPanel = new JPanel();
		midPanel.setBounds(0, 48, 700, 272);
		midPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelContents.add(midPanel);
		midPanel.setLayout(null);
		scrollDoc.setBounds(35, 35, 172, 226);
		scrollDoc.setPreferredSize(new Dimension(150, 10));
		scrollDoc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		midPanel.add(scrollDoc);
		listAsig.setModel(new AbstractListModel() {
			String[] values = new String[] {"Doctor Alex", "---------\t27/11/2014 M", "---------\t27/11/2014 M", "---------\t27/11/2014 M", "Doctor Oscar", "---------\t27/11/2014 M", "Doctor Axel", "---------\t27/11/2014 M", "---------\t27/11/2014 M", "Doctor Felix", "Doctor Sergi"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAsig.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollDoc.setViewportView(listAsig);
		mediumPanel.setBounds(254, 125, 150, 0);
		mediumPanel.setPreferredSize(new Dimension(150, 0));
		
		midPanel.add(mediumPanel);
		mediumPanel.setLayout(new BoxLayout(mediumPanel, BoxLayout.X_AXIS));
		
		
		scrollTurn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTurn.setPreferredSize(new Dimension(150, 10));
		scrollTurn.setBounds(234, 35, 115, 128);
		midPanel.add(scrollTurn);
		listNoTurn.setModel(new AbstractListModel() {
			String[] values = new String[] {"01/01/2014 M", "01/01/2014 T", "02/01/2014 M", "03/01/2014 M", "03/01/2014 N"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		scrollTurn.setViewportView(listNoTurn);
		listNoTurn.setFont(new Font("Arial", Font.PLAIN, 13));
		
		
		
		btnAnadirTurno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAnadirTurno.setBounds(234, 175, 117, 29);
		midPanel.add(btnAnadirTurno);
		
		
		btnEliminarTurno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarTurno.setBounds(234, 204, 117, 29);
		midPanel.add(btnEliminarTurno);
		
		JLabel lblNombreSolucin = new JLabel("Nombre Solucion:");
		lblNombreSolucin.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombreSolucin.setBounds(381, 38, 112, 16);
		midPanel.add(lblNombreSolucin);
		
		
		txtNameSol.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNameSol.setBounds(521, 32, 117, 28);
		midPanel.add(txtNameSol);
		txtNameSol.setColumns(10);
		
		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setFont(new Font("Arial", Font.PLAIN, 13));
		lblComentario.setBounds(415, 66, 77, 16);
		midPanel.add(lblComentario);
		
		
		txtComent.setFont(new Font("Arial", Font.PLAIN, 12));
		txtComent.setWrapStyleWord(true);
		txtComent.setLineWrap(true);
		txtComent.setBounds(521, 72, 148, 74);
		midPanel.add(txtComent);
		
		JLabel lblAsignaciones = new JLabel("Asignaciones");
		lblAsignaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignaciones.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAsignaciones.setBounds(61, 7, 115, 16);
		midPanel.add(lblAsignaciones);
		
		JLabel lblTurnosNoAsignados = new JLabel("Turnos no asignados");
		lblTurnosNoAsignados.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnosNoAsignados.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTurnosNoAsignados.setBounds(234, 7, 115, 29);
		midPanel.add(lblTurnosNoAsignados);
		
		
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(371, 332, 117, 29);
		panelContents.add(btnGuardar);
		
		
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(222, 332, 117, 29);
		panelContents.add(btnCancelar);
	}
	private void init_panelTopButtons() {
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
	}

	private void init_panelBottomButtons() {
	}

	private void init_panelRightButtons() {
	}
	
	
	/** Asignacion de listeners **/
	
	private void assign_listenersComponents() {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlPresentacion.changeView("vistaGestionSoluciones", panelContents);
				
			}
		});
	
		listAsig.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
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
	private void loadInformation() {
		DefaultListModel<String> modelAsign = new DefaultListModel<String>(); 
		DefaultListModel<String> modelNoSol = new DefaultListModel<String>(); 
		asign = ctrlPresentacion.getAsignaciones();
		Set<Integer> ids = asign.keySet();
		for (Integer idDoc : ids){
			ArrayList<String> fechasAsignedDoc = asign.get(idDoc);
			String doctor = "Doctor " + idDoc + " Sueldo: " + ctrlPresentacion.getSueldoAsigned(idDoc);
			modelAsign.addElement(doctor);
			for(String st : fechasAsignedDoc){
				modelAsign.addElement("------- " + st);
				System.out.printf("%s\n",st);
			}
			//System.out.printf("Sueldo: %f\n\n", ctrlPresentacion.getSueldoAsigned(idDoc));
		}
		
		listAsig.setModel(modelAsign);
		
		System.out.println("Turnos sin solucion:");
		for(String st : ctrlPresentacion.getTurnosSinSol()) {
			modelNoSol.addElement(st);
			System.out.println(st);
		}
		listNoTurn.setModel(modelNoSol);
		reloadLists();
	}
	
	private void reloadLists() {
		listAsig.revalidate();
		listAsig.repaint();
		listNoTurn.revalidate();
		listNoTurn.repaint();
	}
	
	/* Constructoras y metodos publicos */
	public VistaSolucion(CtrlPresentacion pCtrlVistaPrincipal) {
		ctrlPresentacion = pCtrlVistaPrincipal;
		/*** DESCOMENTAR PARA EDITAR *
		 initComponents();
		 /*** END DESCOMENTAR PARA EDITAR */
	}
	
	public void init() {
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
		loadInformation();
		reloadLists();
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
