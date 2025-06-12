/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import smoking.member.CreateAccountError;
import smoking.member.MemberDAO;
import smoking.member.MemberDTO;

/**
 *
 * @author Thinkpad
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_ERROR = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String IDMember = request.getParameter("txtIdmember");
        String gender = request.getParameter("txtGender");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullName = request.getParameter("txtFullname");
        String phone = request.getParameter("txtPhone");
        String address = request.getParameter("txtAddress");
        String dob = request.getParameter("txtDob");

        CreateAccountError accountError = new CreateAccountError();
        boolean foundErr = false;
        String url = LOGIN_ERROR;
        try {
            if (IDMember.trim().length() < 6 || IDMember.trim().length() > 30 || IDMember.trim().isEmpty()) {
                foundErr = true;
                accountError.setIDMemberError("IDMember is required to be 6 to 30 chars");
            }
            
            if (gender == null || gender.isEmpty()){
                foundErr = true;
                accountError.setGenderError("Please select your gender.");
            }

            if (password.trim().length() < 6 || password.trim().length() > 20 || password.trim().isEmpty()) {
                foundErr = true;
                accountError.setPasswordError("Password is required to be 6 to 20 chars");

            } else if (!confirm.trim().equals(password.trim()) || confirm.trim().isEmpty()) {
                foundErr = true;
                accountError.setCofirmPasswordError("Confirm password must match the password");
            }

            if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$") || email.trim().isEmpty()) {
                foundErr = true;
                accountError.setEmailError("Invalid email format");
            }

            if (fullName.trim().length() < 2 || fullName.trim().length() > 50 || fullName.trim().isEmpty()) {
                foundErr = true;
                accountError.setFullNameError("Full name is required to be 2 to 50 chars");
            }

            if (phone.trim().length() < 10 || phone.trim().length() > 12 || phone.trim().isEmpty()) {
                foundErr = true;
                accountError.setPhoneError("Phone is required to be 10 to 12 numbers");
            }          

            if (foundErr) {
                request.setAttribute("CREATE_ERRORS", accountError);
            } else {
                // Create account in the database
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDob = sdf.parse(dob);
                Date dateOfBirth = new Date(parsedDob.getTime());
                // Join date is current date
                Date joinDate = new Date(System.currentTimeMillis());
                // You can set these values as needed
                String image = "default.jpg"; // or whatever default
                String IDCoach = null;        // no coach yet
                String subcription = ""; // or null if not set
                String status = "";        // or "Active" etc.
                String token = "";            // or generate if needed
                MemberDAO dao = new MemberDAO();
                MemberDTO dto = new MemberDTO(IDMember, password, fullName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, subcription, status, token);
                boolean result = dao.createAccount(dto);
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            // Handle SQL exceptions (e.g., duplicate username)
            String msg = ex.getMessage();
            log("CreateAccountServlet _ SQL: " + msg);
            if (msg.contains("duplicate")) {
                foundErr = true;
                accountError.setIDMemberError(IDMember + " is already existed");
                request.setAttribute("CREATE_ERRORS", accountError);
            }
        } catch (ClassNotFoundException ex) {
            // Handle class not found exception
            log("CreateAccountServlet _ ClassNotFound: " + ex.getMessage());
        } finally {
            // Forward the request to the appropriate page
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
