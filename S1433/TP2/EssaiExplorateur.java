// ----------------------------------------------
//    Algorithmique et programmation en Java     
// Ecole Nationale Supérieure des Mines de PARIS
//  Analyse, Conception et Programmation Objet
// ----------------------------------------------
//         Utilisation d'interface
// ----------------------------------------------

import fr.ensmp.karel.robots.*; // Pour accéder aux classes Ville, ...

public class EssaiExplorateur {
  public static void main(String[] args)  {
    // CHOIX DU NOMBRE D'OBSTACLES 
    int nombreObstacles = 7;
    if (args.length==1)
      nombreObstacles = Integer.parseInt(args[0]);
     
    // CREATION DE L'ENVIRONNEMENT DE TEST
    Ville environnement = new Ville(nombreObstacles,'0');
    
    // CHOIX ET CREATION DE L'EXPLORATEUR
    
    // ######################################################
    // ##### LIGNE CI-DESSOUS A DECOMMENTER UNIQUEMENT  ##### 
    // #####    APRES AVOIR DEFINI ExplorateurAbstrait  #####
    // ######################################################
    //
     ExplorateurAbstrait indianaJones=null;
    
    // Affichage
    System.out.println("Quel type d'explorateur voulez-vous tester ?");
    System.out.println(" 1. ExplorateurAveugleAleatoire");
    System.out.println(" 2. ExplorateurEviteurSystematique");
    System.out.println(" 3. ExplorateurEconome");

    // SAISIE
    // Branchement d'un "parser d'input" sur le flux clavier System.in
    java.util.Scanner input = new java.util.Scanner(System.in);
    int choix = input.nextInt();
    switch (choix) {
      // ###########################################################
      // ##### LIGNES CI-DESSOUS A DECOMMENTER UNIQUEMENT      ##### 
      // ##### AU FUR ET A MESURE QUE VOUS AVEZ DEFINI  LES    #####
      // ##### CLASSES CORRESPONDANTES                         #####
      // ###########################################################
      case 1:
        indianaJones = new ExplorateurAveugleAleatoire(environnement);
        break;
      //
      case 2:
       indianaJones = new ExplorateurEviteurSystematique(environnement);
        break;
      //case 3:
      //  indianaJones = new ExplorateurEconome(environnement);
      //  break;
      // 
    default:
      System.err.println("Type d'explorateur inconnu ("+choix+")");
    }
    
    // CREATION DE L'AFFICHAGE
    Simulation sim = new Simulation(environnement);
    
    // ESSAI DE L'EXPLORATEUR
    // #######################################################
    // ##### LIGNES CI-DESSOUS A DECOMMENTER UNIQUEMENT  ##### 
    // #####    APRES AVOIR DEFINI ExplorateurAbstrait   #####
    // #######################################################
    //
    if (indianaJones!=null)
      essai(indianaJones);
  } 
  
  /**
   * Fonction testant un Explorateur en le faisant évoluer
   * dans son environnement.
   */
  // #######################################################
  // ##### LIGNES CI-DESSOUS A DECOMMENTER UNIQUEMENT  ##### 
  // #####    APRES AVOIR DEFINI ExplorateurAbstrait   #####
  // #######################################################
  //
  public static void essai(ExplorateurAbstrait explorateur) {
  while(true) {
    // CHOIX D'UNE ORIENTATION PAR L'EXPLORATEUR
    explorateur.choisirDirection();
  //  // AVANCER D'UNE CASE DANS LA DIRECTION CHOISIE
  //  //   (SYSTEMATIQUEMENT, OU EVENTUELLEMENT
  //  //      UNIQUEMENT SI C'EST POSSIBLE) 
    explorateur.avancer();
    }  
  }
}