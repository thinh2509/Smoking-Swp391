/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import smoking.member.MemberDAO;
import smoking.member.MemberDTO;

/**
 *
 * @author Thinkpad
 */
@WebServlet(name = "CheckCookiesServlet", urlPatterns = {"/CheckCookiesServlet"})
public class CheckCookiesServlet extends HttpServlet {

    private final String LOGIN_PAGE = "index.html";
    private final String HOME_PAGE = "home_member.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            // 1. Get all cookies
            Cookie[] cookies = request.getCookies();
            String token = null;
            // 2. check existed cookies
            if(cookies != null){
                for(Cookie cookie : cookies) {
                    if("login_token".equals(cookie.getName())){
                        token = cookie.getValue();
                        break;
                    }
                }
            }// End cookies have EXISTED
            // if find token in cookie
            if (token != null) {
                MemberDAO dao = new MemberDAO();
                MemberDTO result = dao.checkLoginByToken(token);
                if (result != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("MEMBER", result);
                    url = HOME_PAGE;
                }
            }// End token have EXISTED
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            // dùng cái gì cũng được tại vì cookie vẫn nằm trong file không mất luôn luôn tồn tại
            response.sendRedirect(url);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
