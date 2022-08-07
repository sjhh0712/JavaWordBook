package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class homeController implements Initializable {
	@FXML Button btlbtn,insertbtn,delbtn,listbtn;
	
	
	public void inserttheword(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("wordinsert.fxml"));
		
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		stage.setTitle("단어를 입력하세요");
		stage.setScene(scene);
		stage.show();
	}
	
	public void worddelete(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("worddelete.fxml"));
		
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		stage.setTitle("삭제할 단어를 입력하세요");
		stage.setScene(scene);
		stage.show();
	}
	
	public void listsearch() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("wordlist.fxml"));
		
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		stage.setTitle("단어 리스트");
		stage.setScene(scene);
		stage.show();
	}
		
	public void backtologin() {
		Stage stage2 = new Stage();
		Stage stage1 = (Stage)btlbtn.getScene().getWindow();
	
		
		try{
			Parent second = FXMLLoader.load(getClass().getResource("login.fxml")); 
			Scene sc = new Scene(second);
			
			stage2.setScene(sc);
			stage2.show();
			
			stage1.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
