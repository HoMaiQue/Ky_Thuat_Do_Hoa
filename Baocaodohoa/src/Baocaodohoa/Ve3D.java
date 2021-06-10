/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baocaodohoa;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public class Ve3D {

    public static void drawRectangular(Graphics2D g, Diem3d o, int length, int width, int height) {

        Diem2d A = new Diem3d(length + o.getX(), 0 + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d B = new Diem3d(length + o.getX(), width + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d C = new Diem3d(0 + o.getX(), width + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d O = o.convert2d();

        Diem2d D = new Diem3d(length + o.getX(), 0 + o.getY(), height + o.getZ()).convert2d();
        Diem2d G = new Diem3d(length + o.getX(), width + o.getY(), height + o.getZ()).convert2d();
        Diem2d F = new Diem3d(0 + o.getX(), width + o.getY(), height + o.getZ()).convert2d();
        Diem2d E = new Diem3d(0 + o.getX(), 0 + o.getY(), height + o.getZ()).convert2d();

        Ve2D.line(g, A, B);
        Ve2D.line(g, B, C);
        Ve2D.dottedLine(g, C, O);
        Ve2D.dottedLine(g, O, A);

        Ve2D.line(g, D, G);
        Ve2D.line(g, G, F);
        Ve2D.line(g, F, E);
        Ve2D.line(g, E, D);

        Ve2D.line(g, A, D);
        Ve2D.line(g, B, G);
        Ve2D.line(g, C, F);
        Ve2D.dottedLine(g, O, E);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.BLUE);
        g.drawString("A", Handle.x0 + (A.getX() + 3) * 5, Handle.y0 - (A.getY() + 3) * 5);
        g.drawString("B", Handle.x0 + (B.getX() + 3) * 5, Handle.y0 - (B.getY() + 3) * 5);
        g.drawString("C", Handle.x0 + (C.getX() + 3) * 5, Handle.y0 - (C.getY() + 3) * 5);
        g.drawString("O", Handle.x0 + (O.getX() + 3) * 5, Handle.y0 - (O.getY() + 3) * 5);
        g.drawString("D", Handle.x0 + (D.getX() + 3) * 5, Handle.y0 - (D.getY() + 3) * 5);
        g.drawString("G", Handle.x0 + (G.getX() + 3) * 5, Handle.y0 - (G.getY() + 3) * 5);
        g.drawString("F", Handle.x0 + (F.getX() + 3) * 5, Handle.y0 - (F.getY() + 3) * 5);
        g.drawString("E", Handle.x0 + (E.getX() + 3) * 5, Handle.y0 - (E.getY() + 3) * 5);
        g.setColor(Color.BLACK);

    }

    public static void drawPyramid(Graphics2D g, Diem3d o, int length, int width, int height) {

        Diem2d A = new Diem3d(length + o.getX(), 0 + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d B = new Diem3d(length + o.getX(), width + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d C = new Diem3d(0 + o.getX(), width + o.getY(), 0 + o.getZ()).convert2d();
        Diem2d O = o.convert2d();
        Diem2d H = new Diem3d(o.getX() + length / 2, o.getY() + width / 2, o.getZ()).convert2d();
        Diem2d I = new Diem3d(o.getX()+length/2, o.getY()+width/2, o.getZ()+height).convert2d();

        float hsgOC = (float) (O.getY() - C.getY()) / (float) (O.getX() - C.getX());
        float hsgCI = (float) (I.getY() - C.getY()) / (float) (I.getX() - C.getX());
        double AB = Math.sqrt(Math.pow((double) A.getX() - (double) B.getX(), 2) + Math.pow((double) A.getY() - (double) B.getY(), 2));
        double HI = Math.sqrt(Math.pow((double) H.getX() - (double) I.getX(), 2) + Math.pow((double) H.getY() - (double) I.getY(), 2));
        double d = AB / (2 * Math.sqrt(2));
        Ve2D.line(g, A, B);
        Ve2D.line(g, B, C);
        if (hsgOC > hsgCI) {
            Ve2D.line(g, C, O);
            Ve2D.line(g, O, I);
        } else {
            Ve2D.dottedLine(g, C, O);
            Ve2D.dottedLine(g, O, I);
        }
        if (HI < d) {
            Ve2D.line(g, O, A);
        } else {
            Ve2D.dottedLine(g, O, A);
        }

        Ve2D.dottedLine(g, O, B);
        Ve2D.dottedLine(g, A, C);

        Ve2D.line(g, A, I);
        Ve2D.line(g, B, I);
        Ve2D.line(g, C, I);
        Ve2D.dottedLine(g, H, I);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.BLUE);
        g.drawString("A", Handle.x0 + (A.getX() + 3) * 5, Handle.y0 - (A.getY() + 3) * 5);
        g.drawString("B", Handle.x0 + (B.getX() + 3) * 5, Handle.y0 - (B.getY() + 3) * 5);
        g.drawString("C", Handle.x0 + (C.getX() + 3) * 5, Handle.y0 - (C.getY() + 3) * 5);
        g.drawString("O", Handle.x0 + (O.getX() + 3) * 5, Handle.y0 - (O.getY() + 3) * 5);
        g.drawString("H", Handle.x0 + (H.getX() + 3) * 5, Handle.y0 - (H.getY() + 3) * 5);
        g.drawString("I", Handle.x0 + (I.getX() + 3) * 5, Handle.y0 - (I.getY() + 3) * 5);
        g.setColor(Color.BLACK);
    }

}
