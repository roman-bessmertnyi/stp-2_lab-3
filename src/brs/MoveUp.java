package brs;

import java.awt.*;

public class MoveUp implements Command {

	Point mainPoint;
	
	public MoveUp(Point mainPoint) {
		super();
		this.mainPoint = mainPoint;
	}

	@Override
	public void execute() {
		mainPoint.translate(0, 1);
	}
	
	@Override
	public void undo() {
		mainPoint.translate(0, -1);
	}
	
	@Override
	public String info() {
		return "Moved the point up by 1";
	}
}
