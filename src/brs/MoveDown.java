package brs;

import java.awt.Point;

public class MoveDown implements Command {
	Point mainPoint;
	
	public MoveDown(Point mainPoint) {
		super();
		this.mainPoint = mainPoint;
	}

	@Override
	public void execute() {
		mainPoint.translate(0, -1);
	}
	
	@Override
	public void undo() {
		mainPoint.translate(0, 1);
	}

	@Override
	public String info() {
		return "Moved the point down by 1";
	}
}
