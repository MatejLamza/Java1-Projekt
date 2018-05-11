/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import BL.buissnesClass;
import classes.Doctor;
import classes.Patient;
import classes.PatientRecord;
import java.util.ArrayList;
import java.util.Scanner;
import model.Repo;

/**
 *
 * @author Meowcake
 */
public class DoctorMenu {

    public static void drawDoctorMenu() {
        System.out.println("YOU ARE LOGGED IN AS DOCTOR" + "\n");
        System.out.println("1. Search for patient record");
        System.out.println("2. Recommend patient to specialist");
        System.out.println("3. Treat patient");
        System.out.println("4. Make new appointment");
    }

    public static void selectedChoice(int choice) {
        Scanner input = new Scanner(System.in);
        int tempChoice;

        ArrayList<Patient> patientCollection = buissnesClass.getAllPatients();

        switch (choice) {
            case 1:
                System.out.println("PATIENT RECORDS" + "\n");
                System.out.println("LIST OF PATIENTS");
                for (Object allPatient : patientCollection) {
                    System.out.println(allPatient.toString());

                }
                System.out.println("Select patient: ");
                tempChoice = Integer.parseInt(input.nextLine());

                
                ArrayList<PatientRecord> pr = Repo.getPatientRecord(tempChoice);
                System.out.println(pr.toString());
                break;
            case 2:
                System.out.println("RECCOMENDATION TO OTHER DOCTOR" + "\n");
                System.out.println("LIST OF PATIENTS");
                for (Patient allPatient : Repo.getAllPatients()) {
                    System.out.println(allPatient.toString());
                }
                System.out.println("Select Patient: ");
                tempChoice = Integer.parseInt(input.nextLine());

                System.out.println("TO WICH DOCTOR YOU WANT TO RECOMMEND YOUR PATIENT: ");
                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    System.out.println(allDoctor.toString());
                }
                System.out.println("Chose: ");
                int tempDocID = Integer.parseInt(input.nextLine());

                Repo.updatePatientsDoctor(tempChoice, tempDocID);
                break;
            case 3:
                System.out.println("PATIENT TREATMENT" + "\n");
                System.out.println("Patient: ");

                ArrayList<Patient> copyList = new ArrayList<>();
                String fullName = input.nextLine();
                
                String name = getNameFromFullName(fullName);
                String surname = getSurnameFromFullName(fullName);

                for (Patient patient : patientCollection) {
                    if (patient.getName().contains(name) && patient.getSurname().contains(surname)) {
                        copyList.add(patient);
                    }
                }
                
                for (Patient patient : copyList) {
                    System.out.println(patient.toString());
                }

                break;
        }
    }
    
    public static String getNameFromFullName(String fullName){
        String[] splited = fullName.split(" ");
        String name = splited[0];
        
        return name;
    }
    
    public static String getSurnameFromFullName(String fullName){
        String[] splited = fullName.split(" ");
        String surname = splited[1];
        
        return surname;
    }
    
    public static String getSpecialization(String fullName){
        String[] splited = fullName.split(" ");
        String spec = splited[2];
        
        return spec;
    }

} 
