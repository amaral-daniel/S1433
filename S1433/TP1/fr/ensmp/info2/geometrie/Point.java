// ----------------------------------------------
//              Mines ParisTech (ENSMP)
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------

package fr.ensmp.info2.geometrie; // Ce fichier fait partie du paquetage "fr.ensmp.info2.geometrie"

/** Classe encapsulant l'abscisse et l'ordonnée d'un point. */
public class Point implements Cloneable {
  // "implements Cloneable" pour pouvoir utiliser la méthode clone()
  // [Ce n'était pas demandé, mais montre comment le faire]
  private int x;
  private int y;
  /** Constructeur initialisant l'abscisse et l'ordonnée. */
  public Point(int abscisse, int ordonnee) {
    x = abscisse;
    y = ordonnee;
  }
  /** Translation du point.
      @param dx la variation d'abscisse
      @param dy la variation d'ordonnée */
  public void deplacer(int dx, int dy) {
   x += dx;
   y += dy;
  }
  /** Accès à l'abscisse.
       @return l'abscisse du point */
  public int getX() {
    return x;
  }
  /**  Accès à l'ordonnée
       @return L'ordonnée du point */
  public int getY() {
    return y;
  }
  /** @return une chaîne de caractère avec les coordonnées du point. */
  public String toString() {
    return new String("("+x+","+y+")");
  }
  /** @return true si et seulement si o est un autre objet de type
       Point ayant même abscisse et même ordonnée. */
  public boolean equals(Object o) {
    if (o!=null && o instanceof Point)
      return x==((Point)o).x && y==((Point)o).y;
    else
      return false;
  }

  /** Pour dupliquer un point (clonage). */
  public Object clone() {
    // NOTE : L'écriture de cette méthode n'était pas demandé, mais cela
    // montre comment faire si nécessaire.
    try{
      return super.clone();
      // Les attributs de la classe étant de types élémentaires,
      // la méthode "standard" donnée par Object est suffisante
      // (par contre s'il y avait des attributs de type référence, il
      //  faudrait les cloner aussi si on ne veut pas que le clone
      //  et l'original réfèrent les mêmes objets)
    }
    catch(CloneNotSupportedException e) {
      // Juste pour filtrer l'exception : normalement, on ne passera
      // jamais ici
      System.out.println(e);
      return null;
    }
  }

  /** Programme principal servant uniquement à tester la classe. */
  public static void main(String[] args) {
    Point p=null;
    char action;
     // Branchement d'un "parser d'input" sur le flux clavier System.in
    java.util.Scanner input = new java.util.Scanner(System.in);
    do {
      System.out.println("Taper :");
      System.out.println(" C pour Créer la position");
      System.out.println(" A pour l'Afficher ");
      System.out.println(" E pour tester equals(p2) ");
      System.out.println(" D pour tester deplacer(dx,dy) ");
      System.out.println(" Q pour Quitter");
      String rep = input.next();
      if (rep.length()!=1)
	  action = '?';
      else
	  action = rep.charAt(0);
      switch(action) {
      case 'C':
	System.out.print("x = ");
	int x = input.nextInt();
	System.out.print("y = ");
	int y = input.nextInt();
	p = new Point(x,y);
	break;
      case 'A':
	System.out.println(p);
	break;
      case 'E':
	System.out.println("Comparer à la position : ");
	System.out.print(" x2 = ");
	x = input.nextInt();
	System.out.print(" y2 = ");
	y = input.nextInt();
	Point p2 = new Point(x,y);
	System.out.println(p.equals(p2)?
			   "positions égales":"positions différentes");
        break;
      case 'D':
	System.out.print("dx = ");
	int dx = input.nextInt();
	System.out.print("dy = ");
	int dy = input.nextInt();
	p.deplacer(dx,dy);
	break;
      case 'Q':
      default:
      }
    } while (action!='Q');
  }
}