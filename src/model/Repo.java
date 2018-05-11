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
import classes.Report;
import classes.Schedule;
import classes.Specialization;
import classes.Test;
import classes.Treatment;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Meowcake
 */
public class Repo {

    private static final DataSource ds = Repo.getSQLDataSource();

    public static DataSource getSQLDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();

        ds.setServerName("localhost");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setDatabaseName("DBFinal2");
        ds.setPortNumber(1433);

        return ds;
    }

    public static void insertSpecialization(String specialization) {
        DataSource ds = Repo.getSQLDataSource();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertSpecialization(?)}")) {

            stmt.setString(1, specialization);
            stmt.executeUpdate();

        } catch (Exception e) {
            //Zapisivati excpetione u log file
        }
    }

    public static void insertDoctor(Doctor doctor) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertDoctor(?,?,?)}")) {

            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSurname());
            stmt.setInt(3, doctor.getSpecialization().getIdSpecialization());

            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static ArrayList<Specialization> getSpecializations() {
        ArrayList<Specialization> allSpecializations = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getSpecializations()}")) {
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Specialization spec = new Specialization();
                spec.setIdSpecialization(rs.getInt("IDSpecialization"));
                spec.setSpecialization(rs.getString("Specialization"));

                allSpecializations.add(spec);

            }

        } catch (Exception e) {
        }
        return allSpecializations;
    }

    public static ArrayList<Doctor> getAllGeneralDoctors() {
        ArrayList<Doctor> generalDoctors = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllGeneralDoctors()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                Specialization specialization = new Specialization();

                doctor.setIdDoctor(rs.getInt("IDDoctor"));
                doctor.setName(rs.getString("Name"));
                doctor.setSurname(rs.getString("Surname"));
                specialization.setSpecialization(rs.getString("Specialization"));
                doctor.setSpecialization(specialization);

                generalDoctors.add(doctor);
            }

        } catch (Exception e) {
            e.getMessage();
            //DODATI LOGOVE
        }
        return generalDoctors;
    }

    public static ArrayList<Doctor> getAllSpecialistDoctors() {
        ArrayList<Doctor> specialistDoctors = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllSpecialists()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                Specialization specialization = new Specialization();

                doctor.setIdDoctor(rs.getInt("IDDoctor"));
                doctor.setName(rs.getString("Name"));
                doctor.setSurname(rs.getString("Surname"));
                specialization.setSpecialization(rs.getString("Specialization"));
                doctor.setSpecialization(specialization);

                specialistDoctors.add(doctor);
            }
        } catch (Exception e) {
        }
        return specialistDoctors;
    }

    public static ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> collectionDoctors = new ArrayList<Doctor>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllDoctors()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Doctor d = new Doctor();
                Specialization s = new Specialization();

                d.setIdDoctor(rs.getInt("IDDoctor"));
                d.setName(rs.getString("Name"));
                d.setSurname(rs.getString("Surname"));
                s.setIdSpecialization(rs.getInt("IDSpecialization"));
                s.setSpecialization(rs.getString("Specialization"));
                d.setSpecialization(s);

                collectionDoctors.add(d);
            }
        } catch (Exception e) {
        }
        return collectionDoctors;
    }

    public static void updateDoctor(Doctor doctor) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL updateDoctor(?,?,?,?)}")) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSurname());
            stmt.setInt(3, doctor.getSpecialization().getIdSpecialization());
            stmt.setInt(4, doctor.getIdDoctor());

            stmt.execute();
        } catch (Exception e) {
        }
    }

    public static void removeDoctor(int idDoctor) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL removeDoctor(?)}")) {

            stmt.setInt(1, idDoctor);
            stmt.execute();
        } catch (Exception ex) {
        }
    }

    public static void insertNextOfKinBasic(NextOfKinBasic nextOfKinBasic) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertNextOfKinBasic(?,?,?,?)}")) {
            stmt.setString(1, nextOfKinBasic.getName());
            stmt.setString(2, nextOfKinBasic.getMiddleName());
            stmt.setString(3, nextOfKinBasic.getSurname());
            stmt.setString(4, nextOfKinBasic.getRelationshipToPatient());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertPatient(Patient patient) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPatient(?,?,?,?,?,?,?,?,?,?,?)}")) {

            Date dateOfBirth = Date.valueOf(patient.getDateOfBirth());

            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getSurname());
            stmt.setString(3, patient.getMiddleName());
            stmt.setString(4, String.valueOf(patient.getSex()));
            stmt.setDate(5, dateOfBirth);
            stmt.setString(6, patient.getStatmentOfComplaint());
            stmt.setString(7, patient.getContact1());
            stmt.setString(8, patient.getContact2());
            stmt.setInt(9, patient.getNextOfKinBasic().getIdNextOfKinBasic());
            stmt.setBoolean(10, patient.isIsFollowUp());
            stmt.setInt(11, patient.getPatientDoctor().getIdDoctor());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<NextOfKinBasic> getAllNextOFKinBasic() {
        ArrayList<NextOfKinBasic> allNextOfKinBasics = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllNextOFKinBasic()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                NextOfKinBasic nokb = new NextOfKinBasic();

                nokb.setIdNextOfKinBasic(rs.getInt("IDNextOfKinBasic"));
                nokb.setName(rs.getString("Name"));
                nokb.setMiddleName(rs.getString("MiddleName"));
                nokb.setSurname(rs.getString("Surname"));
                nokb.setRelationshipToPatient(rs.getString("RelationshipToOutPatient"));

                allNextOfKinBasics.add(nokb);
            }

        } catch (Exception e) {
        }
        return allNextOfKinBasics;
    }

    public static ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> allPatients = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllPatients()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Patient patient = new Patient();

                Date dateOfBirth = rs.getDate("DateOfBirth");
                LocalDate datum = LocalDate.parse(dateOfBirth.toString());

                patient.setIdPatient(rs.getInt("IDpatient"));
                patient.setName(rs.getString("Name"));
                patient.setSurname(rs.getString("Surname"));
                patient.setMiddleName(rs.getString("Middlename"));
                patient.setSex(rs.getString("Sex").toCharArray()[0]);//potencijalni problem
                patient.setDateOfBirth(datum);
                patient.setContact1(rs.getString("Contact_1"));

                Doctor doc = Repo.getDoctor(rs.getInt("DoctorID"));
                patient.setPatientDoctor(doc);

                allPatients.add(patient);
            }
        } catch (Exception e) {
        }
        return allPatients;
    }

    public static ArrayList<Schedule> getSchedule() {
        ArrayList<Schedule> allSchedules = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getSchedule()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Schedule schedule = new Schedule();

                schedule.setIdSchedule(rs.getInt("IDSchedule"));

                Date temp = rs.getDate("Datum");
                LocalDate date = LocalDate.parse(temp.toString());
                schedule.setDate(date);

                Time tempTime = rs.getTime("Vrijeme");
                LocalTime time = LocalTime.parse(tempTime.toString());
                schedule.setTime(time);

                allSchedules.add(schedule);
            }

        } catch (Exception e) {
        }
        return allSchedules;
    }

    public static void createAppointment(Appointment appointment) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL createAppointment(?,?,?)}")) {
            stmt.setString(1, appointment.getDiagnose());
            stmt.setInt(2, appointment.getSchedule().getIdSchedule());
            stmt.setInt(3, appointment.getPatient().getIdPatient());

            stmt.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Poruka: ");
            System.out.println(e.getMessage());
        }
    }

    public static void insertTest(Test test) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertTest(?,?)}")) {
            stmt.setString(1, test.getTestName());
            stmt.setString(2, test.getTestResult());

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void insertTreatment(Treatment treatment) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertTreatment(?,?)}")) {

            stmt.setString(1, treatment.getDoctorNote());
            stmt.setInt(2, treatment.getDoctor().getIdDoctor());

            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void insertMedicine(Medicine medicine) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertMedicine(?)}")) {
            stmt.setString(1, medicine.getName());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Nemogu insertat med");
            System.out.println(e.getMessage());
        }
    }

    public static void insertPatientRecord(PatientRecord pr) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPationRecord(?,?,?,?)}")) {

            stmt.setInt(1, pr.getTest().getIdTest());
            stmt.setInt(2, pr.getMedicine().getIdMedicine());
            stmt.setInt(3, pr.getTreatment().getIdTreatment());
            stmt.setInt(4, pr.getAppointment().getIdAppointment());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("CANT INSERT PATIENT RECORD");
            e.printStackTrace();
        }
    }

    public static void insertSchedule(Schedule schedule) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertSchedule(?,?,?,?)}")) {

            Date tempDate = Date.valueOf(schedule.getDate());
            Time tempTime = Time.valueOf(schedule.getTime());

            stmt.setDate(1, tempDate);
            stmt.setTime(2, tempTime);
            stmt.setBoolean(3, schedule.isIsAvailable());
            stmt.setInt(4, schedule.getDoctor().getIdDoctor());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Test> getTests() {
        ArrayList<Test> allTests = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTests()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Test t = new Test();

                t.setIdTest(rs.getInt("IDTest"));
                t.setTestName(rs.getString("TestName"));
                t.setTestResult(rs.getString("TestResult"));

                allTests.add(t);
            }
        } catch (Exception e) {
            //LOGOVI
        }
        return allTests;
    }

    public static ArrayList<Medicine> getMedicines() {
        ArrayList<Medicine> allMedicines = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getMedicines()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Medicine med = new Medicine();

                med.setIdMedicine(rs.getInt("IDMedicine"));
                med.setName(rs.getString("Name"));

                allMedicines.add(med);
            }
        } catch (Exception e) {
        }

        return allMedicines;
    }

    public static ArrayList<Treatment> getTreatments() {
        ArrayList<Treatment> allTreatments = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTreatments()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Treatment treatment = new Treatment();

                treatment.setIdTreatment(rs.getInt("IDTreatment"));
                treatment.setDoctorNote(rs.getString("DoctorNote"));

                allTreatments.add(treatment);
            }
        } catch (Exception e) {
        }
        return allTreatments;
    }

    public static ArrayList<Appointment> getAppointments() {
        ArrayList<Appointment> allAppointments = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllAppointments()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Appointment appointment = new Appointment();

                appointment.setIdAppointment(rs.getInt("IDAppointment"));
                appointment.setDiagnose(rs.getString("Diagnose"));

                allAppointments.add(appointment);
            }

        } catch (Exception e) {
        }
        return allAppointments;
    }

    public static Test getLastTest() {
        Test test = new Test();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastTest()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.next();

            test.setIdTest(rs.getInt("IDTest"));
            test.setTestName(rs.getString("TestName"));
            test.setTestResult(rs.getString("TestResult"));
        } catch (Exception e) {
        }
        return test;
    }

    public static Medicine getLastMedicine() {
        Medicine lijek = new Medicine();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastMedicine()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            lijek.setIdMedicine(rs.getInt("IDMedicine"));
            lijek.setName(rs.getString("Name"));

        } catch (Exception e) {
        }

        return lijek;
    }

    public static Treatment getLastTreatment() {
        Treatment pregled = new Treatment();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastTreatment()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            pregled.setIdTreatment(rs.getInt("IDTreatment"));
            pregled.setDoctorNote(rs.getString("DoctorNote"));

        } catch (Exception e) {
        }

        return pregled;
    }

    public static void updateAppointment(Appointment appointment) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL updateAppointment(?,?,?)}")) {
            stmt.setString(1, appointment.getDiagnose());
            stmt.setInt(2, appointment.getSchedule().getIdSchedule());
            stmt.setInt(3, appointment.getIdAppointment());
            stmt.execute();

        } catch (Exception e) {
        }
    }

    public static void updateSchedule(Schedule sc) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL updateSchedule(?)}")) {
            stmt.setInt(1, sc.getIdSchedule());
            stmt.execute();

        } catch (Exception e) {
        }
    }

    public static ArrayList<Schedule> getScheduleForDoctor(Doctor docID) {
        ArrayList<Schedule> allSchedules = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getScheduleForDoctor(?)}")) {
            stmt.setInt(1, docID.getIdDoctor());
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Schedule sc = new Schedule();
                Doctor doc = new Doctor();
                Specialization spec = new Specialization();

                sc.setIdSchedule(rs.getInt("IDSchedule"));

                Date temp = rs.getDate("Datum");
                LocalDate date = LocalDate.parse(temp.toString());
                sc.setDate(date);

                Time tempTime = rs.getTime("Vrijeme");
                LocalTime time = LocalTime.parse(tempTime.toString());
                sc.setTime(time);

                doc.setName(rs.getString("Name"));
                doc.setSurname(rs.getString("Surname"));
                spec.setSpecialization(rs.getString("Specialization"));
                doc.setSpecialization(spec);

                sc.setDoctor(doc);
                allSchedules.add(sc);
            }

        } catch (Exception e) {
        }
        return allSchedules;
    }

    public static NextOfKinBasic getLastNextOfKinBasic() {
        NextOfKinBasic nokBasic = new NextOfKinBasic();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastNextOfKinBasic()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            nokBasic.setIdNextOfKinBasic(rs.getInt("IDNextOfKinBasic"));
            nokBasic.setName(rs.getString("Name"));
            nokBasic.setMiddleName(rs.getString("MiddleName"));
            nokBasic.setSurname(rs.getString("Surname"));
            nokBasic.setRelationshipToPatient(rs.getString("RelationshipToOutPatient"));

        } catch (Exception e) {
        }
        return nokBasic;
    }

    public static void insertContactDetails(ContactDetails conDetails) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertContactDetails(?,?,?,?,?,?)}")) {

            stmt.setString(1, conDetails.getTelephoneWork());
            stmt.setString(2, conDetails.getTelephoneHome());
            stmt.setString(3, conDetails.getMobile());
            stmt.setString(4, conDetails.getPager());
            stmt.setString(5, conDetails.getFax());
            stmt.setString(6, conDetails.getEmail());

            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static ContactDetails getLastContactDetails() {
        ContactDetails conDetails = new ContactDetails();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastContactDetails()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            conDetails.setIdContactDetails(rs.getInt("IDContactDetails"));
            conDetails.setTelephoneWork(rs.getString("TelephoneWork"));
            conDetails.setTelephoneHome(rs.getString("TelephoneHome"));
            conDetails.setMobile(rs.getString("Mobile"));
            conDetails.setPager(rs.getString("Pager"));
            conDetails.setFax(rs.getString("Fax"));
            conDetails.setEmail(rs.getString("Email"));
        } catch (Exception e) {
        }
        return conDetails;
    }

    public static void insertContactDetailsAdress(ContactDetailsAdress adress) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertContactDetailsAdress(?,?,?,?,?,?)}")) {

            stmt.setString(1, adress.getDoorNumber());
            stmt.setString(2, adress.getStreet());
            stmt.setString(3, adress.getArea());
            stmt.setString(4, adress.getCity());
            stmt.setString(5, adress.getState());
            stmt.setString(6, adress.getPincode());

            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static ContactDetailsAdress getLastAdressDetails() {
        ContactDetailsAdress adress = new ContactDetailsAdress();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastAdressDetails()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            adress.setIdContactDetailAdress(rs.getInt("IDContactDetailsAddress"));
            adress.setDoorNumber(rs.getString("DoorNumber"));
            adress.setStreet(rs.getString("Street"));
            adress.setArea(rs.getString("Area"));
            adress.setCity(rs.getString("City"));
            adress.setState(rs.getString("State_"));
            adress.setPincode(rs.getString("Pincode"));

        } catch (Exception e) {
        }
        return adress;
    }

    public static void insertNextOfKin(NextOfKin nok) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertNextOfKin(?,?,?)}")) {

            stmt.setInt(1, nok.getNextOfKinBasic().getIdNextOfKinBasic());
            stmt.setInt(2, nok.getContactDetails().getIdContactDetails());
            stmt.setInt(3, nok.getContactDetailsAdress().getIdContactDetailAdress());

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static NextOfKin getLastNextOfKin() {
        NextOfKin nok = new NextOfKin();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastNextOfKin()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            NextOfKinBasic nokBasic = new NextOfKinBasic();
            ContactDetails conDetails = new ContactDetails();
            ContactDetailsAdress adressDetails = new ContactDetailsAdress();

            nok.setIdNextOfKin(rs.getInt("IDNextOfKin"));
            nokBasic.setIdNextOfKinBasic(rs.getInt("NextOfKinBasicID"));
            conDetails.setIdContactDetails(rs.getInt("ContactDetailsID"));
            adressDetails.setIdContactDetailAdress(rs.getInt("ContactDetailsAddressID"));

            nok.setNextOfKinBasic(nokBasic);
            nok.setContactDetails(conDetails);
            nok.setContactDetailsAdress(adressDetails);

        } catch (Exception e) {
        }

        return nok;
    }

    public static void insertPersonalDetails(PersonalDetails details) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPersonalDetails(?,?,?,?,?)}")) {

            stmt.setString(1, details.getMartialStatus());
            stmt.setInt(2, details.getNumberOfDependents());
            stmt.setDouble(3, details.getHeight());
            stmt.setDouble(4, details.getWeight());
            stmt.setString(5, details.getBloodType());

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static PersonalDetails getLastPersonalDetails() {
        PersonalDetails details = new PersonalDetails();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastPersonalDetails()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            details.setIdPersonalDetails(rs.getInt("IDpersonalDetails"));
            details.setMartialStatus(rs.getString("MartialStatus"));
            details.setNumberOfDependents(rs.getInt("NumberOfDependents"));
            details.setHeight(rs.getDouble("Height"));
            details.setWeight(rs.getDouble("Weight"));
            details.setBloodType(rs.getString("BloodType"));

        } catch (Exception e) {
        }
        return details;
    }

    public static void insertProfessionDetails(ProfessionDetails professionDetails) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertProfessionDetails(?,?)}")) {

            stmt.setString(1, professionDetails.getOccupation());
            stmt.setInt(2, professionDetails.getGrossAnnualIncome());
            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static ProfessionDetails getLastProfessionDetails() {
        ProfessionDetails professionDetails = new ProfessionDetails();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastProfessionDetails()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            professionDetails.setIdProfessionDetails(rs.getInt("IDProfessionDetails"));
            professionDetails.setOccupation(rs.getString("Occupation"));
            professionDetails.setGrossAnnualIncome(rs.getInt("GrossAnnualIncome"));

        } catch (Exception e) {
        }
        return professionDetails;
    }

    public static void insertLifestyle(LifeStyle ls) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertLifeStyle(?,?,?,?,?,?,?,?,?,?)}")) {

            stmt.setBoolean(1, ls.isVegeterian());
            stmt.setBoolean(2, ls.isSmoker());
            stmt.setInt(3, ls.getAvgNoCigarettes());
            stmt.setBoolean(4, ls.isAlcoholic());
            stmt.setInt(5, ls.getAvgNoDrinks());
            stmt.setString(6, ls.getUseStimulants());
            stmt.setInt(7, ls.getNoCofeTeaDay());
            stmt.setInt(8, ls.getNoSoftDrinksDay());
            stmt.setBoolean(9, ls.isHaveRegularMeals());
            stmt.setBoolean(10, ls.isHaveHomeFood());

            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static LifeStyle getLastLifeStyle() {
        LifeStyle ls = new LifeStyle();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastLifeStyle()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            ls.setIdLifeStyle(rs.getInt("IDlifestyle"));

        } catch (Exception e) {
        }
        return ls;
    }

    public static void insertBasicComplaints(BasicComplaints complaints) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertBasicComplaints(?,?,?)}")) {

            stmt.setString(1, complaints.getStatmentOfComplaint());
            stmt.setString(2, complaints.getHistoryOfPreviousTreatment());
            stmt.setString(3, complaints.getPhysicianOrHospital());

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static BasicComplaints getLastBasicComplaint() {
        BasicComplaints complaint = new BasicComplaints();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastBasicComplaint()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            complaint.setIdBasicComplaints(rs.getInt("IDBasicComplaints"));

        } catch (Exception e) {
        }

        return complaint;
    }

    public static void insertImportantComplaints(ImportantMedicalComplaints complaint) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertImportantComplaints(?,?,?,?,?,?,?,?,?,?)}")) {

            stmt.setBoolean(1, complaint.isIsDiabetic());
            stmt.setBoolean(2, complaint.isIsHypertensive());
            stmt.setString(3, complaint.getCardiacCondition());
            stmt.setString(4, complaint.getDigestiveCondition());
            stmt.setString(5, complaint.getOrthopedicCondition());
            stmt.setString(6, complaint.getMuscularCondition());
            stmt.setString(7, complaint.getNeurologicalCondition());
            stmt.setString(8, complaint.getKnownAllergies());
            stmt.setString(9, complaint.getKnownReactionToSpecDrugs());
            stmt.setString(10, complaint.getMajorSurgeries());

            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static ImportantMedicalComplaints getLastImportantComplaint() {
        ImportantMedicalComplaints complaint = new ImportantMedicalComplaints();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastImportantComplaint()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            complaint.setIdImportantMedicalComplaints(rs.getInt("IDimportantMedicalComplaints"));

        } catch (Exception e) {
        }

        return complaint;
    }

    public static void insertFullPatient(PatientFull fullPatient) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertFullPatient(?,?,?,?,?,?,?,?,?,?)}")) {

            stmt.setInt(1, fullPatient.getPatient().getIdPatient());
            stmt.setInt(2, fullPatient.getPernamentAdress().getIdContactDetailAdress());
            stmt.setInt(3, fullPatient.getPresentAdress().getIdContactDetailAdress());
            stmt.setInt(4, fullPatient.getNextOfKinContact().getIdNextOfKin());
            stmt.setInt(5, fullPatient.getPersonalDetails().getIdPersonalDetails());
            stmt.setInt(6, fullPatient.getProfessionDetails().getIdProfessionDetails());
            stmt.setInt(7, fullPatient.getLifestyle().getIdLifeStyle());
            stmt.setInt(8, fullPatient.getBasicComplaints().getIdBasicComplaints());
            stmt.setInt(9, fullPatient.getImportantMedComplaints().getIdImportantMedicalComplaints());
            stmt.setInt(10, fullPatient.getContactDetails().getIdContactDetails());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Ne mogu insertat full pacijenta");
            e.printStackTrace();
        }
    }

    public static void insertPartialPatient(Patient patient) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertPartialPatient(?,?,?,?,?)}")) {

            Date dateOfBirth = Date.valueOf(patient.getDateOfBirth());

            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getSurname());
            stmt.setString(3, patient.getMiddleName());
            stmt.setString(4, String.valueOf(patient.getSex()));
            stmt.setDate(5, dateOfBirth);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Patient getLastPatient() {
        Patient pat = new Patient();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastPatient()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            pat.setIdPatient(rs.getInt("IDPatient"));
            pat.setName(rs.getString("Name"));
            pat.setSurname(rs.getString("Surname"));
            pat.setMiddleName(rs.getString("Middlename"));
            pat.setSex(rs.getString("Sex").charAt(0));

            Date temp = rs.getDate("DateOfBirth");
            LocalDate date = LocalDate.parse(temp.toString());
            pat.setDateOfBirth(date);
            pat.setStatmentOfComplaint(rs.getString("StatementOfComplaint"));
            pat.setContact1(rs.getString("Contact_1"));
            pat.setContact2(rs.getString("Contact_2"));
            int tempIDNextOfKin = rs.getInt("NextOfKinBasicID");

            NextOfKinBasic nokb = Repo.getNextOfKinBasic(tempIDNextOfKin);
            pat.setNextOfKinBasic(nokb);
            pat.setIsFollowUp(rs.getBoolean("IsFollowUp"));

            int tempDocorID = rs.getInt("DoctorID");
            Doctor doc = Repo.getDoctor(tempDocorID);
            pat.setPatientDoctor(doc);

        } catch (Exception e) {
        }

        return pat;
    }

    public static void createBill(Bill bill) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL createBill(?,?)}")) {

            stmt.setString(1, bill.getPaymentMethod());
            stmt.setInt(2, bill.getPatient().getIdPatient());
            stmt.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static Bill getPatientBill(int idPatient) {
        Bill bill = new Bill();
        Patient patient = new Patient();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPatientBill(?)}")) {
            stmt.setInt(1, idPatient);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            bill.setIdBill(rs.getInt("IDBill"));
            bill.setPaymentMethod(rs.getString("PaymentMethod"));
            int patientID = rs.getInt("PatientID");
            patient = Repo.getPatient(patientID);
            bill.setPatient(patient);

        } catch (Exception e) {
        }
        return bill;
    }

    public static void insertBillItem(BillItem item) {

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL insertAccountItem(?,?,?,?)}")) {

            stmt.setString(1, item.getItemName());
            stmt.setDouble(2, item.getItemPrice());
            stmt.setInt(3, item.getItemQuantity());
            stmt.setInt(4, item.getBill().getIdBill());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("razmak");
            e.printStackTrace();
        }
    }

    public static Appointment getLastAppointment() {
        Appointment app = new Appointment();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastAppointment()}")) {

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            Schedule sc = new Schedule();
            Patient pat = new Patient();

            app.setIdAppointment(rs.getInt("IDAppointment"));
            app.setDiagnose(rs.getString("Diagnose"));
            sc.setIdSchedule(rs.getInt("ScheduleID"));
            pat.setIdPatient(rs.getInt("PatientID"));
            app.setSchedule(sc);
            app.setPatient(pat);

        } catch (Exception e) {
        }

        return app;
    }

    public static Schedule getLastSchedule() {
        Schedule sc = new Schedule();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastSchedule()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            sc.setIdSchedule(rs.getInt("IDSchedule"));

        } catch (Exception e) {
        }
        return sc;
    }

    public static ArrayList<PatientRecord> getPatientRecord(int idPatient) {
        ArrayList<PatientRecord> patientRecords = new ArrayList<>();

        Doctor d = new Doctor();
        Test test = new Test();
        Medicine med = new Medicine();
        Treatment tr = new Treatment();
        Appointment app = new Appointment();
        Schedule sc = new Schedule();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPatientRecord(?)}")) {

            stmt.setInt(1, idPatient);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                PatientRecord pr = new PatientRecord();

                pr.setIdPatientRecord(rs.getInt("IDPatientRecord"));

                d.setName(rs.getString("Name"));
                d.setSurname(rs.getString("Surname"));

                test.setIdTest(rs.getInt("IDTest"));
                test.setTestName(rs.getString("TestName"));
                test.setTestResult(rs.getString("TestResult"));

                med.setIdMedicine(rs.getInt("IDMedicine"));
                med.setName(rs.getString("Name"));

                tr.setIdTreatment(rs.getInt("IDTreatment"));
                tr.setDoctorNote(rs.getString("DoctorNote"));
                tr.setDoctor(d);

                app.setIdAppointment(rs.getInt("IDAppointment"));
                app.setDiagnose(rs.getString("Diagnose"));

                Date temp = rs.getDate("Datum");
                LocalDate date = LocalDate.parse(temp.toString());
                sc.setDate(date);

                Time tempTime = rs.getTime("Vrijeme");
                LocalTime time = LocalTime.parse(tempTime.toString());
                sc.setTime(time);

                app.setSchedule(sc);

                pr.setTest(test);
                pr.setMedicine(med);
                pr.setAppointment(app);
                pr.setTreatment(tr);

                patientRecords.add(pr);

            }

        } catch (Exception e) {
            System.out.println("porukica");
            System.out.println(e.getMessage());

        }

        return patientRecords;
    }

    public static void updatePatientsDoctor(int patientID, int doctorID) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL updatePatientsDoctor(?,?)}")) {
            stmt.setInt(1, patientID);
            stmt.setInt(2, doctorID);
            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static NextOfKinBasic getNextOfKinBasic(int id) {
        NextOfKinBasic nokBasic = new NextOfKinBasic();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getNextOfKinBasic(?)}")) {

            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            nokBasic.setIdNextOfKinBasic(rs.getInt("IDNextOfKinBasic"));
            nokBasic.setName(rs.getString("Name"));
            nokBasic.setSurname(rs.getString("Surname"));
            nokBasic.setMiddleName(rs.getString("MiddleName"));
            nokBasic.setRelationshipToPatient(rs.getString("RelationshipToOutPatient"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("PROBLEM NEXTOFKINBASIC");
        }
        return nokBasic;
    }

    public static Doctor getDoctor(int id) {
        Doctor doc = new Doctor();
        Specialization spec = new Specialization();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getDoctor(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            doc.setIdDoctor(rs.getInt("IDDoctor"));
            doc.setName(rs.getString("Name"));
            doc.setSurname(rs.getString("Surname"));
            doc.setIsActive(rs.getBoolean("IsActive"));

            spec.setIdSpecialization(rs.getInt("IDSpecialization"));
            spec.setSpecialization(rs.getString("Specialization"));

            doc.setSpecialization(spec);

        } catch (Exception e) {
        }

        return doc;
    }

    public static Patient getPatient(int id) {
        Patient pat = new Patient();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getPatient(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            pat.setIdPatient(rs.getInt("IDPatient"));
            pat.setName(rs.getString("Name"));
            pat.setSurname(rs.getString("Surname"));
            pat.setMiddleName(rs.getString("Middlename"));
            pat.setSex(rs.getString("Sex").charAt(0));

            Date temp = rs.getDate("DateOfBirth");
            LocalDate date = LocalDate.parse(temp.toString());
            pat.setDateOfBirth(date);
            pat.setStatmentOfComplaint(rs.getString("StatementOfComplaint"));
            pat.setContact1(rs.getString("Contact_1"));
            pat.setContact2(rs.getString("Contact_2"));
            int tempIDNextOfKin = rs.getInt("NextOfKinBasicID");

            NextOfKinBasic nokb = Repo.getNextOfKinBasic(tempIDNextOfKin);
            pat.setNextOfKinBasic(nokb);
            pat.setIsFollowUp(rs.getBoolean("IsFollowUp"));

            int tempDocorID = rs.getInt("DoctorID");
            Doctor doc = Repo.getDoctor(tempDocorID);
            pat.setPatientDoctor(doc);

        } catch (Exception e) {

        }

        return pat;
    }

    public static ArrayList<Bill> getAllBills() {
        ArrayList<Bill> allBills = new ArrayList<>();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAllBills()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Bill bill = new Bill();

                bill.setIdBill(rs.getInt("IDBill"));
                bill.setPaymentMethod(rs.getString("PaymentMethod"));
                int tempID = rs.getInt("PatientID");
                Patient tempPatient = Repo.getPatient(tempID);
                bill.setPatient(tempPatient);

                allBills.add(bill);
            }

        } catch (Exception e) {

        }
        return allBills;
    }

    public static Bill getLastBill() {
        Bill bill = new Bill();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastBill()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            bill.setIdBill(rs.getInt("IDBill"));
            bill.setPaymentMethod(rs.getString("PaymentMethod"));
            Patient patient = Repo.getPatient(rs.getInt("PatientID"));
            bill.setPatient(patient);

        } catch (Exception e) {
        }

        return bill;
    }

    public static Schedule getScheduleByID(int idSchedule) {
        Schedule sc = new Schedule();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getScheduleByID(?)}")) {
            stmt.setInt(1, idSchedule);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            Date date = rs.getDate("Datum");
            LocalDate datum = LocalDate.parse(date.toString());
            Time time = rs.getTime("Vrijeme");
            LocalTime vrijeme = LocalTime.parse(time.toString());

            sc.setIdSchedule(rs.getInt("IDSchedule"));
            sc.setDate(datum);
            sc.setTime(vrijeme);
            sc.setIsAvailable(rs.getBoolean("Zauzeto"));
            sc.setDoctor(Repo.getDoctor(rs.getInt("DoctorID")));

        } catch (Exception e) {
        }
        return sc;
    }

    public static Specialization getLastSpecialization() {
        Specialization spec = new Specialization();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getLastSpecialization()}")) {
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            rs.next();

            spec.setIdSpecialization(rs.getInt("IDSpecialization"));
            spec.setSpecialization(rs.getString("Specialization"));

        } catch (Exception e) {
        }
        return spec;
    }

    public static ArrayList<Schedule> allAvalivableAppointments(int id) {
        ArrayList<Schedule> temp = new ArrayList<>();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getScheduleForDoctor(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Schedule sc = new Schedule();

                sc.setIdSchedule(rs.getInt("IDSchedule"));

                Date date = rs.getDate("Datum");
                sc.setDate(LocalDate.parse(date.toString()));

                Time time = rs.getTime("Vrijeme");
                sc.setTime(LocalTime.parse(time.toString()));

                sc.setDoctor(Repo.getDoctor(id));

                temp.add(sc);
            }
        } catch (Exception e) {
        }
        return temp;
    }

    public static void updateIsFollowUp(Patient pat) {
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL updateIsFollowUp(?)}")) {
            stmt.setInt(1, pat.getIdPatient());
            stmt.execute();

        } catch (Exception e) {
        }
    }

    public static Test getTest(int idTest) {
        Test test = new Test();
        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTest(?)}")) {
            stmt.setInt(1, idTest);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            rs.next();

            test.setIdTest(rs.getInt("IDTest"));
            test.setTestName(rs.getString("TestName"));
            test.setTestResult(rs.getString("TestResult"));

        } catch (Exception e) {
        }
        return test;
    }

    public static Medicine getMedicine(int idMed) {
        Medicine med = new Medicine();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getMedicine(?)}")) {
            stmt.setInt(1, idMed);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            med.setIdMedicine(rs.getInt("IDMedicine"));
            med.setName(rs.getString("Name"));
        } catch (Exception e) {
        }
        return med;
    }

    public static Treatment getTreatment(int idTreat) {
        Treatment treatment = new Treatment();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getTreatment(?)}")) {
            stmt.setInt(1, idTreat);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            treatment.setIdTreatment(rs.getInt("IDTreatment"));
            treatment.setDoctorNote(rs.getString("DoctorNote"));
            Doctor doc = Repo.getDoctor(rs.getInt("DoctorID"));
            treatment.setDoctor(doc);

        } catch (Exception e) {
        }
        return treatment;
    }

    public static Appointment getAppointment(int idAppointment) {
        Appointment appointment = new Appointment();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getAppointment(?)}")) {
            stmt.setInt(1, idAppointment);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            appointment.setIdAppointment(rs.getInt("IDAppointment"));
            appointment.setDiagnose(rs.getString("Diagnose"));
            Schedule sc = Repo.getScheduleByID(rs.getInt("ScheduleID"));
            appointment.setSchedule(sc);
            Patient pat = Repo.getPatient(rs.getInt("PatientID"));
            appointment.setPatient(pat);

        } catch (Exception e) {
        }
        return appointment;
    }

    public static Report getNumberOfFollowUps(int idDoctor) {
        Report rep = new Report();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getNumberOfFollowUps(?)}")) {
            stmt.setInt(1, idDoctor);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            rep.setNumberOfFollowUps(rs.getString("NumberOfPatients"));

        } catch (Exception e) {
        }

        return rep;
    }

    public static Report getNumberOfPatients(int idDoctor) {
        Report rep = new Report();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL getNumberOfPatients(?)}")) {
            stmt.setInt(1, idDoctor);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            rep.setNumberOfPatients(rs.getString("NumberOfPatients"));
        } catch (Exception e) {
        }
        return rep;
    }

    public static Report getTotalForConsultations() {
        Report rep = new Report();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL totalForConsultations()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            rep.setTotalPrice(rs.getString("TotalPrice"));
            rep.setQuantity(rs.getString("NumberOfConsultations"));
        } catch (Exception e) {
        }
        return rep;
    }

    public static Report getTotalForTreatments() {
        Report rep = new Report();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL totalForTreatments()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            rep.setTotalPrice(rs.getString("TotalPrice"));
            rep.setQuantity(rs.getString("NumberOfTreatments"));
        } catch (Exception e) {
        }
        return rep;
    }

    public static Report getTotalForMedicines() {
        Report rep = new Report();

        try (Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall("{CALL totalForMedicines()}")) {
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            rs.next();

            rep.setTotalPrice(rs.getString("TotalPrice"));
            rep.setQuantity(rs.getString("NumberOfMedicines"));
        } catch (Exception e) {
        }
        return rep;
    }

    //KRAJ
    public Repo() {
    }
}
