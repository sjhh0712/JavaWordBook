package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class wordInController implements Initializable {
	@FXML private TextField wordin, wordmn;
	@FXML private Button insbtn;
	PreparedStatement ps;
	public static mariadbconn db;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		db= new mariadbconn();
	}
	
	public void insertword(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("wordinsert.fxml"));
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		String gword = wordin.getText();
		String gmean = wordmn.getText();
		
		try {
			//���� ����
			ps = db.con.prepareStatement("insert into wordlist (word, mean)values(?,?)");
			
			ps.setString(1, gword);
			ps.setString(2, gmean);
			int status = ps.executeUpdate();//���� ���� �� �����(�Ǽ�)�� status�� ���
			
			if(gword == "" || gmean == "") {
				JOptionPane.showMessageDialog(null, "�ܾ �Է����ּ���.");
			}
			if(status == 1) {
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
				wordin.setText("");
				wordmn.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "�̹� �ְų� ������ �� ���� �ܾ��Դϴ�.");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
