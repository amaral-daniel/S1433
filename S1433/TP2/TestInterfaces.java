// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//      Utilisation d'interfaces
// ----------------------------------------------

import java.awt.Font;
import fr.ensmp.info2.geometrie.*;

public class TestInterfaces {
  /** Fonction affichant tous les objets d'un tableau.
        La fonction suppose que ces objets sont des instances
        de classes ayant redéfini toString() correctement.
  */
  public static void afficher(Object[] tab) {
    for (int i=0; i<tab.length; i++)   
      System.out.println(tab[i]);
  }

  /** Fonction appliquant le même facteur de zoom à un tableau d'objets
      implémentant tous Zoomable.
  */
  public static void zoomer(Zoomable[] tab, float facteur) {
    for (int i=0; i<tab.length; i++)
      tab[i].zoomer(facteur);
  }

  /** Fonction appliquant le même facteur de zoom à tous les objets
      zoomables d'un tableau d'objets.
  */
  public static void zoomer(Object[] tab, float facteur) {
    for (int i=0; i<tab.length; i++)
      if ((tab[i] instanceof Zoomable))
        ((Zoomable)tab[i]).zoomer(facteur);
  }
  
  public static void ecraser(RectangleDeformable r, float facteur)
  {
	  r.elargir(facteur);
	  r.aplatir(facteur);
	  
	  
  }
  public static void main(String[] args) {
    LabelZoomable label1 = new LabelZoomable("Bla-bla",
                                          new Font("Serif",Font.PLAIN,11));
    LabelZoomable label2 = new LabelZoomable("Bla-bla 2",
                                          new Font("Monospaced",Font.PLAIN,9));
    RectangleDeformable rec1 = new RectangleDeformable(1.0f,1.0f);
    Zoomable [] tabZ = {label1, label2, rec1};
    afficher(tabZ);
    zoomer(tabZ,2.5f);
    System.out.println("\nAprès zoom de tabZ d'un facteur 2,5 :");
    afficher(tabZ);
    System.out.println();
 
    Object [] tab = new Object[tabZ.length+1];
    for (int i=0; i<tabZ.length; i++)
      tab[i]= tabZ[i];
  //  tab[tabZ.length] = new Rectangle(20,30);
    afficher(tab);
    zoomer(tab,0.5f);
    System.out.println("\nAprès zoom de tab d'un facteur 0,5 :");
    afficher(tab);
    ecraser((RectangleDeformable)tab[2],0.5f);
    afficher(tab);
    
  }
}