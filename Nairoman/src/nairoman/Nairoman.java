/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nairoman;

import Controller.Controller;
import Views.vMain;

/**
 *
 * @author Jhonny
 */
public class Nairoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller c=new Controller();
        vMain principal=new vMain(c);
        principal.setVisible(true);
    }
    
}
