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

public class ContactDetails {

    /**
     * @return the idContactDetails
     */
    public int getIdContactDetails() {
        return idContactDetails;
    }

    /**
     * @param idContactDetails the idContactDetails to set
     */
    public void setIdContactDetails(int idContactDetails) {
        this.idContactDetails = idContactDetails;
    }

    /**
     * @return the telephoneWork
     */
    public String getTelephoneWork() {
        return telephoneWork;
    }

    /**
     * @param telephoneWork the telephoneWork to set
     */
    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    /**
     * @return the telephoneHome
     */
    public String getTelephoneHome() {
        return telephoneHome;
    }

    /**
     * @param telephoneHome the telephoneHome to set
     */
    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the pager
     */
    public String getPager() {
        return pager;
    }

    /**
     * @param pager the pager to set
     */
    public void setPager(String pager) {
        this.pager = pager;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    private int idContactDetails;
    private String telephoneWork;
    private String telephoneHome;
    private String mobile;
    private String pager;
    private String fax;
    private String email;

}
