

/**
   Classe permettant de manipuler les fractions (1/2, 2/3, ...)
    sous forme d'objets.
*/
public class Fraction  implements Comparable<Fraction>{
  private int numerateur;
  private int denominateur;
  
  /** Constructeur "principal" avec en paramètre le numérateur et
      le dénominateur.
      @param n le numérateur.
      @param d le dénominateur.
      @throws ArithmeticException si le dénominateur est null.     
  */ 
  public Fraction(int n, int d) {
    numerateur = n;
    denominateur = d;
    if (denominateur==0)
      throw new ArithmeticException("Dénominateur nul pour une fraction");
  }
  
  /** Constructeur pour mettre un entier sous forme de fraction. */
  public Fraction(int n) {
    this(n,1); // appel de l'autre constructeur
  }
  
  /** Calcul et retour de la valeur de la fraction. */
  public double valeur() {
    // remarquer la conversion du numerateur avant la division
    //   pour faire la division flottante et non entière 
    return (double)numerateur/denominateur;
  }
  
   public String toString() {
    return numerateur+"/"+denominateur+" = "+valeur();
  }
 
  /** Affichage de la fraction et de sa valeur */
  public void afficher() {
    System.out.println(this);
  }
 
  /** Teste si la fraction est simplifiable en un entier */
  public boolean estUnEntier() {
    return numerateur%denominateur==0;
  }
  
  /** Ajout d'une fraction. */
  public void ajouter(Fraction f) {
    numerateur = numerateur*f.denominateur + denominateur*f.numerateur;
    denominateur *= f.denominateur;
  }
 
  /** Fonction retournant une fraction dont le numérateur et le
      dénominateur sont tirés aléatoirement entre -10 et 10.
      @return la fraction aléatoire.
  */
  public static Fraction fractionAleatoire() {
    // Noter le static, car c'est une *fonction*.
    Fraction f=null;
    boolean exception=false;
    do {
      try{
        exception = false;
        int num = -10+(int)(20*Math.random());
        int denom = -10+(int)(20*Math.random());
        f = new Fraction(num,denom);
      }
      catch (ArithmeticException e) {
        System.err.println("mauvais tirage, on recommence...");
        exception = true;
      }
    } while (exception);
    return f;
  }
  
  public int compareTo(Fraction f)
  {
	  if(this.valeur() == f.valeur())
	  {
		  return 0;

	  }  
	  if(this.valeur() < f.valeur())
	  {
		  return -1;
	  }
	  return 1;
}
  
  /** Programme principal de test */
  public static void main(String[] args) {
    final int DIM=6;
    Fraction[] tab = new Fraction[DIM];
    for (int i=0; i<DIM; i++)
      tab[i] = fractionAleatoire();
    System.out.println("Avant tri");
    for (int i=0; i<DIM; i++)
      System.out.println(tab[i]);
 
    // Test de l'implémentation de Comparable
    java.util.Arrays.sort(tab); 
    System.out.println("Après tri");
    for (int i=0; i<DIM; i++)
      System.out.println(tab[i]);
  }
}