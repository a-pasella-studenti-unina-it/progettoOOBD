import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class FinestraConfezionati extends JFrame {

	private JPanel contentPane;
	private JTextField Quantitą_TF;
	public Controller IlController;
	private double QuantitąDaSottrarreDouble;
	private JTextField PrezzoAlKilo_TF;
	private JTextField PrezzoTot_TF;
	private JTextField DispInMagazzino_TF;
	private double PrezzoAlKiloDouble;
	private JTextField SimboloEuro;
	private String DispInMagazzinoString;
	private JTextField SelezionaConfezionati_TF;
	public String TipoFrutta=null;
	private JTextField textField;
	
	
	public String getDispInMagazzinoString() {
		return DispInMagazzinoString;
	}
	public void setDispInMagazzinoString(String dispInMagazzinoString) {
		DispInMagazzinoString = dispInMagazzinoString;
	}
	public void setQuantitąDaSottrarreDouble(double quantitąDaSottrarreDouble) {
		QuantitąDaSottrarreDouble = 0.0;
	}
	public double getQuantitąDaSottrarreDouble() {
		return QuantitąDaSottrarreDouble;
	}
	
	public double getPrezzoAlKiloDouble() {
		return PrezzoAlKiloDouble;
	}
	


	/**
	 * Create the frame.
	 */
	public FinestraConfezionati (Controller c) {
		
		IlController=c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Confezionati_JLb = new JLabel("Confezionati");
		Confezionati_JLb.setHorizontalAlignment(SwingConstants.CENTER);
		Confezionati_JLb.setFont(new Font("Cambria", Font.PLAIN, 20));
		Confezionati_JLb.setBounds(187, 0, 109, 25);
		contentPane.add(Confezionati_JLb);
		
		JLabel Quantitą_JLb = new JLabel("Quantit\u00E0(in chili) che desidera aquistare:");
		Quantitą_JLb.setFont(new Font("Cambria", Font.PLAIN, 14));
		Quantitą_JLb.setBounds(10, 144, 261, 19);
		contentPane.add(Quantitą_JLb);
		
		Quantitą_TF = new JTextField();
		Quantitą_TF.setEditable(false);
		Quantitą_TF.setFont(new Font("Cambria", Font.PLAIN, 13));
		Quantitą_TF.setHorizontalAlignment(SwingConstants.CENTER);
		Quantitą_TF.setToolTipText("Inserire quantit\u00E0 desiderata");
		Quantitą_TF.setBounds(263, 142, 94, 23);
		contentPane.add(Quantitą_TF);
		Quantitą_TF.setColumns(10);
		
		JButton CalcolaPrezzoButton = new JButton("Calcola Prezzo");
		CalcolaPrezzoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PrezzoAlKiloString = PrezzoAlKilo_TF.getText();
				try {
					PrezzoAlKiloDouble = Double.parseDouble(PrezzoAlKiloString);	
				}
				catch (NumberFormatException Nfe){
					System.err.println("");
				}
				PrezzoTot_TF.setText(c.CalcolaPrezzo());
				CalcolaPrezzoButton.setEnabled(false);
				if((DispInMagazzinoString.equals("Queste erano le ultime scorte in magazzino"))){
					PrezzoTot_TF.setText(PrezzoTot_TF.getText());
					CalcolaPrezzoButton.setEnabled(false);
				};
			}
		});
		CalcolaPrezzoButton.setBounds(10, 203, 121, 23);
		contentPane.add(CalcolaPrezzoButton);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String QuantitąDaSottrarreString=Quantitą_TF.getText();
				try {
					QuantitąDaSottrarreDouble = Double.parseDouble(QuantitąDaSottrarreString);	
				}
				catch (NumberFormatException Nfe){
					System.err.println("");
				}
				DispInMagazzinoString=c.SottraiQuantitą();
				DispInMagazzino_TF.setText(DispInMagazzinoString);
				if((DispInMagazzinoString.equals("Non ci sono abbastanza scorte"))){
					Quantitą_TF.setEditable(false);
					ConfermaButton.setEnabled(false);
					CalcolaPrezzoButton.setEnabled(false);
				}
					else {
						DispInMagazzino_TF.setText(DispInMagazzinoString);
						ConfermaButton.setEnabled(false);
						Quantitą_TF.setEditable(false);
					}
				
			}
		});
		ConfermaButton.setBounds(366, 142, 94, 23);
		contentPane.add(ConfermaButton);
		
		JLabel PrezzoAlKilo_JLb = new JLabel("Prezzo al Chilo:");
		PrezzoAlKilo_JLb.setFont(new Font("Cambria", Font.PLAIN, 14));
		PrezzoAlKilo_JLb.setBounds(10, 178, 109, 14);
		contentPane.add(PrezzoAlKilo_JLb);
		
		PrezzoAlKilo_TF = new JTextField();
		PrezzoAlKilo_TF.setFont(new Font("Cambria", Font.PLAIN, 13));
		PrezzoAlKilo_TF.setHorizontalAlignment(SwingConstants.CENTER);
		PrezzoAlKilo_TF.setEditable(false);
		PrezzoAlKilo_TF.setBounds(112, 175, 35, 20);
		contentPane.add(PrezzoAlKilo_TF);
		PrezzoAlKilo_TF.setColumns(10);
		
		
		
		JLabel PrezzoTot_JLb = new JLabel("Prezzo Totale:");
		PrezzoTot_JLb.setFont(new Font("Cambria", Font.PLAIN, 14));
		PrezzoTot_JLb.setBounds(10, 237, 109, 17);
		contentPane.add(PrezzoTot_JLb);
		
		PrezzoTot_TF = new JTextField();
		PrezzoTot_TF.setFont(new Font("Cambria", Font.PLAIN, 13));
		PrezzoTot_TF.setText("0,00\u20AC");
		PrezzoTot_TF.setEditable(false);
		PrezzoTot_TF.setHorizontalAlignment(SwingConstants.CENTER);
		PrezzoTot_TF.setBounds(112, 235, 109, 20);
		contentPane.add(PrezzoTot_TF);
		PrezzoTot_TF.setColumns(10);
		
		JLabel DispInMagazzino_JLb = new JLabel("Disponibilit\u00E0 in magazzino:");
		DispInMagazzino_JLb.setFont(new Font("Cambria", Font.PLAIN, 15));
		DispInMagazzino_JLb.setBounds(10, 39, 257, 17);
		contentPane.add(DispInMagazzino_JLb);
		
		DispInMagazzino_TF = new JTextField();
		DispInMagazzino_TF.setFont(new Font("Cambria", Font.PLAIN, 14));
		DispInMagazzino_TF.setText("100");
		DispInMagazzino_TF.setHorizontalAlignment(SwingConstants.LEFT);
		DispInMagazzino_TF.setEditable(false);
		DispInMagazzino_TF.setBounds(197, 38, 194, 20);
		contentPane.add(DispInMagazzino_TF);
		DispInMagazzino_TF.setColumns(10);
		
		
		
		JButton AcquistaDiNuovoButton = new JButton("Acquista di nuovo");
		AcquistaDiNuovoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					if((DispInMagazzinoString.equals("Non ci sono abbastanza scorte"))){
						c.ApriJDialogAcquistareQuantitąMinore();
					}
					else if((DispInMagazzinoString.equals("Queste erano le ultime scorte in magazzino"))) {
						AcquistaDiNuovoButton.setEnabled(false);
					}
					else {
						Quantitą_TF.setText("");
						c.setQuantitąTfToZero();
						ConfermaButton.setEnabled(true);
						CalcolaPrezzoButton.setEnabled(true);
						Quantitą_TF.setEditable(true);
					}
				} catch (Exception e1) {
					System.out.println("Selezioni una quantitą prima di acquistare di nuovo");
//					e1.printStackTrace();
				}
				
			}
		});
		AcquistaDiNuovoButton.setBounds(318, 236, 154, 25);
		contentPane.add(AcquistaDiNuovoButton);
		

		JButton TornaHomeButton = new JButton("Torna alla home");
		TornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.TornaAllaHome();
			}
		});
		TornaHomeButton.setBounds(318, 265, 154, 25);
		contentPane.add(TornaHomeButton);
		
		SimboloEuro = new JTextField();
		SimboloEuro.setEditable(false);
		SimboloEuro.setFont(new Font("Cambria", Font.PLAIN, 13));
		SimboloEuro.setHorizontalAlignment(SwingConstants.CENTER);
		SimboloEuro.setText("\u20AC");
		SimboloEuro.setBounds(149, 175, 18, 20);
		contentPane.add(SimboloEuro);
		SimboloEuro.setColumns(10);
		
		JComboBox ConfezionatiComboBox = new JComboBox();
		
		ConfezionatiComboBox.setModel(new DefaultComboBoxModel(new String[] {"Caff\u00E8", "Cioccolato", "Prosciutto", "Mortadella", "Salame", "Gelato"}));
		ConfezionatiComboBox.setToolTipText("");
		ConfezionatiComboBox.setSelectedItem(null);
		ConfezionatiComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TipoFrutta = (String) ConfezionatiComboBox.getSelectedItem();
				
				if(TipoFrutta.equals("Caff\u00E8")) {
					PrezzoAlKilo_TF.setText("1.82");
					Quantitą_TF.setEditable(true);
				}
				
				if(TipoFrutta.equals("Cioccolato")) {
					PrezzoAlKilo_TF.setText("2.92");
					Quantitą_TF.setEditable(true);
				}
				
				if(TipoFrutta.equals("Prosciutto")) {
					PrezzoAlKilo_TF.setText("2.02");
					Quantitą_TF.setEditable(true);
				}

				if(TipoFrutta.equals("Mortadella")) {
					PrezzoAlKilo_TF.setText("2.47");
					Quantitą_TF.setEditable(true);
				}
				
				if(TipoFrutta.equals("Salame")) {
					PrezzoAlKilo_TF.setText("3.27");
					Quantitą_TF.setEditable(true);
				}
				
				if(TipoFrutta.equals("Gelato")) {
					PrezzoAlKilo_TF.setText("3.10");
					Quantitą_TF.setEditable(true);
				}
				
				
			}
		});
		ConfezionatiComboBox.setBounds(162, 108, 109, 22);
		contentPane.add(ConfezionatiComboBox);
		
		SelezionaConfezionati_TF = new JTextField();
		SelezionaConfezionati_TF.setEditable(false);
		SelezionaConfezionati_TF.setFont(new Font("Cambria", Font.PLAIN, 14));
		SelezionaConfezionati_TF.setText("Seleziona Prodotto:");
		SelezionaConfezionati_TF.setBounds(10, 108, 137, 25);
		contentPane.add(SelezionaConfezionati_TF);
		SelezionaConfezionati_TF.setColumns(10);
		
		JLabel DataConfezionamento_JLb = new JLabel("Data Confezionamento:");
		DataConfezionamento_JLb.setFont(new Font("Cambria", Font.PLAIN, 15));
		DataConfezionamento_JLb.setBounds(10, 67, 250, 17);
		contentPane.add(DataConfezionamento_JLb);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(197, 67, 194, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	}
	
}
