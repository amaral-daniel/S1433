// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------

package fr.ensmp.info2.annuaire; // Fichier faisant partie du paquetage "fr.ensmp.info2.annuaire"

import java.util.*; // pour List, ArrayList, ...

public class Entreprise {
    private List<Employe> personnel;

    // Constructeur (privé pour limiter utilisation à l'intérieur de la classe)
    private Entreprise() {
	personnel = new ArrayList<Employe>();
    }
    
    public void afficher() {
	for (Employe e : personnel) 
	    System.out.println(e);
    }

    List<Employe> getPersonnel() {
	return personnel;
    }

    public static Entreprise getTestExample() {
	Entreprise res = new Entreprise();
	res.personnel.add(new Employe("Jean", "technicien", 1033));
	res.personnel.add(new Employe("Corinne", "ingénieur", 1012));
	res.personnel.add(new Employe("Alain", "comptable", 1075));
	res.personnel.add(new Employe("Sophie", "secrétaire", 1010));
	return res;
    }

    public static void main(String[] args) {
	Entreprise tst = Entreprise.getTestExample();
	tst.afficher();
    }
}

