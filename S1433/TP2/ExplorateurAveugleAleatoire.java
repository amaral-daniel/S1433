import fr.ensmp.karel.robots.*;; 
public class ExplorateurAveugleAleatoire extends RobotAveugleAleatoire implements ExplorateurAbstrait{
	ExplorateurAveugleAleatoire(Ville v)
	{
		super(v);
	}
	public void choisirDirection()
	{
		super.rotationAleatoire();
		while(!super.peutAvancer())
			super.rotationAleatoire();
	}
	

}
