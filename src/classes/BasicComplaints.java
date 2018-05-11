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

public class BasicComplaints {

    /**
     * @return the idBasicComplaints
     */
    public int getIdBasicComplaints() {
        return idBasicComplaints;
    }

    /**
     * @param idBasicComplaints the idBasicComplaints to set
     */
    public void setIdBasicComplaints(int idBasicComplaints) {
        this.idBasicComplaints = idBasicComplaints;
    }

    /**
     * @return the statmentOfComplaint
     */
    public String getStatmentOfComplaint() {
        return statmentOfComplaint;
    }

    /**
     * @param statmentOfComplaint the statmentOfComplaint to set
     */
    public void setStatmentOfComplaint(String statmentOfComplaint) {
        this.statmentOfComplaint = statmentOfComplaint;
    }

    /**
     * @return the historyOfPreviousTreatment
     */
    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    /**
     * @param historyOfPreviousTreatment the historyOfPreviousTreatment to set
     */
    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    /**
     * @return the physicianOrHospital
     */
    public String getPhysicianOrHospital() {
        return physicianOrHospital;
    }

    /**
     * @param physicianOrHospital the physicianOrHospital to set
     */
    public void setPhysicianOrHospital(String physicianOrHospital) {
        this.physicianOrHospital = physicianOrHospital;
    }

    private int idBasicComplaints;
    private String statmentOfComplaint;
    private String historyOfPreviousTreatment;
    private String physicianOrHospital;
}
