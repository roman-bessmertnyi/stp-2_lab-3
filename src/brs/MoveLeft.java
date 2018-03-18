package brs;

import java.awt.Point;

public class MoveLeft implements Command {

Point mainPoint;
	
	public MoveLeft(Point mainPoint) {
		super();
		this.mainPoint = mainPoint;
	}

	@Override
	public void execute() {
		mainPoint.translate(-1, 0);
	}
	
	@Override
	public void undo() {
		mainPoint.translate(1, 0);
	}
	
	@Override
	public String info() {
		return "Moved the point left by 1";
	}

}
