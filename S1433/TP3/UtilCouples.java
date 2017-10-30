import java.util.ArrayList;
import java.util.List;

public class UtilCouples<X,Y> {
	UtilCouples()
	{
		
	}
	public void setAllPrem(List<CoupleGenerique> l,X prem)
	{
		for(CoupleGenerique c:l)
		{
			c.setPremier(prem);
		}
	}
	
	public double sumOfSeconds(List<CoupleGenerique> l)
	{
		double result = 0;
		for(CoupleGenerique c:l)
		{
			if(c.deuxieme() instanceof Number   )
			{
				result = result + ((Number)c.deuxieme()).doubleValue();
			}
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		  CoupleGenerique<Integer, Integer> c1 = 
				  new CoupleGenerique<Integer,Integer>(2,2);
			      System.out.println(c1);
	      CoupleGenerique<Double, Double> c2 = 
     	    		  new CoupleGenerique<Double,Double>(3.0,2.0);
		    	      System.out.println(c2);	
		  CoupleGenerique<Float, Float> c3 = 
     	    		  new CoupleGenerique<Float,Float>(-1.0f,6.0f);
		          System.out.println(c3);
		  List<CoupleGenerique> l = new ArrayList<CoupleGenerique>();       
		  l.add(c1);
		  l.add(c2);
		  l.add(c3);
		  UtilCouples<Number,Number> util= new UtilCouples<Number,Number>();
		  System.out.println("resultat sumOfSeconds : " + util.sumOfSeconds(l));
		  
		  Number a = 2;
		  util.setAllPrem(l, a);
		  System.out.println(c1);
		  System.out.println(c2);
		  System.out.println(c3);
		  
		
		
	}
}

