import fr.ensmp.info2.annuaire.Personne;

public class CoupleHomogeneGenerique<T> extends CoupleGenerique<T,T>{
	T X,Y;
	
	CoupleHomogeneGenerique(T x,T y)
	{
	
		super(x, y);
	}
	void permuter()
	{
		T aux;
		aux = super.deuxieme();
		super.setDeuxieme(super.premier());
		super.setPremier(aux);
	}
	
	public static void main(String args[])
	{
	      CoupleHomogeneGenerique<String> c1 = 
	    		  new CoupleHomogeneGenerique<String>("titi","rominet");
	    	      System.out.println("c1 : "+c1);

	    	      CoupleHomogeneGenerique<Personne> c2 = 
	    		  new CoupleHomogeneGenerique<Personne>(new Personne("David", 2355),
	    							new Personne("Daniel", 23545));
	    	      System.out.println("c2 : " + c2);
	
	    	      
	    	      c1.permuter();
	    	      System.out.println("c1 apres permuter" + c1);
	    	      c2.permuter();
	    	      System.out.println("c2 apres permuter" + c2);
	    	      
	    	      
	}
}
