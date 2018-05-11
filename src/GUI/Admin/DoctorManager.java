/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import BL.buissnesClass;
import Menu.DoctorMenu;
import classes.Doctor;
import classes.Schedule;
import classes.Specialization;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Repo;

/**
 *
 * @author Meowcake
 */
public class DoctorManager extends javax.swing.JFrame {

    /**
     * Creates new form DoctorManager
     */
    public DoctorManager() {
        initComponents();
        
        fillList(updateList);
        fillList(dsListDoctors);
        
        updateList.setSelectedIndex(0);
        dsListDoctors.setSelectedIndex(0);
        
        dsDoctor = Repo.getAllDoctors().get(dsListDoctors.getSelectedIndex());
        fillScheduleList(listSchedule, dsDoctor);
        
        currentDoctor = Repo.getAllDoctors().get(updateList.getSelectedIndex());
        lblID.setText(Integer.toString(currentDoctor.getIdDoctor()));
    }
    
    ArrayList<Doctor> allDoctors = Repo.getAllDoctors();
    Doctor currentDoctor = new Doctor();
    Doctor dsDoctor = new Doctor();

    private void fillList(JList list) {

        DefaultListModel<String> model = new DefaultListModel<String>();

        for (Doctor allDoctors : allDoctors) {
            model.addElement(allDoctors.getName() + " " + allDoctors.getSurname() + " " + allDoctors.getSpecialization().getSpecialization());
        }

        list.setModel(model);
    }

    private void fillScheduleList(JList list, Doctor doc) {
        DefaultListModel model = new DefaultListModel();
        ArrayList<Schedule> allSchedules = Repo.getScheduleForDoctor(doc);

        for (Schedule allSchedule : allSchedules) {
            model.addElement(allSchedule.getDate() + " " + allSchedule.getTime());
        }
        list.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        btnInsertDoc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        updateList = new javax.swing.JList<>();
        searchBox = new javax.swing.JTextField();
        btnFIlter = new javax.swing.JButton();
        txtUpdName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUpdSurname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUpdSpec = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dsSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dsListDoctors = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSchedule = new javax.swing.JList<>();
        btnOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(153, 153, 153));

        lblName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblName.setText("Name: ");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Surname:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Specialization: ");

        btnInsertDoc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnInsertDoc.setText("Insert Doctor");
        btnInsertDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnInsertDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnInsertDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        jTabbedPane2.addTab("Insert Doctor", jPanel1);

        updateList.setBackground(new java.awt.Color(204, 204, 204));
        updateList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        updateList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                updateListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(updateList);

        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        btnFIlter.setText("Filter");
        btnFIlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFIlterActionPerformed(evt);
            }
        });

        txtUpdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Surname: ");

        txtUpdSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdSurnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Specialization");

        txtUpdSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdSpecActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Search: ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Doctor ID: ");

        lblID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblID.setText("jLabel8");

        btnDelete.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFIlter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(172, 172, 172))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUpdSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblID)))
                                .addGap(98, 98, 98))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFIlter)
                            .addComponent(jLabel6))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblID))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpdSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUpdSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Update Doctor", jPanel2);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Search: ");

        dsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsSearchActionPerformed(evt);
            }
        });

        dsListDoctors.setBackground(new java.awt.Color(204, 204, 204));
        dsListDoctors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dsListDoctors.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dsListDoctorsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(dsListDoctors);

        listSchedule.setBackground(new java.awt.Color(204, 204, 204));
        listSchedule.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listSchedule);

        btnOrder.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnOrder.setText("Order by Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrder))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Doctor Schedule", jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDocActionPerformed
        // TODO add your handling code here:
        try {
            Doctor doctor = new Doctor();
            Specialization spec = new Specialization();

            doctor.setName(txtName.getText());
            doctor.setSurname(txtSurname.getText());

            spec.setSpecialization(txtSpecialization.getText());
            buissnesClass.insertSpecialization(spec);

            spec = buissnesClass.getLastSpecialization();
            doctor.setSpecialization(spec);

            buissnesClass.insertDoctor(doctor);
            JOptionPane.showMessageDialog(this, spec.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Inserting doctor failed!!");
        }
    }//GEN-LAST:event_btnInsertDocActionPerformed

    private void txtUpdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdNameActionPerformed
        // TODO add your handling code here:
        try {
            if (txtUpdName.getText() == null || txtUpdName.getText().length() == 0) {
                throw new RuntimeException("Textfield Name cannot be empty!!");
            } else {
                currentDoctor.setName(txtUpdName.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_txtUpdNameActionPerformed

    private void updateListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_updateListValueChanged
        // TODO add your handling code here:
        if (updateList.getSelectedValue() == null) {
            updateList.setSelectedIndex(0);
        }

        String fullDoc = updateList.getSelectedValue();

        currentDoctor = Repo.getAllDoctors().get(updateList.getSelectedIndex());
        lblID.setText(Integer.toString(currentDoctor.getIdDoctor()));

        String[] splitted = fullDoc.split(" ");
        String name = splitted[0];
        String surname = splitted[1];
        String spec = splitted[2];

//        String name = DoctorMenu.getNameFromFullName(fullDoc);
//        String surname = DoctorMenu.getSurnameFromFullName(fullDoc);
//        String spec = DoctorMenu.getSpecialization(fullDoc);
        txtUpdName.setText(name);
        txtUpdSurname.setText(surname);
        txtUpdSpec.setText(spec);
    }//GEN-LAST:event_updateListValueChanged


    private void btnFIlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFIlterActionPerformed
        // TODO add your handling code here:
//        try {
//            String filter = searchBox.getText();
//            ArrayList<Doctor> originalList = allDoctors;
//            ArrayList<Doctor> filtieredList = new ArrayList<>();
//
//            DefaultListModel model = new DefaultListModel();
//
//            for (Doctor doctor : originalList) {
//                if (doctor.getName().startsWith(filter)) {
//                    filtieredList.add(doctor);
//
//                }
//            }
//
//            for (Doctor doctor : filtieredList) {
//                model.addElement(doctor.getName() + " " + doctor.getSurname() + " " + doctor.getSpecialization().getSpecialization());
//            }
//
//            updateList.setModel(model);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_btnFIlterActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            Repo.updateDoctor(currentDoctor);
            JOptionPane.showMessageDialog(this, "Doctor sucessfuly updated!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating doctor!");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtUpdSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdSurnameActionPerformed
        // TODO add your handling code here:
        try {
            if (txtUpdSurname.getText() == null || txtUpdSurname.getText().length() == 0) {
                throw new RuntimeException("Textfield Name cannot be empty!!");
            } else {
                currentDoctor.setSurname(txtUpdSurname.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_txtUpdSurnameActionPerformed

    private void txtUpdSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdSpecActionPerformed
        // TODO add your handling code here:
        try {
            Specialization spec = new Specialization();

            if (txtUpdSpec.getText() == null || txtUpdSpec.getText().length() == 0) {
                spec.setSpecialization("General");
                spec.setIdSpecialization(1);
                currentDoctor.setSpecialization(spec);
                throw new RuntimeException("Specialization has been set to General");
            } else {
                spec.setSpecialization(txtUpdSpec.getText());
                Repo.insertSpecialization(spec.getSpecialization());
                spec = Repo.getLastSpecialization();
                currentDoctor.setSpecialization(spec);
                JOptionPane.showMessageDialog(this, "Specialization sucessfuly changed!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtUpdSpecActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Repo.removeDoctor(currentDoctor.getIdDoctor());
            JOptionPane.showMessageDialog(this, "Sucessfuly removed doctor!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Problem with removing doctor!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
        try {
                updateList.setSelectedIndex(0);
                String filter = searchBox.getText();
                ArrayList<Doctor> originalList = allDoctors;
                ArrayList<Doctor> filtieredList = new ArrayList<>();

                DefaultListModel model = new DefaultListModel();
                copyArrayList(originalList, filtieredList,filter);

//            for (Doctor doctor : originalList) {
//                if (doctor.getName().startsWith(filter)) {
//                    filtieredList.add(doctor);
//
//                }
//            }
                for (Doctor doctor : filtieredList) {
                    model.addElement(doctor.getName() + " " + doctor.getSurname() + " " + doctor.getSpecialization().getSpecialization());
                }

                updateList.setModel(model);
//           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"List is empty");
            //e.printStackTrace();
        }

    }//GEN-LAST:event_searchBoxActionPerformed

    private void dsListDoctorsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dsListDoctorsValueChanged
        // TODO add your handling code here:
        if (dsListDoctors.getSelectedValue()==null) {
            dsListDoctors.setSelectedIndex(0);
        }
        
        dsDoctor = Repo.getAllDoctors().get(dsListDoctors.getSelectedIndex());
        
        DefaultListModel model = new DefaultListModel();
        for (Schedule schedule : Repo.getScheduleForDoctor(dsDoctor)) {
            model.addElement(schedule.getDate() + " " + schedule.getTime());
        }
        listSchedule.setModel(model);
    }//GEN-LAST:event_dsListDoctorsValueChanged

    private void dsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsSearchActionPerformed
        // TODO add your handling code here:
          try {
              
              dsListDoctors.setSelectedIndex(0);
              String filter = dsSearch.getText();
              ArrayList<Doctor> original = allDoctors;
              ArrayList<Doctor> filiteredList = new ArrayList<>();
              
              copyArrayList(original, filiteredList,filter);
              
              DefaultListModel model = new DefaultListModel();
              
              for (Doctor doctor : filiteredList) {
                 model.addElement(doctor.getName() + " " + doctor.getSurname() + " " + doctor.getSpecialization().getSpecialization());
             }
              
              dsListDoctors.setModel(model);
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"List is empty");
            e.printStackTrace();
        }

         
    }//GEN-LAST:event_dsSearchActionPerformed

    private ArrayList<Doctor> copyArrayList(ArrayList<Doctor> original, ArrayList<Doctor> filteredList,String filter) {
        

        for (Doctor doctor : original) {
            if (doctor.getName().startsWith(filter)) {
                filteredList.add(doctor);
            }
        }
        return filteredList;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFIlter;
    private javax.swing.JButton btnInsertDoc;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JList<String> dsListDoctors;
    private javax.swing.JTextField dsSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JList<String> listSchedule;
    private javax.swing.JTextField searchBox;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUpdName;
    private javax.swing.JTextField txtUpdSpec;
    private javax.swing.JTextField txtUpdSurname;
    private javax.swing.JList<String> updateList;
    // End of variables declaration//GEN-END:variables
}