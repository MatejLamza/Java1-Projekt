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

public class NextOfKinBasic {

    /**
     * @return the idNextOfKinBasic
     */
    public int getIdNextOfKinBasic() {
        return idNextOfKinBasic;
    }

    /**
     * @param idNextOfKinBasic the idNextOfKinBasic to set
     */
    public void setIdNextOfKinBasic(int idNextOfKinBasic) {
        this.idNextOfKinBasic = idNextOfKinBasic;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the relationshipToPatient
     */
    public String getRelationshipToPatient() {
        return relationshipToPatient;
    }

    /**
     * @param relationshipToPatient the relationshipToPatient to set
     */
    public void setRelationshipToPatient(String relationshipToPatient) {
        this.relationshipToPatient = relationshipToPatient;
    }
    
    @Override
    public String toString(){
        if (middleName!=null) {
            return idNextOfKinBasic + " " + name + " " + middleName + " " + surname;
        }
        else{
            return idNextOfKinBasic + " " + name + " " + surname;
        }
        
    }
    
    private int idNextOfKinBasic;
    private String name;
    private String middleName;
    private String surname;
    private String relationshipToPatient;

}
