/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import view.LoginView;

/**
 *
 * @author phamn
 */
public class LoginListener implements ActionListener, MouseListener {

    private LoginView loginView;

    public LoginListener(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("X")) {
            this.loginView.click_close();
        }
        else if (button.equals("-")) {
            this.loginView.click_hidden();
        }
    }

    //sự kiện chuột
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    	if (e.getComponent() == this.loginView.jButton_login) {
    		loginView.xuLySuKienDangNhap();
    	}
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() == this.loginView.jButton_close) {
            this.loginView.mouseEntered_button_close();
        }
        else if (e.getComponent() == this.loginView.jButton_login) {
            this.loginView.mouseEntered_login();
        }
        else if (e.getComponent() == this.loginView.jLabel_forgotPass) {
            this.loginView.mouseEntered_forgotPass();
        }
        else if (e.getComponent() == this.loginView.jButton_hidden) {
            this.loginView.mouseEntered_button_hidden();
        }

        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent() == this.loginView.jButton_close) {
            this.loginView.mouseExited_button_close();
        }
        else if (e.getComponent() == this.loginView.jButton_login) {
            this.loginView.mouseExited_login();
        }
        else if (e.getComponent() == this.loginView.jLabel_forgotPass) {
            this.loginView.mouseExited_forgotPass();
        }
        else if (e.getComponent() == this.loginView.jButton_hidden) {
            this.loginView.mouseExited_button_hidden();
        }
        
        
        
    }

}
