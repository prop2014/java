package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JCalendar;


/**
 * Vista principal de gestion de calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class VistaCalendario {

	/* Private attributes */
	//-- VistaCalendario controller --//
//	private CtrlVistaCalendario ctrl;

	//-- Containers --//
	private JFrame frameView = new JFrame("Gestion calendario");
	private JPanel panelContents = new JPanel(); // contenedor principal: contendra todos los paneles de la vista
	private JPanel panelInfo = new JPanel(); // contenedor central: contendra diferentes paneles, segun la opcion seleccionada
	private JPanel panelAddVacation = new JPanel();
	private JPanel panelCalendar = new JPanel();
	private JPanel panelTopButtons = new JPanel();
	private JPanel panelBottomButtons = new JPanel();
	private JPanel panelRightButtons = new JPanel();

	//-- Buttons --//
	// Top
	private JButton buttonCreateCal = new JButton("Crear calendario");
	private JButton buttonImportCal = new JButton("Importar calendario");
	// Bottom
	private JButton buttonDeleteCal = new JButton("Eliminar calendario");
	private JButton buttonGoBack = new JButton("Volver");
	// Right
	private JButton buttonAddVacation = new JButton("Anadir dia vacacional");
	private JButton buttonMod = new JButton("Modificar dia vacacional");
	private JButton buttonDel = new JButton("Eliminar dia vacacional");

	//-- Others private atributes--//
	// selected panelInfo
//	private int iPanelInfo; // provissional

	/* Private Methods */
	private void init_frameView() {
		//		frameView.setMinimumSize(new Dimension(700,400));
		//		frameView.setPreferredSize(frameView.getMinimumSize());
		frameView.setResizable(false);
		//		frameView.setLocationRelativeTo(null);
		frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.add(panelContents);
	}

	private void init_panelContents() {
		// Layout
		panelContents.setLayout(new BorderLayout());
		// Components
		panelContents.add(panelTopButtons, BorderLayout.NORTH);
		panelContents.add(panelInfo, BorderLayout.CENTER);
		panelContents.add(panelBottomButtons, BorderLayout.SOUTH);
		panelContents.add(panelRightButtons, BorderLayout.EAST);
	}

	private void init_panelInfo() {
		panelInfo = panelAddVacation;
	}

	private void init_panelAddVacation() throws ParseException{
		panelAddVacation.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		JCalendar c = new JCalendar();
		c.setWeekOfYearVisible(false);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		c.setDate(sdf.parse("01-01-2007"));
		c.setSelectableDateRange(sdf.parse("01-01-2007"), sdf.parse("31-12-2007"));
		panelAddVacation.add(c);
	}
	private void init_panelCalendar() throws ParseException{
		//		panelCalendar.setPreferredSize(new Dimension(500,200));;
		panelCalendar.setLayout(new BorderLayout());
		panelCalendar.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		//		JDateChooser c = new JDateChooser();
		JCalendar c = new JCalendar();
		c.setWeekOfYearVisible(false);

		//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//		String min = "27-01-2007";
		//		c.setDate(sdf.parse(min));
		//		//c.setMinSelectableDate(sdf.parse(s));
		//		String max = "31-12-2009";
		//		c.setDate(sdf.parse(max));
		//		c.setSelectableDateRange(sdf.parse(min), sdf.parse(max));
		//c.setMaxSelectableDate(sdf.parse(s));
		panelCalendar.add(c, BorderLayout.CENTER);
	}

	private void init_panelTopButtons() {
		// Layout
		panelTopButtons.setLayout(new GridLayout(0,4,10,0));
		panelTopButtons.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		buttonCreateCal.setPreferredSize(new Dimension(0,35));
		// Components
		panelTopButtons.add(buttonCreateCal);
		panelTopButtons.add(buttonImportCal);
		// ToolTips (optional)
		buttonCreateCal.setToolTipText("Crear nuevo calendario");
		buttonImportCal.setToolTipText("Importar calendario existente");
	}

	private void init_panelBottomButtons() {
		// Layout
		panelBottomButtons.setLayout(new GridLayout(0,4,10,0));
		panelBottomButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		buttonDeleteCal.setPreferredSize(new Dimension(0,35));
		// Components
		panelBottomButtons.add(buttonDeleteCal);
		panelBottomButtons.add(new JLabel());
		panelBottomButtons.add(new JLabel());
		panelBottomButtons.add(buttonGoBack);
	}

	private void init_panelRightButtons() {
		// Layout
		panelRightButtons.setLayout(new GridLayout(4,0,0,10));
		panelRightButtons.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		buttonAddVacation.setPreferredSize(new Dimension(0,40));
		// Components
		panelRightButtons.add(buttonAddVacation);
		panelRightButtons.add(buttonMod);
		panelRightButtons.add(buttonDel);
		//		panelRightButtons.add(new JButton());
	}

	private void initComponents() throws ParseException {

		init_panelAddVacation();
		init_panelInfo();

		init_panelCalendar();
		init_panelTopButtons();
		init_panelBottomButtons();
		init_panelRightButtons();
		assign_listenersComponents();
		init_panelContents();
		init_frameView();
	}

//	//************************************************//
//	/* Methods of the listener interfaces */
	public void actionPerformed_buttonAddVacation (ActionEvent event) {

	}

	/* Assigning listeners */	
	private void assign_listenersComponents() {

		buttonAddVacation.addActionListener
		(new ActionListener() {
			public void actionPerformed (ActionEvent event) {

				actionPerformed_buttonAddVacation(event);
			}
		});
	}

	//************************************************//

	/* Constructors & public methods */
	public VistaCalendario() throws ParseException {
		initComponents();
	}

	public void showView() {
		frameView.pack();
		frameView.setLocationRelativeTo(null);
		frameView.setVisible(true);
	}

	public void enableView() {
		frameView.setEnabled(true);
	}

	public void disableView() {
		frameView.setEnabled(false);
	}

	/** For testing, a main program 
	 * @throws ParseException */
	public static void main(String[] args) throws ParseException {
		VistaCalendario v = new VistaCalendario();

		v.showView();
	}
}
