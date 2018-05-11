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

public class ImportantMedicalComplaints {

    /**
     * @return the idImportantMedicalComplaints
     */
    public int getIdImportantMedicalComplaints() {
        return idImportantMedicalComplaints;
    }

    /**
     * @param idImportantMedicalComplaints the idImportantMedicalComplaints to set
     */
    public void setIdImportantMedicalComplaints(int idImportantMedicalComplaints) {
        this.idImportantMedicalComplaints = idImportantMedicalComplaints;
    }

    /**
     * @return the isDiabetic
     */
    public boolean isIsDiabetic() {
        return isDiabetic;
    }

    /**
     * @param isDiabetic the isDiabetic to set
     */
    public void setIsDiabetic(boolean isDiabetic) {
        this.isDiabetic = isDiabetic;
    }

    /**
     * @return the isHypertensive
     */
    public boolean isIsHypertensive() {
        return isHypertensive;
    }

    /**
     * @param isHypertensive the isHypertensive to set
     */
    public void setIsHypertensive(boolean isHypertensive) {
        this.isHypertensive = isHypertensive;
    }

    /**
     * @return the cardiacCondition
     */
    public String getCardiacCondition() {
        return cardiacCondition;
    }

    /**
     * @param cardiacCondition the cardiacCondition to set
     */
    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    /**
     * @return the digestiveCondition
     */
    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    /**
     * @param digestiveCondition the digestiveCondition to set
     */
    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    /**
     * @return the orthopedicCondition
     */
    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    /**
     * @param orthopedicCondition the orthopedicCondition to set
     */
    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    /**
     * @return the muscularCondition
     */
    public String getMuscularCondition() {
        return muscularCondition;
    }

    /**
     * @param muscularCondition the muscularCondition to set
     */
    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    /**
     * @return the neurologicalCondition
     */
    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    /**
     * @param neurologicalCondition the neurologicalCondition to set
     */
    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    /**
     * @return the knownAllergies
     */
    public String getKnownAllergies() {
        return knownAllergies;
    }

    /**
     * @param knownAllergies the knownAllergies to set
     */
    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    /**
     * @return the knownReactionToSpecDrugs
     */
    public String getKnownReactionToSpecDrugs() {
        return knownReactionToSpecDrugs;
    }

    /**
     * @param knownReactionToSpecDrugs the knownReactionToSpecDrugs to set
     */
    public void setKnownReactionToSpecDrugs(String knownReactionToSpecDrugs) {
        this.knownReactionToSpecDrugs = knownReactionToSpecDrugs;
    }

    /**
     * @return the majorSurgeries
     */
    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    /**
     * @param majorSurgeries the majorSurgeries to set
     */
    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }
    
    private int idImportantMedicalComplaints;
    private boolean isDiabetic;
    private boolean isHypertensive;
    private String cardiacCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    private String knownAllergies;
    private String knownReactionToSpecDrugs;
    private String majorSurgeries;
    

}
