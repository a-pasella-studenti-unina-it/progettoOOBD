import java.util.*;

public class Verdura extends Prodotto {
	
	private Date DataDiRaccolta;
	private String ModalitÓDiConservazione;
	
	public Date getDataDiRaccolta() {
		return DataDiRaccolta;
	}
	public void setDataDiRaccolta(Date dataDiRaccolta) {
		DataDiRaccolta = dataDiRaccolta;
	}
	public String getModalitÓDiConservazione() {
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
	
	public Verdura() {
		// TODO Auto-generated constructor stub
	}

}
