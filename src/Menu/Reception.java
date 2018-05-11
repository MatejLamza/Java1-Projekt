/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import BL.buissnesClass;
import classes.Appointment;
import classes.BasicComplaints;
import classes.Bill;
import classes.BillItem;
import classes.ContactDetails;
import classes.ContactDetailsAdress;
import classes.Doctor;
import classes.ImportantMedicalComplaints;
import classes.LifeStyle;
import classes.Medicine;
import classes.NextOfKin;
import classes.NextOfKinBasic;
import classes.Patient;
import classes.PatientFull;
import classes.PatientRecord;
import classes.PersonalDetails;
import classes.ProfessionDetails;
import classes.Schedule;
import classes.Test;
import classes.Treatment;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import model.Repo;

/**
 *
 * @author Meowcake
 */
public class Reception {
    
    public static void drawReceptionMenu() {
        System.out.println("YOU ARE LOGGED IN AS RECEPTION" + "\n");
        System.out.println("1. Patient registration");
        System.out.println("2. Zakazi sljedeci pregled");
        System.out.println("3. Izdavanje racuna pacijentu");
        System.out.println("ODABERI: ");
        
    }
    
    public static void selectedChoice(int choice) {
        Scanner input = new Scanner(System.in);
        Patient tempPatient = new Patient();
        int tempChoice;
        
        switch (choice) {
            case 1:
                System.out.println("PATIENT REGISTRATIOR" + "\n");
                System.out.println("1. Emergency registration form");
                System.out.println("2. Regular registration form");
                
                int temp = Integer.parseInt(input.nextLine());
                
                if (temp == 1) {
                    System.out.println("EMERGENCY REGISTRATION" + "\n");
                    Patient pat = Reception.createPatient(true);
                    PatientRecord pr = new PatientRecord();
                    
                    Appointment app = Reception.createAppointment(pat);
                    Test test = Reception.createTest();
                    Treatment treatment = Reception.createTreatment(pat.getPatientDoctor());
                    Medicine med = Reception.createMedicine();
                    
                    pr.setAppointment(app);
                    pr.setMedicine(med);
                    pr.setTest(test);
                    pr.setTreatment(treatment);
                    
                    Repo.insertPatientRecord(pr);

                    // dodjeli pacijentu doktora
                    System.out.println("APPOINTMENT DONE");
                    
                } else {
                    PatientFull fullPatient = new PatientFull();
                    System.out.println("REGULAR REGISTRATION FORM" + "\n");
                    
                    Patient patient = Reception.createPatient(false);
                    System.out.println("Is your presnet adress also a pernament one");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int tempAdr = Integer.parseInt(input.nextLine());
                    if (tempAdr == 1) {
                        ContactDetailsAdress pernamentAdress = Reception.createContactAdress();
                        fullPatient.setPernamentAdress(pernamentAdress);
                        fullPatient.setPresentAdress(pernamentAdress);
                    } else {
                        ContactDetailsAdress pernamentAdress = Reception.createContactAdress();
                        fullPatient.setPernamentAdress(pernamentAdress);
                        ContactDetailsAdress presentAdress = Reception.createContactAdress();
                        fullPatient.setPresentAdress(presentAdress);
                    }
                    
                    ContactDetails conDetails = Reception.createContactDetails();
                    NextOfKin nok = Reception.createNextOfKin();
                    PersonalDetails personalDetails = Reception.createPersonalDetails();
                    ProfessionDetails professionDetails = Reception.createProfessionDetails();
                    LifeStyle ls = Reception.createLifeStyle();
                    BasicComplaints basicComplaint = Reception.createBasicComplaints();
                    ImportantMedicalComplaints importantComplaint = Reception.createImportantComplaints();
                    
                    fullPatient.setPatient(patient);
                    
                    fullPatient.setNextOfKinContact(nok);
                    fullPatient.setPersonalDetails(personalDetails);
                    fullPatient.setProfessionDetails(professionDetails);
                    fullPatient.setLifestyle(ls);
                    fullPatient.setBasicComplaints(basicComplaint);
                    fullPatient.setImportantMedComplaints(importantComplaint);
                    fullPatient.setContactDetails(conDetails);
                    
                    System.out.println(fullPatient.toString());
                    Repo.insertFullPatient(fullPatient);

                    //dodjeli paijentu doktora
                }
                
                break;
            case 2:
                System.out.println("MAKE NEW APPOINTMENT" + "\n");
                System.out.println("LIST OF PATIENTS");
                for (Patient allPatient : buissnesClass.getAllPatients()) {
                    System.out.println(allPatient.toString());
                }
                
                System.out.println("\n" + "Select patient for next appointment: ");
                int choicePatient = Integer.parseInt(input.nextLine());
                Patient pat = buissnesClass.getPatientByID(choicePatient);
                

                //provjeri dali je doktor slobodan ako nije dodjeli sljedeceg slobodnog
                System.out.println("\n" + "AVALIVABLE APPOINTMENS");
                for (Schedule schedule : buissnesClass.getAllSchedules()) {
                    System.out.println(schedule.toString());
                }
                System.out.println("Select appointment from list: ");
                int schId = Integer.parseInt(input.nextLine());
                Schedule sc = new Schedule();
                sc.setIdSchedule(schId);
                
                Appointment appointment = new Appointment();
                appointment.setPatient(pat);
                appointment.setSchedule(sc);
                buissnesClass.insertSchedule(sc);
                buissnesClass.updateSchedule(sc);
                
                break;
            case 3:
                Bill bill = new Bill();
                System.out.println("BILLING" + "\n");
                System.out.println("LIST OF PATIENTS");
                for (Patient allPatient : Repo.getAllPatients()) {
                    System.out.println(allPatient.toString());
                }
                System.out.println("Select patient: ");
                choicePatient = Integer.parseInt(input.nextLine());
                tempPatient = buissnesClass.getPatientByID(choicePatient);

                
                //  AKO PACIJENT IMA RACUN PRESKOCI OVO
                // lista racuna i usporedit preko pacijent ID 
//                for (Bill allBill : buissnesClass.getAllBills()) {
//                    if (allBill.getPatient().getIdPatient() == tempPatient.getIdPatient()) {
//                        System.out.println("PATIENT ALREADY HAS ACCOUNT");
//                    }
//                }
                
                System.out.println("Payment Method: ");
                System.out.println("1. Credit card");
                System.out.println("2. Cash");
                
                System.out.println("Chose payment method: ");
                int payMethod = Integer.parseInt(input.nextLine());
                
                if (payMethod == 1) {
                    bill.setPaymentMethod("Credit card");
                } else {
                    bill.setPaymentMethod("Cash");
                }
                
                bill.setPatient(tempPatient);
                buissnesClass.insertBill(bill);
                
               
                // ZAVRSI UVIJET
                BillItem itemBill = new BillItem();
                
                System.out.println("Service you are charging: ");
                System.out.println("1. Treatment");
                System.out.println("2. Medicine");
                System.out.println("3. Consultaions");
                System.out.println("\n" + "Select service: ");
                tempChoice = Integer.parseInt(input.nextLine());
                
                switch (tempChoice) {
                    case 1:
                        double itemPrice = 250;
                        System.out.println("How many hours of treatment: ");
                        int itemQuantity = Integer.parseInt(input.nextLine());
                        
                        itemBill.setItemPrice(itemPrice * itemQuantity);
                        itemBill.setItemName("Treatment");
                        itemBill.setItemQuantity(itemQuantity);
                        itemBill.setBill(bill);
                        
                        buissnesClass.insertBillItem(itemBill);
                        break;
                    case 2:
                        itemPrice = 30;
                        System.out.println("How many medicines patient took: ");
                        itemQuantity = Integer.parseInt(input.nextLine());
                        
                        itemBill.setItemName("Medicine");
                        itemBill.setItemPrice(itemPrice * itemQuantity);
                        itemBill.setItemQuantity(itemQuantity);
                        itemBill.setBill(bill);
                        
                        buissnesClass.insertBillItem(itemBill);
                        break;
                    case 3:
                        itemPrice = 50;
                        System.out.println("How many hours of consultations: ");
                        itemQuantity = Integer.parseInt(input.nextLine());
                        
                        itemBill.setItemName("Consultations");
                        itemBill.setItemPrice(itemPrice * itemQuantity);
                        itemBill.setItemQuantity(itemQuantity);
                        itemBill.setBill(bill);
                        
                        buissnesClass.insertBillItem(itemBill);
                        break;
                }
        }
    }
    
    public static NextOfKinBasic createNextOfKinBasic() {
        Scanner input = new Scanner(System.in);
        NextOfKinBasic nokBasic = new NextOfKinBasic();
        
        System.out.println("NEXT OF KIN INFORMATION" + "\n");
        System.out.println("Name: ");
        nokBasic.setName(input.nextLine());
        
        System.out.println("Middlename");
        nokBasic.setMiddleName(input.nextLine());
        
        System.out.println("Surname: ");
        nokBasic.setSurname(input.nextLine());
        
        System.out.println("Relationship to outpatient: ");
        nokBasic.setRelationshipToPatient(input.nextLine());
        
        buissnesClass.insertNextOfKinBasic(nokBasic);
        
        return nokBasic;
    }
    
    public static Patient createPatient(boolean isEmergency) {
        Scanner input = new Scanner(System.in);
        Patient patient = new Patient();
        
        System.out.println("Name: ");
        patient.setName(input.nextLine());
        
        System.out.println("Middlename: ");
        patient.setMiddleName(input.nextLine());
        
        System.out.println("Surname: ");
        patient.setSurname(input.nextLine());
        
        System.out.println("Sex: ");
        patient.setSex(input.nextLine().charAt(0));
        
        System.out.println("Date of birth (yyyy-MM-dd): ");
        patient.setDateOfBirth(LocalDate.parse(input.nextLine()));
        patient.setIsFollowUp(false);
        
        for (Doctor allDoctor : Repo.getAllDoctors()) {
            System.out.println(allDoctor.toString());
        }
        
        System.out.println("Assign doctor to patient: ");
        int docId = Integer.parseInt(input.nextLine());
        
        Doctor docTemp = Repo.getDoctor(docId);
        patient.setPatientDoctor(docTemp);
        
        if (isEmergency) {
            System.out.println("Brief statment of complaint: ");
            patient.setStatmentOfComplaint(input.nextLine());
            
            System.out.println("Contact: ");
            patient.setContact1(input.nextLine());
            
            System.out.println("Contact2: ");
            patient.setContact2(input.nextLine());
            
            NextOfKinBasic tempBasic = Reception.createNextOfKinBasic();
            
            patient.setNextOfKinBasic(tempBasic);
            
            buissnesClass.insertPatient(patient);
            
        } else {
            NextOfKinBasic nokBasic = Reception.createNextOfKin().getNextOfKinBasic();
            patient.setNextOfKinBasic(nokBasic);
            buissnesClass.insertPatient(patient);
        }
        
        return patient;
    }
    
    public static ContactDetails createContactDetails() {
        Scanner input = new Scanner(System.in);
        ContactDetails contact = new ContactDetails();
        
        System.out.println("CONTACT DETAILS" + "\n");
        System.out.println("Telephone work: ");
        contact.setTelephoneWork(input.nextLine());
        
        System.out.println("Telephone home: ");
        contact.setTelephoneHome(input.nextLine());
        
        System.out.println("Mobile: ");
        contact.setMobile(input.nextLine());
        
        System.out.println("Pager: ");
        contact.setPager(input.nextLine());
        
        System.out.println("Fax: ");
        contact.setFax(input.nextLine());
        
        System.out.println("Email: ");
        contact.setEmail(input.nextLine());
        
        buissnesClass.insertContactDetails(contact);
        return contact;
    }
    
    public static ContactDetailsAdress createContactAdress() {
        Scanner input = new Scanner(System.in);
        ContactDetailsAdress adress = new ContactDetailsAdress();
        
        System.out.println("Door number: ");
        adress.setDoorNumber(input.nextLine());
        
        System.out.println("Street: ");
        adress.setStreet(input.nextLine());
        
        System.out.println("Area: ");
        adress.setArea(input.nextLine());
        
        System.out.println("City: ");
        adress.setCity(input.nextLine());
        
        System.out.println("State: ");
        adress.setState(input.nextLine());
        
        System.out.println("Pincode: ");
        adress.setPincode(input.nextLine());
        
        buissnesClass.insertAdress(adress);
        return adress;
    }
    
    public static NextOfKin createNextOfKin() {
        Scanner input = new Scanner(System.in);
        NextOfKin nok = new NextOfKin();
        
        NextOfKinBasic nokBasic = Reception.createNextOfKinBasic();
        ContactDetails conDetails = Reception.createContactDetails();
        ContactDetailsAdress adressDetails = Reception.createContactAdress();

//        nokBasic.setIdNextOfKinBasic(Repo.getLastNextOfKinBasic().getIdNextOfKinBasic());
//        conDetails.setIdContactDetails(Repo.getLastContactDetails().getIdContactDetails());
//        adressDetails.setIdContactDetailAdress(Repo.getLastAdressDetails().getIdContactDetailAdress());
        nok.setNextOfKinBasic(nokBasic);
        nok.setContactDetails(conDetails);
        nok.setContactDetailsAdress(adressDetails);
        
        buissnesClass.insertNextOfKin(nok);
        return nok;
    }
    
    public static PersonalDetails createPersonalDetails() {
        Scanner input = new Scanner(System.in);
        PersonalDetails details = new PersonalDetails();
        
        System.out.println("PERSONAL DETAILS" + "\n");
        System.out.println("Martial status: ");
        details.setMartialStatus(input.nextLine());
        
        System.out.println("Number of Dependents: ");
        details.setNumberOfDependents(Integer.parseInt(input.nextLine()));
        
        System.out.println("Height: ");
        details.setHeight(Double.parseDouble(input.nextLine()));
        
        System.out.println("Weight: ");
        details.setWeight(Double.parseDouble(input.nextLine()));
        
        System.out.println("Blood type: ");
        details.setBloodType(input.nextLine());
        
        buissnesClass.insertPersonalDetails(details);
        return details;
    }
    
    public static ProfessionDetails createProfessionDetails() {
        Scanner input = new Scanner(System.in);
        ProfessionDetails professionDetails = new ProfessionDetails();
        
        System.out.println("PROFESSION DETAILS" + "\n");
        System.out.println("Occupation : ");
        professionDetails.setOccupation(input.nextLine());
        
        System.out.println("Gross Anual Income: ");
        professionDetails.setGrossAnnualIncome(Integer.parseInt(input.nextLine()));

        //TODO: create business layer, send proffesionDetails as object
        // business layer will handle it, and communicate with repo
        buissnesClass.insertProfessionDetails(professionDetails);
        
        professionDetails.setIdProfessionDetails(Repo.getLastProfessionDetails().getIdProfessionDetails());
        
        return professionDetails;
    }
    
    public static LifeStyle createLifeStyle() {
        Scanner input = new Scanner(System.in);
        LifeStyle ls = new LifeStyle();
        
        System.out.println("LIFESTYLE" + "\n");
        System.out.println("Vegetarian/Non-Vegetarian: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        
        int vegeterian = Integer.parseInt(input.nextLine());
        boolean isVegeterian = false;
        
        if (vegeterian == 1) {
            isVegeterian = true;
        }
        ls.setVegeterian(isVegeterian);
        
        System.out.println("Smoker: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int smoker = Integer.parseInt(input.nextLine());
        boolean isSmoker = false;
        
        if (smoker == 1) {
            isSmoker = true;
        }
        ls.setSmoker(isSmoker);
        
        if (isSmoker) {
            System.out.println("Average Nu. of Cigarettes/Day: ");
            ls.setAvgNoCigarettes(Integer.parseInt(input.nextLine()));
        }
        
        System.out.println("Consume Alcoolic Beverage: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int alcoholic = Integer.parseInt(input.nextLine());
        boolean isAlcoholic = false;
        
        if (alcoholic == 1) {
            isAlcoholic = true;
        }
        ls.setAlcoholic(isAlcoholic);
        
        if (isAlcoholic) {
            System.out.println("Average No. of Drinks/Day: ");
            ls.setAvgNoDrinks(Integer.parseInt(input.nextLine()));
        }
        
        System.out.println("Use Stimulants (Specify / if not leave empty): ");
        ls.setUseStimulants(input.nextLine());
        
        System.out.println("Consumption of Coffe-Tea/Day: ");
        ls.setNoCofeTeaDay(Integer.parseInt(input.nextLine()));
        
        System.out.println("Consumption of Soft Drinks/Day: ");
        ls.setNoSoftDrinksDay(Integer.parseInt(input.nextLine()));
        
        System.out.println("Have Regular Meals (Breakfast/Lunch/Dinner): ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int regMeals = Integer.parseInt(input.nextLine());
        boolean haveRegMeals = false;
        
        if (regMeals == 1) {
            haveRegMeals = true;
        }
        ls.setHaveRegularMeals(haveRegMeals);
        
        System.out.println("Eat Home Food/Outside Predominantly: ");
        System.out.println("1. Home food");
        System.out.println("2. Outside food");
        int homeFood = Integer.parseInt(input.nextLine());
        boolean isHavingHomeFood = false;
        
        if (homeFood == 1) {
            isHavingHomeFood = true;
        }
        ls.setHaveHomeFood(isHavingHomeFood);
        
        buissnesClass.insertLifeStyle(ls);
        return ls;
    }
    
    public static BasicComplaints createBasicComplaints() {
        Scanner input = new Scanner(System.in);
        BasicComplaints basicComp = new BasicComplaints();
        
        System.out.println("BASIC COMPLAINTS" + "\n");
        System.out.println("Statment of complaint: ");
        basicComp.setStatmentOfComplaint(input.nextLine());
        
        System.out.println("History of Previous Treatments: ");
        basicComp.setHistoryOfPreviousTreatment(input.nextLine());
        
        System.out.println("Physician/Hospital Treated: ");
        basicComp.setPhysicianOrHospital(input.nextLine());
        
        buissnesClass.insertBasicComplaint(basicComp);
        return basicComp;
    }
    
    public static ImportantMedicalComplaints createImportantComplaints() {
        Scanner input = new Scanner(System.in);
        ImportantMedicalComplaints importantComplaint = new ImportantMedicalComplaints();
        
        System.out.println("IMPORTANT MEDICAL COMPLAINTS" + "\n");
        
        System.out.println("Diabetic: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int diabetic = Integer.parseInt(input.nextLine());
        boolean isDiabetic = false;
        if (diabetic == 1) {
            isDiabetic = true;
        }
        importantComplaint.setIsDiabetic(isDiabetic);
        
        System.out.println("Hypertensive: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int hypertensive = Integer.parseInt(input.nextLine());
        boolean isHypertensive = false;
        if (hypertensive == 1) {
            isHypertensive = true;
        }
        importantComplaint.setIsHypertensive(isHypertensive);
        
        System.out.println("Cardiac Condition: ");
        importantComplaint.setCardiacCondition(input.nextLine());
        
        System.out.println("Digestive Condition: ");
        importantComplaint.setDigestiveCondition(input.nextLine());
        
        System.out.println("Orthopedic Condition: ");
        importantComplaint.setOrthopedicCondition(input.nextLine());
        
        System.out.println("Muscular Condition: ");
        importantComplaint.setMuscularCondition(input.nextLine());
        
        System.out.println("Neurological Condition: ");
        importantComplaint.setNeurologicalCondition(input.nextLine());
        
        System.out.println("Known allergies: ");
        importantComplaint.setKnownAllergies(input.nextLine());
        
        System.out.println("Known Adverse Reaction to Specific Drugs: ");
        importantComplaint.setKnownReactionToSpecDrugs(input.nextLine());
        
        System.out.println("Major Surgeries (History): ");
        importantComplaint.setMajorSurgeries(input.nextLine());
        
        buissnesClass.insertImportantComplaints(importantComplaint);
        return importantComplaint;
    }
    
    public static Appointment createAppointment(Patient pat) {
        Scanner input = new Scanner(System.in);
        Appointment appointment = new Appointment();
        Schedule sc = new Schedule();
        
        System.out.println("APPOINTMENT" + "\n");
        System.out.println("Diagnose: ");
        appointment.setDiagnose(input.nextLine());
        
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        sc.setDate(date);
        sc.setTime(time);
        sc.setIsAvailable(false);
        sc.setDoctor(pat.getPatientDoctor());
        
        buissnesClass.insertSchedule(sc);
        
        appointment.setPatient(pat);
        appointment.setSchedule(sc);
        
        buissnesClass.insertAppointment(appointment);
        return appointment;
    }
    
    public static Treatment createTreatment(Doctor doc) {
        Scanner input = new Scanner(System.in);
        Treatment treatment = new Treatment();
        
        System.out.println("TREATMENT" + "\n");
        System.out.println("Doctor Note: ");
        treatment.setDoctorNote(input.nextLine());
        
        treatment.setDoctor(doc);
        
        buissnesClass.insertTreatment(treatment);
        return treatment;
    }
    
    public static Test createTest() {
        Scanner input = new Scanner(System.in);
        Test test = new Test();
        
        System.out.println("MEDICAL TEST" + "\n");
        System.out.println("Test Name");
        test.setTestName(input.nextLine());
        
        System.out.println("Test Result: ");
        test.setTestResult(input.nextLine());
        
        buissnesClass.insertTest(test);
        return test;
    }
    
    public static Medicine createMedicine() {
        Scanner input = new Scanner(System.in);
        Medicine medicine = new Medicine();
        
        System.out.println("MEDICINE" + "\n");
        System.out.println("Medicine Name: ");
        medicine.setName(input.nextLine());
        
        buissnesClass.insertMedicine(medicine);
        return medicine;
    }
    
}
