// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//  Utilisation de la méthode clone()
// ----------------------------------------------

import java.util.*; // pour classes Vector et Date

public class Groupe implements Cloneable {
  /** Liste des membres du groupe. */
  private Vector<String> membres;
  /** Date de création du groupe. */
  private Date dateCreation;
  /** Constructeur. */
  public Groupe() {
    membres = new Vector<String>();
    dateCreation = new Date();
  }
  /** Ajout d'une personne dans le groupe. */
  public void ajouterMembre(String nomPersonne) {
    membres.add(nomPersonne);
  }
  /** Pour affichage des membres du groupes. */
  public String toString() {
    return membres.toString()+", créé le "+dateCreation;
  }
  /** Duplication du groupe. */
  public Object clone() throws CloneNotSupportedException {
    // Clonage par défaut (héritée Object) :
    //   copie membre à membre des attributs
	 
    Object copie = new Groupe();
    for(String s:membres)
    {
    		((Groupe)copie).ajouterMembre(s);
    }
    // ### A COMPLETER ###
    
    // On renvoie la copie
    return copie;
  }
  public static void main(String[] args) {
    try {
      Groupe g1 = new Groupe();
      g1.ajouterMembre("Jean");
      g1.ajouterMembre("Sophie");
      g1.ajouterMembre("Pierre");
      System.out.println(g1);
      Groupe g2 = (Groupe)g1.clone();
      System.out.println("Groupe g2 (obtenu par clonage) : "+g2);
      g2.ajouterMembre("Nathalie");
      System.out.println("Après ajout de Nathalie à g2");
      System.out.println("Groupe g1 : "+g1);
      System.out.println("Groupe g2 : "+g2);
    }
    catch (CloneNotSupportedException e) {
      System.out.println(e);
    }
  }
} 
    