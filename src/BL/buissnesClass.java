/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BL;

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
import classes.PersonalDetails;
import classes.ProfessionDetails;
import classes.Schedule;
import classes.Specialization;
import classes.Test;
import classes.Treatment;
import java.util.ArrayList;
import model.Repo;

/**
*
* @author Meowcake
*/

public class buissnesClass {
    
    public static void insertNextOfKinBasic(NextOfKinBasic nokBasic){
        Repo.insertNextOfKinBasic(nokBasic);
        nokBasic.setIdNextOfKinBasic(Repo.getLastNextOfKinBasic().getIdNextOfKinBasic());
    }
    
    public static void insertProfessionDetails(ProfessionDetails details){
        Repo.insertProfessionDetails(details);
        //Obradit exception
    }
    
    public static void insertPatient(Patient patient){
        Repo.insertPatient(patient);
        patient.setIdPatient(Repo.getLastPatient().getIdPatient());
    }
    
    public static void insertContactDetails(ContactDetails contact){
        Repo.insertContactDetails(contact);
        contact.setIdContactDetails(Repo.getLastContactDetails().getIdContactDetails());
    }
    
    public static void insertAdress(ContactDetailsAdress adress){
        Repo.insertContactDetailsAdress(adress);
        adress.setIdContactDetailAdress(Repo.getLastAdressDetails().getIdContactDetailAdress());
    }
    
    public static void insertNextOfKin(NextOfKin nok){
        Repo.insertNextOfKin(nok);
        nok.setIdNextOfKin(Repo.getLastNextOfKin().getIdNextOfKin());
    }
    
    public static void insertPersonalDetails(PersonalDetails details){
        Repo.insertPersonalDetails(details);
        details.setIdPersonalDetails(Repo.getLastPersonalDetails().getIdPersonalDetails());
    }
    
    public static void insertLifeStyle(LifeStyle ls){
        Repo.insertLifestyle(ls);
        ls.setIdLifeStyle(Repo.getLastLifeStyle().getIdLifeStyle());
    }
    
    public static void insertBasicComplaint(BasicComplaints basicComplaint){
        Repo.insertBasicComplaints(basicComplaint);
        basicComplaint.setIdBasicComplaints(Repo.getLastBasicComplaint().getIdBasicComplaints());
    }
    
    public static void insertImportantComplaints(ImportantMedicalComplaints complaints){
        Repo.insertImportantComplaints(complaints);
        complaints.setIdImportantMedicalComplaints(Repo.getLastImportantComplaint().getIdImportantMedicalComplaints());
    }
    
    public static void insertSchedule(Schedule sc){
        Repo.insertSchedule(sc);
        sc.setIdSchedule(Repo.getLastSchedule().getIdSchedule());
    }
    
    public static void insertAppointment(Appointment appointment){
        Repo.createAppointment(appointment);
        appointment.setIdAppointment(Repo.getLastAppointment().getIdAppointment());
    }
    
    public static void insertTreatment(Treatment treatment){
        Repo.insertTreatment(treatment);
        treatment.setIdTreatment(Repo.getLastTreatment().getIdTreatment());
    }
    
    public static void insertTest(Test test){
        Repo.insertTest(test);
        test.setIdTest(Repo.getLastTest().getIdTest());
    }
    
    public static void insertMedicine(Medicine med ){
        Repo.insertMedicine(med);
        med.setIdMedicine(Repo.getLastMedicine().getIdMedicine());
    }
    
    public static Patient getPatientByID(int idPatient){
        Patient patient = Repo.getPatient(idPatient);
        return  patient;
    }
    
    public static ArrayList<Bill> getAllBills(){
        ArrayList<Bill> allBills = Repo.getAllBills();
        return allBills;
    }
    
    public static void updateSchedule(Schedule sc){
        Repo.updateSchedule(sc);
    }
    
    public static void insertBill(Bill bill){
        Repo.createBill(bill);
        bill.setIdBill(Repo.getLastBill().getIdBill());
    }
    
    public static void insertBillItem(BillItem item){
        Repo.insertBillItem(item);
    }
    
    public static ArrayList<Patient> getAllPatients(){
        ArrayList<Patient> allPatients = Repo.getAllPatients();
        return allPatients;
    }
    
    public static ArrayList<Schedule> getAllSchedules(){
        ArrayList<Schedule> allSchedules = Repo.getSchedule();
        return allSchedules;
    }
    
    public static ArrayList<Doctor> getAllGeneralDoctors(){
        ArrayList<Doctor> allGenDoctors = Repo.getAllGeneralDoctors();
        return  allGenDoctors;
    }
    
    public static ArrayList<Doctor> getAllSpecialists(){
        ArrayList<Doctor> allSpecialists = Repo.getAllSpecialistDoctors();
        return allSpecialists;
    }
    
    public static void insertSpecialization(Specialization spec){
        Repo.insertSpecialization(spec.getSpecialization());
    }
    
    public static void insertDoctor(Doctor doc){
        Repo.insertDoctor(doc);
    }
    
    public static Specialization getLastSpecialization(){
        Specialization spec = Repo.getLastSpecialization();
        return spec;
    }
    
    public static ArrayList<Doctor> getAllDoctors(){
        ArrayList<Doctor> allDoctors = Repo.getAllDoctors();
        return allDoctors;
    }
    
    public static void updatePatientsDoctor(int docId, int patId){
        Repo.updatePatientsDoctor(patId, docId);
    }

}
