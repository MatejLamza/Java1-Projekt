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

public class NextOfKin {

    /**
     * @return the idNextOfKin
     */
    public int getIdNextOfKin() {
        return idNextOfKin;
    }

    /**
     * @param idNextOfKin the idNextOfKin to set
     */
    public void setIdNextOfKin(int idNextOfKin) {
        this.idNextOfKin = idNextOfKin;
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
     * @return the contactDetails
     */
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    /**
     * @param contactDetails the contactDetails to set
     */
    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * @return the contactDetailsAdress
     */
    public ContactDetailsAdress getContactDetailsAdress() {
        return contactDetailsAdress;
    }

    /**
     * @param contactDetailsAdress the contactDetailsAdress to set
     */
    public void setContactDetailsAdress(ContactDetailsAdress contactDetailsAdress) {
        this.contactDetailsAdress = contactDetailsAdress;
    }

    private int idNextOfKin;
    private NextOfKinBasic nextOfKinBasic;
    private ContactDetails contactDetails;
    private ContactDetailsAdress contactDetailsAdress;
}
