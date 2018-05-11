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

public class Test {

    /**
     * @return the idTest
     */
    public int getIdTest() {
        return idTest;
    }

    /**
     * @param idTest the idTest to set
     */
    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    /**
     * @return the testName
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * @return the testResult
     */
    public String getTestResult() {
        return testResult;
    }

    /**
     * @param testResult the testResult to set
     */
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    @Override 
    public String toString(){
        return idTest + " " + testName + " " + testResult;
    }

    private int idTest;
    private String testName;
    private String testResult;
    
}
