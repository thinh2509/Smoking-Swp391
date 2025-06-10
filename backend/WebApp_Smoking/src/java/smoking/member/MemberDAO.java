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
                        + "image, IDCoach, subcription, status "
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
                    dto = new MemberDTO(IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, subcription, status);
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
                        + "image, IDCoach, subcription, status "
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
                    dto = new MemberDTO(IDMember, password, memberName, gender, phone, email, address, dateOfBirth, joinDate, image, IDCoach, subcription, status);
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
}
