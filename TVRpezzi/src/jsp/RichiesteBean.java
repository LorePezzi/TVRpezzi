package jsp;

import java.time.LocalDate;

public class RichiesteBean {

    private String numero, ente;
    private String dataRilascio, dataScad;
	
	public RichiesteBean() {
		
	}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(String dataRilascio) {
        this.dataRilascio = dataRilascio;
    }
    
    public String getDatascad() {
        return dataScad;
    }

    public void setDataScad(String dataScad) {
        this.dataScad = dataScad;
    }
    
    public String getEnte() {
        return numero;
    }

    public void setEnte(String ente) {
        this.ente = ente;
    }

    public boolean invio() {
    	
		System.out.println("ciao sono il bean delle richieste, invio i dati al controller applicativo");
		System.out.println("il numero della patente è " + numero +", la data di rilascio è " + dataRilascio + ", la data di scadenza è "+ dataScad +", l'ente di rilascio è:" + ente);
		// controllo sintattico
        RichiesteBean send = RequestController.getInstance().send(numero, dataRilascio, dataScad, ente);
		return send!=null;
        
    }
	
	
}
