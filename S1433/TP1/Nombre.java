// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//           Héritage et polymorphisme
// ----------------------------------------------

/** Classe représentant les expressions de type "Nombre". */
public class Nombre extends Expression {
  /** Attribut pour stocker la valeur. */
  private double valeur;
  /** Constructeur pour créer une expression de type "Nombre". */
  public Nombre(double val) {
    valeur = val;
  }
  /** Redéfinition de evaluer(), triviale pour un nombre. */
  public double evaluer() {
    return valeur;
  }
  
  public String toString()
  {
	  return super.toString( ) + "valeur" + valeur;
  }
}