// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//           héritage, polymorphisme
// ----------------------------------------------

import fr.ensmp.info2.geometrie.*;



public class EssaiGeometrie {
  public static void main(String[] args) {
	  Figure[] tableauFigures = new Figure[2];
	  tableauFigures[0] = new Cercle(new Point(0,1), 1);
	  tableauFigures[1] = new Rectangle(new Point(0,1), 1,1);
	  System.out.println(tableauFigures[0] + " " + tableauFigures[1]);
	  tableauFigures[0].deplacer(1, 1);
	  tableauFigures[1].deplacer(1, 1);
	  System.out.println(tableauFigures[0] + " " + tableauFigures[1]);
	  
  }
}
