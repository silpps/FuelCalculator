import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class View extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fuelCalculator.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Fuel Calculator");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}