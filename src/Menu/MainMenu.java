/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Meowcake
 */
public class MainMenu {

    public static void drawMainMenu() {

        System.out.println("----M E N U----" + "\n");
            System.out.println("1. Administrator");
            System.out.println("2. Reception");
            System.out.println("3. Doctor");
            System.out.println("0. EXIT" + "\n");
            System.out.println("YOUR CHOICE:");
        
    }
    
    public static void getChosenUser(int choice){
        switch(choice){
            case 1:
                Admin.drawAdminMenu();
                break;
        }
    }
}
