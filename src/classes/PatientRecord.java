/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
*
* @author Meowcake
*/

public class PatientRecord {

    /**
     * @return the idPatientRecord
     */
    public int getIdPatientRecord() {
        return idPatientRecord;
    }

    /**
     * @param idPatientRecord the idPatientRecord to set
     */
    public void setIdPatientRecord(int idPatientRecord) {
        this.idPatientRecord = idPatientRecord;
    }

    /**
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * @return the medicine
     */
    public Medicine getMedicine() {
        return medicine;
    }

    /**
     * @param medicine the medicine to set
     */
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    /**
     * @return the treatment
     */
    public Treatment getTreatment() {
        return treatment;
    }

    /**
     * @param treatment the treatment to set
     */
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    /**
     * @return the appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * @param appointment the appointment to set
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    @Override
    public String toString(){
        return idPatientRecord + " " + treatment.getDoctor().getName() + " " + treatment.getDoctor().getSurname()
                + " " + test.getTestName() + " " + test.getTestResult() + " " + medicine.getName() + " " + 
                treatment.getDoctorNote() + " " + appointment.getDiagnose() + " " + appointment.getSchedule().getDate()
                + " " + appointment.getSchedule().getTime();
    }
    
    private int idPatientRecord;
    private Test test;
    private Medicine medicine;
    private Treatment treatment;
    private Appointment appointment;
    

}
