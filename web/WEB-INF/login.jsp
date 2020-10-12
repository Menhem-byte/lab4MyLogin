<%-- 
    Document   : login
    Created on : Oct 11, 2020, 9:32:30 PM
    Author     : 789438
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        <form method="POST" action="login">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" value="${user}"></td>
                   
                </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <input type="password" name="password" value="${pass}">
                            </td>
                        </tr>
                        <tr>
                           
                            <td><input type="submit" name="Submit" value="Login"></td>
                             <td>${message}</td>
                        </tr>
            </table>
            
        </form>
    </body>
</html>
