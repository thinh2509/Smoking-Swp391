/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoking.member;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Thinkpad
 */
public class MemberDTO implements Serializable{
    private String IDMember;
    private String password;
    private String memberName;
    private String phone;
    private String email;
    private String address;
    private Date date;
    private Date joinDate;
    private String image;
    private String IDCoach;
    private String subcription;
    private String status;

    /**
     * @return the IDMember
     */
    public String getIDMember() {
        return IDMember;
    }

    /**
     * @param IDMember the IDMember to set
     */
    public void setIDMember(String IDMember) {
        this.IDMember = IDMember;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the IDCoach
     */
    public String getIDCoach() {
        return IDCoach;
    }

    /**
     * @param IDCoach the IDCoach to set
     */
    public void setIDCoach(String IDCoach) {
        this.IDCoach = IDCoach;
    }

    /**
     * @return the subcription
     */
    public String getSubcription() {
        return subcription;
    }

    /**
     * @param subcription the subcription to set
     */
    public void setSubcription(String subcription) {
        this.subcription = subcription;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
