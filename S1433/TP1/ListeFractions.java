// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//         Héritage et polymorphisme
// Redéfinition de méthodes héritées de classe racine
// ----------------------------------------------

import java.util.*; // pour List, etc...

public class ListeFractions {

  public static void main(String[] args) {
    List<Fraction> liste = new ArrayList<Fraction>();
    Fraction f1 = new Fraction(1,2);    
    Fraction f2 = new Fraction(1,3);
    Fraction f3 = new Fraction(1,4);
    liste.add(f1);    
    liste.add(f2);
    liste.add(f3);
     
    System.out.println("Liste : "+liste);

    Fraction unTiers = new Fraction(1,3);
    boolean inclus = liste.contains(unTiers);
    if (inclus)
      System.out.println("Cette liste contient la fraction "+unTiers);
    else
      System.out.println("Cette liste ne contient PAS la fraction "+unTiers);
   
    Set<Fraction> set = new HashSet<Fraction>();
    set.add(f1);
    set.add(f2);
    set.add(f3);
    set.add(new Fraction (1,3));
    System.out.println("\nCONTENU D'UN HashSet apres ajout de 1/2 1/3 1/4 et 1/3 :");
    System.out.println(set);
  }
}