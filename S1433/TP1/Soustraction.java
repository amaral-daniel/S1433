
public class Soustraction extends ExpressionADeuxOperandes {

	public Soustraction(Expression gauche,Expression droite)
	{
		super(droite,gauche);
		super.symboleOperation = new String("-").toCharArray();

	}
	public double evaluer()
	{
		return this.gauche.evaluer()-this.droite.evaluer();
	}
	
	public String toString()
	{
		return super.toString() + this.gauche + "-" + this.droite;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
