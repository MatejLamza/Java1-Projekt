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

public class PatientFull {

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
     * @return the idPatientFull
     */
    public int getIdPatientFull() {
        return idPatientFull;
    }

    /**
     * @param idPatientFull the idPatientFull to set
     */
    public void setIdPatientFull(int idPatientFull) {
        this.idPatientFull = idPatientFull;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the pernamentAdress
     */
    public ContactDetailsAdress getPernamentAdress() {
        return pernamentAdress;
    }

    /**
     * @param pernamentAdress the pernamentAdress to set
     */
    public void setPernamentAdress(ContactDetailsAdress pernamentAdress) {
        this.pernamentAdress = pernamentAdress;
    }

    /**
     * @return the presentAdress
     */
    public ContactDetailsAdress getPresentAdress() {
        return presentAdress;
    }

    /**
     * @param presentAdress the presentAdress to set
     */
    public void setPresentAdress(ContactDetailsAdress presentAdress) {
        this.presentAdress = presentAdress;
    }

    /**
     * @return the nextOfKinContact
     */
    public NextOfKin getNextOfKinContact() {
        return nextOfKinContact;
    }

    /**
     * @param nextOfKinContact the nextOfKinContact to set
     */
    public void setNextOfKinContact(NextOfKin nextOfKinContact) {
        this.nextOfKinContact = nextOfKinContact;
    }

    /**
     * @return the personalDetails
     */
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * @param personalDetails the personalDetails to set
     */
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    /**
     * @return the professionDetails
     */
    public ProfessionDetails getProfessionDetails() {
        return professionDetails;
    }

    /**
     * @param professionDetails the professionDetails to set
     */
    public void setProfessionDetails(ProfessionDetails professionDetails) {
        this.professionDetails = professionDetails;
    }

    /**
     * @return the lifestyle
     */
    public LifeStyle getLifestyle() {
        return lifestyle;
    }

    /**
     * @param lifestyle the lifestyle to set
     */
    public void setLifestyle(LifeStyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    /**
     * @return the basicComplaints
     */
    public BasicComplaints getBasicComplaints() {
        return basicComplaints;
    }

    /**
     * @param basicComplaints the basicComplaints to set
     */
    public void setBasicComplaints(BasicComplaints basicComplaints) {
        this.basicComplaints = basicComplaints;
    }

    /**
     * @return the importantMedComplaints
     */
    public ImportantMedicalComplaints getImportantMedComplaints() {
        return importantMedComplaints;
    }

    /**
     * @param importantMedComplaints the importantMedComplaints to set
     */
    public void setImportantMedComplaints(ImportantMedicalComplaints importantMedComplaints) {
        this.importantMedComplaints = importantMedComplaints;
    }
    @Override
    public String toString(){
        return patient.getIdPatient() + " " +
                contactDetails.getIdContactDetails() + " " +
                pernamentAdress.getIdContactDetailAdress() + " " + 
                nextOfKinContact.getIdNextOfKin() + " " + 
                personalDetails.getIdPersonalDetails() + " " + 
                professionDetails.getIdProfessionDetails() + " " +
                lifestyle.getIdLifeStyle() + " " +
                basicComplaints.getIdBasicComplaints() + " " + 
                importantMedComplaints.getIdImportantMedicalComplaints();
    }

    private int idPatientFull;
    private Patient patient;
    private ContactDetails contactDetails;
    private ContactDetailsAdress pernamentAdress;
    private ContactDetailsAdress presentAdress;
    private NextOfKin nextOfKinContact;
    private PersonalDetails personalDetails;
    private ProfessionDetails professionDetails;
    private LifeStyle lifestyle;
    private BasicComplaints basicComplaints;
    private ImportantMedicalComplaints importantMedComplaints;
}
