
public class Scooter extends VehiculeMotorise {
	Scooter(String marque, int puissance)
	{
		super(2,marque,puissance);
	}
	
	public String toString()
	{
		return super.toString() + "de type Scooter";
	}
	
	public void avancer()
	{
		System.out.println("il faut accelerer");
	}

}
