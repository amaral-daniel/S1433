// ----------------------------------------------
//            Mines ParisTech (ENSMP) 
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//           Héritage et polymorphisme                            
//        Classe abtraite et méthode abstraite
// ----------------------------------------------

import java.util.*;

public class Calcul {
  public static void main(String[] args) {
    System.out.println("Entrez une expression arithmétique, en prenant soin ");
    System.out.println(" de laisser des espaces autour de chaque symbole");
    System.out.print("  et de chaque nombre : ");
    // Branchement d'un "parser d'input" sur le flux clavier System.in
    Scanner input = new Scanner(System.in);
    // Lecture d'une ligne
    String saisie = input.nextLine();
    Expression expression = null;
    StringTokenizer analyseur = new StringTokenizer(saisie);
    Stack<Expression> operandes = new Stack<Expression>(); // piles des opérandes
    Stack<String> operateurs = new Stack<String>(); // piles des opérateurs
    boolean attenteOperande = true;
    try {
      while (analyseur.hasMoreTokens()) {
        String token = analyseur.nextToken();
        if (attenteOperande) { // On attend un opérande
          if (token.equals("("))
            operateurs.push(token);
          else { // il FAUT un nombre
            empilerNombre(token, operandes);
            attenteOperande = false; // après un nombre, attente opérateur ou ")"
          }
        }
        else { // On attend un opérateur ou une ")"
          if (token.equals(")")) 
            traiterParentheseFermante(operateurs, operandes);
          else {
            traiterOperateur(token, operateurs, operandes);
            attenteOperande = true; // après un opérateur, attente opérande
          }
        }
      }
      // Traiter les éventuels opérateurs encore sur la pile des opérateurs
      while (!operateurs.empty()) 
        empilerExpression(operateurs, operandes);
      // Au final, l'expression doit être seule en haut de la pile des opérandes
      expression =  operandes.pop(); 
      if (!operandes.empty())
        throw new RuntimeException("Expression invalide");
    }
    catch(EmptyStackException e) {
      throw new RuntimeException("Expression invalide");
    }
	// Affichage de l'expression
    System.out.println("Affichage (totalement parenthésé) de l'expression (via toString()) : "+expression);
 
    // Evaluation et affichage de la valeur de l'expression
    System.out.println("Resultat = "+expression.evaluer());
  }

  /** Essaie de "parser" un nombre, puis le met en haut de la pile des opérandes. */
  static private void empilerNombre(String s, Stack<Expression> operandes) {
    try {
      double val = Double.parseDouble(s);
      operandes.push(new Nombre(val));
    }
    catch(NumberFormatException e) {
      throw new RuntimeException("Expression invalide : "+s+
                                 " trouvée quand nombre attendu");
    }
  }

  /** Lors d'une fermeture de parenthèse, construire et empiler toutes
     les expressions correspondant aux opérateurs situés au-dessus
     de la parenthèse ouvrante. */
  static private void traiterParentheseFermante(Stack<String> operateurs,
                                                Stack<Expression> operandes) {
    if (operateurs.peek().equals("("))
      operateurs.pop(); // annulation mutuelle des parenthèses
    else { // autre opérateur
      empilerExpression(operateurs, operandes);
      traiterParentheseFermante(operateurs, operandes);
    }
  }

  /** Construire et empiler l'expression correspondant au sommet de la
      pile des opérateur : dépiler 2 opérandes et un opérateur,
      puis créer et empiler l'expression résultante. */
  static private void empilerExpression(Stack<String> operateurs,
                                         Stack<Expression> operandes) {
    try {
      Expression operandeDroit = operandes.pop();
      Expression operandeGauche = operandes.pop();
      String operateur = operateurs.pop();
      if (operateur.equals("+"))
        operandes.push(new Addition(operandeGauche, operandeDroit));
      else if (operateur.equals("-"))
        operandes.push(new Soustraction(operandeGauche, operandeDroit));
      else if (operateur.equals("*"))
        operandes.push(new Multiplication(operandeGauche, operandeDroit));
      else if  (operateur.equals("/"))
        operandes.push(new Division(operandeGauche, operandeDroit));
      else
        throw new RuntimeException("Expression invalide : opérateur "+
                                   operateur+ " inconnu");
    }
    catch(EmptyStackException e) {
      throw new RuntimeException("Expression invalide");
    }
  }

  /** Lors de la rencontre d'un nouvel opérateur, construire et empiler
      d'abord les expressions de tous les opérateurs de priorités >=,
      puis empiler le nouvel opérateur quand la pile des opérateurs est
      vide ou a un sommet de priorité <. */
  static private void traiterOperateur(String s, Stack<String> operateurs,
                                        Stack<Expression> operandes) {
    if (s.equals("+")||s.equals("-")) 
      if (operateurs.empty()||operateurs.peek().equals("("))
        operateurs.push(s);
      else { // priorité <= à celle du sommet de la pile des opérateurs
        empilerExpression(operateurs, operandes);
        traiterOperateur(s, operateurs, operandes);
      }
    else if (s.equals("*")||s.equals("/"))
      if (operateurs.empty()||operateurs.peek().equals("+")||
          operateurs.peek().equals("-")||operateurs.peek().equals("("))
        operateurs.push(s);
      else { // priorité <= à celle du sommet de la pile des opérateurs
        empilerExpression(operateurs, operandes);
        traiterOperateur(s, operateurs, operandes);
      }
    else // opérateur inconnu
      throw new RuntimeException("Expression invalide : "+s+
                                 " trouvé quand opérateur attendu");
  }
}

class TestEquals {
  public static void main(String[] args) {
    Expression deux = new Nombre(2.);
    Expression unPlusUn = new Addition(new Nombre(1.), new Nombre(1.));
    System.out.println("( "+deux+" ).equals( "+unPlusUn+" ) == "+deux.equals(unPlusUn));
  }
}