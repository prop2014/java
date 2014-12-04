package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Vista generica
 * @author Felix Fernando Ramos Velazquez
 */
public class Vista {

	/* Private attributes */
	protected CtrlPresentacion ctrlPresentacion;

	//-- Containers --//
	protected JFrame frameView = new JFrame("Programador de guardias");
	protected JPanel panelContents = new JPanel();

	//-- Others private attributes--//
	protected static final int width = 700;		// anchura panel contenedor
	protected static final int height = 378;	// altura panel contenedor
	
	/* Constructors & protected methods */
	protected Vista(CtrlPresentacion pCtrlPresentacion) {
		ctrlPresentacion = pCtrlPresentacion;
	}
	
	protected void init() {}
	
	protected void init_frameView() {
		frameView = ctrlPresentacion.getFrame();
		JPanel contentPane = (JPanel) frameView.getContentPane();
		contentPane.setLayout(null);
		panelContents.setBounds(0,0,width,height);
		contentPane.add(panelContents);
	}
	
	protected void init_panelContents() {}
	
	protected void assign_listenersComponents() {}
	
	/* Public methods */
	public JPanel getPanel() {
		return panelContents;
	}
	
	public void showPanel() {
		panelContents.setVisible(true);
	}
	
	public void hidePanel() {
		panelContents.setVisible(false);
	}

	public void showView() {
		frameView.setVisible(true);
	}

	public void enableView() {
		frameView.setEnabled(true);
	}

	public void disableView() {
		frameView.setEnabled(false);
	}
}
