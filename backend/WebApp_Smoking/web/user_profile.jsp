<%-- 
    Document   : user_profile
    Created on : Jun 13, 2025, 10:55:02 PM
    Author     : Thinkpad
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/user_profile.css">
    </head>

    <body>
        <div class="user-profile">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card profile-card">
                            <div class="profile-header">
                            </div>
                            <div class="text-center profile-image-container">
                                <c:choose >
                                    <c:when test="${empty sessionScope.MEMBER.image}">
                                        <img src="${pageContext.request.contextPath}/assets/image/user.jpg" alt="Avatar" class="profile-image">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="${pageContext.request.contextPath}/assets/image/${sessionScope.MEMBER.image}" alt="Avatar" class="profile-image">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="card-body profile-body">
                                <h3 class="card-title text-center mb-4">Information about User</h3>

                                <div class="detail-row">
                                    <span class="detail-label">ID Member:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.IDMember}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Password:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.password}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Full Name:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.memberName}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Gender:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.gender}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Date of Birth:</span>
                                    <span class="detail-value">
                                        <fmt:formatDate value="${sessionScope.MEMBER.dateOfBirth}" pattern="dd/MM/yyyy"/>                                       
                                    </span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Join Date:</span>
                                    <span class="detail-value">
                                        <fmt:formatDate value="${sessionScope.MEMBER.joinDate}" pattern="dd/MM/yyyy"/>
                                    </span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Phone:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.phone}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Address:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.address}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Email:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.email}</span>
                                </div>
                                <div class="detail-row">
                                    <span class="detail-label">Status:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.status}</span>
                                </div>

                                <div class="detail-row">
                                    <span class="detail-label">ID Coach:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.IDCoach}</span>
                                </div>

                                <div class="detail-row">
                                    <span class="detail-label">Subscription:</span>
                                    <span class="detail-value">${sessionScope.MEMBER.subcription}</span>
                                </div>

                                <div class="text-center mt-4">
                                    <a href="edit.html" class="btn btn-success">
                                        Edit my profile
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2+UjszW/vFfrFWK7xM1uW+R5c+z4fN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
    </body>

</html>
