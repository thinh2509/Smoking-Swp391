<%-- 
    Document   : register
    Created on : Jun 8, 2025, 5:06:01 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <label for="fullname">Full Name</label>
                        <input type="text" class="form-control" name="txtFullname" required>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="txtEmail" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="txtPassword" required>
                    </div>

                    <div class="form-group">
                        <label for="confirm">Confirm Password</label>
                        <input type="password" class="form-control" name="txtConfirm" required>
                    </div>

                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="tel" class="form-control" name="txtPhone" required>
                    </div>

                    <div class="form-group">
                        <label for="phone">Address</label>
                        <textarea name="txtAdress" class="form-control" rows="2" required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="phone">Date of Birth</label>
                        <input type="date" class="form-control" name="txtDob" required>
                    </div>

                    <button type="submit" class="btn btn-green btn-block" value="Create New Account">Register</button>
                </form>
            </div>
        </div>
    </div>
    
  </body>
</html>
