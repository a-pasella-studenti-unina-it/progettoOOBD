import javax.swing.JDialog;

public class Controller {
	

	FinestraDisponibilità Disp;
	SimulazioneDatabase Sim;
	NuovaDisponibilità_Jdialog NewDispJdialog;
	public int NuovaDisponibilità;
	
	
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
		
	}
	
	public Controller() {
		Disp=new FinestraDisponibilità(this);
		Disp.setVisible(true);
	}
	
	public void ApriJDialog() {
		NewDispJdialog=new NuovaDisponibilità_Jdialog(this);
		NewDispJdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		NewDispJdialog.setVisible(true);
	}

//	public void StampaNuovaDisp() {
//		System.out.println(""+NuovaDisponibilità);
//	}
	public void SottraiQuantità() {
//		System.out.println(""+Sim.getDisponibilitàInMagazzino());
		NuovaDisponibilità=(Sim.getDisponibilitàInMagazzino())-(Disp.getQuantitàDaSottrarreInt());
	}
	
	@Override
	public String toString() {
		return "NuovaDisponibilità=" + NuovaDisponibilità;
	}
}
