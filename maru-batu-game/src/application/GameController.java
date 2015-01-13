package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
	
	private Button [][] chart;
	
	private GameOwner owner;
	private SystemPlayer system;
	
	public void clear() {
		lock(false);
		for (Node n : grid.getChildren()) {
			Button b = (Button) n;
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
		
		for (Node n : grid.getChildren()) {
			Button b = (Button) n;
			b.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Button b = (Button) event.getSource();
					// user select
					b.setText(Marker.USER.getResult());

					// system select
					system.select().setText(Marker.SYSTEM.getResult());

					// evaluate and set result
					evluate();
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

	private void evluate() {
		Result result = owner.check();
		
		if(result.equals(Result.SYSTEM_WIN)) {
			plus(systemResult);
			message.setText("System Win! If you want to continue, press clear!");
			lock(true);
		} else if (result.equals(Result.USER_WIN)) {
			plus(userResult);
			message.setText("You win! If you want to continue, press clear!");
			lock(true);
		} else if (result.equals(Result.DRAW)) {
			message.setText("Draw! If you want to continue, press clear!");
			lock(true);
		} else {
			message.setText("Try your best! Come On!");
		}
	}
	
	private void lock(boolean lockMode) {
		for(Node n : grid.getChildren()) {
			Button b = (Button) n;
			b.setDisable(lockMode);
		}
	}

	private void plus(Label lbl) {
		int original = Integer.parseInt(lbl.getText());
		lbl.setText(String.valueOf(original + 1));
	}

	@Override
	public int getButtonCount() {
		int count = 0;
		for(Node n : grid.getChildren()) {
			Button b = (Button) n;
			if(b.getText().isEmpty()) {
				count ++;
			}
		}
		return count;
	}
	
	
}
