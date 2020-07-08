package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class iletisim implements Initializable {

    @FXML
    private AnchorPane iletisim;
    
	   @FXML
	    void cýkýsyap(MouseEvent event) {
		   iletisim.getScene().getWindow().hide();

	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
