package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.NumberFormatException;
import java.io.IOException;

import com.toedter.calendar.JDateChooser;
//import java.util.Formatter;
//import java.text.ParseException;


/**
 * Vista gestion de calendario
 * @author Felix Fernando Ramos Velazquez
 */
public class VistaCalendario extends Vista {

	//-- Containers --//
	private JPanel panelTop = new JPanel();
	private JPanel panelInfo1 = new JPanel();
	//	private JPanel panelInfo2 = new JPanel();
	private JPanel panelRight = new JPanel();
	private JPanel panelBottom = new JPanel();
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
	private JList<String> listVacations;
	private JScrollPane scrollPanel;
	private JDateChooser dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/##", '_');


	//-- Others private attributes--//
	private static final String pattern = "%7s%11s%9s%9s%-7s%s";	// patron formato lista dias vacacionales

	/* Private Methods */
	private void init_panelTop() {
		// panel
		panelTop.setLayout(null);
		panelTop.setBounds(0, 0, width, 95);
		// components
		buttonCreateCal.setBounds(325, 10, 170, 30);
		buttonCreateCal.setFont(new Font("Arial", Font.BOLD, 11));
		buttonDeleteCal.setBounds(325, 10, 170, 30);
		buttonDeleteCal.setFont(new Font("Arial", Font.BOLD, 11));
		buttonDeleteCal.setVisible(false);
		buttonImportCal.setBounds(505, 10, 170, 30);
		buttonImportCal.setFont(new Font("Arial", Font.BOLD, 11));
		labelCalendar = new JLabel("(No hay calendario vacacional)");
		labelCalendar.setFont(new Font("Arial Italic", Font.TRUETYPE_FONT,16));
		labelCalendar.setBounds(20, 10, 325, 30);
		labelVacationList1 = new JLabel(String.format("%36s", "Numero de doctores:"));
		labelVacationList1.setFont(new Font("Courier", Font.BOLD,14));
		labelVacationList1.setBounds(20, 60, 495, 15);
		labelVacationList2 = new JLabel(String.format("%7s%9s%9s%9s%-7s%s", " Dia vac.","M","T","N","","Fecha espec."));
		labelVacationList2.setFont(new Font("Courier", Font.BOLD,14));
		labelVacationList2.setBounds(20, 75, 495, 15);

		panelTop.add(labelCalendar);
		panelTop.add(buttonCreateCal);
		panelTop.add(buttonImportCal);
		panelTop.add(buttonDeleteCal);
		panelTop.add(labelVacationList1);
		panelTop.add(labelVacationList2);

		// tooltips
		buttonCreateCal.setToolTipText("Crear nuevo calendario");
		buttonImportCal.setToolTipText("Importar calendario existente");
		buttonDeleteCal.setToolTipText("Eliminar calendario existente");
	}

	private void init_panelInfo1() {
		// panel
		panelInfo1.setLayout(null);
		panelInfo1.setBounds(0, 50, 525, 265);
		// components
		dlm.addElement("17-ene");
		//		dlm.addElement(String.format(pattern, "31-ene",23,23,12,"", ""));
		//		dlm.addElement(String.format(pattern, "2-feb",0,0,0,"", ""));
		//		dlm.addElement(String.format(pattern, "3-feb",0,0,0,"", ""));
		//		dlm.addElement(String.format(pattern, "4-feb",0,0,0,"", ""));
		//		dlm.addElement(String.format(pattern, "17-feb",25,25,12,"", ""));
		//		dlm.addElement(String.format(pattern, "17-mar",25,25,12,"", ""));
		//		dlm.addElement(String.format(pattern, "14-abr",26,25,12,"", ""));
		//		dlm.addElement(String.format(pattern, "19-abr",26,25,12,"", ""));
		//		dlm.addElement(String.format(pattern, "23-jun",1220,1222,12100,"", "san juan"));
		//		dlm.addElement(String.format(pattern, "14-ago",32,33,23,"", ""));
		//		dlm.addElement(String.format(pattern, "15-sep",23,23,13,"", ""));
		//		dlm.addElement(String.format(pattern, "25-dic",35,23,43,"","navidad"));
		//		dlm.addElement(String.format(pattern, "31-dic",45,60,98,"","noche vieja"));

		listVacations = new JList<String>(dlm);
		listVacations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		listVacations.setFont(new Font("Courier", Font.PLAIN,14));
		scrollPanel = new JScrollPane(listVacations);
		scrollPanel.setBounds(20, 45, 495, 200);

		panelInfo1.add(scrollPanel);
	}

	private void init_panelInfo2() {

	}

	private void init_panelRight() {
		// panel
		panelRight.setLayout(null);
		panelRight.setBounds(525, 95, 175, 220);
		// components
		dateChooser.setBounds(0, 0, 150, 25);
		dateChooser.setEnabled(false);
		buttonAddVacation.setBounds(0, 35, 150, 40);
		buttonAddVacation.setEnabled(false);
		buttonModVacation.setBounds(0, 95, 150, 40);
		buttonModVacation.setEnabled(false);
		buttonDelVacation.setBounds(0, 155, 150, 40);
		buttonDelVacation.setEnabled(false);

		panelRight.add(dateChooser);
		panelRight.add(buttonAddVacation);
		panelRight.add(buttonModVacation);
		panelRight.add(buttonDelVacation);
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

	private void update_listVacations() {
		dlm.clear();
		ArrayList<ArrayList<String>> vacations = ctrlPresentacion.getALLVacations();
		if (!vacations.isEmpty()) {
			for (ArrayList<String> vacationDay : vacations) {
				String date = vacationDay.get(0);
				String morningDrs = vacationDay.get(1);
				String eveningDrs = vacationDay.get(2);
				String nightDrs = vacationDay.get(3);
				String especialDate = vacationDay.get(4);
				dlm.addElement(String.format(pattern, date, morningDrs, eveningDrs, nightDrs,"", especialDate));
			}
		}
	}

	private GregorianCalendar getSelectedDate(String strDate) throws ParseException,NumberFormatException {
		try {
			int hyphenIndex = strDate.indexOf('-');
			int beginIndex = (strDate.charAt(hyphenIndex-2) != ' ') ? hyphenIndex-2 : hyphenIndex-1;
			
			int d = Integer.parseInt(strDate.substring(beginIndex, hyphenIndex));
			int M;
			switch (strDate.substring(hyphenIndex+1, hyphenIndex+4)) {
			case "ene": {M = 0;break;}
			case "feb": {M = 2;break;}
			case "mar": {M = 3;break;}
			case "abr": {M = 4;break;}
			case "may": {M = 5;break;}
			case "jun": {M = 6;break;}
			case "jul": {M = 7;break;}
			case "ago": {M = 8;break;}
			case "sep": {M = 9;break;}
			case "oct": {M = 10;break;}
			case "nov": {M = 11;break;}
			case "dic": {M = 12;break;}
			default: {
				throw new ParseException("El mes no es correcto ",0);
			}
			}
			GregorianCalendar date = new GregorianCalendar(calendarYear,M,d);
			return date;
		}
		catch (NumberFormatException e) {throw new NumberFormatException("La fecha seleccionada no es correcta ");}
	}

	protected void init_panelContents() {
		panelContents.setLayout(null);
		panelContents.add(panelTop);
		panelContents.add(panelInfo1);
		panelContents.add(panelRight);
		panelContents.add(panelBottom);
	}

	//******************************************************************************//
	/* Methods of the listener interfaces */
	public void actionPerformed_buttonCreateCal(ActionEvent event) {
		String s = JOptionPane.showInputDialog(null, "Introducir anyo del calendario ", "Crear calendario", JOptionPane.PLAIN_MESSAGE );
		if ((s != null) && (s.length() > 0)) {
			try {
				int year = Integer.parseInt(s);
				GregorianCalendar currentDate = new GregorianCalendar();
				int minYear = currentDate.get(GregorianCalendar.YEAR);
				int maxYear = currentDate.get(GregorianCalendar.YEAR) + 5;
				if (year < minYear || year > maxYear) {
					rejectedOperationDialog("El anyo ha de estar dentro del rango " + minYear + " - " + maxYear + " ");
				}
				else {
					ctrlPresentacion.createCalendar(year);
					calendarYear = ctrlPresentacion.getCalendarYear();
					labelCalendar.setText("Calendario vacacional " + calendarYear);
					labelCalendar.setFont(new Font("Arial", Font.BOLD, 16));

					buttonDeleteCal.setVisible(true);
					buttonCreateCal.setVisible(false);
					GregorianCalendar minSelectDate, maxSelectDate;
					minSelectDate = new GregorianCalendar(calendarYear,0,1,0,0,0);
					maxSelectDate = new GregorianCalendar(calendarYear,11,31,23,59,59);
					dateChooser.setSelectableDateRange(minSelectDate.getTime(), maxSelectDate.getTime());
					dateChooser.setEnabled(true);
					buttonAddVacation.setEnabled(true);
					successfulOperationDialog("Se ha creado el calendario del anyo " + year + " ! ");
				}
			}
			catch(NumberFormatException e) {
				rejectedOperationDialog("El anyo introducido no es correcto ");
			}
			return;
		}
		canceledOperationDialog("No se ha creado el calendario !");
	}

	public void actionPerformed_buttonDeleteCal(ActionEvent event) {
		if (confirmationDialog("Eliminar el calendario actual ? ", "Eliminar calendario") == JOptionPane.YES_OPTION) {
			int year = calendarYear;
			calendarYear = -1;
			labelCalendar.setText("(No hay calendario vacacional)");
			labelCalendar.setFont(new Font("Arial", Font.ITALIC, 16));
			dateChooser.setCalendar(null);
			dateChooser.setEnabled(false);
			buttonAddVacation.setEnabled(false);
			buttonCreateCal.setVisible(true);
			buttonDeleteCal.setVisible(false);
			dlm.clear();
			successfulOperationDialog("Se ha eliminado el calendario vacacional " + year + " ! ");
		}
	}

	public void actionPerformed_buttonImportCal(ActionEvent event) {
		if (calendarYear != -1) {
			if (confirmationDialog("Importar un nuevo calendario y reemplazar el calendario actual ? ", "Importar calendario") == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File (.txt)", "txt");
		chooser.setFileFilter(filter);
		chooser.showOpenDialog(frameView);
	}
	//--------------------------------------------------------------------------//
	public void actionPerformed_listVacations(ListSelectionEvent event) {
		if (!listVacations.isSelectionEmpty()) {
			buttonModVacation.setEnabled(true);
			buttonDelVacation.setEnabled(true);
		}
		else {
			buttonModVacation.setEnabled(false);
			buttonDelVacation.setEnabled(false);
		}
	}


	public void actionPerformed_dateChooser(ActionEvent event) {
		if (dateChooser.getDate() == null)
			dateChooser.setCalendar(new GregorianCalendar(calendarYear,0,1,0,0,0));
	}

	//	public void actionPerformed_buttonAddVacation(ActionEvent event) {
	//		Date date = dateChooser.getDate();
	//		if (date != null && !(date.before(dateChooser.getMinSelectableDate())) && !(date.after(dateChooser.getMaxSelectableDate()))) {
	//			
	////			vacations = ctrlPresentacion.getALLVacations();
	//		}
	//		else {
	//			rejectedOperationDialog("No se ha introducido una fecha o la fecha introducida no es correcta ");
	//		}
	//	}

	public void actionPerformed_buttonAddVacation(ActionEvent event) {
		Date date = dateChooser.getDate();
		if (date != null && !(date.before(dateChooser.getMinSelectableDate())) && !(date.after(dateChooser.getMaxSelectableDate()))) {
			SimpleDateFormat sdf = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
			if (confirmationDialog("Anadir el dia vacacional " + sdf.format(date) + " ? ", "Anadir dia vacacional") == JOptionPane.YES_OPTION) {
				sdf.applyPattern("d-MMM");
				dlm.addElement(String.format(pattern, sdf.format(date),0,0,0,"", ""));
				sdf.applyPattern("d 'de' MMMM 'de' yyyy");
				successfulOperationDialog("Se ha anadido el dia vacacional " + sdf.format(date) + " ! ");
			}
			else {
				canceledOperationDialog("No se ha anadido el dia vacacional !");
			}
		}
		else {
			rejectedOperationDialog("No se ha introducido una fecha o la fecha introducida no es correcta ");
		}
		dateChooser.setDate(null);
	}

	public void actionPerformed_ModVacation(ActionEvent event) {
		if (!listVacations.isSelectionEmpty()) {
			//			ctrlPresentacion.changeView("vistaDiaCalendario", panelContents);
			//			change_panelInfo();
		}
	}

	public void actionPerformed_buttonDelVacation(ActionEvent event) {
		if (!listVacations.isSelectionEmpty()) {
			if (confirmationDialog("Eliminar el dia vacacional ?", "Eliminar dia vacacional") == JOptionPane.YES_OPTION) {
				try {
					GregorianCalendar date = getSelectedDate(listVacations.getSelectedValue());
					if (ctrlPresentacion.deleteVacationDay(date)) {
						update_listVacations();
						//						dlm.remove(listVacations.getSelectedIndex());
						successfulOperationDialog("Se ha eliminado el dia vacacional !");
					}
				}
				catch(IOException e) {rejectedOperationDialog(e.getMessage());}
				catch(NumberFormatException e) {rejectedOperationDialog(e.getMessage());}
				catch(ParseException e) {rejectedOperationDialog(e.getMessage());}
			}
		}
		else rejectedOperationDialog("No se ha seleccionado ningun dia vacacional ");
	}
	//--------------------------------------------------------------------------//
	public void actionPerformed_buttonGoBack(ActionEvent event) {
		ctrlPresentacion.changeView("vistaGestion", panelContents);
		listVacations.clearSelection();
	}
	//--------------------------------------------------------------------------//
	/* Assigning listeners */
	//--------------------------------------------------------------------------//
	protected void assign_listenersComponents() {

		buttonCreateCal.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_buttonCreateCal(event);
			}
		});

		buttonDeleteCal.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_buttonDeleteCal(event);
			}
		});

		buttonImportCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				actionPerformed_buttonImportCal(event);
			}
		});
		//--------------------------------------------------------------------------//
		listVacations.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				actionPerformed_listVacations(event);
			}
		});

		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_dateChooser (event);
			}
		});

		buttonAddVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_buttonAddVacation(event);
			}
		});

		buttonModVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_ModVacation (event);
			}
		});

		buttonDelVacation.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				actionPerformed_buttonDelVacation(event);
			}
		});
		//--------------------------------------------------------------------------//
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				actionPerformed_buttonGoBack (event);
			}
		});

		buttonHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//				actionPerformed_buttonHelp (event);
			}
		});
	}
	//******************************************************************************//

	/* Constructors & public methods */
	public VistaCalendario(CtrlPresentacion pCtrlPresentacion) {
		super(pCtrlPresentacion);
	}

	public void init() {
		init_panelTop();
		init_panelInfo1();
		init_panelInfo2();
		init_panelRight();
		init_panelBottom();
		init_frameView();
		init_panelContents();
		assign_listenersComponents();
	}
}
