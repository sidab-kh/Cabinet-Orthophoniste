package app.util;

/**
 * Cette classe fournit des méthodes pour le cryptage et la vérification des mots de passe.
 */
public class CryptageMotDePasse {

    /**
     * Crypte une chaîne de caractères en la retournant dans l'ordre inverse.
     * Cette méthode est simple mais n'est pas sécurisée.
     * 
     * @param input La chaîne de caractères à crypter.
     * @return La chaîne cryptée.
     */
    public static String crypter(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Vérifie si un mot de passe correspond à sa version cryptée.
     * 
     * @param mdp Le mot de passe à vérifier.
     * @param mdpCrypte Le mot de passe crypté à comparer.
     * @return true si le mot de passe correspond à sa version cryptée, sinon false.
     */
    public static boolean verifierMotDePasse(String mdp, String mdpCrypte) {
        return crypter(mdp).equals(mdpCrypte);
    }
}
