<%-- 
    Document   : register
    Created on : Jun 8, 2025, 5:06:01 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

        <link rel="stylesheet" href="assets/css/register.css">

        <title>Register Page</title>
    </head>
    <body>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

        <div class="register-form">
            <div class="container">
                <div class="inner-form">
                    <h2 class="inner-title">Register</h2>
                    <form action="MainController" method="POST">
                        <div class="form-group">
                            <label for="idmember">ID Member</label>
                            <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
                            <input type="text" class="form-control" id="idmember" name="txtIdmember" 
                                   value="${param.txtIdmember}">
                            <c:if test="${not empty errors.IDMemberError}" >
                                <font color="red">
                                ${errors.IDMemberError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="gender">Gender</label>
                            <div class="inner-form-gender">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="txtGender" id="male" value="male"
                                           <c:if test="${param.txtGender eq 'male'}" >checked</c:if>>
                                           <label class="form-check-label" for="male">Male</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="txtGender" id="female" value="female"
                                        <c:if test="${param.txtGender eq 'female'}" >checked</c:if>>
                                        <label class="form-check-label" for="female">Female</label>
                                    </div>
                                <c:if test="${not empty errors.genderError}">
                                    <font color="red">
                                    ${errors.genderError}
                                    </font><br/>
                                </c:if>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="txtEmail" 
                                   value="${param.txtEmail}">
                            <c:if test="${not empty errors.emailError}">
                                <font color="red">
                                ${errors.emailError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="txtPassword" 
                                   value="${param.txtPassword}">
                            <c:if test="${not empty errors.passwordError}" >
                                <font color="red">
                                ${errors.passwordError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="confirm">Confirm Password</label>
                            <input type="password" class="form-control" id="confirm" name="txtConfirm" 
                                   value="${param.txtConfirm}">
                            <c:if test="${not empty errors.cofirmPasswordError}" >
                                <font color="red">
                                ${errors.cofirmPasswordError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="fullname">Full Name</label>
                            <input type="text" class="form-control" id="fullname" name="txtFullname" 
                                   value="${param.txtFullname}">
                            <c:if test="${not empty errors.fullNameError}" >
                                <font color="red">
                                ${errors.fullNameError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="tel" class="form-control" id="phone" name="txtPhone" 
                                   value="${param.txtPhone}">
                            <c:if test="${not empty errors.phoneError}" >
                                <font color="red">
                                ${errors.phoneError}
                                </font><br/>
                            </c:if>
                        </div>

                        <div class="form-group">
                            <label for="address">Address</label>
                            <textarea name="txtAddress" id="address" class="form-control" rows="2">${param.txtAddress}</textarea>
                        </div>

                        <div class="form-group">
                            <label for="dob">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="txtDob" 
                                   value="${param.txtDob}">
                        </div>

                        <button type="submit" class="btn btn-green btn-block" name="btAction" value="Create New Account">Register</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
