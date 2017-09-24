
public abstract class ExpressionADeuxOperandes extends Expression{
	protected Expression droite,gauche;
	protected char[] symboleOperation;
	
	
	public ExpressionADeuxOperandes(Expression droite, Expression gauche)
	{
		this.droite = droite;
		this.gauche = gauche;
		this.symboleOperation = new String("?????").toCharArray();
	}
	
	public String toString()
	{
		return super.toString() + " 2 operandes : ";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
