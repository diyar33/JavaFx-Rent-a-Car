package controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.db;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import function.functions;

public class mainPage implements Initializable {

    

	@FXML
    private AnchorPane mainPage;

    @FXML
    private Label userLabel;

    @FXML
    private ImageView otoimg;

    @FXML
    private Label marka;

    @FXML
    private Label model;

    @FXML
    private Label segment;

    @FXML
    private Label motor;

    @FXML
    private Label yil;

    @FXML
    private Label ktarih;

    @FXML
    private Label tsube;

    @FXML
    private Label ttarih;

    @FXML
    private Label ksube;

    @FXML
    private Label yakit;

    @FXML
    private Label tfiyat;

    @FXML
    private Label gfiyat;
    @FXML
    private Button cikisyap;

	public functions get=new functions();
	 private Connection connect;
	 private PreparedStatement pst;
	 private PreparedStatement pst2;
	 private db dbveri=new db();
	 int id;
	 FileInputStream file; 

	 

	
	
	 public void gelenid(int a) {
		 id=a;
		 //1. Sorgu
		 String sorgu="select * from kullanici where id=?";
			connect=dbveri.getconnection();
			try {
				pst=connect.prepareStatement(sorgu);
				pst.setInt(1, a);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					userLabel.setText(rs.getString("adi"));
					
			}
			else {
				userLabel.setText("yokk");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//2. Sorgu
		 String sorgu1="select * from kiralama kr "
		 		+ "inner join araclar ar on kr.arac_id=ar.id "
		 		+ "where kr.kullanici_id=? and kr.kdurum=1";
			connect=dbveri.getconnection();
			try {
				
				pst=connect.prepareStatement(sorgu1);
				pst.setInt(1, a);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					
					file=new FileInputStream(rs.getString("resim"));
					Image imag=new Image(file);
					otoimg.setImage(imag);
					model.setText(rs.getString("model"));
					marka.setText(rs.getString("marka"));
					yil.setText(rs.getString("yil"));
					segment.setText(rs.getString("segment"));
					yakit.setText(rs.getString("yakit"));
					motor.setText(rs.getString("motor"));
					gfiyat.setText(rs.getString("fiyat"));
					tfiyat.setText(rs.getString("toplam_fiyat"));
					ktarih.setText(rs.getString("kira_tarih"));
					ttarih.setText(rs.getString("teslim_tarih"));
					ksube.setText(rs.getString("kira_sube"));
					tsube.setText(rs.getString("teslim_sube"));

					
				model.setText(rs.getString("model"));
				
			}
			else {
				model.setText("yokk");
			}
			
			
			
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	    }
	 
	 
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			

			
			
		}
		
		
		   @FXML
		    void kapat(MouseEvent event) {
		    
				Platform.exit();
		    }
		   
	    @FXML
	    void cikisYap(MouseEvent event) {
	    
get.getPage(mainPage, "/Car/LoginPage.fxml");
	    }

	    @FXML
	    void gett(ActionEvent event) throws IOException {
	   get.getPage1(id, mainPage, "/Car/aracKirala.fxml");
	    }

	    @FXML
	    void getGecmis(ActionEvent event) {
	    	get.getPage3(id, mainPage, "/Car/gecmisIslemler.fxml");
			
	    }

	    @FXML
	    void getIletisim(ActionEvent event) {
	    	get.getPage("/Car/iletisim.fxml");
	    }
	    
		
	    
	
}
