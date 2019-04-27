/*
 * Created by JFormDesigner on Fri Apr 26 02:49:03 IRDT 2019
 */

package swing_jdbc.view;

import swing_jdbc.model.Entity.Student;
import swing_jdbc.model.dao.StudentDaoImp;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mohammad
 */
public class StudentsView extends JFrame {
        public StudentsView() {
        initComponents();
        setTitle("Student List");

        btn2.addActionListener(e -> {
            try {
                getStudent();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }


    private void button1ActionPerformed(ActionEvent e) {
        if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter Full Info");
        else {
            StudentDaoImp dao = new StudentDaoImp();
            Student student = new Student(textField1.getText(), textField2.getText(), textField3.getText());
            try {
                dao.insert(student);
                getStudent();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void init() {
        try {
            getStudent();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void thisWindowActivated(WindowEvent e) {
        init();
//        Student student = change();


    }


    private void scrollPane1MouseClicked(MouseEvent e) {
//    change();
    }


    private void btn2ActionPerformed(ActionEvent e) {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        System.out.println(table1.getValueAt(1, 1));
        System.out.println(table1.getSelectedRows());
        System.out.println(table1.getSelectedColumn());
        System.out.println(table1.getSelectedRow());
        System.out.println();
    }

    private void button2ActionPerformed(ActionEvent e) {
        StudentDaoImp dao = new StudentDaoImp();
        Student student = null;
        Student studentupdate = null;
        if (button2.getText().equals("Save")) {
            try {
                student = dao.find(textField6.getText(), true);
                if (student != null) {
                    studentupdate = new Student(textField6.getText(), textField4.getText(), textField5.getText());
                    dao.Update(studentupdate);
                    JOptionPane.showMessageDialog(null, "Update Success");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    getStudent();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                textField6.setText("");
                textField5.setText("");
                textField4.setText("");
                button2.setText("Edit");
            }

        } else {
            button2.setText("Save");
//            ListSelectionModel select = table1.getSelectionModel();
//            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//            select.addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent e) {
//                                                int row = table1.getSelectedRow();
//                                                String studentcode = (String)table1.getValueAt(row, 0);
//                                                String firstname = (String) table1.getValueAt(row, 1);
//                                                String lastname = (String) table1.getValueAt(row, 2);
//                                                studentshre = new Student(studentcode, firstname, lastname);
//                }
//            });


            int row = table1.getSelectedRow();
            if (textField6.getText().equals("")) {
                textField6.setText((String) table1.getValueAt(row, 0));
                textField4.setText((String) table1.getValueAt(row, 1));
                textField5.setText((String) table1.getValueAt(row, 2));
            }
        }


    }

    private void change() {
//
        ListSelectionModel select = table1.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            //                                            @Override
            public void valueChanged(ListSelectionEvent e) {
//                                                int row = table1.getSelectedRow();
//                                                String studentcode = (String)table1.getValueAt(row, 0);
//                                                String firstname = (String) table1.getValueAt(row, 1);
//                                                String lastname = (String) table1.getValueAt(row, 2);
//                                                studentshre = new Student(studentcode, firstname, lastname);
            }
        });
//        );
//        System.out.println(studentshre.getStudentCode()+studentshre.getFirstName()+studentshre.getLastName());
//
//        return studentshre;
    }

    private void btn3ActionPerformed(ActionEvent e) {
        StudentDaoImp dao = new StudentDaoImp();
        Student student = null;
        int row = table1.getSelectedRow();
        if (row >= 0) {
            int result = JOptionPane.showConfirmDialog(null, " Delete Student \n First Name:" + table1.getValueAt(row, 1) + "\n Last Name :" + table1.getValueAt(row, 2) + "\n Student Code : " + table1.getValueAt(row, 0), "Remove Student", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                try {
                    student = dao.find(String.valueOf(table1.getValueAt(row, 0)), true);
                    if (student!=null)dao.delete(student.getStudentCode());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mohammad
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField3 = new JTextField();
        btn2 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        btn3 = new JButton();
        textField7 = new JTextField();
        label4 = new JLabel();
        textField8 = new JTextField();
        label5 = new JLabel();
        textField9 = new JTextField();
        label6 = new JLabel();
        button3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        checkBox1 = new JCheckBox();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
            }
        });
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- textField1 ----
        textField1.addCaretListener(e -> textField1CaretUpdate(e));

        //---- textField2 ----
        textField2.addCaretListener(e -> textField2CaretUpdate(e));

        //---- label1 ----
        label1.setText("StudentCode");

        //---- label2 ----
        label2.setText("FirstName");

        //---- label3 ----
        label3.setText("LastName");

        //---- textField3 ----
        textField3.addCaretListener(e -> textField3CaretUpdate(e));

        //---- btn2 ----
        btn2.setText("Show All Student");
        btn2.addActionListener(e -> {
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
		});

        //---- button1 ----
        button1.setText("Add Student");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Edit & Save");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- textField6 ----
        textField6.setEditable(false);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }

        //---- btn3 ----
        btn3.setText("Delete Student");
        btn3.addActionListener(e -> {
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn3ActionPerformed(e);
		});

        //---- textField7 ----
        textField7.addCaretListener(e -> textField3CaretUpdate(e));

        //---- label4 ----
        label4.setText("LastName");

        //---- textField8 ----
        textField8.addCaretListener(e -> textField2CaretUpdate(e));

        //---- label5 ----
        label5.setText("FirstName");

        //---- textField9 ----
        textField9.addCaretListener(e -> textField1CaretUpdate(e));

        //---- label6 ----
        label6.setText("TeacherCode");

        //---- button3 ----
        button3.setText("Add Teacher");
        button3.addActionListener(e -> button1ActionPerformed(e));

        //---- btn4 ----
        btn4.setText("Delete Teacher");
        btn4.addActionListener(e -> {
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn3ActionPerformed(e);
		});

        //---- btn5 ----
        btn5.setText("Show All Teacher");
        btn5.addActionListener(e -> {
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
			btn2ActionPerformed(e);
		});

        //---- checkBox1 ----
        checkBox1.setText("Teacher Edit");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                            .addGap(146, 146, 146)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkBox1)))
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(133, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label6)
                                .addComponent(label5)
                                .addComponent(label4))))
                    .addGap(15, 15, 15)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(checkBox1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btn2)
                                .addComponent(button1)
                                .addComponent(btn3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(btn4)
                                .addComponent(btn5))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(151, 151, 151))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    private void textField1CaretUpdate(javax.swing.event.CaretEvent evt) {
        // TODO add your handling code here:
        try {
            getStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void textField2CaretUpdate(javax.swing.event.CaretEvent evt) {
        // TODO add your handling code here:
        try {
            getStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void textField3CaretUpdate(javax.swing.event.CaretEvent evt) {
        // TODO add your handling code here:
        try {
            getStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getTeacher()throws SQLException{




    }
    private void getStudent() throws SQLException {
        System.out.println(textField1.getText() + " " + textField2.getText() + " " + textField3.getText() + " ");
        StudentDaoImp dao = new StudentDaoImp();
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        if (textField1.getText().equals("") && textField2.getText().equals("") && textField3.getText().equals("")) {
            list = dao.show();
        } else if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("")) {
            list = dao.find(textField1.getText(), textField2.getText(), textField3.getText());
        } else if (!textField2.getText().equals("") && textField3.getText().equals("")) {
            list = dao.find(null, textField2.getText(), textField3.getText());
        } else if (textField2.getText().equals("") && !textField3.getText().equals("")) {
            list = dao.find(null, textField2.getText(), textField3.getText());
        } else if (!textField1.getText().equals("")) {
            student = dao.find(textField1.getText(), false);
            if (student != null)
                list.add(new Student(student.getStudentCode(), student.getFirstName(), student.getLastName()));

        }
        if (list != null) {
            Object[][] o = new Object[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                o[i][0] = list.get(i).getStudentCode();
                o[i][1] = list.get(i).getFirstName();
                o[i][2] = list.get(i).getLastName();

            }
            TableModel dm = new DefaultTableModel(o, new String[]{"studentcode", "firstname", "lastname"});
            table1.setModel(dm);
            dm.addTableModelListener(table1);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mohammad
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField3;
    private JButton btn2;
    private JButton button1;
    private JButton button2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton btn3;
    private JTextField textField7;
    private JLabel label4;
    private JTextField textField8;
    private JLabel label5;
    private JTextField textField9;
    private JLabel label6;
    private JButton button3;
    private JButton btn4;
    private JButton btn5;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
