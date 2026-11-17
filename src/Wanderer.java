package VierWanderer;

public class Wanderer {

	private char name;
	private int minuten;

	public Wanderer(char name, int minuten) {

		this.name = name;
		this.minuten = minuten;
	}

	public char getName() {
		return name;
	}

	public int getMinuten() {
		return minuten;
	}

	public String toStrin() {
		return "" + name + "(" + minuten + ")";
	}

}
