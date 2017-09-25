// ----------------------------------------------
//            Mines ParisTech (ENSMP) 
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//   Ecriture et utilisation d'une classe
//     + classe java.util.Vector + paquetage
// ----------------------------------------------

package fr.ensmp.info2.annuaire; // Fichier faisant partie du paquetage "fr.ensmp.info2.annuaire"
  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Nécessaire pour faciliter lectures clavier

/** Classe implémentant un annuaire
    (version 2 : stockage des instances de Personne dans un Vector). */
public class Annuaire2{
  /** Vector contenant les entrées de l'annuaire. */
  private List<Personne> tabP=null;
  
  /** Constructeur. */
  public Annuaire2() {
    tabP=new ArrayList<Personne>();
  }
  
  /** Ajout d'une personne dans l'annuaire. */
  public void ajouter(Personne p) {
    tabP.add(p); 
  }
  
  /** Ajout dans l'annuaire de la *copie* d'une personne.  */
  public void ajouterCopie(Personne p) {
    tabP.add(new Personne(p));
  }
  
  /** Ajout d'une personne dans l'annuaire 
        (à partir de son nom et son téléphone). */
  public void ajouter(String nom, int tel) {
    ajouter(new Personne(nom,tel));
  }

  /** Renvoie le nombre de personnes figurant dans l'annuaire. */
  public int nombreDePersonnes() {
    return tabP.size();
  }
  
  /** Redéfinition de toString() pour produire une chaîne
      contenant la liste des abonnés. */
  public String toString() {
    StringBuffer buf = new StringBuffer();
    for (int i=0; i<tabP.size(); i++)
      buf.append(tabP.get(i)+"\n");
    return buf.toString();
  }
  
  /** Affichage de toutes les personnes de l'annuaire */
  public void afficher() {
    System.out.println(toString());
  }
  
  /** Recherche d'une personne dans l'annuaire, par son nom.
      @return null si ce nom ne figure pas dans l'annuaire,
      et le premier abonné portant ce nom sinon. */
  public Personne chercher(String nom) {
    int index = tabP.indexOf(new Personne(nom,-1));
    if (index == -1)
      return null;
    else
      return (Personne)(tabP.get(index));
  }
  
  /** Suppression d'une personne dans l'annuaire (désignée par son nom).
      @return false si ce nom ne figure pas dans l'annuaire,
      et true sinon. */
  public boolean supprimer(String nom) {
    int index = tabP.indexOf(new Personne(nom,-1));
    if (index == -1)
      return false;
    else {
      tabP.remove(index);
      return true;
    }
  }
  
  /** Programme de test de l'annuaire. */
  static public void main(String[] args) {
    Annuaire2 ann=null;
    char action='?';
    Scanner input = new Scanner(System.in);
    
    do {
      try{
        System.out.println();
        System.out.println("Taper :");
        System.out.println(" C pour Créer l'annuaire");
        System.out.println(" + pour y ajouter une personne");
        System.out.println(" D pour Dupliquer une entrée de l'annuaire");
        System.out.println(" A pour Afficher l'annuaire");
        System.out.println(" R pour Rechercher une personne");
        System.out.println(" - pour supprimer une personne");
        System.out.println(" Q pour Quitter");
        action = input.next().charAt(0); 
        String nom;
        switch(action) {
        case 'C':
          ann = new Annuaire2();
          break;
        case '+':
          System.out.print("Nom ? ");
          nom = input.next(); // lecture (sur clavier) du prochain "mot"
          System.out.print("\n Tel ? ");
	      int tel=input.nextInt();
	  ann.ajouter(nom,tel);
          break;
       case 'D':
         System.out.print("Nom de la personne à dupliquer ? ");
          nom = input.next();
          ann.ajouterCopie(ann.chercher(nom));
          break;
        case 'A':
          ann.afficher();
          break;
        case 'R':
          System.out.print("Nom ? ");
          nom = input.next();
          Personne rep=ann.chercher(nom);
          if (rep==null)
            System.out.println(nom+" n'est pas dans l'annuaire");
          else
            System.out.println(rep);
          break;
        case '-':
          System.out.print("Nom ? ");
          nom = input.next();
          boolean res=ann.supprimer(nom);
          if (res==false)
            System.out.println(nom+" n'est pas dans l'annuaire");
          else
            System.out.println("OK : "+nom+" supprimé de l'annuaire");
          break;
        case 'Q':
        default:
        }
      }
      catch(NullPointerException e) {
        System.out.println(e);
        if (ann==null)
          System.out.println("Créez d'abord l'annuaire");
      } 
    } while (action!='Q'); 
  }
}