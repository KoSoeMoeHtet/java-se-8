package application.util;

import javafx.scene.control.Button;

public class GameOwner {
	
	private Button[][] rows;
	private Button[][] columns;
	private ButtonCountGetter countGetter;
	
	public GameOwner(Button [][] chart, ButtonCountGetter countGetter) {
		this.rows = chart;
		columns = new Button[rows[0].length][rows.length];
		
		for(int i=0; i < rows.length; i++) {
			for(int j=0; j < rows[i].length; j++) {
				columns[i][j] = rows[j][i];
			}
		}
		
		this.countGetter = countGetter;
		
	}
	
	public enum Result {
		SYSTEM_WIN, USER_WIN, DRAW, ON_PLAYING;
	}
	
	public Result check() {
		
		if(isUserWin()) {
			return Result.USER_WIN;
		}
		
		if(isSystemWin()) {
			return Result.SYSTEM_WIN;
		}
		
		if(isOnPlaying()) {
			return Result.ON_PLAYING;
		}
		
		return Result.DRAW;
	}

	private boolean isSystemWin() {
		if(checkColumns(Marker.SYSTEM) 
				|| checkRows(Marker.SYSTEM) 
				|| leftCrossCheck(Marker.SYSTEM) 
				|| rightCrossCheck(Marker.SYSTEM)) {
			return true;
		}
		return false;
	}

	private boolean isUserWin() {
		if(checkColumns(Marker.USER) 
				|| checkRows(Marker.USER) 
				|| leftCrossCheck(Marker.USER) 
				|| rightCrossCheck(Marker.USER)) {
			return true;
		}
		return false;
	}

	private boolean isOnPlaying() {
		return countGetter.getButtonCount() > 1;
	}

	private boolean checkRows(Marker mark) {
		for(Button[] row : rows) {
			int index = 0;
			for(Button b : row) {
				if(mark.getResult().equals(b.getText())) {
					index ++;
				}
			}
			
			if(index == 3)
				return true;
		}
		return false;
	}

	private boolean checkColumns(Marker mark) {
		for(Button[] column : columns) {
			int index = 0;
			for(Button b : column) {
				if(mark.getResult().equals(b.getText())) {
					index ++;
				}
			}
			
			if(index == 3)
				return true;
		}
		return false;
	}

	private boolean leftCrossCheck(Marker mark) {
		int index = 0;
		for(int i=0; i < rows.length; i++) {
			if(rows[i][i].getText().equals(mark.getResult())) {
				index ++;
			}
		}
		
		if(index == 3) 
			return true;
		
		return false;
	}

	private boolean rightCrossCheck(Marker mark) {
		int index = 0;
		for(int i=0; i < rows.length; i++) {
			if(rows[i][2-i].getText().equals(mark.getResult())) {
				index ++;
			}
		}
		
		if(index == 3) 
			return true;

		return false;
	}


}
