// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//      Exemple d'implémentation d'interface 
// ----------------------------------------------

import java.awt.*;

public class LabelZoomable extends Label implements Zoomable {
  /** Méthode correspondant à l'interface Zoomable : dans le cas du Label,
      on fait en sorte que zoomer ne fasse que modifier la taille
      de la police de caractères du label.
  */
  public void zoomer(float facteur) {
    Font policeInitiale = getFont();
    Font nouvellePolice = policeInitiale.deriveFont(
      facteur*policeInitiale.getSize());
    setFont(nouvellePolice);
  }

  // Ci-dessous 3 constructeurs reprenant ceux de la classe
  // Java.awt.Label, mais obligeant à passer en plus la police
  // de caractères lors de la création de l'objet.
  
  public LabelZoomable(String texte, int alignement, Font police) {
    super(texte, alignement);
    setFont(police);
  }
  public LabelZoomable(String texte, Font police) {
    this(texte, Label.LEFT, police);
  }
  public LabelZoomable(Font police) {
    this("", police);
  }

  /** Retourne les caractéristiques du Label (texte et police). */
  public String toString() {
    return getText() + " {" + getFont() +"}";
  }
  
  /** Petit programme de test */
  public static void main(String[] args) {
    LabelZoomable label = new LabelZoomable("Bla-bla",
                                 new Font("Serif",Font.PLAIN,11));
    System.out.println(label);
    float fact = 2.5f;
    label.zoomer(fact);
    System.out.println("Après un zoom d'un facteur "+fact+" :");
    System.out.println(label);
  }
}