/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Jordan
 */
public class TradeDialog extends javax.swing.JDialog 
{
    Player p1, p2;
    ArrayList<String> propsP1, propsP2;
    ArrayList<Property>p1Trade, p2Trade;

    private class TradeListener implements ActionListener
    {

        private JDialog di;
        public TradeListener(JDialog d)
        {
            di = d;
        }
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           if(p1MoneyLabel.getText().equalsIgnoreCase("") && p2MoneyLabel.getText().equalsIgnoreCase(""))
           {
               
           }
           else if(p1MoneyLabel.getText().equalsIgnoreCase(""))
           {
               p1.acceptPayment(Integer.parseInt(p2MoneyLabel.getText()));
               p2.acceptPayment(-1 * Integer.parseInt(p2MoneyLabel.getText()));
                
           }
           else if(p2MoneyLabel.getText().equalsIgnoreCase(""))
           {
                p1.acceptPayment(-1 * Integer.parseInt(p1MoneyLabel.getText()));
                p2.acceptPayment(Integer.parseInt(p1MoneyLabel.getText()));
           }
           else
           {
               p1.acceptPayment(Integer.parseInt(p2MoneyLabel.getText()));
               p2.acceptPayment(-1 * Integer.parseInt(p2MoneyLabel.getText()));
               p1.acceptPayment(-1 * Integer.parseInt(p1MoneyLabel.getText()));
               p2.acceptPayment(Integer.parseInt(p1MoneyLabel.getText()));
           }
           
           
           
           
           for(Property p : p1Trade)
           {
               p.setOwner(p2.getName());
               p2.getProperties().add(p);
           }
           
           for(Property p : p2Trade)
           {
               p.setOwner(p1.getName());
               p1.getProperties().add(p);
           }
           di.dispose();
        }
        
    }
    private class AddListener implements ActionListener
    {
        private JComboBox box;
        private Player p;
        private int pl;
        private JTextField text;
        private JLabel money, prop;
        private int x;
        private JCheckBox checkBox;

        public AddListener(JComboBox b, Player pl, int num, JTextField t, JLabel m, JLabel prop, JCheckBox c)
        {
            box = b;
            p = pl;
            this.pl = num;
            text = t;
            money = m;
            this.prop = prop;
            checkBox = c;
                    
        }
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            boolean isNum = true;
            if(!text.getText().equalsIgnoreCase(""))
            {
                try
                {
                    x = Integer.parseInt(text.getText());
                    
                    if(x > p.getBalance())
                    {
                        JOptionPane.showMessageDialog(null, "The String "+ text.getText() + " is greater than the current balance of $"+p.getBalance() + ", try again");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "The String "+ text.getText() + " isn't a real number, try again");
                    isNum = false;
                }
                if(isNum)
                {
                    money.setText(""+ x);
                }
            }
            String sel;
            ArrayList<String> currentString;
            ArrayList<Property> currentProperty;
            if(pl == 1)
            {
                currentProperty = p1Trade;
                currentString = propsP1;
            }
            else
            {
                currentProperty = p2Trade;
                currentString = propsP2;
            }
            
            if(checkBox.isSelected())
            {
                sel = (String)box.getSelectedItem();
                currentString.add(sel);
                currentProperty.add(p.getProperties().remove(p.indexOf(sel)));
                box.setModel(new DefaultComboBoxModel(p.getPropertyNames()));
            }
            prop.setText(currentString + "");
        }
    }
    /**
     * Creates new form TradeDialog
     */
    public TradeDialog(Player p1, Player p2) 
    {
        super(new JFrame(), true);
        this.p1 = p1;
        this.p2 = p2;
        initComponents();
        setTitle(p1.getName() + " trading with " + p2.getName());
        propsP1 = new ArrayList<>();
        propsP2 = new ArrayList<>();
        p1Trade = new ArrayList<>();
        p2Trade = new ArrayList<>();
        p1NameLabel.setText("Player 1: " +p1.getName());
        p2NameLabel.setText("Player 2: " +p2.getName());
        
        p1AddButton.addActionListener(new AddListener(p1ComboBox, this.p1, 1, p1MoneyField, p1MoneyLabel, p1PropLabel, p1AddProperty));
        p2AddButton.addActionListener(new AddListener(p2ComboBox, this.p2, 2, p2MoneyField, p2MoneyLabel, p2PropLabel, p2AddProperty));
        tradeButton.addActionListener(new TradeListener(this));
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        p1NameLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        p1MoneyField = new javax.swing.JTextField();
        p1ComboBox = new javax.swing.JComboBox();
        p1AddButton = new javax.swing.JButton();
        p1AddProperty = new javax.swing.JCheckBox();
        aLabel = new javax.swing.JLabel();
        p1PropLabel = new javax.swing.JLabel();
        p1MoneyLabel = new javax.swing.JLabel();
        tradeButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        p2NameLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        p2MoneyField = new javax.swing.JTextField();
        p2ComboBox = new javax.swing.JComboBox();
        p2AddButton = new javax.swing.JButton();
        p2AddProperty = new javax.swing.JCheckBox();
        aLabel2 = new javax.swing.JLabel();
        p2PropLabel = new javax.swing.JLabel();
        p2MoneyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        p1NameLabel.setText("Player 1: ");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setText("Money $: ");

        p1ComboBox.setModel(new javax.swing.DefaultComboBoxModel(p1.getPropertyNames()));

        p1AddButton.setText("Add");

        p1AddProperty.setText("Add Property");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p1MoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(p1AddButton))
                            .addComponent(p1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(p1AddProperty)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(p1MoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(p1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(p1AddProperty)
                .addContainerGap())
        );

        aLabel.setText("Money Offer: $ ");

        p1PropLabel.setText("Property Offers: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(p1NameLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1PropLabel)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(aLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p1MoneyLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1NameLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLabel)
                    .addComponent(p1MoneyLabel))
                .addGap(18, 18, 18)
                .addComponent(p1PropLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tradeButton.setText("Trade!");

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        p2NameLabel.setText("Player 2: ");

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setText("Money $: ");

        p2ComboBox.setModel(new javax.swing.DefaultComboBoxModel(p2.getPropertyNames()));

        p2AddButton.setText("Add");

        p2AddProperty.setText("Add Property");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p2MoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(p2AddButton))
                            .addComponent(p2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(p2AddProperty)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(p2MoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(p2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(p2AddProperty)
                .addContainerGap())
        );

        aLabel2.setText("Money Offer: $");

        p2PropLabel.setText("Propety Offers: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(p2NameLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2PropLabel)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(aLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p2MoneyLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p2NameLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLabel2)
                    .addComponent(p2MoneyLabel))
                .addGap(18, 18, 18)
                .addComponent(p2PropLabel)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(tradeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tradeButton))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TradeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                TradeDialog dialog = new TradeDialog(null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JLabel aLabel2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton p1AddButton;
    private javax.swing.JCheckBox p1AddProperty;
    private javax.swing.JComboBox p1ComboBox;
    private javax.swing.JTextField p1MoneyField;
    private javax.swing.JLabel p1MoneyLabel;
    private javax.swing.JLabel p1NameLabel;
    private javax.swing.JLabel p1PropLabel;
    private javax.swing.JButton p2AddButton;
    private javax.swing.JCheckBox p2AddProperty;
    private javax.swing.JComboBox p2ComboBox;
    private javax.swing.JTextField p2MoneyField;
    private javax.swing.JLabel p2MoneyLabel;
    private javax.swing.JLabel p2NameLabel;
    private javax.swing.JLabel p2PropLabel;
    private javax.swing.JButton tradeButton;
    // End of variables declaration//GEN-END:variables
}
