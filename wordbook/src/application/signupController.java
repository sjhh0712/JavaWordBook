package application;

import java.io.IOException;
import java.net.URL;
import java.util.logging.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class signupController implements Initializable{
	@FXML private Button supbtn2,backbtn;
	@FXML private TextField txtid, txtpwd;
	PreparedStatement ps;//sql ������ ����� �ʿ��� ��ü
	public static mariadbconn db;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		db = new mariadbconn();
		
	}
	

	public void signuppage(ActionEvent event) {
		
		Logger logger = Logger.getLogger(signupController.class.getName());

		String checkid = "";
		
		String gid = txtid.getText();
		String gpwd = txtpwd.getText();
		
		try {
			//��ȸ ����
			ps = db.con.prepareStatement("select userID from user where userID = ?");
			ps.setString(1, gid);
			
			db.rs = ps.executeQuery();
			
			while(db.rs.next()) {
				checkid = db.rs.getString("userID");
				break;
			}
			if(checkid == "") {
				JOptionPane.showMessageDialog(null, "�׸��� �Է����ּ���.");
				return;
			}
			if(checkid.equals(gid)) {
				JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");
				return;
			}
			
			
		}catch(SQLException e) {
			logger.log(Level.INFO, e.getMessage());
		}
		
		try {
			//���� ����
			ps = db.con.prepareStatement("insert into user (userID, userPassword)values(?,?)");
			
			ps.setString(1, gid);
			ps.setString(2, gpwd);
			int status = ps.executeUpdate();//���� ���� �� �����(�Ǽ�)�� status�� ���
			

			
			if(status == 1) {
				JOptionPane.showMessageDialog(null, "��밡���� ���̵�. ȸ������ �Ϸ�");
				txtid.setText("");
				txtpwd.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "�ߺ��� ���̵�. ȸ������ ����");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void backtomain(ActionEvent event) {
		Stage stage2 = new Stage();
		Stage stage1 = (Stage) backbtn.getScene().getWindow();
		try {
			Parent first = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene window = new Scene(first);
			
			stage2.setScene(window);
			stage2.show();
			
			stage1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
