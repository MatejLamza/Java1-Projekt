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

public class ProfessionDetails {

    /**
     * @return the idProfessionDetails
     */
    public int getIdProfessionDetails() {
        return idProfessionDetails;
    }

    /**
     * @param idProfessionDetails the idProfessionDetails to set
     */
    public void setIdProfessionDetails(int idProfessionDetails) {
        this.idProfessionDetails = idProfessionDetails;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the grossAnnualIncome
     */
    public int getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    /**
     * @param grossAnnualIncome the grossAnnualIncome to set
     */
    public void setGrossAnnualIncome(int grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }
    
    @Override
    public String toString(){
        return idProfessionDetails + " " + occupation + " " + grossAnnualIncome;
    }
    
    private int idProfessionDetails;
    private String occupation;
    private int grossAnnualIncome;

}
