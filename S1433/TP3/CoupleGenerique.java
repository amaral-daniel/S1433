// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//   Exemple de classe de type "generics"
// ----------------------------------------------

import java.util.*; // pour List, ...

import fr.ensmp.info2.annuaire.Personne; // Utile uniquement pour les tests
//                                           du main()

/**
 *  Classe permettant de stocker un couple (x,y) quelconque.
 *   Les paramètres de type X et Y correspondent respectivement 
 *     aux types du premier et du deuxième élément du couple.
 */
public class CoupleGenerique<X,Y> {
    /** Premier élément du couple */
    private X o1;
    /** Deuxième élément du couple */    
    private Y o2;
    
    /** Constructeur. */
    public CoupleGenerique(X premier, Y deuxieme) {
	o1 = premier;
	o2 = deuxieme;
    }
    
    /** Représentation sous forme de chaîne de caractères. */
    public String toString() {
	return "(" + o1 + " ; " + o2 + ")";
    }
    
    /** Accès au premier élément. */
    public X premier() {
	return o1;
    }
    
    /** Accès au deuxième élément. */
    public Y deuxieme() {
	return o2;
    }
    
    /** Modification du premier élément. */
    public void setPremier(X premier) {
	o1 = premier;
    }
    
    /** Modification du deuxième élément. */
    public void setDeuxieme(Y deuxieme) {
	o2 = deuxieme;
    }



  public static void main(String[] args) {
      CoupleGenerique<String, String> c1 = 
	  new CoupleGenerique<String,String>("titi","rominet");
      System.out.println(c1);
      c1.setDeuxieme("sylvestre");
      System.out.println("Après setDeuxieme(\"sylvestre\") : "+c1);

      CoupleGenerique<Personne, String> c2 = 
	  new CoupleGenerique<Personne, String>(new Personne("David", 2355),
						"bureau L.111");
      System.out.println(c2);
      Personne p = c2.premier();
      System.out.println("Téléphone du premier = "+p.getTel());
      
      CoupleGenerique<?,?> cg;
      cg = c1;
      Object prem1 = cg.premier();
      cg = c2;
      cg.deuxieme();

  }      
}