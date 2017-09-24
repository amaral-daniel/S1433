import java.lang.Math;

public class UtileSuite {
		private class N implements Suite{
			N()
			{
				
			}
			public double valeur(int i)
			{
				return i;
			}
		}
		
		private class NCarre implements Suite{
			public double valeur(int i)
			{
				return i*i;
			}
		}
		private class UnTiersPuissanceN implements Suite{
			public double valeur(int i)
			{
				System.out.println(Math.pow((double)1/3,(double)i));
				return Math.pow((double)1/3,(double)i);//Math.pow doesnt accept ints
			}
		}
	
	
		double somation(Suite object,int debut, int fin)
		{
			double resultat = 0;
			for(int i = debut; i <=fin ; i++)
			{
				resultat+=object.valeur(i);
			}
			return resultat;
		}
		public static void main(String[] args) {
			UtileSuite x = new UtileSuite();
			Suite a1 = x.new N();
			System.out.println(x.somation(a1,1,10));
			Suite a2 = x.new NCarre();
			System.out.println(x.somation(a2,3,5));
			Suite a3 = x.new UnTiersPuissanceN();
			System.out.println(x.somation(a3,1,2));

		}
}

