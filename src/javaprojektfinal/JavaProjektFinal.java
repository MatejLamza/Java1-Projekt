/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojektfinal;

import BL.buissnesClass;
import Menu.Admin;
import Menu.DoctorMenu;
import Menu.MainMenu;
import Menu.Reception;
import classes.*;
import classes.Treatment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.Repo;

/**
 *
 * @author Meowcake
 */
public class JavaProjektFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        int choice;

        //  do {
//        MainMenu.drawMainMenu();
//        choice = Integer.parseInt(input.nextLine());
//
//        switch (choice) {
//            case 1:
//                Admin.drawAdminMenu();
//                choice = Integer.parseInt(input.nextLine());
//                Admin.getDoctors(choice);
//
//                break;
//            case 2:
//                Reception.drawReceptionMenu();
//                choice = Integer.parseInt(input.nextLine());
//                Reception.selectedChoice(choice);
//                break;
//            case 3:
//                DoctorMenu.drawDoctorMenu();
//                choice = Integer.parseInt(input.nextLine());
//                DoctorMenu.selectedChoice(choice);
//        }
//           

    ProfessionDetails profDetails = Repo.getLastProfessionDetails();
    PersonalDetails personalDetails = Repo.getLastPersonalDetails();
    LifeStyle ls = Repo.getLastLifeStyle();
    ContactDetails conDetails = Repo.getLastContactDetails();
    BasicComplaints basicComplaints = Repo.getLastBasicComplaint();
    ImportantMedicalComplaints importComplaints = Repo.getLastImportantComplaint();
    NextOfKinBasic nokBasic = Repo.getLastNextOfKinBasic();
    NextOfKin nok = Repo.getLastNextOfKin();
    Patient pat = Repo.getLastPatient();
    ContactDetailsAdress pernamentAdress = Repo.getLastAdressDetails();
    ContactDetailsAdress presentAdress = pernamentAdress;
    
    PatientFull pf = new PatientFull();
    pf.setBasicComplaints(basicComplaints);
    pf.setContactDetails(conDetails);
    pf.setImportantMedComplaints(importComplaints);
    pf.setLifestyle(ls);
    pf.setNextOfKinContact(nok);
    pf.setPatient(pat);
    pf.setPernamentAdress(pernamentAdress);
    pf.setPresentAdress(presentAdress);
    pf.setProfessionDetails(profDetails);
    
    Repo.insertFullPatient(pf);

        //} while (choice != 0);
    }

}
