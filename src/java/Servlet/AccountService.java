/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

/**
 *
 * @author 789438
 */
public class AccountService {
    public User login(String username,String password){
    
        if((username.equalsIgnoreCase("adam") || username.equalsIgnoreCase("betty")) && password.equalsIgnoreCase("password"))
            
            return new User(username,null);
        
        return null;
    
        }
}
