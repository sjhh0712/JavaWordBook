package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class searchEng extends JFrame {
	public void webview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		final JFXPanel wtweb = new JFXPanel();
		add(wtweb);
		
		Platform.runLater(new Runnable() {
			
			public void run() {
				
				initWebView(wtweb);
				
			}
			
		});
		setVisible(true);
		
	}
	
	public static void initWebView(final JFXPanel wtweb) {
		Group group = new Group();
		Scene scene = new Scene(group);
		wtweb.setScene(scene);
		
		WebView webview = new WebView();
		
		group.getChildren().add(webview);
		webview.setMinSize(500, 500);
		webview.setMaxSize(500, 500);
		
		WebEngine webEngine = webview.getEngine();
		
		webEngine.load("https://en.dict.naver.com/#/main");
	}
}
