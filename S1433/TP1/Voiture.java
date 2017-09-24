
public class Voiture extends VehiculeMotorise {
		private int portes;
		Voiture(String marque, int puissance, int portes)
		{
			super(4,marque,puissance);
			this.puissance = puissance;
			this.portes = portes;
		}
		
		public String toString()
		{
			return super.toString() + " avec " + portes + " portes";
		}
		
		public void avancer()
		{
			System.out.println("Il faut accelerer.");
		}
		
		public int getPortes()
		{
			return portes;
		}
		

		public static void main(String[] args)
		{
			
			Voiture monVoiture = new Voiture("Chevrolet", 4000, 4);
			System.out.println(monVoiture);
			monVoiture.avancer();
			
		}


}
