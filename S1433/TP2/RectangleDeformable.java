import fr.ensmp.info2.geometrie.*;
public class RectangleDeformable extends Rectangle implements Deformable{
	
	RectangleDeformable(String nom,Point centre,  float width, float height)
	{
		super(nom,centre,width,height);
		
	}
	RectangleDeformable(Point centre,  float width, float height)
	{
		super(centre,width,height);
		
	}
	RectangleDeformable(float width, float height)
	{
		super(width,height);
		
	}
	
	public void elargir(float facteur)
	{
		super.width *= facteur;
	}
	
	public void aplatir(float facteur)
	{
		super.height /= facteur;
	}
	
	public void zoomer(float facteur)
	{
		super.height *= facteur;
		super.width *= facteur;
	}

}
