package brs;

import java.awt.*;
import java.util.*;

public class CommandablePoint extends Point{
	
	private static final long serialVersionUID = 1L;

	ArrayList<Command> history;

	public CommandablePoint() {
		super();
		history = new ArrayList<Command>();
	}

	public String[] handleInput(String inpit) {
		Command command;
		switch (inpit) {
		case "W":
		case "w":
		case "forward":
		case "up":
			command = new MoveUp(this);
			command.execute();
			history.add(command);
			return (formOutput());
		case "S":
		case "s":
		case "back":
		case "down":
			command = new MoveDown(this);
			command.execute();
			history.add(command);
			return (formOutput());
		case "A":
		case "a":
		case "left":
			command = new MoveLeft(this);
			command.execute();
			history.add(command);
			return (formOutput());
		case "D":
		case "d":
		case "right":
			command = new MoveRight(this);
			command.execute();
			history.add(command);
			return (formOutput());
		case "H":
		case "h":
		case "history":
			return (formHistory());
		case "Z":
		case "z":
		case "revert":
			if (history.size() > 0) {
				Command lastCommand = history.get(history.size() - 1);
				lastCommand.undo();
				String removedInfo = lastCommand.info();
				history.remove(history.size() - 1);
				return new String[] { "reverted action: " + removedInfo };
			} else
				return new String[] { "no history" };
		default:
			return new String[] { "INVALID COMMAND" };
		}

	}

	public String[] formOutput() {
		if (history.size() > 0) {
			String[] output = new String[2];
			output[0] = "Current point coords: " + this.getX() + "; " + this.getY();
			output[1] = "Last action: " + history.get(history.size() - 1).info();
			return output;
		} else
			return new String[] { "no history" };
	}

	public String[] formHistory() {
		if (history.size() > 0) {
			String[] output = new String[history.size()];
			for (Command c : history) {
				output[history.indexOf(c)] = c.info();
			}
			return output;
		} else
			return new String[] { "no history" };
	}
}
