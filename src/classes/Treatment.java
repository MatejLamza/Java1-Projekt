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

public class Treatment {

    /**
     * @return the idTreatment
     */
    public int getIdTreatment() {
        return idTreatment;
    }

    /**
     * @param idTreatment the idTreatment to set
     */
    public void setIdTreatment(int idTreatment) {
        this.idTreatment = idTreatment;
    }

    /**
     * @return the doctorNote
     */
    public String getDoctorNote() {
        return doctorNote;
    }

    /**
     * @param doctorNote the doctorNote to set
     */
    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    @Override 
    public String toString(){
        return idTreatment + " " + doctorNote;
    }

    private int idTreatment;
    private String doctorNote;
    private Doctor doctor;
}
