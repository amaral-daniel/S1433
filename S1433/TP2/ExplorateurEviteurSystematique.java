
import fr.ensmp.karel.robots.*;
public class ExplorateurEviteurSystematique implements ExplorateurAbstrait{
	private RobotEviteurSystematique myRobot;
	ExplorateurEviteurSystematique(Ville v)
	{
		myRobot = new RobotEviteurSystematique(v);
	}
	public void choisirDirection()
	{
		
		myRobot.tournerSiFaceMur();
		while(!myRobot.peutAvancer())
			myRobot.tournerSiFaceMur();
	}
	
	public void avancer()
	{
		myRobot.avancer();
	}
	

}
