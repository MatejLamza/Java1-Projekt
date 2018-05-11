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

public class Report {

    /**
     * @return the numberOfPatients
     */
    public String getNumberOfPatients() {
        return numberOfPatients;
    }

    /**
     * @param numberOfPatients the numberOfPatients to set
     */
    public void setNumberOfPatients(String numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    /**
     * @return the numberOfFollowUps
     */
    public String getNumberOfFollowUps() {
        return numberOfFollowUps;
    }

    /**
     * @param numberOfFollowUps the numberOfFollowUps to set
     */
    public void setNumberOfFollowUps(String numberOfFollowUps) {
        this.numberOfFollowUps = numberOfFollowUps;
    }

    /**
     * @return the totalPrice
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    private String totalPrice;
    private String quantity;
    private String numberOfFollowUps;
    private String numberOfPatients;
    
    

}
