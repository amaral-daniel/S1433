
public class Division extends ExpressionADeuxOperandes {

	public Division(Expression gauche,Expression droite)
	{
		super(droite,gauche);
		super.symboleOperation = new String("/").toCharArray();

	}
	public double evaluer()
	{
		if(this.droite.evaluer() != 0)
		{
			return this.gauche.evaluer()/this.droite.evaluer();
		}
		return 0;
	}
	
	public String toString()
	{
		return super.toString() + this.gauche + "/" + this.droite;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
