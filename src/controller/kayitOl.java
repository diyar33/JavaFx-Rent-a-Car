package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import db.db;
import function.functions;

public class kayitOl implements Initializable {
	
	   @FXML
	    private AnchorPane kayitPage;
	   @FXML
	    private TextField telefon;

	    @FXML
	    private ImageView img;

	    @FXML
	    private Button girisButon;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextField sehir;

	    @FXML
	    private RadioButton erkek;

	    @FXML
	    private ToggleGroup Cinsiyet;

	    @FXML
	    private RadioButton kadin;

	    @FXML
	    private Button kayitButon;

	    @FXML
	    private PasswordField sifre;

	    @FXML
	    private Label success;

private Connection connect;
private db dbveri;
private PreparedStatement pst;
public functions get=new functions();
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		success.setVisible(false);
		dbveri=new db();
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("cikisYap.png");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Image image = new Image(inputstream); 
	
		
	}
	
	  @FXML
	    void girisYap(ActionEvent event) throws IOException {
		get.getPage(kayitPage, "/Car/LoginPage.fxml");

	    }
	  
	  
	  
	  //KAYIT OLLL
	  
	  @FXML
	    void kayitOl(ActionEvent event) throws IOException {
			success.setVisible(true);
			String save="insert into kullanici(adi,sifre,cinsiyet,sehir,telefon) Values(?,?,?,?,?)";
			connect=dbveri.getconnection();
			try {
				pst=connect.prepareStatement(save);
				pst.setString(1, name.getText());
				pst.setString(2, sifre.getText());
				pst.setString(3, Cinsiyet());
				pst.setString(4, sehir.getText());
				pst.setString(5, telefon.getText());
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  
	  
	  
	  
	  
	  public String Cinsiyet() {
		  String cinsiyet="";
		  if(erkek.isSelected()) {
			  cinsiyet="Erkek";
		  }
		  else if(kadin.isSelected()) {
			  cinsiyet="Kadýn";
			  
		  }
			
		  return cinsiyet;
	  }




}
