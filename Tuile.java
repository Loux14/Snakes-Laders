
public class Tuile {

	private int position;
	private boolean type;
	private int destination;

	Tuile(int pos)
	{
		position = pos;
		type = false;
		destination = 0;
	}

	public int getPosition() {
		return position;
	}

	public void makeSpecialType(int position) {
        type = true;
        this.destination = position;

	}
	
	public boolean isType() {
		return type;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	
	
}
