package app;

import controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application Class
 *
 * @author Martin Gallacher
 */
public class AnniversariesApp extends Application {
    private Stage primaryStage;

   @Override
   public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Anniversaries App");
      Controller controller = new Controller(primaryStage);
      controller.initRootLayout();
   }

    /**
     * Starts the application by invoking the JavaFX Application class method launch
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}

