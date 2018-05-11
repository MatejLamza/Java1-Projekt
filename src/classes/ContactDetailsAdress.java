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

public class ContactDetailsAdress {

    /**
     * @return the idContactDetailAdress
     */
    public int getIdContactDetailAdress() {
        return idContactDetailAdress;
    }

    /**
     * @param idContactDetailAdress the idContactDetailAdress to set
     */
    public void setIdContactDetailAdress(int idContactDetailAdress) {
        this.idContactDetailAdress = idContactDetailAdress;
    }

    /**
     * @return the doorNumber
     */
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * @param doorNumber the doorNumber to set
     */
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    private int idContactDetailAdress;
    private String doorNumber;
    private String street;
    private String area;
    private String city;
    private String state;
    private String pincode;
}
