/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import classes.Specialization;
import classes.Test;
import classes.Treatment;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.sql.DataSource;

/**
 *
 * @author Meowcake
 */
public interface IRepo {

    public abstract DataSource getSQLDataSource()
            throws Exception;

    public abstract void insertSpecialization(String specialization)
            throws Exception;

    public abstract void insertDoctor(Doctor doctor)
            throws Exception;

    public abstract ArrayList<Specialization> getSpecializations()
            throws Exception;

    public abstract ArrayList<Doctor> getAllGeneralDoctors()
            throws Exception;

    public abstract ArrayList<Doctor> getAllSpecialistDoctors()
            throws Exception;

    public abstract ArrayList<Doctor> getAllDoctors()
            throws Exception;

    public abstract void updateDoctor(Doctor doctor)
            throws Exception;

    public abstract void removeDoctor(int idDoctor)
            throws Exception;

    public abstract void insertNextOfKinBasic(NextOfKinBasic nextOfKinBasic)
            throws Exception;

    public abstract void insertPatient(Patient patient)
            throws Exception;

    public abstract ArrayList<NextOfKinBasic> getAllNextOFKinBasic()
            throws Exception;

    public abstract ArrayList<Patient> getAllPatients()
            throws Exception;

    public abstract ArrayList<Schedule> getSchedule()
            throws Exception;

    public abstract void createAppointment(Appointment appointment)
            throws Exception;

    public abstract void insertTest(Test test)
            throws Exception;

    public abstract void insertTreatment(Treatment treatment)
            throws Exception;

    public abstract void insertMedicine(Medicine medicine)
            throws Exception;

    public abstract void insertPatientRecord(PatientRecord pr)
            throws Exception;

    public abstract void insertSchedule(Schedule schedule)
            throws Exception;

    public abstract ArrayList<Test> getTests()
            throws Exception;

    public abstract ArrayList<Medicine> getMedicines()
            throws Exception;

    public abstract ArrayList<Treatment> getTreatments()
            throws Exception;

    public abstract ArrayList<Appointment> getAppointments()
            throws Exception;

    public abstract Test getLastTest()
            throws Exception;

    public abstract Medicine getLastMedicine()
            throws Exception;

    public abstract Treatment getLastTreatment()
            throws Exception;

    public abstract void updateAppointment(Appointment appointment)
            throws Exception;

    public abstract void updateSchedule(Schedule sc)
            throws Exception;

    public abstract ArrayList<Schedule> getScheduleForDoctor(Doctor docID)
            throws Exception;

    public abstract NextOfKinBasic getLastNextOfKinBasic()
            throws Exception;

    public abstract void insertContactDetails(ContactDetails conDetails)
            throws Exception;

    public abstract ContactDetails getLastContactDetails()
            throws Exception;

    public abstract void insertContactDetailsAdress(ContactDetailsAdress adress)
            throws Exception;

    public abstract ContactDetailsAdress getLastAdressDetails()
            throws Exception;

    public abstract void insertNextOfKin(NextOfKin nok)
            throws Exception;

    public abstract NextOfKin getLastNextOfKin()
            throws Exception;

    public abstract void insertPersonalDetails(PersonalDetails details)
            throws Exception;

    public abstract PersonalDetails getLastPersonalDetails()
            throws Exception;

    public abstract void insertProfessionDetails(ProfessionDetails professionDetails)
            throws Exception;

    public abstract ProfessionDetails getLastProfessionDetails()
            throws Exception;

    public abstract void insertLifestyle(LifeStyle ls)
            throws Exception;

    public abstract LifeStyle getLastLifeStyle()
            throws Exception;

    public abstract void insertBasicComplaints(BasicComplaints complaints)
            throws Exception;

    public abstract BasicComplaints getLastBasicComplaint()
            throws Exception;

    public abstract void insertImportantComplaints(ImportantMedicalComplaints complaint)
            throws Exception;

    public abstract ImportantMedicalComplaints getLastImportantComplaint()
            throws Exception;

    public abstract void insertFullPatient(PatientFull fullPatient)
            throws Exception;

    public abstract void insertPartialPatient(Patient patient)
            throws Exception;

    public abstract Patient getLastPatient()
            throws Exception;

    public abstract void createBill(Bill bill)
            throws Exception;

    public abstract Bill getPatientBill(int idPatient)
            throws Exception;

    public abstract void insertBillItem(BillItem item)
            throws Exception;

    public abstract Appointment getLastAppointment()
            throws Exception;

    public abstract Schedule getLastSchedule()
            throws Exception;

    public abstract PatientRecord getPatientRecord(int idPatient)
            throws Exception;

    public abstract void updatePatientsDoctor(int patientID, int doctorID)
            throws Exception;

    public abstract NextOfKinBasic getNextOfKinBasic(int id)
            throws Exception;

    public abstract Doctor getDoctor(int id)
            throws Exception;

    public abstract Patient getPatient(int id)
            throws Exception;

    public abstract ArrayList<Bill> getAllBills()
            throws Exception;

    public abstract Bill getLastBill()
            throws Exception;

    public abstract Schedule getScheduleByID(int idSchedule)
            throws Exception;

}
