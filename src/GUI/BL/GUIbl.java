/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.BL;

import classes.Doctor;
import classes.Patient;
import classes.PatientRecord;
import classes.Schedule;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
*
* @author Meowcake
*/

public class GUIbl {
    
    public static void fillListPatients(JList list,ArrayList<Patient> allPatients){
        
        DefaultListModel model = new DefaultListModel();
        
        for (Patient allPatient : allPatients) {
            model.addElement( allPatient.getIdPatient() + " " + allPatient.getName() + " " + allPatient.getSurname());
        }
        
        list.setModel(model);
    }
    
    public static void fillListSchedule(JList list,ArrayList<Schedule> schedule){
        DefaultListModel model = new DefaultListModel();
        
        for (Schedule schedule1 : schedule) {
            model.addElement(schedule1.toString());
        }
        
        list.setModel(model);
    }
    
    public static void fillListDoctors(JList list,ArrayList<Doctor> allDoctors){
        DefaultListModel model = new DefaultListModel();
        
        for (Doctor allDoctor : allDoctors) {
            model.addElement(allDoctor.getName() + " " + allDoctor.getSurname() + " " + allDoctor.getSpecialization().getSpecialization() );
        }
        
        list.setModel(model);
    }
    
    public static void fillListPatientRecords(JList list, ArrayList<PatientRecord> patientRecords){
        DefaultListModel model = new DefaultListModel();
        
        for (PatientRecord patientRecord : patientRecords) {
         model.addElement(patientRecord.toString());
        }
        
        list.setModel(model);
    }
    
   

}
