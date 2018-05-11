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

public class Specialization {

    /**
     * @return the idSpecialization
     */
    public int getIdSpecialization() {
        return idSpecialization;
    }

    /**
     * @param idSpecialization the idSpecialization to set
     */
    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    @Override 
    public String toString(){
        return idSpecialization + " " + specialization;
    }

    private int idSpecialization;
    private String specialization;
}
