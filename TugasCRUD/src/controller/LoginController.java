package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import model.Akun;
import service.AkunService;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField passwordUsername;

    @FXML
    private Button buttonLogin;

    private AkunService akunService = new AkunService();

    @FXML
    private void onLogin(ActionEvent event) {

        String username = loginUsername.getText();
        String password = passwordUsername.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username atau Password kosong!");
            return;
        }

        boolean valid = cekLogin(username, password);

        if (valid) {
            System.out.println("Login berhasil!");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardView.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) buttonLogin.getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Dashboard");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Gagal buka dashboard: " + e.getMessage());
            }
        } else {
            System.out.println("Login gagal: Username atau Password salah.");
        }
    }

    private boolean cekLogin(String username, String password) {    
        for (Akun akun : akunService.getSemuaAkun()) {
            System.out.println("Akun: username=" + akun.getUsername() + ", password=" + akun.getPassword());
        }

        for (Akun akun : akunService.getSemuaAkun()) {
            if (akun.getUsername().equals(username) &&
                akun.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    
}