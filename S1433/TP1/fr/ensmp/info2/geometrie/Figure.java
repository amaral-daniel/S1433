package fr.ensmp.info2.geometrie;

public abstract class Figure {
	protected Point centre;
	protected String nom;
	private static int counter;
	
	public Figure(String nom, Point centre)
	{
		this.centre = centre;
		this.nom = nom;
		counter++;
	}
	public Figure(Point centre)
	{
		this("Figure" + counter,centre);
		
	}
	public String getNom()
	{
		return this.nom;
	}
	
	public void deplacer(int dx,int dy)
	{
		centre.deplacer(dx, dy);
	}
	
	public String toString()
	{
		return nom + centre;
	}
	
	public abstract float surface();
	
	public abstract boolean contient(Point p);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
