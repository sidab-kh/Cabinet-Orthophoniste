package app;

import app.mvc.Controlleur;
import app.util.enumerations.EScenes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * La classe principale de l'application qui lance l'interface utilisateur.
 * Elle étend la classe Application de JavaFX et initialise la première scène de l'application.
 */
public class Main extends Application {
    /** La fenêtre principale de l'application. */
    private static Stage primaryStage;

    /** Méthode principale qui lance l'application. */
    public static void main(String[] args) { launch(args); }
    
    /**
     * Méthode appelée lors du démarrage de l'application.
     * Elle initialise le stage principal et lance la première scène.
     */
    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        initialiserStage();
    }
    
    /**
     * Méthode appelée lors de l'arrêt de l'application.
     * Elle sauvegarde les données de l'orthophoniste si celui-ci est connecté.
     */
    @Override
    public void stop() {
        if (Controlleur.getInstance().getServiceOrthophoniste().getOrthophoniste() != null) {
            Controlleur.getInstance().getServiceOrthophoniste().sauvegarderOrthophoniste();
        }
    }

    /**
     * Méthode pour initialiser la première scène de l'application.
     * Elle affiche une scène de chargement pendant 1 seconde puis passe à la scène de connexion.
     */
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

            // Attendre 1 seconde (simuler un chargement)
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    Platform.runLater(() -> changerScene(EScenes.CONNEXION));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour changer de scène dans l'application.
     * Elle charge le fichier FXML correspondant à la nouvelle scène et l'affiche.
     *
     * @param scene La scène vers laquelle changer.
     */
    public static void changerScene(EScenes scene) {
        try {
            String fxmlFile = scene.getNomFichier();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlFile));
            Scene nouvelleScene = new Scene(loader.load());
            primaryStage.setScene(nouvelleScene);
            primaryStage.setTitle(scene.getNom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}