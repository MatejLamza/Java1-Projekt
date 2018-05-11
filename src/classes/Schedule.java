/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.time.LocalDate;
import java.time.LocalTime;

/**
*
* @author Meowcake
*/

public class Schedule {

    /**
     * @return the idSchedule
     */
    public int getIdSchedule() {
        return idSchedule;
    }

    /**
     * @param idSchedule the idSchedule to set
     */
    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * @return the isAvailable
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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
        return idSchedule + " " + date + " " + time;
    }

    private int idSchedule;
    private LocalDate date;
    private LocalTime time;
    private boolean isAvailable;
    private Doctor doctor;
}
