<%-- 
    Document   : user_profile
    Created on : Jun 13, 2025, 10:55:02 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <img src="R.jpg" alt="Ảnh đại diện" class="profile-image">
                        </div>
                        <div class="card-body profile-body">
                            <h3 class="card-title text-center mb-4">Thông tin Hồ sơ</h3>

                            <div class="detail-row">
                                <span class="detail-label">ID thành viên:</span>
                                <span class="detail-value">MEMBER12345</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Mật khẩu:</span>
                                <span class="detail-value">********</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Họ và tên:</span>
                                <span class="detail-value">Nguyễn Văn A</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Giới Tính</span>
                                <span class="detail-value">Nam</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Ngày sinh:</span>
                                <span class="detail-value">01/01/1990</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Ngày tham gia:</span>
                                <span class="detail-value">15/05/2023</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Điện thoại:</span>
                                <span class="detail-value">0901 234 567</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Địa chỉ:</span>
                                <span class="detail-value">123 Đường XYZ, Quận ABC, TP.HCM</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Email:</span>
                                <span class="detail-value">nguyenvana@example.com</span>
                            </div>
                            <div class="detail-row">
                                <span class="detail-label">Trạng thái:</span>
                                <span class="detail-value">Đang hoạt động</span>
                            </div>

                            <div class="detail-row">
                                <span class="detail-label">ID Coach</span>
                                <span class="detail-value">........</span>
                            </div>

                            <div class="detail-row">
                                <span class="detail-label">Mô tả</span>
                                <span class="detail-value">.........</span>
                            </div>

                            <div class="text-center mt-4">
                                <a href="edit.html" class="btn btn-success">
                                    Chỉnh sửa Hồ sơ
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
