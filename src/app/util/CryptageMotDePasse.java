package app.util;

public class CryptageMotDePasse {

	// Methode simple mais pas du tout securisee
	public static String crypter(String input) { return new StringBuilder(input).reverse().toString(); }
	
	// Verifier le mot de passe
	public static boolean verifierMotDePasse(String mdp, String mdpCrypte) { return crypter(mdp).equals(mdpCrypte); }
}
