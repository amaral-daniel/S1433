// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------

package fr.ensmp.info2.annuaire; // Fichier faisant partie du paquetage "fr.ensmp.info2.annuaire"

public class Employe extends Personne {
    private String fonction;
    public Employe(String nom, String fonction, int posteTel) {
	super(nom, posteTel);
	this.fonction = fonction;
    }
    public String toString() {
	String base = super.toString();
	String res = base+" [fonction = "+fonction+"]";
	return res;
    }
}