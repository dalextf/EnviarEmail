package dad.enviaremail;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.EmailException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private StringProperty serverProperty = new SimpleStringProperty();
    private StringProperty portProperty = new SimpleStringProperty();
    private BooleanProperty sslProperty = new SimpleBooleanProperty();
    private StringProperty eFromProperty = new SimpleStringProperty();
    private StringProperty passProperty = new SimpleStringProperty();
    private StringProperty eToProperty = new SimpleStringProperty();
    private StringProperty subjectProperty = new SimpleStringProperty();
    private StringProperty smsProperty = new SimpleStringProperty();

    @FXML
    private GridPane view;

    @FXML
    private Label servidorLabel;

    @FXML
    private TextField servidorText;

    @FXML
    private TextField puertoText;

    @FXML
    private Button enviarButton;

    @FXML
    private Label sslLabel;
    @FXML
    private CheckBox sslCheck;

    @FXML
    private Button vaciarButton;

    @FXML
    private Label remitenteLabel;

    @FXML
    private TextField remitenteText;

    @FXML
    private PasswordField passText;

    @FXML
    private Button cerrarButton;


    @FXML
    private Label destinatarioLabel;

    @FXML
    private TextField destinatarioText;

    @FXML
    private Label asuntoLabel;

    @FXML
    private TextField asuntoText;


    @FXML
    private TextArea mensajeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        serverProperty.bind(servidorText.textProperty());
        portProperty.bind(puertoText.textProperty());
        sslProperty.bind(sslCheck.selectedProperty());
        eFromProperty.bind(remitenteText.textProperty());
        passProperty.bind(passText.textProperty());
        eToProperty.bind(destinatarioText.textProperty());
        subjectProperty.bind(asuntoText.textProperty());
        smsProperty.bind(mensajeText.textProperty());

    }

    @FXML
    void onCerrarButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onEnviarButtonAction(ActionEvent event) {
        try {
            Email email = new SimpleEmail();

            email.setHostName(serverProperty.get());
            email.setSmtpPort(Integer.parseInt(portProperty.get()));
            email.setAuthenticator(new DefaultAuthenticator(eFromProperty.get(), passProperty.get()));
            email.setSSLOnConnect(sslProperty.get());
            email.setFrom(eFromProperty.get());
            email.setSubject(subjectProperty.get());
            email.setMsg(smsProperty.get());
            email.addTo(eToProperty.get());
            email.send();

            destinatarioText.clear();
            asuntoText.clear();
            mensajeText.clear();

            successAccess();
        } catch (EmailException e) {
            errorAccess();
            e.printStackTrace();
        }
    }

    @FXML
    void onVaciarButtonAction(ActionEvent event) {
        servidorText.clear();
        puertoText.clear();
        remitenteText.clear();
        passText.clear();
        sslCheck.setSelected(false);
        mensajeText.clear();
        destinatarioText.clear();
        asuntoText.clear();
    }

    private void successAccess() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje enviado con éxito a '"+ destinatarioText.textProperty().get() +"'.");
        alert.setTitle("Mensaje enviado");
        App.getPrimaryStage().getIcons().add(new Image(getClass().getResourceAsStream("images/email-send-icon-32x32.png")));
        alert.showAndWait();
    }

    private void errorAccess() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("No se pudo enviar el email");
        alert.setTitle("Error");
        alert.setContentText("Invalid message supplied");
        App.getPrimaryStage().getIcons().add(new Image("images/email-send-icon-32x32.png"));
        alert.showAndWait();
    }

    public Controller() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Enviar.fxml"));
        loader.setController(this);
        loader.load();
    }

    public GridPane getView() {
        return view;
    }
}
