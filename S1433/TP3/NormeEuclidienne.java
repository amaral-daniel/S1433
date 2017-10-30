
public class NormeEuclidienne implements Evaluateur<Double[]> {

	static private NormeEuclidienne instanceNormeEuclidienne;
	private NormeEuclidienne()
	{
		
	}
	
	static public NormeEuclidienne getInstance()
	{
		if(instanceNormeEuclidienne == null)
		{
			instanceNormeEuclidienne = new NormeEuclidienne();
		}
		return instanceNormeEuclidienne;
	}
		public double evaluer(Double[] t)
		{
			double result = 0;
			for(int i = 0 ; i < t.length ; i++)
			{
				result += t[i]*t[i];
			}
			result = java.lang.Math.sqrt(result);
			return result;
		}
		
		public static void main(String[] args)
		{
			
			NormeEuclidienne n = NormeEuclidienne.getInstance();
			Double[] a = {(Double) 1.0,1.0,1.0,1.0,1.0,1.0,1.0};
			System.out.println(n.evaluer(a)); //ca ne marche pas
		}
}
