// ----------------------------------------------
// Ecole Nationale Supérieure des Mines de PARIS
//           Programmation avancée
//    Analyse et Conception orientées objet
// ----------------------------------------------
//   Exemple d'interface de type "generics"
// ----------------------------------------------


/**
 *  Interface caractérisant les objets capables d'évaluer quantitativement
 *    (par une valeur de type double) toute instance d'une classe donnée.
 */
public interface Evaluateur<T> {
    double evaluer(T objet);
}