//sostituto della pagina jsp nello stand alone

package jsp;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class sendControllerGUI implements Initializable{
	ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TextField numberTextField;

    @FXML
    private DatePicker DataRilascioInput;

    @FXML
    private DatePicker DataScadInput;

    @FXML
    private ChoiceBox<String> EnteInput;
    
    @FXML
    private Button ButtonReq;
    
    private void loadData() {
    	
    	String a = "motorizzazione";
    	String b = "comune";
    	list.addAll(a,b);
    	EnteInput.getItems().addAll(list);
    }

    @FXML
    void send(ActionEvent event) {
    	Alert a = new Alert(AlertType.NONE); 
        
        a.setAlertType(AlertType.WARNING); 
    	            
        String numero = numberTextField.getText();
        System.out.println("numero patente"+numero);
        if(numero==null) {
        	a.setContentText("Inserire il numero della patente"); 
        	a.show(); //errore
        	}
        
        LocalDate dataScad = DataScadInput.getValue();
    	if(dataScad == null) {
    		a.setContentText("Inserire una data di scadenza"); 
    		a.show(); //errore
		}
        
    	LocalDate dataRilascio = DataRilascioInput.getValue();
    	if(dataRilascio == null) {
    		a.setContentText("Inserire una data di rilascio"); 
    		a.show(); //errore 
    		}

        if (dataRilascio.isAfter(dataScad)) {
        	a.setContentText("La data di rilascio non può essere successiva a quella di scadenza!"); 
        	a.show();
        }
        
        String Ente = EnteInput.getValue();
        if (Ente==null) {
        	
        	a.setContentText("Inserisci ente di rilascio"); 
        	a.show();
        	
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dataRilascio2 = dataRilascio.format(formatter);
        String dataScad2 = dataScad.format(formatter);
        
        RichiesteBean passaggioB = new RichiesteBean();
        passaggioB.setNumero(numero);
        passaggioB.setDataRilascio(dataRilascio2);
        passaggioB.setDataScad(dataScad2);
        passaggioB.setEnte(Ente);
        System.out.println("ho settato le variabili nel bean");
        passaggioB.invio();
        

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	loadData();
    	
    }
    
}
