package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Admin;
import service.AdminService;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    private AdminService adminService = new AdminService();

    @FXML
    private void handleLogin() {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Validasi", "Username dan password harus diisi");
            return;
        }

        Admin admin = adminService.login(username, password);

        if (admin == null) {
            showAlert("Login Gagal", "Username atau password salah");
            return;
        }

        bukaDashboard(admin);
        tutupWindow();
    }

    private void bukaDashboard(Admin admin) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/DashboardView.fxml")
            );
            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.setAdmin(admin);

            Stage stage = new Stage();
            stage.setTitle("SIMAGYM - Dashboard");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tutupWindow() {
        Stage stage = (Stage) txtUsername.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
}
