package Controller;

import Model.Mahasiswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable { 

    @FXML
    private TableView<Mahasiswa> tableMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        ObservableList<Mahasiswa> listData = FXCollections.observableArrayList(
            new Mahasiswa(1, "John", "1"),       
            new Mahasiswa(2, "Jane", "2"),       
            new Mahasiswa(3, "Jono", "3"),    
            new Mahasiswa(4, "Agus", "4"),   
            new Mahasiswa(5, "Raka", "5"),
            new Mahasiswa(6, "Azriel", "6"),
            new Mahasiswa(7, "Zul", "7"),
            new Mahasiswa(8, "Nafis", "8"),
            new Mahasiswa(9, "Faqih", "9"),
            new Mahasiswa(10, "Ibnu", "10"),
            new Mahasiswa(11, "Ulyani", "11"),
            new Mahasiswa(12, "Alfi", "12"),
            new Mahasiswa(13, "Indra", "13"),
            new Mahasiswa(14, "Andre", "14"),
            new Mahasiswa(15, "Luthfi", "15")
        );

        tableMahasiswa.setItems(listData);
    }
}