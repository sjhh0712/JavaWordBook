package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class wordlistController implements Initializable{
	@FXML TableView<product> tablelist;
	@FXML TableColumn<product, String> wordcol;
	@FXML TableColumn<product, String> meancol;
	@FXML TableColumn<product, String> datecol;
	mariadbconn mdb = new mariadbconn();
	PreparedStatement ps;
	ResultSet rss;

	ObservableList<product> ob = FXCollections.observableArrayList();
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ps = mdb.con.prepareStatement("select * from wordlist");
			
			rss = ps.executeQuery();
			
			while(rss.next()) {
				ob.add(new product(rss.getString("word"), rss.getString("mean"), rss.getString("date")));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		wordcol.setCellValueFactory(new PropertyValueFactory<>("word"));
		meancol.setCellValueFactory(new PropertyValueFactory<>("mean"));
		datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
		
	
		tablelist.setItems(ob);
	}	
}
