package brs;

public interface Command {
	public void execute();
	public void undo();
	public String info();
}
