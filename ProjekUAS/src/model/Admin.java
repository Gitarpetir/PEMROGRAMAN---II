package model;

public class Admin extends EntitasGym {

    private String username;
    private String password;
    private String shift;

    public Admin(int id, String nama, String username, String password, String shift) {
        super(id, nama);
        this.username = username;
        this.password = password;
        this.shift = shift;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String getIdentitas() {
        return "Admin: " + getNama() + " (Shift " + shift + ")";
    }
}
