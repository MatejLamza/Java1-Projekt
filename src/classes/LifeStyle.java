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

public class LifeStyle {

    /**
     * @return the idLifeStyle
     */
    public int getIdLifeStyle() {
        return idLifeStyle;
    }

    /**
     * @param idLifeStyle the idLifeStyle to set
     */
    public void setIdLifeStyle(int idLifeStyle) {
        this.idLifeStyle = idLifeStyle;
    }

    /**
     * @return the vegeterian
     */
    public boolean isVegeterian() {
        return vegeterian;
    }

    /**
     * @param vegeterian the vegeterian to set
     */
    public void setVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    /**
     * @return the smoker
     */
    public boolean isSmoker() {
        return smoker;
    }

    /**
     * @param smoker the smoker to set
     */
    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    /**
     * @return the avgNoCigarettes
     */
    public int getAvgNoCigarettes() {
        return avgNoCigarettes;
    }

    /**
     * @param avgNoCigarettes the avgNoCigarettes to set
     */
    public void setAvgNoCigarettes(int avgNoCigarettes) {
        this.avgNoCigarettes = avgNoCigarettes;
    }

    /**
     * @return the alcoholic
     */
    public boolean isAlcoholic() {
        return alcoholic;
    }

    /**
     * @param alcoholic the alcoholic to set
     */
    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    /**
     * @return the avgNoDrinks
     */
    public int getAvgNoDrinks() {
        return avgNoDrinks;
    }

    /**
     * @param avgNoDrinks the avgNoDrinks to set
     */
    public void setAvgNoDrinks(int avgNoDrinks) {
        this.avgNoDrinks = avgNoDrinks;
    }

    /**
     * @return the useStimulants
     */
    public String getUseStimulants() {
        return useStimulants;
    }

    /**
     * @param useStimulants the useStimulants to set
     */
    public void setUseStimulants(String useStimulants) {
        this.useStimulants = useStimulants;
    }

    /**
     * @return the noCofeTeaDay
     */
    public int getNoCofeTeaDay() {
        return noCofeTeaDay;
    }

    /**
     * @param noCofeTeaDay the noCofeTeaDay to set
     */
    public void setNoCofeTeaDay(int noCofeTeaDay) {
        this.noCofeTeaDay = noCofeTeaDay;
    }

    /**
     * @return the noSoftDrinksDay
     */
    public int getNoSoftDrinksDay() {
        return noSoftDrinksDay;
    }

    /**
     * @param noSoftDrinksDay the noSoftDrinksDay to set
     */
    public void setNoSoftDrinksDay(int noSoftDrinksDay) {
        this.noSoftDrinksDay = noSoftDrinksDay;
    }

    /**
     * @return the haveRegularMeals
     */
    public boolean isHaveRegularMeals() {
        return haveRegularMeals;
    }

    /**
     * @param haveRegularMeals the haveRegularMeals to set
     */
    public void setHaveRegularMeals(boolean haveRegularMeals) {
        this.haveRegularMeals = haveRegularMeals;
    }

    /**
     * @return the haveHomeFood
     */
    public boolean isHaveHomeFood() {
        return haveHomeFood;
    }

    /**
     * @param haveHomeFood the haveHomeFood to set
     */
    public void setHaveHomeFood(boolean haveHomeFood) {
        this.haveHomeFood = haveHomeFood;
    }

    private int idLifeStyle;
    private boolean vegeterian;
    private boolean smoker;
    private int avgNoCigarettes;
    private boolean alcoholic;
    private int avgNoDrinks;
    private String useStimulants;
    private int noCofeTeaDay;
    private int noSoftDrinksDay;
    private boolean haveRegularMeals;
    private boolean haveHomeFood;
}
