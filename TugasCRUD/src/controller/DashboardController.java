package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private void onAkun(ActionEvent e) {
        bukaWindow("/view/AkunView.fxml", "Data Akun");
    }

    @FXML
    private void onBarang(ActionEvent e) {
        bukaWindow("/view/BarangView.fxml", "Data Barang");
    }

    @FXML
    private void onPelanggan(ActionEvent e) {
        bukaWindow("/view/PelangganView.fxml", "Data Pelanggan");
    }

    @FXML
    private void onTransaksi(ActionEvent e) {
        bukaWindow("/view/TransaksiView.fxml", "Data Transaksi");
    }

    private void bukaWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
