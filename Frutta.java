import java.util.*;

public class Frutta extends Prodotto{
	
	private Date DataDiRaccolta;
	private String ModalitÓDiConservazione;
	
	
	public Date getDataDiRaccolta() {
		return DataDiRaccolta;
	}
	public void setDataDiRaccolta(Date dataDiRaccolta) {
		DataDiRaccolta = dataDiRaccolta;
	}
	public String getModalitÓDiConservazione() {
		System.out.println(""+ModalitÓDiConservazione);
		return ModalitÓDiConservazione;
	}
	public void setModalitÓDiConservazione(String modalitÓDiConservazione) {
		ModalitÓDiConservazione = modalitÓDiConservazione;
	}


	@Override
	public void CalcolaPrezzo() {
		// TODO Auto-generated method stub
		super.CalcolaPrezzo();
	}
	
	public Frutta() {
		// TODO Auto-generated constructor stub
	}

}
