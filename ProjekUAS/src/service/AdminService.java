package service;

import dao.AdminDAO;
import model.Admin;

public class AdminService {

    private AdminDAO adminDAO = new AdminDAO();

    public Admin login(String username, String password) {
        return adminDAO.login(username, password);
    }
}
