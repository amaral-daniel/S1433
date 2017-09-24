import java.util.ArrayList;

public class TestVehicule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicule> tableauVehicules = new ArrayList<Vehicule>();
		
		tableauVehicules.add( new Voiture("Volks", 1000,3));
		tableauVehicules.add( new Velo("Caloi"));
		
		Vehicule[] tableauVehiculesArray = new Vehicule[10];
		tableauVehicules.toArray(tableauVehiculesArray);
		
		afficherRoues( tableauVehiculesArray );
	}
	
	public static void afficherRoues(Vehicule[] tableauVehicules)
	{
		
		for(Vehicule v:tableauVehicules)
		{

			if(v instanceof Velo || v instanceof Voiture)
			{
				System.out.println(v);
			}
			
		}
	}

}
