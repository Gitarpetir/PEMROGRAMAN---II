package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Admin;

public class DashboardController {

    @FXML
    private Label lblAdmin;

    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
        lblAdmin.setText(admin.getIdentitas());
        }

    @FXML
    private void handleKelolaMember() {
        bukaWindow("/view/MemberView.fxml");
        }

    @FXML
    private void handleKelolaKeanggotaan() {
        bukaWindow("/view/KeanggotaanView.fxml");
        }

    @FXML
    private void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/LoginView.fxml")
            );
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();

            ((Stage) lblAdmin.getScene().getWindow()).close();
            
        } catch (Exception e) {
            e.printStackTrace();
            }
    }

    private void bukaWindow(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            }
        }
}
