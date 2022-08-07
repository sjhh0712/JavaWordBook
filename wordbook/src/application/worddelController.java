package application;

import java.io.IOException;
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

public class worddelController implements Initializable{
	@FXML TextField deltxt;
	@FXML Button delexebtn;
	PreparedStatement ps;
	public static mariadbconn db;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		db = new mariadbconn();
	}

	public void deleteword(ActionEvent event) {
		String dword = deltxt.getText();
		
		try {
			ps = db.con.prepareStatement("delete from wordlist where word = ?");
			
			ps.setString(1, dword);
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
			}
			else {
				JOptionPane.showMessageDialog(null, "���������ʴ� �ܾ��Դϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
