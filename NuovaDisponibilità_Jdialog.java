import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuovaDisponibilitą_Jdialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Controller IlController;
	private JTextField MostraNuovaDisponibilitą_TF;
	

	

	/**
	 * Create the dialog.
	 */
	public NuovaDisponibilitą_Jdialog(Controller c) {
		IlController=c;
		
		setBounds(100, 100, 317, 125);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			MostraNuovaDisponibilitą_TF = new JTextField();
			MostraNuovaDisponibilitą_TF.setEditable(false);
			MostraNuovaDisponibilitą_TF.setHorizontalAlignment(SwingConstants.CENTER);
			MostraNuovaDisponibilitą_TF.setBounds(10, 48, 279, 20);
			MostraNuovaDisponibilitą_TF.setText(c.toString());
			contentPanel.add(MostraNuovaDisponibilitą_TF);
			MostraNuovaDisponibilitą_TF.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("La nuova disponibilit\u00E0 \u00E8:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(55, 23, 200, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
