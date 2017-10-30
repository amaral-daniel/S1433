import java.awt.Font;

public class CoupleGeneriqueDeformable extends CoupleGenerique implements Zoomable{
	
	
	public CoupleGeneriqueDeformable(Zoomable premier, Zoomable deuxieme) 
	{
		super(premier,deuxieme);		
    }
	
	public void zoomer(float f)
	{
		((Zoomable)o1).zoomer(f);
		((Zoomable)o2).zoomer(f);
	}
	
	public String toString()
	{
		return o1.toString() + o2.toString();
		
	}
	public static void main(String[] args)
	{
		RectangleDeformable rectangle= new RectangleDeformable(10,10);
		LabelZoomable label = new LabelZoomable("Bla-bla",
                new Font("Serif",Font.PLAIN,10));
		 
		CoupleGeneriqueDeformable c = new CoupleGeneriqueDeformable(rectangle,label);
		c.zoomer(1.2f);
		System.out.println(c);
	}
}
