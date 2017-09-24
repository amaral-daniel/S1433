// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//         Héritage et polymorphisme
// ----------------------------------------------

public class VehiculeMotorise extends Vehicule {
  protected int puissance; // Ajout d'attribut

  /** Constructeur.
      @param nombreDeRoues le nombre de roues du véhicule.
      @param marque la marque du véhicule.
      @param puissance puissance du moteur (en CV).
  */
  public VehiculeMotorise(int nombreDeRoues, String marque, int puissance) {
    super(nombreDeRoues, marque); // appel du constructeur de la classe mère
    this.puissance = puissance;
  }

  public int getPuissance() { // Ajout de méthode
    return puissance;
  }

  public void avancer() {
    System.out.println("Il suffit de demarrer le moteur puis d'accelerer.");
  }

  public String toString() { // Redéfinition de méthode
    return super.toString()+" avec un moteur de puissance "+puissance+ " CV";
    // NOTE : super.toString() permet d'appeler la méthode de la classe mère
  }

  public static void main(String[] args) {
    Vehicule triporteur = new VehiculeMotorise(3, "Piaggio", 2);
    System.out.println(triporteur);
    triporteur.avancer();
  }
}