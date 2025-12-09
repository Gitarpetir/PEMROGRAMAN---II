package model;

import javafx.beans.property.*;

public class Akun {
	private IntegerProperty idAkun = new SimpleIntegerProperty();
	private StringProperty username = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	//Construtor buat read select delete
	public Akun (int idAkun, String username, String password) {
		this.idAkun.set(idAkun);
		this.username.set(username);
		this.password.set(password);
	}
	//Constructor buat insert
	public Akun (String username, String password) {
		this.username.set(username);
		this.password.set(password);
	}
	
	//Getter
	public int getIdAkun() {
		return idAkun.get();
	}
	
	public String getUsername() {
		return username.get();
	}
	
	public String getPassword() {
		return password.get();
	}
	
	//Setter
	public void setIdAkun(int idAkun) {
		this.idAkun.set(idAkun);
	}
	
	public void setUsername(String username) {
		this.username.set(username);
	}
	
	public void setPassword(String password) {
		this.password.set(password);
	}
	
	//property untuk tableview
	public IntegerProperty idAkunProperty() {
		return idAkun;
	}
	
	public StringProperty usernameProperty() {
		return username;
	}
	
	public StringProperty passwordProperty() {
		return password;
	}
}
