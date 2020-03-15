import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends javax.swing.JFrame {

    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonSub;
    private javax.swing.JButton buttonMultiply;
    private javax.swing.JButton buttonDiv;
    private javax.swing.JButton buttonDeriv;
    private javax.swing.JButton buttonInteg;
    private javax.swing.JLabel labelResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelHelp;
    private javax.swing.JLabel labelPoly1;
    private javax.swing.JLabel labelPoly2;
    private javax.swing.JTextField textPoly1;
    private javax.swing.JTextField textPoly2;

    public View() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textPoly1 = new javax.swing.JTextField();
        labelPoly1 = new javax.swing.JLabel();
        labelPoly2 = new javax.swing.JLabel();
        textPoly2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelHelp = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JButton();
        buttonSub = new javax.swing.JButton();
        buttonMultiply = new javax.swing.JButton();
        buttonDiv = new javax.swing.JButton();
        buttonDeriv = new javax.swing.JButton();
        buttonInteg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        labelResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Polynomial Calculator");

        textPoly1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPoly1.setText("First Polynomial");
        textPoly1.setToolTipText("");


        labelPoly1.setLabelFor(textPoly1);
        labelPoly1.setText("POLYNOMIAL 1");

        labelPoly2.setLabelFor(textPoly2);
        labelPoly2.setText("POLYNOMIAL 2");

        textPoly2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textPoly2.setText("Second Polynomial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelPoly2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelPoly1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textPoly2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                        .addComponent(textPoly1))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textPoly1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPoly1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPoly2)
                                        .addComponent(textPoly2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHelp.setLabelFor(jPanel2);
        labelHelp.setText("HOVER FOR POLYNOMIAL INPUT RULES");
        labelHelp.setToolTipText("");
        labelHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelHelpMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelHelp)
                                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        buttonAdd.setText("ADD");

        buttonSub.setText("SUBTRACT");

        buttonMultiply.setText("MULTIPLY");

        buttonDiv.setText("DIVIDE");

        buttonDeriv.setText("DERIVATE");

        buttonInteg.setText("INTEGRATE");

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        labelResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResult.setText("RESULT :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonDeriv, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonInteg, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAdd)
                                        .addComponent(buttonSub))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonMultiply)
                                        .addComponent(buttonDiv)
                                        .addComponent(buttonDeriv)
                                        .addComponent(buttonInteg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(labelResult)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );

        pack();
    }

    private void labelHelpMouseEntered(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(rootPane, "All monomials are written like this: ax^pow\n" +
                "You have to use the following conventions:\n" +
                "- \"x\" -> \"1x^1\"	(for monomials of power 1)\n" +
                "- \"a\" -> \"ax^0\"	(for monomials of power 0)\n" +
                "Example of valid input: -3x^2+1x^1+42x^0");
    }

    void showResult(String res){
        jTextPane1.setText(res);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

//  Getters for the input polynomials ==================================================================================

    public String getUserInput1(){
        return textPoly1.getText();
    }

    public String getUserInput2(){
        return textPoly2.getText();
    }

//  Operation Listeners ================================================================================================

    public void addAdditionListener(ActionListener al){
        buttonAdd.addActionListener(al);
    }

    public void addSubtractionListener(ActionListener al){
        buttonSub.addActionListener(al);
    }

    public void addMultiplicationListener(ActionListener al){
        buttonMultiply.addActionListener(al);
    }

    public void addDivisionListener(ActionListener al){
        buttonDiv.addActionListener(al);
    }

    public void addDerivationListener(ActionListener al){
        buttonDeriv.addActionListener(al);
    }

    public void addIntegrationListener(ActionListener al){
        buttonInteg.addActionListener(al);
    }

}
