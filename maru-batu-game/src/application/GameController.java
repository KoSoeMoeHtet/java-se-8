package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import application.util.ButtonCountGetter;
import application.util.GameOwner;
import application.util.GameOwner.Result;
import application.util.Marker;
import application.util.SystemPlayer;

public class GameController implements Initializable, ButtonCountGetter{
	
	@FXML
	private Label message;
	@FXML
	private Label systemResult;
	@FXML
	private Label userResult;
	
	@FXML
	private GridPane grid;
	
	private Button [] btns;
	private Button [][] chart;
	
	private GameOwner owner;
	private SystemPlayer system;
	
	public void clear() {
		btns = new Button[grid.getChildren().size()];
		for (int i = 0; i < btns.length; i++) {
			Button b = (Button) grid.getChildren().get(i);
			btns[i] = b;
			b.setText("");
		}
	}
	
	public void reset() {
		this.clear();
		systemResult.setText("0");
		userResult.setText("0");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chart = new Button[3][3];
		
		btns = new Button[grid.getChildren().size()];
		for (int i = 0; i < btns.length; i++) {
			Button b = (Button) grid.getChildren().get(i);
			btns[i] = b;
			b.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Button b = (Button) event.getSource();
					clickButton(b);
				}
			});
			
			chart[getRow(b)][getColumn(b)] = b;
		}
		
		owner = new GameOwner(chart, this);
		system = new SystemPlayer(chart);
	}

	private int getColumn(Button b) {
		return Integer.parseInt(b.getId())%3;
	}

	private int getRow(Button b) {
		return Integer.parseInt(b.getId())/3;
	}

	protected void clickButton(Button b) {
		b.setText(Marker.USER.getResult());
		
		// remove selected button from button array
		removeFromButtons(b);
		
		// remove system selected button from button array
		Button sysBtn = system.select();
		if(null != sysBtn) 
			sysBtn.setText(Marker.SYSTEM.getResult());
		
		removeFromButtons(sysBtn);
		
		// evaluate and set result
		this.evluate();
	}

	private void evluate() {
		Result result = owner.check();
		
		if(result.equals(Result.SYSTEM_WIN)) {
			plus(systemResult);
			message.setText("System Win! If you want to continue, press clear!");
		} else if (result.equals(Result.USER_WIN)) {
			plus(userResult);
			message.setText("You win! If you want to continue, press clear!");
		} else if (result.equals(Result.DRAW)) {
			message.setText("Draw! If you want to continue, press clear!");
		} else {
			message.setText("Try your best! Come On!");
		}
		
	}

	private void plus(Label lbl) {
		int original = Integer.parseInt(lbl.getText());
		lbl.setText(String.valueOf(original + 1));
	}

	private void removeFromButtons(Button b) {
		if(btns.length > 1) {
			Button [] tempArray = new Button[btns.length -1];
			int j = 0;
			for (int i = 0; i < btns.length; i++) {
				if(!b.getId().equals(btns[i].getId())) {
					tempArray[j] = btns[i];
					j++;
				}
			}
			btns = tempArray;
		}
	}

	@Override
	public int getButtonCount() {
		return btns.length;
	}
	
	
}
