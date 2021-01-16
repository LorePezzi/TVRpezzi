package jsp;


import java.time.LocalDate;

public class RequestController {
	//qui posso fare ulteriori controlli sui dati ricevuti e manipolarli.
	
	
	private static RequestController INSTANCE = null;

    private RequestController() {}

    public static RequestController getInstance() {
        if(INSTANCE==null) {
            INSTANCE = new RequestController();
        }

        return INSTANCE;
    }
    
    
    //ritorno di un eventuale bean, se ricerca di qualcosa torna bean (diverse "entit�")
	public RichiesteBean send(String numero, String dataRilascio, String dataScad, String ente) {
		
		
		
		RichiesteBean richiesteBean = new RichiesteBean();
		//System.out.println("stampato dal controller applicativo");
		//System.out.println("il numero della patente � " + numero +", la data di rilascio � " + dataRilascio + ", la data di scadenza � "+ dataScad +", l'ente di rilascio �:" + ente);
		MySql jdbc=new MySql();
		jdbc.JDBC(numero, dataRilascio, dataScad, ente);
		System.out.println("inviato dati al db?");
		return richiesteBean;
	
	}
	
	
	
}
