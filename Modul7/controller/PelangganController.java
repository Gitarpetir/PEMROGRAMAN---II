package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*; 
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pelanggan;
import service.PelangganService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class PelangganController {
    @FXML private TextField namaField, emailField, teleponField;
    @FXML private TableView<Pelanggan> pelangganTable;
    @FXML private TableColumn<Pelanggan, Integer> idColumn;
    @FXML private TableColumn<Pelanggan, String> namaColumn, emailColumn, teleponColumn;

    private PelangganService service = new PelangganService();

    @FXML public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("pelangganId"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        teleponColumn.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        loadData();
        
        pelangganTable.getSelectionModel().selectedItemProperty().addListener((obs, old, newVal) -> {
            if(newVal != null) {
                namaField.setText(newVal.getNama());
                emailField.setText(newVal.getEmail());
                teleponField.setText(newVal.getTelepon());
            }
        });
    }

    private void loadData() {
        try { pelangganTable.setItems(FXCollections.observableArrayList(service.getAll())); } 
        catch (Exception e) { showError(e.getMessage()); }
    }

    @FXML private void handleAdd() {
        try {
            service.addPelanggan(new Pelanggan(namaField.getText(), emailField.getText(), teleponField.getText()));
            loadData(); 
            clear();
            new Alert(Alert.AlertType.INFORMATION, "Berhasil Menambahkan Pelanggan!").show();
        } catch (Exception e) { showError(e.getMessage()); }
    }

    @FXML private void handleEdit() {
        Pelanggan p = pelangganTable.getSelectionModel().getSelectedItem();
        if(p != null) {
            try {
                p.setNama(namaField.getText());
                p.setEmail(emailField.getText());
                p.setTelepon(teleponField.getText());
                service.editPelanggan(p);
                loadData(); 
                clear();
                new Alert(Alert.AlertType.INFORMATION, "Berhasil Mengupdate Pelanggan!").show();
            } catch (Exception e) { showError(e.getMessage()); }
        }
    }

    @FXML private void handleDelete() {
        Pelanggan p = pelangganTable.getSelectionModel().getSelectedItem();
        if(p != null) {
            try { service.deletePelanggan(p.getPelangganId()); loadData(); 
            clear(); 
            new Alert(Alert.AlertType.INFORMATION, "Berhasil Menghapus Data Pelanggan!").show();
            }
            catch (Exception e) { showError(e.getMessage()); }
        }
    }

    private void clear() { namaField.clear(); emailField.clear(); teleponField.clear(); }
    private void showError(String msg) { new Alert(Alert.AlertType.ERROR, msg).show(); }
 
}