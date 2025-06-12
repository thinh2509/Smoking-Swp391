/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smoking.member;

/**
 *
 * @author Thinkpad
 */
public class CreateAccountError {
    private String IDMemberError;
    private String passwordError;
    private String cofirmPasswordError;
    private String fullNameError;
    private String phoneError;
    private String emailError;
    private String genderError;

    public CreateAccountError() {
    }

    public CreateAccountError(String IDMemberError, String passwordError, String cofirmPasswordError, String fullNameError, String phoneError, String emailError, String genderError) {
        this.IDMemberError = IDMemberError;
        this.passwordError = passwordError;
        this.cofirmPasswordError = cofirmPasswordError;
        this.fullNameError = fullNameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.genderError = genderError;
    }

    /**
     * @return the IDMemberError
     */
    public String getIDMemberError() {
        return IDMemberError;
    }

    /**
     * @param IDMemberError the IDMemberError to set
     */
    public void setIDMemberError(String IDMemberError) {
        this.IDMemberError = IDMemberError;
    }

    /**
     * @return the passwordError
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * @return the cofirmPasswordError
     */
    public String getCofirmPasswordError() {
        return cofirmPasswordError;
    }

    /**
     * @param cofirmPasswordError the cofirmPasswordError to set
     */
    public void setCofirmPasswordError(String cofirmPasswordError) {
        this.cofirmPasswordError = cofirmPasswordError;
    }

    /**
     * @return the fullNameError
     */
    public String getFullNameError() {
        return fullNameError;
    }

    /**
     * @param fullNameError the fullNameError to set
     */
    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    /**
     * @return the phoneError
     */
    public String getPhoneError() {
        return phoneError;
    }

    /**
     * @param phoneError the phoneError to set
     */
    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    /**
     * @return the emailError
     */
    public String getEmailError() {
        return emailError;
    }

    /**
     * @param emailError the emailError to set
     */
    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    /**
     * @return the genderError
     */
    public String getGenderError() {
        return genderError;
    }

    /**
     * @param genderError the genderError to set
     */
    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }

    
    
    
}
