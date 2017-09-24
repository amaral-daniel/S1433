// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//      Exemple d'interface 
// ----------------------------------------------

public interface Zoomable {
  /** Grossissement ou réduction de l'objet (selon la valeur du facteur
      de zoom).
      @param facteur le facteur de zoom (>1 pour un grossissement ou <1
      pour une réduction).
  */
  public void zoomer(float facteur);
}