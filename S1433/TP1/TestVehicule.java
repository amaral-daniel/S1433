import java.util.ArrayList;

public class TestVehicule {


	
	public static void afficherRoues(ArrayList<Vehicule> tableauVehicules)
	{
		Vehicule[] tableauVehiculesArray = new Vehicule[10];
		tableauVehicules.toArray(tableauVehiculesArray);
		for(Vehicule v:tableauVehiculesArray)
		{

			if(v instanceof Velo || v instanceof Voiture)
			{
				System.out.println(v);
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicule> tableauVehicules = new ArrayList<Vehicule>();
		
		tableauVehicules.add( new Voiture("Volks", 1000,3));
		tableauVehicules.add( new Velo("Caloi"));
		tableauVehicules.add( new Scooter("BMW", 1000));

		
		afficherRoues( tableauVehicules );
	} 
}
