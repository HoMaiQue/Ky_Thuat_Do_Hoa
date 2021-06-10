package Baocaodohoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends javax.swing.JFrame {

    public static JTextField jTextFieldTitle = new JTextField();
    public static JTextField jTextFieldCar = new JTextField();
    public static JTextField jTextFieldCircleCar = new JTextField();
    public static JTextField jTextFieldCircleCarR = new JTextField();
    public static JTextField jTextFieldCircleCarX1 = new JTextField();
    public static JTextField jTextFieldCircleCarY1 = new JTextField();
    public static JTextField jTextFieldCircleCarX2 = new JTextField();
    public static JTextField jTextFieldCircleCarY2 = new JTextField();
    public static JTextField jTextFieldRectangleCar = new JTextField();
    public static JTextField jTextFieldRectangleCarX1 = new JTextField();
    public static JTextField jTextFieldRectangleCarY1 = new JTextField();
    public static JTextField jTextFieldRectangleCarX2 = new JTextField();
    public static JTextField jTextFieldRectangleCarY2 = new JTextField();
    public static JTextField jTextFieldCoronaVirus = new JTextField();
    public static JTextField jTextFieldCoronaVirusX1 = new JTextField();
    public static JTextField jTextFieldCoronaVirusY1 = new JTextField();
    public static JTextField jTextFieldCoronaVirusX2 = new JTextField();
    public static JTextField jTextFieldCoronaVirusY2 = new JTextField();
    public static JTextField jTextFieldCoronaVirusX3 = new JTextField();
    public static JTextField jTextFieldCoronaVirusY3 = new JTextField();
    public static JTextField jTextFieldCoronaVirusR = new JTextField();
    public static JTextField jTextFieldFaceMask = new JTextField();
    public static JTextField jTextFieldFaceMaskX1 = new JTextField();
    public static JTextField jTextFieldFaceMaskY1 = new JTextField();
    public static JTextField jTextFieldFaceMaskX2 = new JTextField();
    public static JTextField jTextFieldFaceMaskY2 = new JTextField();
    public static JTextField jTextFieldNationalFlag = new JTextField();
    public static JTextField jTextFieldNationalFlagX1 = new JTextField();
    public static JTextField jTextFieldNationalFlagY1 = new JTextField();
    public static JTextField jTextFieldNationalFlagX2 = new JTextField();
    public static JTextField jTextFieldNationalFlagY2 = new JTextField();
    public static JButton jButtonDraw2D = new JButton();

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        Handle.k = 0;
        setJPanelControl2D();
        resetPanel(jPanelView2d, new Handle());

        jTabbedPaneMain.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Handle.k = jTabbedPaneMain.getSelectedIndex();
                if (Handle.k == 1) {
                    Handle.select = -1;
                    resetPanel(jPanelView3d, new Handle());
                    jButtonDraw.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String x = jTextFieldX.getText().toString();
                            String y = jTextFieldY.getText().toString();
                            String z = jTextFieldZ.getText().toString();
                            String length = jTextFieldLength.getText().toString();
                            String height = jTextFieldHeight.getText().toString();
                            String width = jTextFieldWidth.getText().toString();
                            if (testData(x, y, z, length, width, height)) {
                                Handle.x = Integer.parseInt(x);
                                Handle.y = Integer.parseInt(y);
                                Handle.z = Integer.parseInt(z);
                                Handle.length = Integer.parseInt(length);
                                Handle.width = Integer.parseInt(width);
                                Handle.height = Integer.parseInt(height);
                                Handle.select = jComboBoxSelect.getSelectedIndex();
                                resetPanel(jPanelView3d, new Handle());
                                jLabelA.setText("(" + (Handle.x + Handle.length) + "," + (Handle.y) + "," + (Handle.z) + ")");
                                jLabelB.setText("(" + (Handle.x + Handle.length) + "," + (Handle.y + Handle.width) + "," + (Handle.z) + ")");
                                jLabelC.setText("(" + (Handle.x) + "," + (Handle.y + Handle.width) + "," + (Handle.z) + ")");
                                jLabelO.setText("(" + (Handle.x) + "," + (Handle.y) + "," + (Handle.z) + ")");
                                if (Handle.select == 0) {
                                    jLabelI.setText("");
                                    jLabelH.setText("");
                                    jLabelD.setText("(" + (Handle.x + Handle.length) + "," + (Handle.y) + "," + (Handle.z + Handle.height) + ")");
                                    jLabelG.setText("(" + (Handle.x + Handle.length) + "," + (Handle.y + Handle.width) + "," + (Handle.z + Handle.height) + ")");
                                    jLabelF.setText("(" + (Handle.x) + "," + (Handle.y + Handle.width) + "," + (Handle.z + Handle.height) + ")");
                                    jLabelE.setText("(" + (Handle.x) + "," + (Handle.y) + "," + (Handle.z + Handle.height) + ")");
                                } else {
                                    jLabelH.setText("(" + (Handle.x + Handle.length / 2) + "," + (Handle.y + Handle.width / 2) + "," + (Handle.z) + ")");
                                    jLabelI.setText("(" + (Handle.x + Handle.length / 2) + "," + (Handle.y + Handle.width / 2) + "," + (Handle.z + Handle.height) + ")");
                                    jLabelD.setText("");
                                    jLabelG.setText("");
                                    jLabelF.setText("");
                                    jLabelE.setText("");
                                }
                            }
                        }
                    });
                    jButtonClear.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int temp = Handle.select;
                            Handle.select = -1;
                            resetPanel(jPanelView3d, new Handle());
                            jLabelD.setText("");
                            jLabelG.setText("");
                            jLabelF.setText("");
                            jLabelE.setText("");
                            jLabelA.setText("");
                            jLabelB.setText("");
                            jLabelC.setText("");
                            jLabelO.setText("");
                            jLabelH.setText("");
                            jLabelI.setText("");
                        }
                    });
                } else {
                    Handle.dx = 0;
                    Handle.dr = 0;
                    Handle.df = 1;
                    Handle.ddx = 1;
                    Handle.dq = 0;
                    resetPanel(jPanelView2d, new Handle());
                }
            }
        }
        );

    }

    public void resetPanel(JPanel jPanel, Handle handle) {
        jPanel.removeAll();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(handle);
        jPanel.validate();
        jPanel.repaint();
    }

    public void setJPanelControl2D() {
        jPanelControl2d.setLayout(null);
        setJTextField(jTextFieldTitle, "THÔNG SỐ HÌNH VẼ", 50, 50, 400, 40, 20, Font.BOLD);

        setJTextField(jTextFieldCar, "XE", 50, 120, 150, 30, 16, Font.ITALIC);
        setJTextField(jTextFieldRectangleCar, "Thùng xe", 50, 170, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldRectangleCarX1, "X1:", 140, 170, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldRectangleCarY1, "Y1:", 220, 170, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldRectangleCarX2, "X2:", 300, 170, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldRectangleCarY2, "Y2:", 380, 170, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCar, "Bánh xe", 50, 210, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCarX1, "X1:", 140, 210, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCarY1, "Y1:", 220, 210, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCarX2, "X2:", 300, 210, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCarY2, "Y2:", 380, 210, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCircleCarR, "R:", 140, 250, 70, 20, 14, Font.PLAIN);

        setJTextField(jTextFieldCoronaVirus, "VIRUS", 50, 290, 150, 30, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusX1, "X1:", 140, 340, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusY1, "Y1:", 220, 340, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusX2, "X2:", 300, 340, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusY2, "Y2:", 380, 340, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusX3, "X3:", 140, 380, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusY3, "Y3:", 220, 380, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldCoronaVirusR, "R:", 300, 380, 70, 20, 14, Font.PLAIN);

        setJTextField(jTextFieldFaceMask, "KHẨU TRANG", 50, 420, 150, 30, 16, Font.ITALIC);
        setJTextField(jTextFieldFaceMaskX1, "X1:", 140, 470, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldFaceMaskY1, "Y1:", 220, 470, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldFaceMaskX2, "X2:", 300, 470, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldFaceMaskY2, "Y2:", 380, 470, 70, 20, 14, Font.PLAIN);

        setJTextField(jTextFieldNationalFlag, "Quốc kì", 50, 510, 150, 30, 16, Font.ITALIC);
        setJTextField(jTextFieldNationalFlagX1, "X1:", 140, 560, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldNationalFlagY1, "Y1:", 220, 560, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldNationalFlagX2, "X2:", 300, 560, 70, 20, 14, Font.PLAIN);
        setJTextField(jTextFieldNationalFlagY2, "Y2:", 380, 560, 70, 20, 14, Font.PLAIN);

        jButtonDraw2D.setText("BẮT ĐẦU");
        jButtonDraw2D.setBounds(100, 620, 300, 40);
        jButtonDraw2D.setFont(new Font("TimesRoman", Font.BOLD, 20));
        jPanelControl2d.add(jButtonDraw2D);
    }

    public void setJTextField(JTextField jTextField, String title, int x, int y, int width, int height, int fontSize, int fontStyle) {
        jTextField.setText(title);
        jTextField.setEditable(false);
        jTextField.setBounds(x, y, width, height);
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setFont(new Font("TimesRoman", fontStyle, fontSize));
        jPanelControl2d.add(jTextField);
    }

    public boolean testData(String x, String y, String z, String length, String width, String height) {
        String pattern = "[-|/]{0,1}[0-9]{1,2}";
        if (!x.matches(pattern) || !y.matches(pattern) || !z.matches(pattern) || !length.matches(pattern) || !width.matches(pattern) || !height.matches(pattern)) {
            JOptionPane.showMessageDialog(this, "Thông số nhập không đúng định dạng");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanel2D = new javax.swing.JPanel();
        jPanelControl2d = new javax.swing.JPanel();
        jPanelView2d = new javax.swing.JPanel();
        jPanel3D = new javax.swing.JPanel();
        jPanelControl3d = new javax.swing.JPanel();
        jComboBoxSelect = new javax.swing.JComboBox<>();
        jTextFieldX = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldZ = new javax.swing.JTextField();
        jTextFieldY = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLength = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldWidth = new javax.swing.JTextField();
        jTextFieldHeight = new javax.swing.JTextField();
        jButtonDraw = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelA = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelFF = new javax.swing.JLabel();
        jLabelF = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelO = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelGG = new javax.swing.JLabel();
        jLabelG = new javax.swing.JLabel();
        jLabelDD = new javax.swing.JLabel();
        jLabelD = new javax.swing.JLabel();
        jLabelEE = new javax.swing.JLabel();
        jLabelE = new javax.swing.JLabel();
        jLabelC = new javax.swing.JLabel();
        jLabelHH = new javax.swing.JLabel();
        jLabelH = new javax.swing.JLabel();
        jLabelII = new javax.swing.JLabel();
        jLabelI = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jPanelView3d = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đồ họa cơ bản");
        setBackground(new java.awt.Color(0, 204, 255));
        setResizable(false);

        jTabbedPaneMain.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N

        jPanel2D.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelControl2d.setBackground(new java.awt.Color(51, 51, 51));
        jPanelControl2d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelControl2dLayout = new javax.swing.GroupLayout(jPanelControl2d);
        jPanelControl2d.setLayout(jPanelControl2dLayout);
        jPanelControl2dLayout.setHorizontalGroup(
            jPanelControl2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        jPanelControl2dLayout.setVerticalGroup(
            jPanelControl2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        jPanel2D.add(jPanelControl2d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 500, 690));

        jPanelView2d.setBackground(new java.awt.Color(255, 255, 255));
        jPanelView2d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelView2dLayout = new javax.swing.GroupLayout(jPanelView2d);
        jPanelView2d.setLayout(jPanelView2dLayout);
        jPanelView2dLayout.setHorizontalGroup(
            jPanelView2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        jPanelView2dLayout.setVerticalGroup(
            jPanelView2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        jPanel2D.add(jPanelView2d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 690));

        jTabbedPaneMain.addTab("2D", jPanel2D);

        jPanel3D.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelControl3d.setBackground(new java.awt.Color(51, 51, 51));
        jPanelControl3d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBoxSelect.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBoxSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HÌNH HỘP CHỮ NHẬT", "HÌNH CHÓP" }));

        jTextFieldX.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Z");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Y");
        jLabel3.setOpaque(true);

        jTextFieldZ.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jTextFieldY.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DÀI");
        jLabel4.setOpaque(true);

        jTextFieldLength.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CAO");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RỘNG");
        jLabel6.setOpaque(true);

        jTextFieldWidth.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jTextFieldHeight.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jButtonDraw.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonDraw.setText("VẼ");
        jButtonDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDrawActionPerformed(evt);
            }
        });

        jButtonClear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonClear.setText("XÓA");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("THÔNG SỐ");
        jLabel7.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("A");
        jLabel8.setOpaque(true);

        jLabelA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelA.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("B");
        jLabel10.setOpaque(true);

        jLabelFF.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFF.setText("F");
        jLabelFF.setOpaque(true);

        jLabelF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelF.setOpaque(true);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("C");
        jLabel14.setOpaque(true);

        jLabelO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelO.setOpaque(true);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("O");
        jLabel16.setOpaque(true);

        jLabelGG.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelGG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelGG.setText("G");
        jLabelGG.setOpaque(true);

        jLabelG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelG.setOpaque(true);

        jLabelDD.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDD.setText("D");
        jLabelDD.setOpaque(true);

        jLabelD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelD.setOpaque(true);

        jLabelEE.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelEE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEE.setText("E");
        jLabelEE.setOpaque(true);

        jLabelE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelE.setOpaque(true);

        jLabelC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelC.setOpaque(true);

        jLabelHH.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelHH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHH.setText("H");
        jLabelHH.setOpaque(true);

        jLabelH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelH.setOpaque(true);

        jLabelII.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelII.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelII.setText("I");
        jLabelII.setOpaque(true);

        jLabelI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelI.setOpaque(true);

        jLabelB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelB.setOpaque(true);

        javax.swing.GroupLayout jPanelControl3dLayout = new javax.swing.GroupLayout(jPanelControl3d);
        jPanelControl3d.setLayout(jPanelControl3dLayout);
        jPanelControl3dLayout.setHorizontalGroup(
            jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                        .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(jComboBoxSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControl3dLayout.createSequentialGroup()
                                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldLength, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControl3dLayout.createSequentialGroup()
                                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelDD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelGG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelG, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jLabelD, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControl3dLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControl3dLayout.createSequentialGroup()
                                                        .addComponent(jLabelEE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabelE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControl3dLayout.createSequentialGroup()
                                                        .addComponent(jLabelFF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabelF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                        .addGap(68, 68, 68))
                    .addGroup(jPanelControl3dLayout.createSequentialGroup()
                        .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                .addComponent(jLabelII, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                                .addComponent(jLabelHH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelControl3dLayout.setVerticalGroup(
            jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControl3dLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jComboBoxSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldX)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldY)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldZ))
                .addGap(18, 18, 18)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLength))
                .addGap(18, 18, 18)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldWidth))
                .addGap(18, 18, 18)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHeight))
                .addGap(50, 50, 50)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelA, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelG, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGG, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelControl3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelII, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jPanel3D.add(jPanelControl3d, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 500, 690));

        jPanelView3d.setBackground(new java.awt.Color(255, 255, 255));
        jPanelView3d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelView3dLayout = new javax.swing.GroupLayout(jPanelView3d);
        jPanelView3d.setLayout(jPanelView3dLayout);
        jPanelView3dLayout.setHorizontalGroup(
            jPanelView3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        jPanelView3dLayout.setVerticalGroup(
            jPanelView3dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        jPanel3D.add(jPanelView3d, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 690));

        jTabbedPaneMain.addTab("3D", jPanel3D);

        getContentPane().add(jTabbedPaneMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDrawActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDrawActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDraw;
    private javax.swing.JComboBox<String> jComboBoxSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelC;
    private javax.swing.JLabel jLabelD;
    private javax.swing.JLabel jLabelDD;
    private javax.swing.JLabel jLabelE;
    private javax.swing.JLabel jLabelEE;
    private javax.swing.JLabel jLabelF;
    private javax.swing.JLabel jLabelFF;
    private javax.swing.JLabel jLabelG;
    private javax.swing.JLabel jLabelGG;
    private javax.swing.JLabel jLabelH;
    private javax.swing.JLabel jLabelHH;
    private javax.swing.JLabel jLabelI;
    private javax.swing.JLabel jLabelII;
    private javax.swing.JLabel jLabelO;
    private javax.swing.JPanel jPanel2D;
    private javax.swing.JPanel jPanel3D;
    private javax.swing.JPanel jPanelControl2d;
    private javax.swing.JPanel jPanelControl3d;
    private javax.swing.JPanel jPanelView2d;
    private javax.swing.JPanel jPanelView3d;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldLength;
    private javax.swing.JTextField jTextFieldWidth;
    private javax.swing.JTextField jTextFieldX;
    private javax.swing.JTextField jTextFieldY;
    private javax.swing.JTextField jTextFieldZ;
    // End of variables declaration//GEN-END:variables
}
