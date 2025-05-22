package web.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.service.RegistrationService;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        System.out.println("Received Registration Info: " + fName + ", " + lName + ", " + email + ", " + dob);

        boolean result = RegistrationService.register(fName, lName, email, dob);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        if (result) {
            resp.getWriter().println("<!DOCTYPE html><html><head><title>success</title></head><body><h2>Registration successful!</h2></body></html>");
        } else {
            resp.getWriter().println("<!DOCTYPE html><html><head><title>fail</title></head><body><h2>Registration failed. Please check your input.</h2></body></html>");
        }
    }
}