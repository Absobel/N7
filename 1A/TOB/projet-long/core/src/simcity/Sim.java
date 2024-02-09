package simcity;
/*Un sim est un habitant de simcity
 * il a  un batiment ou il habite et un numero de bonheur qui indique sa satisfaction
 */
public class Sim {

	private BatRessources building;
	protected int happiness; 
	
	public Sim(BatRessources buil) {
		this.building = buil;
		this.happiness = 100;
	}
	
	public void updateHapiness(boolean est_satisfait) {
		if(est_satisfait) {
			if(this.happiness<100) {
				this.happiness = this.happiness + 1;
			}
		} else {
			if(0<this.happiness) {
				this.happiness = this.happiness - 1;
			}
		}
	}
  
}
