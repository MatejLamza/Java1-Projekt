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

public class Appointment {

    /**
     * @return the idAppointment
     */
    public int getIdAppointment() {
        return idAppointment;
    }

    /**
     * @param idAppointment the idAppointment to set
     */
    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    /**
     * @return the diagnose
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * @param diagnose the diagnose to set
     */
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    @Override
    public String toString(){
        return idAppointment + " " + diagnose;
    }
    
    private int idAppointment;
    private String diagnose;
    private Schedule schedule;
    private Patient patient;
    

}
