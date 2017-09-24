package fr.ensmp.info2.geometrie;

public class Rectangle extends Figure{
	float width,height;
	
	public Rectangle(String nom,Point centre,  float width, float height)
	{
		super(nom,centre);
		this.height = height;
		this.width = width;
		
	}
	
	public Rectangle(Point centre, float width, float height)
	{
		super(centre);
		this.width = width;
		this.height = height;
	}
	
	public float surface()
	{
		return width*height; 
	}
	
	public boolean contient(Point p)
	{
		if((p.getX( ) >= centre.getX() - width/2)        &&  
				p.getX( ) <= centre.getX() + width/2     &&
				p.getY( ) >= centre.getY() - height/2    && 
				p.getY( ) >= centre.getY() + height/2       )
		{
			return true;
		}
		return false;
		
	}
	
	public String toString()
	{
		return "cercle " + nom + centre + width + " " + height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
