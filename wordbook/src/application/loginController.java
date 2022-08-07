package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController implements Initializable {
	@FXML private Button sinbtn, supbtn, backbtn, supbtn2;
	@FXML private TextField logid, logpwd;
	PreparedStatement ps;
	public static mariadbconn mdb;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mdb = new mariadbconn();
	}
	
	public void signinpage() {
		String lid = logid.getText();
		String lpwd = logpwd.getText();
		String uid = null;
		String upwd = null;
		try {
			ps = mdb.con.prepareStatement("select id,password from user where id = ?");
			ps.setString(1, lid);
			
			mdb.rs = ps.executeQuery();
			
			
			while(mdb.rs.next()) {
				uid = mdb.rs.getString("id");
				upwd = mdb.rs.getString("password");
				break;
			}
			
			if(lid.equals(uid)) { // ������Ʈ�� ��� �޼ҵ�� lid�� uid�� ���Ѵ�.uid�� null�̸� ��ü�� �ƴϹǷ� equals�޼ҵ带 ����Ҽ�����.
				if(lpwd.equals(upwd)) {
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
					Stage stage4 = new Stage();
					Stage stage3 = (Stage)sinbtn.getScene().getWindow();
				
					
					try{
						Parent third = FXMLLoader.load(getClass().getResource("home.fxml")); 
						Scene sc = new Scene(third);
						
						stage4.setScene(sc);
						stage4.show();
						
						stage3.close();
						
						
						
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "�α��� ������ ��ġ���� �ʽ��ϴ�");
				return;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pageswap() {
		Stage stage2 = new Stage();
		Stage stage1 = (Stage)supbtn.getScene().getWindow();
	
		
		try{
			Parent second = FXMLLoader.load(getClass().getResource("signup.fxml")); 
			Scene sc = new Scene(second);
			
			stage2.setScene(sc);
			stage2.show();
			
			stage1.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
