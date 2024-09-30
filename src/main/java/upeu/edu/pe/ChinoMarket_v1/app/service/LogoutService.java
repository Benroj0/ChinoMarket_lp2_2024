package upeu.edu.pe.ChinoMarket_v1.app.service;

import jakarta.servlet.http.HttpSession;

public class LogoutService {

    public LogoutService() {

    }
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("iduser");
    }
}
