/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.time.LocalDate;
import java.util.ArrayList;

/**
*
* @author Meowcake
*/

public class Patient {

    /**
     * @return the patientDoctor
     */
    public Doctor getPatientDoctor() {
        return patientDoctor;
    }

    /**
     * @param patientDoctor the patientDoctor to set
     */
    public void setPatientDoctor(Doctor patientDoctor) {
        this.patientDoctor = patientDoctor;
    }

    /**
     * @return the allPatientRecords
     */
    public ArrayList<PatientRecord> getAllPatientRecords() {
        return allPatientRecords;
    }

    /**
     * @param allPatientRecords the allPatientRecords to set
     */
    public void setAllPatientRecords(ArrayList<PatientRecord> allPatientRecords) {
        this.allPatientRecords = allPatientRecords;
    }

    /**
     * @return the idPatient
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * @param idPatient the idPatient to set
     */
    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * @return the dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the statmentOfComplaint
     */
    public String getStatmentOfComplaint() {
        return statmentOfComplaint;
    }

    /**
     * @param statmentOfComplaint the statmentOfComplaint to set
     */
    public void setStatmentOfComplaint(String statmentOfComplaint) {
        this.statmentOfComplaint = statmentOfComplaint;
    }

    /**
     * @return the contact1
     */
    public String getContact1() {
        return contact1;
    }

    /**
     * @param contact1 the contact1 to set
     */
    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    /**
     * @return the contact2
     */
    public String getContact2() {
        return contact2;
    }

    /**
     * @param contact2 the contact2 to set
     */
    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    /**
     * @return the nextOfKinBasic
     */
    public NextOfKinBasic getNextOfKinBasic() {
        return nextOfKinBasic;
    }

    /**
     * @param nextOfKinBasic the nextOfKinBasic to set
     */
    public void setNextOfKinBasic(NextOfKinBasic nextOfKinBasic) {
        this.nextOfKinBasic = nextOfKinBasic;
    }

    /**
     * @return the isFollowUp
     */
    public boolean isIsFollowUp() {
        return isFollowUp;
    }

    /**
     * @param isFollowUp the isFollowUp to set
     */
    public void setIsFollowUp(boolean isFollowUp) {
        this.isFollowUp = isFollowUp;
    }
    
    @Override
    public String toString(){
        if (middleName != null) {
            return idPatient + " " + name + " " + middleName + " " + surname + " " + dateOfBirth.toString() + " " + sex + " " + contact1;
        }
        return idPatient + " " + name + " " + surname + " " + dateOfBirth.toString() + " " + sex;
    }

    private int idPatient;
    private String name;
    private String middleName;
    private String surname;
    private char sex;
    private LocalDate dateOfBirth;
    private String statmentOfComplaint;
    private String contact1;
    private String contact2;
    private NextOfKinBasic nextOfKinBasic;
    private boolean isFollowUp;
    private ArrayList<PatientRecord> allPatientRecords;
    private Doctor patientDoctor;
    
    
    
}
