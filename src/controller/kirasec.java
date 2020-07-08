package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import db.db;
import function.functions;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class kirasec implements Initializable {

	   @FXML
	    private AnchorPane kiraSecPage;
	   
    @FXML
    private DatePicker alimTarih;

    @FXML
    private DatePicker teslimTarih;

    @FXML
    private ComboBox<String> kiraSube;

    @FXML
    private ComboBox<String> teslimSube;

    @FXML
    private Label marka;

    @FXML
    private Label model;

    @FXML
    private Label yakit;

  
int id;
int aracid;
public functions get=new functions();
private Connection connect;
private db dbveri=new db();
float aracFiyat;
int gunSayisi;
private PreparedStatement pst;
ObservableList<String> sube = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String sorgu="select * from sube";
		connect=dbveri.getconnection();
		try {
			pst=connect.prepareStatement(sorgu);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				 sube.add(rs.getString("sube_ad"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kiraSube.setItems(sube);
		teslimSube.setItems(sube);
			
	}
	public void gelenn(int a,int b) {
		 id=a;
		 aracid=b;
			String sorgu="select * from araclar where id=?";
			connect=dbveri.getconnection();
				
		    
							try {
								pst=connect.prepareStatement(sorgu);
								pst.setInt(1, aracid);
								ResultSet rs=pst.executeQuery();
								if (rs.next()) {
									marka.setText(rs.getString("marka"));
									model.setText(rs.getString("model"));
									yakit.setText(rs.getString("yakit"));
									aracFiyat=rs.getFloat("fiyat");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		
							}
						
		   
						
						
	   @FXML
	    void onKirala(ActionEvent event) {
		
			
			
		
gunSayisi=teslimTarih.getValue().getDayOfYear()-alimTarih.getValue().getDayOfYear();
float aracToplamFiyat=gunSayisi*aracFiyat;
String sorgu="insert into kiralama(kullanici_id,arac_id,kira_tarih,teslim_tarih,toplam_fiyat,kira_sube,teslim_sube) "
		+ "Values(?,?,?,?,?,?,?)";
connect=dbveri.getconnection();
try {
	pst=connect.prepareStatement(sorgu);
	pst.setInt(1,id);
	pst.setInt(2,aracid);
	pst.setString(3,alimTarih.getValue().toString());
	pst.setString(4,teslimTarih.getValue().toString());
	pst.setFloat(5,aracToplamFiyat);
	pst.setString(6,kiraSube.getValue());
	pst.setString(7,teslimSube.getValue());
	
	
	int rs =pst.executeUpdate();
	if(rs==1) {
		alert("Kayýt Baþarýyla Tamamlanmýþtýr");
		String sorgu1="update araclar set durum=1 where id=?";
		connect=dbveri.getconnection();
			pst=connect.prepareStatement(sorgu1);
			pst.setInt(1,aracid);
			int rs2 =pst.executeUpdate();
		
		kiraSecPage.getScene().getWindow().hide();
		}
		else {
			alert("Kayýt Ýþlemi Hatalý");
		}
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	    }
	   
	   public void alert(String a) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Bilgi Mesajý");
			alert.setContentText(a);

			alert.showAndWait();
	    }
	    
	
	
}
