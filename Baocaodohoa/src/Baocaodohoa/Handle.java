
package Baocaodohoa;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


public class Handle extends javax.swing.JPanel implements ActionListener {

    static int k;
    static int x, y, z, length, width, height, select;
    static int x0 = 500, y0 = 345;
    static int dx = 0;
    static int dr = 0;
    static int df = 1;
    static int ddx = 1;
    static double dq = 0;
    Timer timer = new Timer(200, this);


    public Handle() {
        initComponents();
        Main.jButtonDraw2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dx = 0;
                dr = 0;
                df = 0;
                timer.start();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (k == 0) {
            coordinate2D(g);
            int x1Car = -100 + dx;
            int y1Car = 30;
            int x2Car = -50 + dx;
            int y2Car = 0;
            int rCar = 5;
            int x1FaceMask = x1Car + 20;
            int y1FaceMask = 0;
            int x2FaceMask = x2Car;
            int y2FaceMask = 0;
            int yTargetCar = (y1Car + y2Car) / 2;
            int x1Covid = 0;
            int y1Covid = 0;
            int x2Covid = 0;
            int y2Covid = 0;
            int x3Covid = 0;
            int y3Covid = 0;
            int rCovid = 0;
            int x1FlagBG = 60;
            int y1FlagBG = 20;
            int x2FlagBG = 95;
            int y2FlagBG = 30;
            if (dx < 100) {
                for (int i = 0; i < 180; i += 50) {
                    Ve2D.drawTree(g, -80 + i, 50, -70 + i, 30);
                    Ve2D.drawTree(g, -80 + i, -50, -70 + i, -30);
                }
                Ve2D.drawRoad(g, -100, 20, 100, -20);
                Ve2D.drawFlagBG(g, x1FlagBG, y1FlagBG, x2FlagBG, y2FlagBG);
                Ve2D.drawCar(g, x1Car, y1Car, x2Car, y2Car, rCar);
                if (ddx % 2 == 0) {
                    y1FaceMask = yTargetCar + Math.abs(y2Car - 20 - yTargetCar);
                    y2FaceMask = yTargetCar + Math.abs(y2Car - 40 - yTargetCar);
                } else {
                    y1FaceMask = yTargetCar - Math.abs(y2Car - 20 - yTargetCar);
                    y2FaceMask = yTargetCar - Math.abs(y2Car - 40 - yTargetCar);
                }
                if (40 - dx <= 10) {
                    x1Covid = x2Covid = 40 + dr;
                    y1Covid = 10 + dr;
                    y2Covid = 10 - dr;
                    rCovid = 10 - dr;
                } else {
                    x1Covid = x2Covid = 40 - dx;
                    y1Covid = 40 - dx;
                    y2Covid = -40 + dx;
                    rCovid = 10;
                }
                y3Covid = 10;
                Ve2D.faceMask(g, x1FaceMask, y1FaceMask, x2FaceMask, y2FaceMask);
                if (rCovid > 0) {
                    Ve2D.drawCoronaVirus(g, x1Covid, y1Covid, rCovid);
                    Ve2D.drawCoronaVirus(g, x2Covid, y2Covid, rCovid);
                    Diem2d temp = Ve2D.rotate(new Diem2d(40 - x1FlagBG, 40 - y1FlagBG), dq);
                    x3Covid = temp.getX() + x1FlagBG;
                    y3Covid = temp.getY() + y1FlagBG;
                    Ve2D.drawCoronaVirus(g, x3Covid, y3Covid, rCovid);
                    Main.jTextFieldCoronaVirusX1.setText("X1: " + x1Covid);
                    Main.jTextFieldCoronaVirusY1.setText("Y1: " + y1Covid);
                    Main.jTextFieldCoronaVirusX2.setText("X2: " + x2Covid);
                    Main.jTextFieldCoronaVirusY2.setText("Y2: " + y2Covid);
                    Main.jTextFieldCoronaVirusX3.setText("X3: " + x3Covid);
                    Main.jTextFieldCoronaVirusY3.setText("Y3: " + y3Covid);
                    Main.jTextFieldCoronaVirusR.setText("R: " + rCovid);
                }
            } else {
                Ve2D.drawFlagVN(g, -3 * df, 2 * df, 3 * df, -2 * df);
                Main.jTextFieldNationalFlagX1.setText("X1: " + (-3 * df));
                Main.jTextFieldNationalFlagY1.setText("Y1: " + (2 * df));
                Main.jTextFieldNationalFlagX2.setText("X2: " + (3 * df));
                Main.jTextFieldNationalFlagY2.setText("Y2: " + (-2 * df));
            }

            Main.jTextFieldRectangleCarX1.setText("X1:" + x1Car);
            Main.jTextFieldRectangleCarY1.setText("Y1:" + y1Car);
            Main.jTextFieldRectangleCarX2.setText("X2:" + x2Car);
            Main.jTextFieldRectangleCarY2.setText("Y2:" + y2Car);
            Main.jTextFieldCircleCarR.setText("R: " + rCar);
            Main.jTextFieldCircleCarX1.setText("X1: " + (x1Car + (x2Car - x1Car) / 4));
            Main.jTextFieldCircleCarY1.setText("Y1: " + y2Car);
            Main.jTextFieldCircleCarX2.setText("X2: " + x2Car);
            Main.jTextFieldCircleCarY2.setText("Y2: " + y2Car);

            Main.jTextFieldFaceMaskX1.setText("X1: " + x1FaceMask);
            Main.jTextFieldFaceMaskY1.setText("Y1: " + y1FaceMask);
            Main.jTextFieldFaceMaskX2.setText("X2: " + x2FaceMask);
            Main.jTextFieldFaceMaskY2.setText("Y2: " + y2FaceMask);

        } else {
            coordinate3D(g);
            if (select == 0) {
                Diem3d o = new Diem3d(x, y, z);
                Ve3D.drawRectangular(g2d, o, length, width, height);
                return;
            }
            if (select == 1) {
                Diem3d o = new Diem3d(x, y, z);
                Ve3D.drawPyramid(g2d, o, length, width, height);
            }
        }
    }

    public void coordinate3D(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        for (int i = 0; i < 2 * x0; i = i + 5) {
            g2d.drawLine(i, 0, i, 2 * y0);
        }
        for (int i = 0; i < 2 * y0; i = i + 5) {
            g2d.drawLine(0, i, 2 * x0, i);
        }
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(x0, y0, 2 * x0, y0);
        g2d.drawLine(x0, y0, x0, 0);
        g2d.drawLine(x0, y0, x0 - y0, 2 * y0);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g2d.drawString("O", x0 - 20, y0 + 10);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int i = 0; i < 2 * x0; i = i + 50) {
            g2d.drawLine(i, 0, i, 2 * y0);
        }
        for (int i = -5; i < 2 * y0; i = i + 50) {
            g2d.drawLine(0, i, 2 * x0, i);
        }
    }

    public void coordinate2D(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        for (int i = 0; i < 2 * x0; i = i + 5) {
            g2d.drawLine(i, 0, i, 2 * y0);
        }
        for (int i = 0; i < 2 * y0; i = i + 5) {
            g2d.drawLine(0, i, 2 * x0, i);
        }
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(0, y0, 2 * x0, y0);
        g2d.drawLine(x0, 2 * y0, x0, 0);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g2d.drawString("O", x0 - 20, y0 + 10);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int i = 0; i < 2 * x0; i = i + 50) {
            g2d.drawLine(i, 0, i, 2 * y0);
        }
        for (int i = -5; i < 2 * y0; i = i + 50) {
            g2d.drawLine(0, i, 2 * x0, i);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (dx > 100) {
            if (df < 15) {
                df++;
            } else {
                timer.stop();
            }
        } else {
            dx += 1;
            ddx++;
            if (40 - dx < 10) {
                if (10 - dr > 0) {
                    dr += 1;
                }
            }
            if (dq > 360) {
                dq = 60;
            } else {
                dq += 30;
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
