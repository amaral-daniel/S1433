// ----------------------------------------------
//              Mines ParisTech (ENSMP)
//  Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//      Ajout de méthodes dans une classe
// ----------------------------------------------

/**
   Classe permettant de manipuler les fractions
   (1/2, 2/3, ...) sous forme d'objets.
*/
public class Fraction {
  // ATTRIBUTS
  /** Le numérateur. */
  private int num;
  /** Le dénominateur. */
  private int deno;


  /** Constructeur "principal" avec en paramètres
      le numérateur et le dénominateur.
      @param numerateur le numérateur.
      @param denominateur le dénominateur.
      @throws ArithmeticException si le dénominateur
                est nul.
  */
  public Fraction(int numerateur, int denominateur) {
    num = numerateur;
    deno = denominateur;
    // Empêcher la création de fraction
    //   ayant un dénominateur nul
    if (deno==0)
      throw new ArithmeticException("Dénominateur nul "+
                                  "pour une fraction");
  }

  /** Constructeur pour mettre un entier sous forme
       de fraction. */
  public Fraction(int n) {
    this(n,1); // appel de l'autre constructeur
  }

  /** Simplification canonique de la fraction. */
  public void simplifier() {
    if (num==0) {
      deno = 1;
      return;
    }
    int div = pgcd(num, deno);
    num /= div;
    deno /= div;
    int signe = num/Math.abs(num) *
      deno/Math.abs(deno);
    num = signe*Math.abs(num);
    deno = Math.abs(deno);
  }

  /** Fonction retournant le pgcd de 2 entiers. */
  static private int pgcd(int m, int n) {
    // Algo d'Euclide
    while (n != 0) {
      int reste = m % n;
      m = n;
      n = reste;
    }
    return m;
  }

  /** Calcul et retour de la valeur de la fraction. */
  public double valeur() {
    // Remarquer la conversion du dénominateur pour
    //   que la division effectuée ne soit PAS
    //   la division *entière*.
    return num/(double)deno;
  }

  /** Conversion en chaîne de caractères. */
  public String toString() {
    return num+"/"+deno;
  }

  /** Affichage de la fraction et de sa valeur. */
  public void afficher() {
    // Puisque toString() a été redéfinie, autant
    //   l'utiliser ici ( System.out.println(o); <=>
    //     System.out.println(o.toString(); )
    System.out.println(this+" = "+valeur());
  }
  
  public int getNum()
  {
	  return num;
  }

  public int getDeno()
  {
	  return deno;
  }
  
  public boolean equals(Object f)
  {
	  if(f instanceof Fraction)
	  {
		  Fraction a = (Fraction) f;
		  if((num == a.getNum()) && (deno == a.getDeno()))
		  {
		  	return true;
		  }
				  
	  }
	  return false;
}
  
  @Override public int hashCode()
  {
	  return (num*100000 + deno);
  }
  /** Programme principal de test */
  public static void main(String[] args) {
    Fraction f1 = new Fraction(1,2);
    Fraction f2 = new Fraction(3);
    System.out.println("affichage fraction 1/2 :");
    f1.afficher();
    System.out.println("affichage fraction 3/1 :");
    f2.afficher();
    // Déclaration et création d'un tableau
    //   de Fractions
    Fraction [] tabF = new Fraction[12];
    // Le tableau est initialement rempli de références
    //   valant null (i.e. ne pointant vers rien).
    // Pour créer effectivement des Fractions vers
    //   lesquelles les éléments du tableau "pointent",
    //   il faut ensuite faire un "new Fraction(...)"
    //    pour chacun d'eux.
    System.out.println("Affichage des fractions "+
                       "-6/-6, -5/-6, ..., 5/6 :");
    for (int i=0; i<tabF.length; i++) {
      tabF[i] = new Fraction(i-6, -6);
      tabF[i].afficher();
    }
  }
}