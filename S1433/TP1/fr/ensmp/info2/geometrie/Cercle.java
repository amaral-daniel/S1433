package fr.ensmp.info2.geometrie;

public class Cercle extends Figure{
	private float radius;
	
	public Cercle(String nom,Point centre,  float radius)
	{
		super(nom,centre);
		this.radius = radius;
		
	}

	public Cercle(Point centre,float radius)
	{
		super(centre);
		this.radius = radius;
		
	}
	
	public float surface()
	{
		return (float)3.14*radius*radius;
	}
	

	
	public boolean contient(Point p)
	{
		if(    ((centre.getX() - p.getX())^2   + (centre.getY() - p.getY())^2)     > radius)
		{
			return false;
		}
		return true;
		
	}
	
	public String toString()
	{
		return "rectangle " + nom + centre + radius;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
