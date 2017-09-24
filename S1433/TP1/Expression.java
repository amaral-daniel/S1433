// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//           Héritage et polymorphisme
//        Classe abtraite et méthode abstraite
// ----------------------------------------------

/** Classe abstraite représentant une expression arithmétique. */
public abstract class Expression {
  /** Méthode abstraite commune à toute expression arithmétique. */
  public abstract double evaluer();
  
  public String toString()
  {
	  return "Expression à ";
  }
}
