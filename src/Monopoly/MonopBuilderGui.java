package Monopoly;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Jordan
 */
public class MonopBuilderGui extends javax.swing.JFrame 
{
    protected Board b;
    private Bank bank;
    private Player currentPlayer;
    private BufferedImage[] pieceImages;
    private String tradeChoice;
    private JComboBox box;
    
    /**
     * A listener for the Trade button on the main window
     */
    private class TradeListener implements ActionListener
    {
        
        private class OKListener implements ActionListener
        {
            private JDialog di;

            public OKListener(JDialog d)
            {
                di = d;
            }
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                tradeChoice = (String)box.getSelectedItem();
                di.dispose();
            }
            
        }
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JDialog d = new JDialog(new JFrame(), true);
            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            
            d.setTitle("Trade with whom..?");
            box = new JComboBox();
            box.setModel(new DefaultComboBoxModel(bank.getPlayerNames()));
            d.add(box, BorderLayout.NORTH);
            JButton ok = new JButton("Ok");
            ok.addActionListener(new OKListener(d));
            d.add(ok, BorderLayout.SOUTH);
            d.setSize(250,100);
            d.setVisible(true);
            d.dispose();
            TradeDialog t = new TradeDialog(currentPlayer, bank.getPlayers().get(bank.indexOf(tradeChoice)));
            updateLabels();
            
        }
        
    }
    
    /**
     * A listener for the manage button on the main window
     */
    private class ManageListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            ChoosePropertyDialog c = new ChoosePropertyDialog(null, currentPlayer);
            updateLabels();
            updateBoard();
        }
        
    }
    /**
     * The listener for the firnish turn button
     */
    private class finishTurnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            currentPlayer = bank.switchPlayers();
            finishTurnButton.setEnabled(false);
            rollButton.setEnabled(true);
            updateLabels();
        }
        
    }
    
    /**
     * Listener for the roll button
     */
    private class rollListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int x = currentPlayer.getPiecePosition();
            currentPlayer.roll();
            if(x + currentPlayer.getRoll1() + currentPlayer.getRoll2() >= 40 && !currentPlayer.isInJail())
            {
                logTextArea.setText(logTextArea.getText() + currentPlayer.getName() + " has passed Go. They are rewarded $" 
                        + bank.PASS_GO_AMOUNT+"!\n");
            }
            if(currentPlayer.hasDoubles())
            {
                logTextArea.setText(logTextArea.getText() + currentPlayer.getName() + " has rolled doubles! "
                        + "They get to roll again!\n");
                if(currentPlayer.getNumDoubles() == 3 && bank.tripDoubles())
                {
                    currentPlayer.getPiece().moveTo(29);
                    updateBoard();
                }
            }
            else
            {
                rollButton.setEnabled(false);
                finishTurnButton.setEnabled(true);
            }
            updateBoard();
            updateLabels();
            
            logTextArea.setText(logTextArea.getText() + currentPlayer.landOn(b, bank));
            
            updateLabels();
            updateBoard();
            if(currentPlayer.isBankrupt())
            {
                logTextArea.setText(bank.bankrupt(currentPlayer));
            }
        }
        
    }
    /**
     * Creates new form MonopBuilderGui
     */
    public MonopBuilderGui() 
    {
        bank = new Bank();
        b = new Board();
        currentPlayer = bank.chooseFirst();
        setTitle("Monopoly by Jordan Giacone");
        
        
        initpieceImages();
        initComponents();
        addListeners();
        updateLabels();
    }
    private void addListeners()
    {
        rollButton.addActionListener(new rollListener());
        finishTurnButton.addActionListener(new finishTurnListener());
        manageButton.addActionListener(new ManageListener());
        tradeButton.addActionListener(new TradeListener());
    }
    
    private void updateBoard()
    {
        backgroundLabel.setIcon(overlayImages(pieceImages));
    }
    
    private void updateLabels()
    {
        nameLabel.setText("Name: " + currentPlayer.getName());
        currentCashLabel.setText("Balance: " + currentPlayer.getBalance());
        int one = currentPlayer.getRoll1(), two = currentPlayer.getRoll2();
        rollLabel.setText("Roll: "+ one + " + " + two + " = " +(one + two));
    }
    
    private void initpieceImages()
    {
        pieceImages = new BufferedImage[bank.getPlayers().size()];
        Player p;
        int j = bank.getPlayers().indexOf(currentPlayer);
        for(int i = 0; i < bank.getPlayers().size(); i++)
        {
            if(j == bank.getPlayers().size())
            {
                j = 0;
            }
            p = bank.getPlayers().get(j);
            pieceImages[j] = p.getPiece().getImage();
            j++;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boardPanel = new javax.swing.JPanel();
        backgroundLabel = new JLabel(overlayImages(pieceImages));
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        bottomButtonPanel = new javax.swing.JPanel();
        rollButton = new javax.swing.JButton();
        finishTurnButton = new javax.swing.JButton();
        tradeButton = new javax.swing.JButton();
        manageButton = new javax.swing.JButton();
        topLabelPanel = new javax.swing.JPanel();
        currentCashLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        rollLabel = new javax.swing.JLabel();
        propertiesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boardPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout boardPanelLayout = new javax.swing.GroupLayout(boardPanel);
        boardPanel.setLayout(boardPanelLayout);
        boardPanelLayout.setHorizontalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        boardPanelLayout.setVerticalGroup(
            boardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        jScrollPane1.setViewportView(logTextArea);

        bottomButtonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rollButton.setText("Roll");

        finishTurnButton.setText("Finish Turn");

        tradeButton.setText("Trade");

        manageButton.setText("Manage Properties");

        javax.swing.GroupLayout bottomButtonPanelLayout = new javax.swing.GroupLayout(bottomButtonPanel);
        bottomButtonPanel.setLayout(bottomButtonPanelLayout);
        bottomButtonPanelLayout.setHorizontalGroup(
            bottomButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rollButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishTurnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tradeButton)
                .addGap(0, 256, Short.MAX_VALUE))
        );
        bottomButtonPanelLayout.setVerticalGroup(
            bottomButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tradeButton)
                    .addComponent(finishTurnButton)
                    .addComponent(rollButton)
                    .addComponent(manageButton))
                .addContainerGap())
        );

        topLabelPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        currentCashLabel.setText("Balance: ");

        nameLabel.setText("Name: ");

        rollLabel.setText("Roll: ");

        javax.swing.GroupLayout topLabelPanelLayout = new javax.swing.GroupLayout(topLabelPanel);
        topLabelPanel.setLayout(topLabelPanelLayout);
        topLabelPanelLayout.setHorizontalGroup(
            topLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topLabelPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(currentCashLabel)
                        .addGap(55, 55, 55))
                    .addGroup(topLabelPanelLayout.createSequentialGroup()
                        .addComponent(rollLabel)
                        .addContainerGap())))
        );
        topLabelPanelLayout.setVerticalGroup(
            topLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(currentCashLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(rollLabel)
                .addContainerGap())
        );

        propertiesPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topLabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(topLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(propertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(bottomButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method to overlay Images
     *
     * @param bgImage --> The background Image
     * @param fgImage --> The foreground Image
     * @return --> overlayed image (fgImage over bgImage)
     */
    private ImageIcon overlayImages(BufferedImage[] fgImages) 
    {
 
        /**
         * Doing some preliminary validations.
         * Foreground image height cannot be greater than background image height.
         * Foreground image width cannot be greater than background image width.
         *
         * returning a null value if such condition exists.
         */
        BufferedImage bgImage = null;
        try
        {
            bgImage = ImageIO.read(new File("images/board50borderless.png"));
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "No image at" + "images/board50borderless.png");
            System.exit(0);
        }
        
        /**Create a Graphics  from the background image**/
        Graphics2D g = bgImage.createGraphics();
        /**Set Antialias Rendering**/
        //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /**
         * Draw background image at location (0,0)
         * You can change the (x,y) value as required
         */
        g.drawImage(bgImage, 0, 0, null);

        /**
         * Draw foreground image at location (0,0)
         * Change (x,y) value as required.
         */
        int i = 0, x, y; 
        for(BufferedImage im : fgImages)
        {
            int j = bank.getPlayers().get(i).getPiece().getPosition();
            Point2D.Double pnt = b.getBoard()[j].getCoords();
            x = (int)pnt.x;
            y = (int)pnt.y;
            g.drawImage(im, x, y, null);
            i++;
        }
        
        Property p;
        BufferedImage house = null, hotelV = null, hotelH = null;
        try
        {
            house = ImageIO.read(new File("images/house.png"));
            hotelV = ImageIO.read(new File("images/hotel_v.png"));
            hotelH = ImageIO.read(new File("images/hotel_h.png"));
        }
        catch(IOException e)
        {
            System.exit(0);
        }
        
        //Add house icons
        for(Space s : b.getBoard())
        {
            if(s instanceof Property && !(s instanceof RailRoad) && !(s instanceof Utility))
            {
                p = (Property)s;
                if(p.numHouses > 0)
                {
                    Point2D.Double pnt = p.getHouseCoord();
                    int ax = (int)pnt.x, ay = (int)pnt.y;

                    if(p.isVert())
                    {
                        int add = 12, place = b.indexOf(p);
                        if(place > 10 && place < 20)
                        {
                            add *= -1;
                        }


                        for(int n = 1; n <= p.getNumHouses(); n++)
                        {
                            g.drawImage(house, ax, ay + (n * add), null);
                        }
                    }
                    else 
                    {
                        int add = 12, place = b.indexOf(p);
                        if(place > 0 && place < 10)
                        {
                            add *= -1;
                        }

                        for(int n = 1; n < p.getNumHouses(); n++)
                        {
                            g.drawImage(house, ax + (n * add), ay, null);
                        }
                    }

                    p = null;
                }
                else if(p.hasHotel())
                {
                    Point2D.Double pnt = p.getHouseCoord();
                    int ax = (int)pnt.x, ay = (int)pnt.y;
                    int ind = b.indexOf(p);
                    
                    if(ind > 0 && ind < 10)
                    {
                        ax -= 34;
                    }
                    else if(ind > 10 && ind < 20)
                    {
                        ay -= 34;
                    }
                    
                    if(p.isVert())
                    {
                        g.drawImage(hotelV, ax, ay, null);
                    }
                    else
                    {
                        g.drawImage(hotelH, ax, ay, null);
                    }
                }
            }
        }
        g.dispose();//get rid of it!
        return new ImageIcon(bgImage);
    }
    
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
            java.util.logging.Logger.getLogger(MonopBuilderGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonopBuilderGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonopBuilderGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonopBuilderGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MonopBuilderGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JPanel boardPanel;
    private javax.swing.JPanel bottomButtonPanel;
    private javax.swing.JLabel currentCashLabel;
    private javax.swing.JButton finishTurnButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JButton manageButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JButton rollButton;
    private javax.swing.JLabel rollLabel;
    private javax.swing.JPanel topLabelPanel;
    private javax.swing.JButton tradeButton;
    // End of variables declaration//GEN-END:variables
}
