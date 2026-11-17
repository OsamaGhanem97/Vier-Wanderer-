package VierWanderer;

public class Ufer {

	private Wanderer[] dieWanderer = new Wanderer[4];
	private int anzWanderer = 0;

	public Ufer(Wanderer[] wanderer) {
		if (wanderer != null) {
			for (int i = 0; i < wanderer.length; i++) {
				dieWanderer[i] = wanderer[i];
			}
			anzWanderer = wanderer.length;
		}
	}

	public Wanderer getWanderer(char name) {
		for (int i = 0; i < anzWanderer; i++) {
			if (name == dieWanderer[i].getName()) {
				return dieWanderer[i];
			}
		}
		return null;
	}
	public Wanderer removeWanderer(Wanderer w) {
		Wanderer opfer=null;
		for(int i=0;i<anzWanderer;i++) {
			if(dieWanderer[i]==w) {
				opfer=dieWanderer[i];
				dieWanderer[i]=dieWanderer[anzWanderer-1];
				anzWanderer--;
			}
			
		}
		return opfer;
	}
	public void addWanderer(Wanderer w) {
		dieWanderer[anzWanderer++]=w;
	}
	public String toString() {
		String erg="";
		for(int i=0;i<anzWanderer;i++) {
			erg+=dieWanderer[i].toStrin()+" ";
		}
		return erg;
	}

	public Wanderer[] getDieWanderer() {
		return dieWanderer;
	}

	public int getAnzWanderer() {
		return anzWanderer;
	}
	public int ueberquere(Ufer zielufer,Wanderer w1,Wanderer w2) {
		int minute=0;
		if(w1!=null) {
			this.removeWanderer(w1);
			zielufer.addWanderer(w1);
			minute=w1.getMinuten();
			if(w2!=null) {
				this.removeWanderer(w2);
				zielufer.addWanderer(w2);
				if(minute<w2.getMinuten()) {
					minute=w2.getMinuten();
				}
			}
		}
		return minute;
	}
	
}
