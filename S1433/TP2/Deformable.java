// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//   Exemple d'interface + héritage entre interfaces
// ----------------------------------------------

public interface Deformable extends Zoomable {
  // "extends Zoomable" implique que Deformable contient
  //   aussi, par héritage, la méthode zoomer(float facteur)  
 
  /** Modification de la hauteur de l'objet.
      @param facteur le facteur d'aplatissement
      (>1 pour aplatir, ou <1 pour augmenter la hauteur).
  */
  public void aplatir(float facteur);
  
  /** Modification de la largeur de l'objet.
      @param facteur le facteur d'élargissement (>1 pour élargir, ou <1
      pour diminuer la largeur).
  */
  public void elargir(float facteur);
}