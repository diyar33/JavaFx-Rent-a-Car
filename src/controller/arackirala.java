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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import function.functions;

public class arackirala implements Initializable {


    @FXML
    public AnchorPane kiraPage;

    @FXML
    private Button cikisyap;

    @FXML
    private Label userLabel;

    @FXML
    private ComboBox<String> markaSelect;

    @FXML
    private ComboBox<String> yakitSelect;

    @FXML
    private ComboBox<String> segmenSelect;

    @FXML
    private TableView<datatable> table;


    @FXML
    private TableColumn<datatable,Integer> sira;

    @FXML
    private TableColumn<datatable, Integer> idtable;

    @FXML
    private TableColumn<datatable, String> colmarka;

    @FXML
    private TableColumn<datatable, String> colmodel;

    @FXML
    private TableColumn<datatable, String> colyil;

    @FXML
    private TableColumn<datatable, String> colyakit;

    @FXML
    private TableColumn<datatable, String> colmotor;

    @FXML
    private TableColumn<datatable, String> colsegment;

    @FXML
    private TableColumn<datatable, String> colfiyat;
	
	
	    public functions get=new functions();
		 private Connection connect;
		 private db dbveri=new db();
		 private PreparedStatement pst;
		 int id;
		 int aracid;
		 FileInputStream file;
ObservableList<String> segmen=FXCollections.observableArrayList("D","C","B");
ObservableList<String> marka=FXCollections.observableArrayList("Ford","Hundai","Fiat","Volkswagen","Opel","Renault","Honda","Peugeot");		
ObservableList<String> yakit=FXCollections.observableArrayList("Benzin","Dizel","LPG");
	   ObservableList<datatable> list=FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		combobox();
		
		connect=dbveri.getconnection();
		int sayac=1;
		String sql="select * from araclar where durum=0 order by model";
	
			ResultSet rs;
			try {
				rs = connect.createStatement().executeQuery(sql);
				while(rs.next()) {
					list.add(new datatable(rs.getString("marka"),sayac, rs.getString("model"),rs.getString("yil"), rs.getString("segment"), rs.getString("yakit"), rs.getString("fiyat"), rs.getString("motor"),rs.getInt("id")));
				sayac++;	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			table();
		
	}
	
	public void table() {
		
		
	
			sira.setCellValueFactory(new PropertyValueFactory<>("sira"));
			colmarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
			colmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
			colyil.setCellValueFactory(new PropertyValueFactory<>("yil"));
			colmotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
			colyakit.setCellValueFactory(new PropertyValueFactory<>("yakit"));
			colsegment.setCellValueFactory(new PropertyValueFactory<>("segment"));
			colfiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			idtable.setCellValueFactory(new PropertyValueFactory<>("id"));
			table.setItems(list);	
		
	}
	
	


	public void combobox() {
		segmenSelect.setItems(segmen);
		markaSelect.setItems(marka);
		yakitSelect.setItems(yakit);
		
		
	}
	
	public void gelenn(int a) {
		 id=a;

	    }
	
	 @FXML
	    void getAnaSayfa(ActionEvent event) {
		 get.getPage(id, kiraPage, "/Car/MainPage.fxml");

	    }
	 @FXML
	    void filtrele(ActionEvent event) {
			connect=dbveri.getconnection();
			int sayac=1;
			String sql="select * from araclar where kdurum=0 and (marka=? or yakit=? or segment=?) order by model";
		
	
				try {
					 pst = connect.prepareStatement(sql);
					pst.setString(1, markaSelect.getValue());
					pst.setString(2, yakitSelect.getValue());
					pst.setString(3, segmenSelect.getValue());
					ResultSet rs=pst.executeQuery();
					table.getItems().clear();
					while(rs.next()) {
						list.add(new datatable(rs.getString("marka"),sayac, rs.getString("model"),rs.getString("yil"), rs.getString("segment"), rs.getString("yakit"), rs.getString("fiyat"), rs.getString("motor"),rs.getInt("id")));
						sayac++;		
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
				table();
        		
	    }


	    @FXML
	    void getGecmis(ActionEvent event) {
	    	get.getPage3(id, kiraPage, "/Car/gecmisIslemler.fxml");

	    }

	    @FXML
	    void getIletisim(ActionEvent event) {
	    	get.getPage("/Car/iletisim.fxml");
	    }
	    public void alert(String a) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Bilgi Mesajý");
			alert.setContentText(a);

			alert.showAndWait();
	    }
	    
	
	    @FXML
	    void kirala(ActionEvent event) {
	    	   String sql="select * from kiralama where kullanici_id=? and kdurum=1 ";
				connect=dbveri.getconnection();
				try {
					pst=connect.prepareStatement(sql);
					pst.setInt(1,id);
					ResultSet rs =pst.executeQuery();
					if(rs.next()) {
						alert("Kiralýk Aracýnýz Bulunmaktadýr. Baþka Araç Kiralayamazsýnýz.");
						
					}
					else {
						aracid= table.getSelectionModel().getSelectedItem().getId();
				    	get.getPage2(id,aracid,"/Car/KiraSec.fxml");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	
	    }
	    
	    @FXML
	    void cikis(MouseEvent event) {
	    	get.getPage(kiraPage, "/Car/LoginPage.fxml");
	    }

	

}
