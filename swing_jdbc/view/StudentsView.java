/*
 * Created by JFormDesigner on Fri Apr 26 02:49:03 IRDT 2019
 */

package swing_jdbc.view;

import java.awt.event.*;

import swing_jdbc.model.Entity.Student;
import swing_jdbc.model.dao.StudentDaoImp;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mohammad
 */
public class StudentsView extends JFrame {
    TableModel tableModel;

    public StudentsView() throws SQLException {
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
            Student student = new Student(Integer.parseInt(textField1.getText()), textField2.getText(), textField3.getText());
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
    }

    private void table1MouseEntered(MouseEvent e) {
        table1.getSelectionModel().addListSelectionListener(table1MouseEntered(this));
    }

    private ListSelectionListener table1MouseEntered(StudentsView studentsView) {

        System.out.println(123);
        return null;
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
        label4 = new JLabel();

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

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    table1MouseEntered(e);
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
        btn2.setText("text");

        //---- button1 ----
        button1.setText("Add Student");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- label4 ----
        label4.setText("text");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btn2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button1))
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
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(286, 286, 286)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
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
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btn2)
                        .addComponent(button1))
                    .addGap(120, 120, 120)
                    .addComponent(label4)
                    .addGap(32, 32, 32))
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

    private void getStudent() throws SQLException {
        System.out.println(textField1.getText() + " " + textField2.getText() + " " + textField3.getText() + " ");
        StudentDaoImp dao = new StudentDaoImp();
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        if (textField1.getText().equals("") && textField2.getText().equals("") && textField3.getText().equals("")) {
            list = dao.show();
        } else if (!textField2.getText().equals("") && !textField3.getText().equals("")) {
            list = dao.find(textField2.getText(), textField3.getText());
        } else if (!textField2.getText().equals("") && textField3.getText().equals("")) {
            list = dao.find(textField2.getText(), textField3.getText());
        } else if (textField2.getText().equals("") && !textField3.getText().equals("")) {
            list = dao.find(textField2.getText(), textField3.getText());
        } else if (!textField1.getText().equals("")) {
            student = dao.find(Integer.parseInt(textField1.getText()));
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
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
