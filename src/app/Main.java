package app;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;
	
	public static void main(String[] args) { launch(args); }
	 
	@Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        initialiserStage();
    }
	
	@Override
    public void stop() {
		if (Controlleur.getInstance().getServiceOrthophoniste().getOrthophoniste() != null)
        { Controlleur.getInstance().getServiceOrthophoniste().sauvegarderOrthophoniste(); }
    }
	
	// Methode pour initialiser la premiere scene
	public void initialiserStage() {
	    try {
	        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Chargement.fxml"));
	        Scene sceneChargement = new Scene(loader.load());
	        primaryStage.setTitle(EScenes.CHARGEMENT.getNom());
	        primaryStage.setScene(sceneChargement);

	        // Ajouter l'icone de l'application
	        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/appicon.png")));
	        primaryStage.setResizable(false);

	        // Afficher le stage principal
	        primaryStage.show();

	        // Attendre 1 secondes (simuler un chargement)
	        new Thread(() -> {
	            try {
	                Thread.sleep(1000);
	                Platform.runLater(() -> changerScene(EScenes.CONNEXION));
	            } catch (InterruptedException e) { e.printStackTrace(); }
	        }).start();
	    } catch (Exception e) { e.printStackTrace(); }
	}

    
	// Methode pour changer de scene
    public static void changerScene(EScenes scene) {
        try {
        	String fxmlFile = scene.getNomFichier();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlFile));
            Scene nouvelleScene = new Scene(loader.load());
            primaryStage.setScene(nouvelleScene);
            primaryStage.setTitle(scene.getNom());
        } catch (Exception e) { e.printStackTrace(); }
    }
}
