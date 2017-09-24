// ----------------------------------------------
//         Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//         Héritage et polymorphisme
// ----------------------------------------------

public abstract class Vehicule {
  private int nbRoues;
  protected String marque;// protected pr accès direct dans classes filles

  /** Constructeur.
      @param nombreDeRoues le nombre de roues du véhicule.
      @param marque la marque du véhicule.
  */
  public Vehicule(int nombreDeRoues, String marque) {
    nbRoues = nombreDeRoues;
    this.marque = marque;
  }

  /** Accès au nombre de roues. */
  public int getNbRoues() {
    return nbRoues;
  }

  /** Conversion en chaîne de caractères pour affichage. */
  public String toString() {
    return "Vehicule a "+nbRoues+" roues, de marque "+marque;
  }
  
  public String getMarque()
  {
	  return marque;
  }

  /** Affiche ce qu'il faut faire pour avancer. */
  abstract void avancer();
}