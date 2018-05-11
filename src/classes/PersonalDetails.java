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

public class PersonalDetails {

    /**
     * @return the idPersonalDetails
     */
    public int getIdPersonalDetails() {
        return idPersonalDetails;
    }

    /**
     * @param idPersonalDetails the idPersonalDetails to set
     */
    public void setIdPersonalDetails(int idPersonalDetails) {
        this.idPersonalDetails = idPersonalDetails;
    }

    /**
     * @return the martialStatus
     */
    public String getMartialStatus() {
        return martialStatus;
    }

    /**
     * @param martialStatus the martialStatus to set
     */
    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    /**
     * @return the numberOfDependents
     */
    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    /**
     * @param numberOfDependents the numberOfDependents to set
     */
    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    

    private int idPersonalDetails;
    private String martialStatus;
    private int numberOfDependents;
    private double height;
    private double weight;
    private String bloodType;
}
