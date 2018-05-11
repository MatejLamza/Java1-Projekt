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

public class Medicine {

    /**
     * @return the idMedicine
     */
    public int getIdMedicine() {
        return idMedicine;
    }

    /**
     * @param idMedicine the idMedicine to set
     */
    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
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
    
    @Override
    public String toString(){
        return idMedicine + " " + name;
    }
    
    private int idMedicine;
    private String name;
    
}
