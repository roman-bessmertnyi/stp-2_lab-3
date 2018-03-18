package brs;

import java.awt.Point;

public class MoveRight implements Command {


	Point mainPoint;
	
	public MoveRight(Point mainPoint) {
		super();
		this.mainPoint = mainPoint;
	}

	@Override
	public void execute() {
		mainPoint.translate(1, 0);
	}
	
	@Override
	public void undo() {
		mainPoint.translate(-1, 0);
	}
	
	@Override
	public String info() {
		return "Moved the point right by 1";
	}
}
