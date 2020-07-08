package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import db.db;
import function.functions;
import controller.mainPage;

public class girisYap implements Initializable {

	
    @FXML
    private AnchorPane loginPage;

    @FXML
    private ImageView img;

    @FXML
    private ImageView loadingImg;

    @FXML
    private Button kayitButon;

    @FXML
    private Button girisButon;

    @FXML
    private TextField name;

    @FXML
    private Button forgetButon;

    @FXML
    private PasswordField password;
    @FXML
    private Label erorLabel;

    
    private Connection connect;
    private db dbveri;
    private PreparedStatement pst;
    public functions get=new functions();
    int id;
   
 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadingImg.setVisible(false);
		dbveri=new db();
		erorLabel.setVisible(false);
		 
		

	}
	
	
	@FXML
	    void girisYap(ActionEvent event) throws IOException {
		loadingImg.setVisible(true);
		 	
	
			
			
		String sorgu="select * from kullanici where adi=? and sifre=?";
		connect=dbveri.getconnection();
		try {
			pst=connect.prepareStatement(sorgu);
			pst.setString(1, name.getText());
			pst.setString(2, password.getText());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				id=rs.getInt("id");
					PauseTransition pt=new PauseTransition();
					pt.setDuration(Duration.seconds(2));
					pt.setOnFinished(ev->{
					get.getPage(id, loginPage,"/Car/MainPage.fxml");
					
						
						
					});
					
					pt.play();
				
				
			}else {
			loadingImg.setVisible(false);
			erorLabel.setVisible(true);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	    }
		
	
	
	  @FXML
	    void kayitOl(ActionEvent e2) throws IOException {
		  
		get.getPage(loginPage, "/Car/SingIn.fxml");
		 		 
	    }
	

}
