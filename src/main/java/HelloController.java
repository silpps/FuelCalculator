
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    private ResourceBundle rb;

    @FXML
    private Label lblResult;

    @FXML
    private Label lblName;

    @FXML
    private Label lblDistance;

    @FXML
    private Label lblFuel;

    @FXML
    private Label lblError;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextField txtDistance;

    @FXML
    private TextField txtFuel;


    public void setLanguage(Locale locale) {
        lblResult.setText("");
        try {
            rb = ResourceBundle.getBundle("messages", locale);
            lblName.setText(rb.getString("lblName"));
            lblDistance.setText(rb.getString("lblDistance"));
            lblFuel.setText(rb.getString("lblFuel"));
            lblResult.setText("");
            lblError.setText("");
            btnCalculate.setText(rb.getString("btnCalculate"));
        } catch (MissingResourceException e) {
            e.printStackTrace();
            lblResult.setText("Error loading resources error");
        }

    }

    public void onEnClick(javafx.event.ActionEvent actionEvent) {
        setLanguage(new Locale("en", "US"));
    }

    public void onJpClick(javafx.event.ActionEvent actionEvent) {
        setLanguage(new Locale("ja", "JP"));
    }

    public void onFrClick(javafx.event.ActionEvent actionEvent) {
        setLanguage(new Locale("fr", "FR"));
    }

    public void onIrClick(javafx.event.ActionEvent actionEvent) {
        setLanguage(new Locale("fa", "IR"));
    }



    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    public void onCalculateClick(javafx.event.ActionEvent actionEvent){
        lblResult.setText("");
        lblError.setText("");
        if (rb == null) {
            lblResult.setText("Error loading resources");
            return;
        }
        if (txtDistance.getText().isEmpty() || txtFuel.getText().isEmpty()) {
            lblError.setText(rb.getString("lblError"));
            return;
        }
        try{
            double distance = Double.parseDouble(txtDistance.getText());
            double fuelAmount = Double.parseDouble(txtFuel.getText());
            double fuelUsage = (fuelAmount/distance)*100;
            String resultMessage = MessageFormat.format(rb.getString("lblResult"),String.format("%.2f", fuelUsage));
            lblResult.setText(resultMessage);
        }
        catch(NumberFormatException e){

            lblResult.setText(rb.getString("lblError"));
        }
    }

}
