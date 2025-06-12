/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoking.member;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtils;

/**
 *
 * @author Thinkpad
 */
public class MemberDAO implements Serializable {

    public MemberDTO checkLogin(String IDMember, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        MemberDTO dto = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select memberName, gender, phone, email, address, dateOfBirth, joinDate, "
                        + "image, IDCoach, subcription, status, token "
                        + "From Member "
                        + "Where IDMember = ? "
                        + "And password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, IDMember);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String memberName = rs.getString("memberName");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    Date dateOfBirth = rs.getDate("dateOfBirth");
                    Date joinDate = rs.getDate("joinDate");
                    String image = rs.getString("image");
                    String IDCoach = rs.getString("IDCoach");
                    String subcription = rs.getString("subcription");
                    String status = rs.getString("status");
                    String token = rs.getString("token");
                    dto = new MemberDTO(IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, subcription, status, token);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto;
    }

    public void saveLoginToken(String IDMember, String token) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Update Member "
                        + "Set token = ? "
                        + "Where IDMember = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, token);
                stm.setString(2, IDMember);
                stm.executeUpdate();

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public MemberDTO checkLoginByToken(String token) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        MemberDTO dto = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, "
                        + "image, IDCoach, subcription, status, token "
                        + "From Member "
                        + "Where token = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, token);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String IDMember = rs.getString("IDMember");
                    // Assuming you might need the password for the DTO constructor, even if not directly used for token validation
                    String password = rs.getString("password");
                    String memberName = rs.getString("memberName");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    Date dateOfBirth = rs.getDate("dateOfBirth");
                    Date joinDate = rs.getDate("joinDate");
                    String image = rs.getString("image");
                    String IDCoach = rs.getString("IDCoach");
                    String subcription = rs.getString("subcription");
                    String status = rs.getString("status");
                    dto = new MemberDTO(IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, subcription, status, token);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return dto; // Return the populated DTO
    }

    public boolean createAccount(MemberDTO account) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert into Member ("
                        + "IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, "
                        + "subcription, status, token"
                        + ") Values ("
                        + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? "
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, account.getIDMember());
                stm.setString(2, account.getPassword());
                stm.setString(3, account.getMemberName());
                stm.setString(4, account.getGender());
                stm.setString(5, account.getPhone());
                stm.setString(6, account.getEmail());
                stm.setString(7, account.getAddress());
                stm.setDate(8, new java.sql.Date(account.getDateOfBirth().getTime()));
                stm.setDate(9, new java.sql.Date(account.getJoinDate().getTime()));
                stm.setString(10, account.getImage());
                stm.setString(11, account.getIDCoach());
                stm.setString(12, account.getSubcription());
                stm.setString(13, account.getStatus());
                stm.setString(14, account.getToken());
                //execute
                int effectRows = stm.executeUpdate();
                //proccess
                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
