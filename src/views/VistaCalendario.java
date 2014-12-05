package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableCellRenderer;
//
//import java.util.Date;
//import java.util.Formatter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;


/**
 * Vista gestion de calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class VistaCalendario extends Vista {

	/* Private attributes */

	//-- Containers --//
	private JPanel panelTop = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelCentral = new JPanel();

	//-- Buttons --//
	private JButton buttonCreateCal = new JButton("Crear calendario");
	private JButton buttonImportCal = new JButton("Importar calendario");
	private JButton buttonDeleteCal = new JButton("Eliminar calendario");
	private JButton buttonAddVacation = new JButton("Anadir dia");	
	private JButton buttonModVacation = new JButton("Modificar dia");
	private JButton buttonDelVacation = new JButton("Eliminar dia");
	private JButton buttonGoBack = new JButton("Volver");
	private JButton buttonHelp = new JButton("Ayuda");

	//-- Labels --//
	private JLabel labelCalendar, labelVacationList1, labelVacationList2;

	DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JList<String> vacationList;
	private JScrollPane scrollPanel;
	private JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');

	//-- Others private atributes--//
	private static final String pattern = "%7s%13d%11d%11d%-5s%s";	// patron formato lista dias vacacionales

	/* Private Methods */

	private void init_panelTop() {
		// panel
		panelTop.setLayout(null);
		panelTop.setBounds(0, 0, width, 50);

		// components
		buttonCreateCal.setBounds(325, 10, 170, 30);
		buttonCreateCal.setFont(new Font("Arial", Font.BOLD, 11));
		buttonDeleteCal.setBounds(325, 10, 170, 30);
		buttonDeleteCal.setFont(new Font("Arial", Font.BOLD, 11));
		buttonDeleteCal.setVisible(false);
		buttonImportCal.setBounds(505, 10, 170, 30);
		buttonImportCal.setFont(new Font("Arial", Font.BOLD, 11));
//		labelCalendar = new JLabel(" (No hay calendario)");
		labelCalendar = new JLabel("Calendario vacacional 2014");
//		labelCalendar.setHorizontalAlignment(SwingConstants.LEFT);
//		labelCalendar.setText("(No hay calendario)");
//		labelCalendar.setOpaque(true);
//		labelCalendar.setBackground(Color.cyan);
//		labelCalendar.setFont(new Font("Arial Italic", Font.TRUETYPE_FONT,16));
		labelCalendar.setFont(new Font("Arial", Font.BOLD, 16));
		//		labelCalendar.setForeground(Color.BLUE);
		labelCalendar.setBounds(20, 10, 325, 30);

		panelTop.add(labelCalendar);
		panelTop.add(buttonCreateCal);
		panelTop.add(buttonImportCal);
		panelTop.add(buttonDeleteCal);


		// tooltips
		buttonCreateCal.setToolTipText("Crear nuevo calendario");
		buttonImportCal.setToolTipText("Importar calendario existente");
		buttonDeleteCal.setToolTipText("Eliminar calendario existente");
	}

	private void init_panelCentral() {
		// panel
		panelCentral.setLayout(null);
		panelCentral.setBounds(0, 50, width, 265);

		// components
		labelVacationList1 = new JLabel(String.format("%62s", "Numero de Drs. por turno:"));
//		labelVacationList1.setOpaque(true);
//		labelVacationList1.setBackground(Color.white);
//		labelVacationList1.setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
		labelVacationList1.setFont(new Font("Arial", Font.BOLD, 12));
		labelVacationList1.setBounds(20, 10, 495, 20);

		labelVacationList2 = new JLabel(String.format(" %s%12s%20s%21s%23s", "Dia vacacional","M","T","N","Fecha especial"));
//		labelVacationList2.setOpaque(true);
//		labelVacationList2.setBackground(Color.cyan);
		labelVacationList2.setFont(new Font("Arial", Font.BOLD, 12));
		labelVacationList2.setBounds(20, 30, 495, 20);
		
		dlm.addElement(String.format(pattern, "17-ene",23,12,7,"", ""));
		dlm.addElement(String.format(pattern, "31-ene",23,23,12,"", ""));
		dlm.addElement(String.format(pattern, "2-feb",0,0,0,"", ""));
		dlm.addElement(String.format(pattern, "3-feb",0,0,0,"", ""));
		dlm.addElement(String.format(pattern, "4-feb",0,0,0,"", ""));
		dlm.addElement(String.format(pattern, "17-feb",25,25,12,"", ""));
		dlm.addElement(String.format(pattern, "17-mar",25,25,12,"", ""));
		dlm.addElement(String.format(pattern, "14-abr",26,25,12,"", ""));
		dlm.addElement(String.format(pattern, "19-abr",26,25,12,"", ""));
		dlm.addElement(String.format(pattern, "23-jun",1220,1222,12100,"", "san juan"));
		dlm.addElement(String.format(pattern, "14-ago",32,33,23,"", ""));
		dlm.addElement(String.format(pattern, "15-sep",23,23,13,"", ""));
		dlm.addElement(String.format(pattern, "25-dic",35,23,43,"","navidad"));
		dlm.addElement(String.format(pattern, "31-dic",45,60,98,"","noche vieja"));

		vacationList = new JList<String>(dlm);
		vacationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		vacationList.setFont(new Font("Courier", Font.BOLD,14));
		scrollPanel = new JScrollPane(vacationList);
		scrollPanel.setBounds(20, 50, 495, 211);
		scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		
		dateChooser.setBounds(525, 50, 150, 20);
		dateChooser.setEnabled(true);
		
		buttonAddVacation.setBounds(525, 80, 150, 30);
//		buttonAddVacation.setEnabled(true);
		buttonModVacation.setBounds(525, 120, 150, 30);
//		buttonModVacation.setEnabled(false);
		buttonDelVacation.setBounds(525, 160, 150, 30);
//		buttonDelVacation.setEnabled(false);

		panelCentral.add(scrollPanel);
		panelCentral.add(labelVacationList1);
		panelCentral.add(labelVacationList2);
		panelCentral.add(scrollPanel);
		
		panelCentral.add(dateChooser);
		panelCentral.add(buttonAddVacation);
		panelCentral.add(buttonModVacation);
		panelCentral.add(buttonDelVacation);
	}

	private void init_panelBottom() {
		// panel
		panelBottom.setLayout(null);
		panelBottom.setBounds(0, 315, width, 60);
		// components
		buttonGoBack.setBounds(20, 10, 150, 30);
		buttonHelp.setBounds(365, 10, 150, 30);
		panelBottom.add(buttonGoBack);
		panelBottom.add(buttonHelp);
	}
	
	protected void init_panelContents() {
		panelContents.setLayout(null);
		panelContents.add(panelTop);
		panelContents.add(panelCentral);
		panelContents.add(panelBottom);
	}
	
	//	//************************************************//
	//	/* Methods of the listener interfaces */
	public void actionPerformed_buttonDelVacation (ActionEvent event) {
//		dlm.remove(vacationList.getSelectedIndex());
	}

	public void actionPerformed_buttonGoBack (ActionEvent event) {
		ctrlPresentacion.changeView("vistaGestion", panelContents);
		vacationList.clearSelection();
	}

	/* Assigning listeners */	
	protected void assign_listenersComponents() {
		
		vacationList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				buttonModVacation.setEnabled(true);
				buttonDelVacation.setEnabled(true);
			}
		});

		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformed_buttonGoBack (e);
			}
		});

		buttonImportCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File (.txt)", "txt");
				chooser.setFileFilter(filter);
				chooser.showOpenDialog(frameView);
			}
		});

		buttonAddVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

			}
		});
		
		buttonModVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (!vacationList.isSelectionEmpty()) {
					ctrlPresentacion.changeView("vistaDiaCalendario", panelContents);
					vacationList.clearSelection();
				}
			}
		});
		
		buttonDelVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (!vacationList.isSelectionEmpty())
					dlm.remove(vacationList.getSelectedIndex());
			}
		});
	}

	//************************************************//

	/* Constructors & public methods */
	public VistaCalendario(CtrlPresentacion pCtrlPresentacion) {
		super(pCtrlPresentacion);
	}
	
	public void init() {
		init_panelTop();
		init_panelCentral();
		init_panelBottom();
		init_frameView();
		init_panelContents();
		assign_listenersComponents();
	}
}
