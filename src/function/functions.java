package function;

import java.io.IOException;


import controller.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class functions<b> {
   

	public void getPage(AnchorPane page,String target) {
		
		page.getScene().getWindow().hide();
		  Stage main=new Stage();
		  Parent root ;
		try {
			root = FXMLLoader.load(getClass().getResource(target));
			Scene scene = new Scene(root);
			main.setScene(scene);
			main.show();
			main.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	public void getPage(String target) {
		
		  Stage main=new Stage();
		  Parent root ;
		try {
			root = FXMLLoader.load(getClass().getResource(target));
			Scene scene = new Scene(root);
			main.setScene(scene);
			main.show();
			main.setResizable(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	public void getPage(int a,AnchorPane page,String target) {
		page.getScene().getWindow().hide();
		 FXMLLoader loader=new FXMLLoader(getClass().getResource(target));
		 Parent root=null;
		 mainPage main=null;
		 try {
			 root=loader.load();
			 main=loader.getController();
	main.gelenid(a);
			Stage stage=new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
		
		
	}
	public void getPage1(int a,AnchorPane page,String target) {
		page.getScene().getWindow().hide();
		 FXMLLoader loader=new FXMLLoader(getClass().getResource(target));
		 Parent root=null;
		 arackirala main=null;
		 try {
			 root=loader.load();
			 main=loader.getController();
	main.gelenn(a);
			Stage stage=new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
		
		
	}
	
	public void getPage2(int a,int b,String target) {
		
		 FXMLLoader loader=new FXMLLoader(getClass().getResource(target));
		 Parent root=null;
		 kirasec main=null;
		 try {
			 root=loader.load();
			 main=loader.getController();
	main.gelenn(a,b);
			Stage stage=new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
		
		
	}
	public void getPage3(int a,AnchorPane page,String target) {
		page.getScene().getWindow().hide();
		 FXMLLoader loader=new FXMLLoader(getClass().getResource(target));
		 Parent root=null;
		 gecmisIslemler main=null;
		 try {
			 root=loader.load();
			 main=loader.getController();
	main.gelenn(a);
			Stage stage=new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
		
		
	}

}
