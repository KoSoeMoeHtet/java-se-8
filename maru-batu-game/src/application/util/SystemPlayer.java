package application.util;

import javafx.scene.control.Button;

public class SystemPlayer {

	private Button[][] rows;
	private Button[][] columns;
	private Button[][] cross;

	public SystemPlayer(Button[][] chart) {
		this.rows = chart;
		columns = new Button[rows[0].length][rows.length];
		
		for(int i=0; i < rows.length; i++) {
			for(int j=0; j < rows[i].length; j++) {
				columns[i][j] = rows[j][i];
			}
		}
		
		cross = new Button[2][3];
		cross[0][0] = chart[0][0];
		cross[0][1] = chart[1][1];
		cross[0][2] = chart[2][2];
		
		cross[1][0] = chart[2][0];
		cross[1][1] = chart[1][1];
		cross[1][2] = chart[0][2];
		
	}
	
	public Button select() {
		Button selectedBtn = null;
		// to win
		selectedBtn = getBtnToWin();
		
		// to defense
		if(null == selectedBtn) {
			selectedBtn = getBtnToDefense();
		}
		
		// to attack
		if(null == selectedBtn) {
			selectedBtn = getBtnToNextAttack();
		}
		
		return selectedBtn;
	}
	
	private Button getBtnToNextAttack() {
		for(Button[] btns : rows) {
			for(Button b : btns) {
				if(null == b.getText() || b.getText().isEmpty()) {
					return b;
				}
			}
		}
		return null;
	}

	private Button getBtnToDefense() {
		return getFreeButton(Marker.USER);
	}

	private Button getBtnToWin() {
		return getFreeButton(Marker.SYSTEM);
	}
	
	private Button getFreeButton(Marker mark) {
		for(Button[] btns : rows) {
			Button b = getFreeButton(btns, mark);
			if(null != b)
				return b;
		}
		
		for(Button[] btns : columns) {
			Button b = getFreeButton(btns, mark);
			if(null != b)
				return b;
		}
		
		for(Button[] btns : cross) {
			Button b = getFreeButton(btns, mark);
			if(null != b)
				return b;
		}

		return null;
	}

	private Button getFreeButton(Button [] btns, Marker mark) {
		Button free = null;
		int count = 0;
		
		for(Button b : btns) {
			if(mark.getResult().equals(b.getText())) {
				count ++;
			}
			
			if(null == b.getText() || b.getText().isEmpty()) {
				free = b;
			}
		}
		
		if(count == 2)
			return free;
		
		return null;
	}
}
