/*
 * Created by JFormDesigner on Sun Apr 28 11:53:13 IRDT 2019
 */

package swing_jdbc.view;

import swing_jdbc.model.Entity.User;
import swing_jdbc.model.dao.UserDaoImp;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;

/**
 * @author mohammad
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void checkBox1ActionPerformed(ActionEvent e) {
        if (checkBox1.isSelected()) {
            label1.setVisible(true);
            textField2.setVisible(true);
            textField3.setEnabled(false);
            button1.setText("Recovery");
        } else {
            label1.setVisible(false);
            textField2.setVisible(false);
            textField3.setEnabled(true);
            button1.setText("Login");

        }
    }

    private void checkBox2ItemStateChanged(ItemEvent e) {
        if (checkBox2.isSelected()) {
            label3.setVisible(true);
            textField4.setVisible(true);
            label1.setVisible(true);
            textField2.setVisible(true);
            button1.setText("Register");

        } else {
            label1.setVisible(false);
            textField2.setVisible(false);
            label3.setVisible(false);
            textField4.setVisible(false);
            button1.setText("Login");

        }

    }

    private void thisWindowOpened(WindowEvent e) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {
        UserDaoImp dao = new UserDaoImp();
        User user = null;
        if (button1.getText().equals("Login")) {
            try {
                user = dao.find(textField1.getText());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (user.getPassWord().equals(textField3.getText())) {
                new StudentsView().setVisible(true);
                new Login().setVisible(false);
            }
        } else if (button1.getText().equals("Recovery")) {
            try {
                user = dao.find(textField1.getText());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if ((user.getUserName().equals(textField1.getText()) && (user.getEmail().equals(textField2.getText())))) {
                textField3.setText(user.getPassWord());
            } else {
                JOptionPane.showMessageDialog(null, "User Not Foun");
            }

        } else if (button1.getText().equals("Register")) {
            if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("") && !textField4.getText().equals("")) {

                if (textField3.getText().equals(textField4.getText())) {

                    user = new User(textField1.getText(), textField3.getText(), textField2.getText());
                    try {
                        dao.insert(user);
                        checkBox2.setSelected(false);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "PassWord Not Match");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill All Information");

            }


        } else if (button1.getText().equals("Update/Delete")) {
            String result = JOptionPane.showInputDialog("For u for Update or d for Delete");
            if (result.equals("d")) {
                try {
                    dao.delete(textField1.getText());
                    checkBox3.setSelected(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (result.equals("u")) {
                User usertemp = new User(textField1.getText(), textField3.getText(), textField2.getText());
                try {
                    dao.update(usertemp);
                    checkBox3.setSelected(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cancel Delete Or Update");
            }

        }
    }


    private void textField3CaretUpdate(CaretEvent e) {
        // TODO add your code here
    }

    private void checkBox3ItemStateChanged(ItemEvent e) {
        UserDaoImp dao = new UserDaoImp();
        User user = null;
        if (textField1.getText().equals("") && textField3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill username and password");
        } else {
            try {
                user = dao.find(textField1.getText());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(user);
            if (user==null){
                JOptionPane.showMessageDialog(null, "User not found");
            }else{
                if (user.getPassWord().equals(textField3.getText())) {
                    textField2.setVisible(true);
                    textField2.setText(user.getEmail());
                    textField3.setText(user.getPassWord());
                    textField1.setText(user.getUserName());
                    button1.setText("Update/Delete");
                } else {
                    JOptionPane.showMessageDialog(null, "Password Wrong");
                    checkBox3.setSelected(false);

                }
            }


        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - mohammad
        layeredPane1 = new JLayeredPane();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        checkBox3 = new JCheckBox();

        //======== this ========
        setTitle("Login");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();

        //======== layeredPane1 ========
        {
            layeredPane1.add(textField1, JLayeredPane.DEFAULT_LAYER);
            textField1.setBounds(130, 55, 135, textField1.getPreferredSize().height);

            //---- label1 ----
            label1.setText("Email");
            label1.setVisible(false);
            layeredPane1.add(label1, JLayeredPane.DEFAULT_LAYER);
            label1.setBounds(35, 30, 60, label1.getPreferredSize().height);

            //---- label2 ----
            label2.setText("PassWord");
            layeredPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
            label2.setBounds(38, 95, 85, 16);

            //---- button1 ----
            button1.setText("Login");
            button1.addActionListener(e -> button1ActionPerformed(e));
            layeredPane1.add(button1, JLayeredPane.DEFAULT_LAYER);
            button1.setBounds(135, 160, 125, button1.getPreferredSize().height);

            //---- checkBox1 ----
            checkBox1.setText("Forget Password");
            checkBox1.addActionListener(e -> checkBox1ActionPerformed(e));
            layeredPane1.add(checkBox1, JLayeredPane.DEFAULT_LAYER);
            checkBox1.setBounds(15, 205, 125, checkBox1.getPreferredSize().height);

            //---- checkBox2 ----
            checkBox2.setText("Register User");
            checkBox2.addItemListener(e -> checkBox2ItemStateChanged(e));
            layeredPane1.add(checkBox2, JLayeredPane.DEFAULT_LAYER);
            checkBox2.setBounds(255, 205, 103, 18);

            //---- textField2 ----
            textField2.setVisible(false);
            layeredPane1.add(textField2, JLayeredPane.DEFAULT_LAYER);
            textField2.setBounds(130, 21, 135, textField2.getPreferredSize().height);

            //---- label3 ----
            label3.setText("Re-PassWord");
            label3.setVisible(false);
            layeredPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(39, 130, 85, 16);

            //---- label4 ----
            label4.setText("UserName");
            layeredPane1.add(label4, JLayeredPane.DEFAULT_LAYER);
            label4.setBounds(35, 62, 85, 16);

            //---- textField3 ----
            textField3.addCaretListener(e -> textField3CaretUpdate(e));
            layeredPane1.add(textField3, JLayeredPane.DEFAULT_LAYER);
            textField3.setBounds(130, 90, 135, textField3.getPreferredSize().height);

            //---- textField4 ----
            textField4.setVisible(false);
            layeredPane1.add(textField4, JLayeredPane.DEFAULT_LAYER);
            textField4.setBounds(130, 125, 135, textField4.getPreferredSize().height);

            //---- checkBox3 ----
            checkBox3.setText("Update/Delete User");
            checkBox3.addItemListener(e -> checkBox3ItemStateChanged(e));
            layeredPane1.add(checkBox3, JLayeredPane.DEFAULT_LAYER);
            checkBox3.setBounds(130, 227, 145, checkBox3.getPreferredSize().height);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(layeredPane1, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - mohammad
    private JLayeredPane layeredPane1;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JTextField textField4;
    private JCheckBox checkBox3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
