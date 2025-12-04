package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buku;
import service.BukuService;

public class BukuController {

    @FXML private TextField judulField;
    @FXML private TextField penulisField;
    @FXML private TextField hargaField;
    @FXML private TextField stokField;

    @FXML private TableView<Buku> bukuTable;
    @FXML private TableColumn<Buku, Integer> idColumn;
    @FXML private TableColumn<Buku, String> judulColumn;
    @FXML private TableColumn<Buku, String> penulisColumn;
    @FXML private TableColumn<Buku, Double> hargaColumn;
    @FXML private TableColumn<Buku, Integer> stokColumn;

    private BukuService service = new BukuService();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("bukuId"));
        judulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        penulisColumn.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        hargaColumn.setCellValueFactory(new PropertyValueFactory<>("harga"));
        stokColumn.setCellValueFactory(new PropertyValueFactory<>("stok"));

        loadData();
        
        bukuTable.setOnMouseEntered(event -> loadData());
        bukuTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                judulField.setText(newVal.getJudul());
                penulisField.setText(newVal.getPenulis());
                hargaField.setText(String.valueOf(newVal.getHarga()));
                stokField.setText(String.valueOf(newVal.getStok()));
            }
        });
    }

    private void loadData() {
        try {
            bukuTable.setItems(FXCollections.observableArrayList(service.getAll()));
        } catch (Exception e) {
            System.err.println("Gagal refresh data buku: " + e.getMessage());
        }
    }

    @FXML
    private void handleAdd() {
        try {
            double harga = Double.parseDouble(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            Buku b = new Buku(
                judulField.getText(), 
                penulisField.getText(), 
                harga, 
                stok
            );
            
            service.addBuku(b);
            loadData();
            clear();
            new Alert(Alert.AlertType.INFORMATION, "Berhasil Menambahkan Buku!").show();
            
        } catch (NumberFormatException e) {
            showError("Harga dan Stok harus berupa angka!");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void handleEdit() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                double harga = Double.parseDouble(hargaField.getText());
                int stok = Integer.parseInt(stokField.getText());

                selected.setJudul(judulField.getText());
                selected.setPenulis(penulisField.getText());
                selected.setHarga(harga);
                selected.setStok(stok);
                
                service.editBuku(selected);
                loadData();
                clear();
                new Alert(Alert.AlertType.INFORMATION, "Berhasil Mengupdate Buku!").show();
                
            } catch (NumberFormatException e) {
                showError("Harga dan Stok harus berupa angka!");
            } catch (Exception e) {
                showError(e.getMessage());
            }
        } else {
            showError("Pilih buku yang ingin diedit terlebih dahulu!");
        }
    }

    @FXML
    private void handleDelete() {
        Buku selected = bukuTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                service.deleteBuku(selected.getBukuId());
                loadData();
                clear();
                new Alert(Alert.AlertType.INFORMATION, "Berhasil Menghapus Buku!").show();
            } catch (Exception e) {
                showError(e.getMessage());
            }
        } else {
            showError("Pilih buku yang ingin dihapus terlebih dahulu!");
        }
    }

    private void clear() {
        judulField.clear();
        penulisField.clear();
        hargaField.clear();
        stokField.clear();
        bukuTable.getSelectionModel().clearSelection();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}