package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.db;
import function.functions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class gecmisIslemler implements Initializable {
	
    @FXML
    private AnchorPane gecmisislem;

    @FXML
    private Label userLabel;
 

    @FXML
    private TableView<datatable2> tableview;


    @FXML
    private TableColumn<datatable2,Integer> sira;


    @FXML
    private TableColumn<datatable2, String> colmarka;

    @FXML
    private TableColumn<datatable2, String> colmodel;

    @FXML
    private TableColumn<datatable2, String> colyil;

    @FXML
    private TableColumn<datatable2, String> colyakit;

    @FXML
    private TableColumn<datatable2, String> colmotor;

    @FXML
    private TableColumn<datatable2, String> colTarih;
   

    @FXML
    private TableColumn<datatable2, String> colFiyat;
	

    @FXML
    private TableColumn<datatable2, String> colGun;

    @FXML
    void cikis(MouseEvent event) {
    	get.getPage(gecmisislem, "/Car/LoginPage.fxml");
    }

    @FXML
    void getAnaSayfa(ActionEvent event) {
    	 get.getPage(id, gecmisislem, "/Car/MainPage.fxml");
    }

    @FXML
    void getaracKirala(ActionEvent event) {
    	  get.getPage1(id, gecmisislem, "/Car/aracKirala.fxml");
    }

    @FXML
    void getIletisim(ActionEvent event) {
    	get.getPage("/Car/iletisim.fxml");

    }
    ObservableList<datatable2> list=FXCollections.observableArrayList();
    public functions get=new functions();
	 private Connection connect;
	 private db dbveri=new db();
	 private PreparedStatement pst;
	 int id;
    
	 public void gelenn(int a) {
		 id=a;
		 
			connect=dbveri.getconnection();
			int sayac=1;
			String sorgu1="select * from kiralama kr "
			 		+ "inner join araclar ar on kr.arac_id=ar.id "
			 		+ "where kr.kullanici_id=? and kr.kdurum=0";
				connect=dbveri.getconnection();
				try {
					pst=connect.prepareStatement(sorgu1);
					pst.setInt(1, id);
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
			list.add(new datatable2(rs.getString("marka"), sayac, rs.getString("model"), rs.getString("yil"), rs.getString("kira_tarih"), rs.getString("yakit"), rs.getString("toplam_fiyat"), rs.getString("motor"), rs.getString("teslim_tarih")));
						
					sayac++;	
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			table();

	    }
	
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
		
	}
	
	public void table() {
		
		
	
			sira.setCellValueFactory(new PropertyValueFactory<>("sira"));
			colmarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
			colmodel.setCellValueFactory(new PropertyValueFactory<>("model"));
			colyil.setCellValueFactory(new PropertyValueFactory<>("yil"));
			colmotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
			colyakit.setCellValueFactory(new PropertyValueFactory<>("yakit"));
			colGun.setCellValueFactory(new PropertyValueFactory<>("gun"));
			colFiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
			colTarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
			tableview.setItems(list);	
		
	}

}
