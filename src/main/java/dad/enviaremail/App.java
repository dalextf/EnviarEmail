package dad.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        App.primaryStage = new Stage();
        controller = new Controller();

        Scene scene = new Scene(controller.getView());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Enviar email");
        primaryStage.getIcons().add(new Image("images/email-send-icon-32x32.png"));
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
