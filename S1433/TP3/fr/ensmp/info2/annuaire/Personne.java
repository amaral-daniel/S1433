// ----------------------------------------------
//            Mines ParisTech (ENSMP) 
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//   Ecriture et utilisation d'une classe
//     + méthodes toString() et equals()
// ----------------------------------------------

package fr.ensmp.info2.annuaire; // Fichier faisant partie du paquetage "fr.ensmp.info2.annuaire"

import java.util.Scanner; // Nécessaire pour faciliter lectures clavier


/** Classe regroupant nom et numéro de téléphone d'un abonné. */
public class Personne {
  private String nom;
  private int tel;
  
  /** Constructeur nécessitant le nom et le téléphone. */
  public Personne(String nom, int tel) {
    this.nom = nom;
    this.tel = tel;
  }
  
  /** Constructeur par recopie. */
  public Personne(Personne p) {
    this(new String(p.nom), p.tel);
    // Note : une String étant non modifiable on pourrait en fait se contenter
    // de faire "this(p.nom, p.tel);", ce qui ferait qu'il y aurait une
    // seule instance de String partagée par la Personne d'origine et la 
    // recopie.
  }
  
  public String getNom() {
    return nom;
  }
  
  public int getTel() {
    return tel;
  }
  
  /** Redéfinition de toString() pour produire une chaîne
      contenant le nom et le téléphone. */
  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append("nom : ").append(nom).append(", tel = ");
    buf.append(String.valueOf(tel));
    return buf.toString();
  }
  
  /* Redéfinition de equals(Object) permettant de tester
     l'égalité totale de 2 abonnés (même nom, même numéro),
     ou l'égalité de nom de 2 personnes dont au moins une
     a un numéro indéfini (représenté par -1),
     @return true si et seulement si o est une Personne
     ayant même nom et même numéro, ou o est une Personne
     ayant juste le même nom mais une des 2 Personne est de numéro
     indéfini (représenté par -1)
  */
  public boolean equals(Object o) {
    if (o==null)
      return false;
    else if (o instanceof Personne) 
      return nom.equals(((Personne)o).nom)&&
	       (tel==-1 || tel==((Personne)o).tel || ((Personne)o).tel==-1);
    else
      return false;
  }
  
  /** Petit programme pour tester la classe. */
  static public void main(String[] args) {
    Personne p=null;
    char action;
    Scanner input = new Scanner(System.in);
    do {
      System.out.println("Taper :");
      System.out.println(" C pour Créer la personne");
      System.out.println(" A pour l'Afficher ");
      System.out.println(" R pour créer par Recopie ");
      System.out.println(" Q pour Quitter");
      action = input.next().charAt(0); 
      switch(action) {
      case 'C':
    	  System.out.print("Nom ? ");
    	  String nom = input.next(); // lecture (sur clavier) du prochain "mot"
    	  System.out.print("\n Tel ? ");
    	  int tel=input.nextInt(); 
    	  p = new Personne(nom,tel);
	break;
      case 'A':
	System.out.println(p);
	break;
      case 'R':
        Personne p2 = new Personne(p);
        System.out.println("Personne obtenue par recopie : "+p2);
	break;
      case 'Q':
      default:
      }
    } while (action!='Q'); 
  }
}
