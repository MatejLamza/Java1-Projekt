/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import classes.Doctor;
import classes.Schedule;
import classes.Specialization;
import java.util.Scanner;
import model.Repo;

/**
 *
 * @author Meowcake
 */
public class Admin {

    public static void drawAdminMenu() {

        System.out.println("YOU ARE LOGGED IN AS ADMINISTRATOR" + "\n");
        System.out.println("1. Get all general doctors");
        System.out.println("2. Get all specialists");
        System.out.println("3. Doctor manager");
        System.out.println("4. Reports " + "\n");
        System.out.println("Your choice: ");
    }

    public static void getDoctors(int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {

            case 1:
                System.out.println("ALL GENERAL DOCTORS" + "\n");
                for (Object genDoc : Repo.getAllGeneralDoctors()) {
                    System.out.println(genDoc.toString());
                }
                break;

            case 2:
                System.out.println("ALL SPECIALISTS" + "\n");
                for (Doctor allSpecs : Repo.getAllSpecialistDoctors()) {
                    System.out.println(allSpecs.toString());
                }
                break;
            case 3:
                System.out.println("DOCTOR MANAGER" + "\n");
                System.out.println("1. Add new doctor");
                System.out.println("2. Update existing doctor");
                System.out.println("3. Remove certain doctor");
                System.out.println("4. Schedule for certain doctor");
                System.out.println("YOUR CHOICE: ");

                choice = Integer.parseInt(input.nextLine());
                Admin.doctorManager(choice);
                break;

        }
        System.out.println("GOTOV SWITCH");
    }

    public static void doctorManager(int choice) {
        Scanner input = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("ADD A NEW DOCTOR");

                int specId;
                Doctor doc = new Doctor();
                Specialization spec = new Specialization();

                System.out.println("Name: ");
                String name = input.nextLine();
                System.out.println("Surname: ");
                String surname = input.nextLine();
                System.out.println("Specialization :");

                for (Specialization specialization : Repo.getSpecializations()) {
                    System.out.println(specialization.toString());
                }

                System.out.println("Chose specialization");
                specId = Integer.parseInt(input.nextLine());

                for (Specialization specialization : Repo.getSpecializations()) {
                    if (specialization.getIdSpecialization() == specId) {
                        spec = specialization;
                    }
                }

                doc.setName(name);
                doc.setSurname(surname);
                doc.setSpecialization(spec);

                Repo.insertDoctor(doc);
                break;

            case 2:
                System.out.println("UPDATE DOCTOR" + "\n");
                Doctor docUpdated = new Doctor();
                Specialization specUpdated = new Specialization();

                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    System.out.println(allDoctor.toString());
                }

                System.out.println("Chose what doctor to update :");
                int docID = Integer.parseInt(input.nextLine());

                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    if (allDoctor.getIdDoctor() == docID) {
                        docUpdated = allDoctor;
                    }
                }

                System.out.println("What do you want to update? ");
                System.out.println("1. Personal details");
                System.out.println("2. Specialization");

                int temp = Integer.parseInt(input.nextLine());

                switch (temp) {
                    case 1:
                        System.out.println("PERSONAL DETAILS" + "\n");
                        System.out.println("New name: ");
                        String newName = input.nextLine();
                        System.out.println("New surname: ");
                        String newSurname = input.nextLine();

                        docUpdated.setName(newName);
                        docUpdated.setSurname(newSurname);
                        Repo.updateDoctor(docUpdated);
                        break;
                    case 2:
                        System.out.println("SPECIALIZATION" + "\n");
                        for (Specialization specialization : Repo.getSpecializations()) {
                            System.out.println(specialization.toString());
                        }
                        temp = Integer.parseInt(input.nextLine());

                        for (Specialization specialization : Repo.getSpecializations()) {
                            if (specialization.getIdSpecialization() == temp) {
                                specUpdated = specialization;
                            }
                        }
                        docUpdated.setSpecialization(specUpdated);
                        Repo.updateDoctor(docUpdated);
                        break;

                }
                break;
            case 3:
                System.out.println("REMOVE CERTAIN DOCTOR" + "\n");
                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    System.out.println(allDoctor.toString());
                }

                System.out.println("WICH ONE WOULD YOU LIKE TO REMOVE: ");
                temp = Integer.parseInt(input.nextLine());

                Repo.removeDoctor(temp);
                break;
            case 4:
                System.out.println("SCHEDULE FOR CERTAIN DOCTOR" + "\n");
                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    System.out.println(allDoctor.toString());
                }
                
                Doctor docTemp = new Doctor();
                System.out.println("Chose doctor: ");
                temp = Integer.parseInt(input.nextLine());
                
                for (Doctor allDoctor : Repo.getAllDoctors()) {
                    if (allDoctor.getIdDoctor()==temp) {
                      docTemp = allDoctor;
                    }
                }
                
            
                for (Schedule sc : Repo.getScheduleForDoctor(docTemp)) {
                    System.out.println(sc.toString());
                }
                
                
                break;
        }

    }
}
