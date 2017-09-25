// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//         Héritage et polymorphisme
// ----------------------------------------------

public class Velo extends Vehicule {
  /** Constructeur.
      @param marque la marque du vélo.
  */
  public Velo(String marque) {
    // NOTE : Pas de paramètre nombreDeRoues, car un vélo en a toujours 2 !
    super(2, marque); // appel du constructeur de la classe mère
  }

  /** Retourne une chaîne indiquant que c'est un vélo et donnant sa
      marque.
  */
  public String toString() { // Redéfinition de méthode
    return "Velo de marque " + marque + " a " + this.getNbRoues() + " roues";
  }

  public void avancer() { // Redéfinition de méthode
    System.out.println("Il faut pedaler !!");
  }

  /** Mini-programme de test. */
  public static void main(String[] args) {
    Velo monVTT = new Velo("MBK");
    System.out.println(monVTT);
    // Appel d'une méthode héritée
    System.out.println("Il a "+monVTT.getNbRoues()+" roues");
    // Appel d'une méthode redéfinie
    monVTT.avancer();
  }
}
