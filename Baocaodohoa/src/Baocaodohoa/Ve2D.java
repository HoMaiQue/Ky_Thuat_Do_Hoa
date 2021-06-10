/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baocaodohoa;

import static Baocaodohoa.Handle.x0;
import static Baocaodohoa.Handle.y0;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Apple Bee
 */
public class Ve2D {

    public static void drawPixel(Graphics2D g, int x, int y) {
        x = x * 5 + Handle.x0 - (6 / 2);
        y = Handle.y0 - y * 5 - (6 / 2);
//        g.setColor(Color.GREEN);
        g.fillOval(x, y, 6, 6);
    }

    public static void drawThinPixel(Graphics2D g, int x, int y) {
        x = x * 5 + Handle.x0 - (8 / 2);
        y = Handle.y0 - y * 5 - (8 / 2);
//        g.setColor(Color.GREEN);
        g.fillOval(x, y, 5, 5);
    }

    public static void line(Graphics2D g, Diem2d a, Diem2d b) {

        int x, y, Dx, Dy, p = 0;
        Dx = Math.abs(b.getX() - a.getX());
        Dy = Math.abs(b.getY() - a.getY());

        x = a.getX();
        y = a.getY();
        int x_unit = 1, y_unit = 1;

        drawPixel(g, x, y);
        if (b.getX() - a.getX() < 0) {
            x_unit = -x_unit;
        }
        if (b.getY() - a.getY() < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != b.getX()) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                drawPixel(g, x, y);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != b.getY()) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                drawPixel(g, x, y);
            }
        }
    }

    public static void drawCircle(Graphics g, int r, int x1, int y1) {
        Graphics2D g2d = (Graphics2D) g;
        for (int h = 0; h <= r; h++) {
            int x = 0;
            int i = 1;
            int y = h;
            int p = 3 - 2 * r;
            drawPixel(g2d, x1, y1);
            do {
                drawPixel(g2d, x + x1, y + y1);
                drawPixel(g2d, -x + x1, -y + y1);
                drawPixel(g2d, -y + x1, -x + y1);
                drawPixel(g2d, x + x1, -y + y1);
                drawPixel(g2d, y + x1, -x + y1);
                drawPixel(g2d, -x + x1, y + y1);
                drawPixel(g2d, -y + x1, x + y1);
                drawPixel(g2d, y + x1, x + y1);
                if (p < 0) {
                    p += 4 * x + 6;
                } else {
                    y--;
                    p += 4 * (x - y) + 10;
                }
                x++;
                i++;
            } while (x <= y);
        }
    }

    public static void drawDotCircle(Graphics g, int r, int x1, int y1) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        int x = 0;
        int i = 1;
        int y = r;
        int p = 3 - 2 * r;
        drawPixel(g2d, x1, y1);
        do {
            if (i <= 2) {
                drawThinPixel(g2d, x + x1, y + y1);
                drawThinPixel(g2d, -x + x1, -y + y1);
                drawThinPixel(g2d, -y + x1, -x + y1);
                drawThinPixel(g2d, x + x1, -y + y1);
                drawThinPixel(g2d, y + x1, -x + y1);
                drawThinPixel(g2d, -x + x1, y + y1);
                drawThinPixel(g2d, -y + x1, x + y1);
                drawThinPixel(g2d, y + x1, x + y1);
            }
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                y--;
                p += 4 * (x - y) + 10;
            }
            x++;
            i++;
            if (i > 4) {
                i = 1;
            }
        } while (x <= y);
    }

    public static void drawRectangle(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        int dem = y1 - y2;
        if (dem > 0) {
            for (int i = 0; i <= dem; i++) {
                line(g2d, new Diem2d(x1, y1), new Diem2d(x2, y1));
                y1--;
            }
        } else {
            for (int i = 0; i <= -dem; i++) {
                line(g2d, new Diem2d(x1, y1), new Diem2d(x2, y1));
                y1++;
            }
        }
    }

    public static void drawElip(Graphics g, int x1, int y1, int a, int b) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.gray);
        int dx, dy, p0, q0, x, y;
        x = 0;
        y = b;
        p0 = (int) ((b * b) - (a * a * b) + (0.25 * a * a));
        dx = 2 * b * b * x;
        dy = 2 * a * a * y;

        while (dx < dy) {

            drawThinPixel(g2d, x + x1, -y + y1);
            drawThinPixel(g2d, -x + x1, -y + y1);

            drawThinPixel(g2d, x + x1, y + y1);
            drawThinPixel(g2d, -x + x1, y + y1);

            if (p0 < 0) {
                x++;
                dx = dx + (2 * b * b);
                p0 = p0 + dx + (b * b);
            } else {
                x++;
                y--;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                p0 = p0 + dx - dy + (b * b);
            }
        }
        //---------------------------------------------------------------------------
        q0 = (int) (((b * b) * ((x + 0.5) * (x + 0.5))) + ((a * a) * ((y - 1)
                * (y - 1))) - (a * a * b * b));
        while (y >= 0) {

            drawThinPixel(g2d, x + x1, -y + y1);
            drawThinPixel(g2d, -x + x1, -y + y1);
            drawThinPixel(g2d, x + x1, y + y1);
            drawThinPixel(g2d, -x + x1, y + y1);

            if (q0 > 0) {
                y--;
                dy = dy - (2 * a * a);
                q0 = q0 + (a * a) - dy;
            } else {
                y--;
                x++;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                q0 = q0 + dx - dy + (a * a);
            }
        }
    }

    public static Diem2d rotate(Diem2d A, double angle) {
        int x = A.getX();
        int y = A.getY();
        return new Diem2d((int) ((double) x * Math.cos(Math.PI * angle / 180) - (double) y * Math.sin(Math.PI * angle / 180)), (int) ((double) x * Math.sin(Math.PI * angle / 180) + (double) y * Math.cos(Math.PI * angle / 180)));
    }

    public static void dottedLine(Graphics2D g, Diem2d a, Diem2d b) {

        int dem = 0;
        int x, y, Dx, Dy, p;
        Dx = Math.abs(b.getX() - a.getX());
        Dy = Math.abs(b.getY() - a.getY());

        x = a.getX();
        y = a.getY();
        int x_unit = 1, y_unit = 1;

        drawPixel(g, x, y);
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (b.getX() - a.getX() < 0) {
            x_unit = -x_unit;
        }
        if (b.getY() - a.getY() < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != b.getX()) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if (dem < 3) {
                    drawPixel(g, x, y);
                    dem++;
                } else if (dem < 6) {
                    dem++;
                } else {
                    dem = 0;
                    drawPixel(g, x, y);
                }
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != b.getY()) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if (dem < 3) {
                    drawPixel(g, x, y);
                    dem++;
                } else if (dem < 6) {
                    dem++;
                } else {
                    dem = 0;
                    drawPixel(g, x, y);
                }

            }
        }
    }

    public static void drawStar(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.YELLOW);
        int x3 = x1;
        int y3 = y1;
        int x4 = x2;
        int y4 = y2;
        line(g2d, new Diem2d(x3 + ((x4 - x3) / 2), (y4 + (8 * (x4 - x3) / 15))), new Diem2d(x3 + 9 * (x4 - x3) / 24, (y4 + (x4 - x3) / 6)));
        line(g2d, new Diem2d(x3 + ((x4 - x3) / 2), (y4 + (8 * (x4 - x3) / 15))), new Diem2d(x3 + (15 * (x4 - x3) / 24), (y4 + ((x4 - x3) / 6))));
        line(g2d, new Diem2d(x3 + ((x4 - x3) / 3), (y4 + (6 * (x4 - x3) / 15))), new Diem2d(x3 + (15 * (x4 - x3) / 24), (y4 + ((x4 - x3) / 6))));
        line(g2d, new Diem2d(x3 + ((x4 - x3) / 3), (y4 + (6 * (x4 - x3) / 15))), new Diem2d(x3 + y3 - y4, (y4 + 6 * ((x4 - x3) / 15))));
        line(g2d, new Diem2d(x3 + 9 * (x4 - x3) / 24, (y4 + (x4 - x3) / 6)), new Diem2d(x3 + y3 - y4, (y4 + (6 * (x4 - x3) / 15))));
    }

    public static void drawStars(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.YELLOW);
        int xa = x1;
        int ya = y1;
        int xb = x2;
        int yb = y2;
        int x3 = xa;
        int y3 = ya;
        int x4 = xb;
        int y4 = yb;
        int d = Math.abs(y1 - y2) / 5;
        int xa1 = x3 + ((x4 - x3) / 2);
        int ya1 = (y4 + (8 * (x4 - x3) / 15));
        int xa2 = x3 + (x4 - x3) / 3;
        int ya2 = (y4 + 6 * (x4 - x3) / 15);
        int xa3 = x3 + (9 * (x4 - x3) / 24);
        int ya3 = (y4 + ((x4 - x3) / 6));
        int xa4 = x3 + 15 * (x4 - x3) / 24;
        int ya4 = (y4 + (x4 - x3) / 6);
        int xa5 = x3 + y3 - y4;
        int ya5 = (y4 + 6 * (x4 - x3) / 15);
        for (int i = 1; i < d; i++) {
            line(g2d, new Diem2d(xa1, ya1), new Diem2d(xa3, ya3));
            line(g2d, new Diem2d(xa1, ya1), new Diem2d(xa4, ya4));
            line(g2d, new Diem2d(xa2, ya2), new Diem2d(xa4, ya4));
            line(g2d, new Diem2d(xa2, ya2), new Diem2d(xa5, ya5));
            line(g2d, new Diem2d(xa3, ya3), new Diem2d(xa5, ya5));
            ya1 = ya1 - 1;
            xa2 = xa2 + 1;
            ya2 = ya2 - 1;
            xa5 = xa5 - 1;
            ya5 = ya5 - 1;
            xa3 = xa3 + 1;
            ya3 = ya3 + 1;
            xa4 = xa4 - 1;
            ya4 = ya4 + 1;

        }

    }

    public static void drawCar(Graphics g, int x1, int y1, int x2, int y2, int r) {
        int x = x1 + (x2 - x1) / 4;
        int y = y2;
        int z = x2;
        int t = y2;
        drawCircle(g, r, x, y);
        drawCircle(g, r, z, t);
        drawRectanglecentre(g, x1, y1, x2, y2);
        drawRectanglehead(g, x1, y1, x2, y2);
        drawRectangleplus1(g, x1, y1, x2, y2);
        drawRectangleplus2(g, x1, y1, x2, y2);
    }

    public static void drawCoronaVirus(Graphics g, int x1, int y1, int r) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 3; i++) {

            drawDotCircle(g, r + i, x1, y1);

        }
        for (int j = 0; j < r; j = j + 3) {
            if (r - 3 - j > 0) {
                drawElip(g, x1, y1, r - 3, r - 3 - j);
            }
        }
    }

    public static void drawTree(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.GRAY);
        drawRectangle(g, x1, y1, x2, y2);
        g.setColor(Color.green);
        drawCircle(g, Math.abs(y2 - y1) / 4, x1, y1);
        drawCircle(g, Math.abs(y2 - y1) / 4, x2, y1);
        drawCircle(g, Math.abs(y2 - y1) / 4, (x1 + x2) / 2, y1 + Math.abs(y2 - y1) / 4);
    }

    public static void faceMask(Graphics g, int x1, int y1, int x2, int y2) {

        int banKinh = Math.abs(y1 - y2) / 2;
        int toaDoY = (y1 + y2) / 2;
        if (x1 - x2 < 0) {
            drawCircleToleft(g, banKinh, x1, toaDoY);
            drawCircleToRight(g, banKinh, x2, toaDoY);

        } else {
            drawCircleToRight(g, banKinh, x1, toaDoY);
            drawCircleToleft(g, banKinh, x2, toaDoY);

        }
        g.setColor(Color.WHITE);
        drawRectangle(g, x1, y1, x2, y2);
    }

    public static void drawFlagBG(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        drawRectangle(g, x1, y1, x2, y2);
        g.setColor(Color.black);
        for (int i = 0; i < 3; i++) {
            line(g2d, new Diem2d(x1 - i, y2), new Diem2d(x1 - i, y1 - 3 * (Math.abs(y2 - y1))));
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString("BẮC GIANG", x0 + x1 * 5 + 3, y0 - y1 * 5 - (Math.abs(y2 * 5 - y1 * 5)) / 3);
    }

    public static void drawFlagVN(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(Color.red);
        drawRectangle(g, x1, y1, x2, y2);
        drawStars(g, x1, y1, x2, y2);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString("CẢ NƯỚC CHUNG TAY CHỐNG DỊCH", x0 - 50 * 5, y0 - 40 * 5);
    }

    public static void drawRoad(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(Color.GREEN);
        drawRectangle(g, x1, y1, x2, y2);
        drawRectangleroadline1(g, x1, y1, x2, y2);
        drawRectangleroadline2(g, x1, y1, x2, y2);
        drawRectangleroadline3(g, x1, y1, x2, y2);
        drawRectangleroadline4(g, x1, y1, x2, y2);

    }

    public static void drawCircleToleft(Graphics g, int r, int x1, int y1) {
        Graphics2D g2d = (Graphics2D) g;
        int x = 0;
        int i = 1;
        int y = r;
        int p = 3 - 2 * r;
        while (x < y) {
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                y--;
                p += 4 * (x - y) + 10;
            }
            x++;
            drawPixel(g2d, -x + x1, -y + y1);
            drawPixel(g2d, -y + x1, -x + y1);
            drawPixel(g2d, -x + x1, y + y1);
            drawPixel(g2d, -y + x1, x + y1);

        }
    }

    public static void drawCircleToRight(Graphics g, int r, int x1, int y1) {
        Graphics2D g2d = (Graphics2D) g;
        int x = 0;
        int i = 1;
        int y = r;
        int p = 3 - 2 * r;
        while (x < y) {
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                y--;
                p += 4 * (x - y) + 10;
            }
            x++;

            drawPixel(g2d, x + x1, y + y1);
            drawPixel(g2d, x + x1, -y + y1);
            drawPixel(g2d, y + x1, -x + y1);
            drawPixel(g2d, y + x1, x + y1);

        }
    }

    public static void drawRectanglecentre(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.blue);
        int xa = x1;
        int ya = y1;
        int xb = x2;
        int yb = y2;
        int dem = ya - yb;
        if (dem > 0) {
            for (int i = 0; i <= dem; i++) {
                line(g2d, new Diem2d(xa, ya), new Diem2d(xb, ya));
                ya--;
            }
        } else {
            for (int i = 0; i <= -dem; i++) {
                line(g2d, new Diem2d(xa, ya), new Diem2d(xb, ya));
                ya++;
            }
        }
    }

    public static void drawRectanglehead(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;
        if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xb;
            int y3 = (-(Math.abs(ya) + Math.abs(yb)) / 3);
            int x4 = xb + Math.abs(ya - yb) / 2;
            int y4 = yb;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xb;
            int y3 = yb + 2 * (ya - yb) / 3;
            int x4 = xb + Math.abs(ya - yb) / 2;
            int y4 = yb;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleplus1(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + (((xb - xa) / 2) - 1);
            int y3 = yb + Math.abs(3 * (ya - yb) / 4);
            int x4 = xa + (((xb - xa) / 2) + 1);
            int y4 = yb + Math.abs((ya - yb) / 4);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + Math.abs(((xb - xa) / 2) - 1);
            int y3 = -2 * ((Math.abs(ya) + Math.abs(yb)) / 3);
            int x4 = xa + Math.abs(((xb - xa) / 2) + 1);
            int y4 = -(Math.abs(ya) + Math.abs(yb)) / 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleplus2(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;a
        if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + Math.abs((xb - xa) / 3);
            int y3 = yb + Math.abs(((ya - yb) / 2) + 1);
            int x4 = xa + Math.abs(2 * (xb - xa) / 3);
            int y4 = yb + Math.abs(((ya - yb) / 2) - 1);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + (xb - xa) / 3;
            int y3 = -(((Math.abs(ya) + Math.abs(yb)) / 2) + 1);
            int x4 = xa + 2 * (xb - xa) / 3;
            int y4 = -(((Math.abs(ya) + Math.abs(yb)) / 2) - 1);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleroadline1(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;
        if (y1 + y2 == 0) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 2 * (xb - xa) / 8;
            int y3 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) + 3);
            int x4 = xa + 3 * (xb - xa) / 8;
            int y4 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) - 3);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 2 * (xb - xa) / 8;
            int y3 = (-(Math.abs(ya) + Math.abs(yb)) / 2) + 3;
            int x4 = xa + 3 * (xb - xa) / 8;
            int y4 = (-(Math.abs(ya) + Math.abs(yb)) / 2) - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 2 * (xb - xa) / 8;;
            int y3 = yb + (ya - yb) / 2 + 3;
            int x4 = xa + 3 * (xb - xa) / 8;
            int y4 = yb + (ya - yb) / 2 - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleroadline2(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;
        if (y1 + y2 == 0) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 4 * (xb - xa) / 8;
            int y3 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) + 3);
            int x4 = xa + 5 * (xb - xa) / 8;
            int y4 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) - 3);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 4 * (xb - xa) / 8;
            int y3 = (-(Math.abs(ya) + Math.abs(yb)) / 2) + 3;
            int x4 = xa + 5 * (xb - xa) / 8;
            int y4 = (-(Math.abs(ya) + Math.abs(yb)) / 2) - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 4 * (xb - xa) / 8;
            int y3 = yb + (ya - yb) / 2 + 3;
            int x4 = xa + 5 * (xb - xa) / 8;
            int y4 = yb + (ya - yb) / 2 - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleroadline3(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;
        if (y1 + y2 == 0) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 6 * (xb - xa) / 8;
            int y3 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) + 3);
            int x4 = xa + 7 * (xb - xa) / 8;
            int y4 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) - 3);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 6 * (xb - xa) / 8;
            int y3 = (-(Math.abs(ya) + Math.abs(yb)) / 2) + 3;
            int x4 = xa + 7 * (xb - xa) / 8;
            int y4 = (-(Math.abs(ya) + Math.abs(yb)) / 2) - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa + 6 * (xb - xa) / 8;
            int y3 = yb + (ya - yb) / 2 + 3;
            int x4 = xa + 7 * (xb - xa) / 8;
            int y4 = yb + (ya - yb) / 2 - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }

    public static void drawRectangleroadline4(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
//        x1 *= 5;
//        x2 *= 5;
//        y1 *= 5;
//        y2 *= 5;
        if (y1 + y2 == 0) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa;
            int y3 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) + 3);
            int x4 = xa + (xb - xa) / 8;
            int y4 = yb + Math.abs((-(Math.abs(ya) + Math.abs(yb)) / 2) - 3);
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 > y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa;
            int y3 = (-(Math.abs(ya) + Math.abs(yb)) / 2) + 3;
            int x4 = xa + (xb - xa) / 8;
            int y4 = (-(Math.abs(ya) + Math.abs(yb)) / 2) - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        } else if (y1 - y2 <= y1) {
            int xa = x1;
            int ya = y1;
            int xb = x2;
            int yb = y2;
            int x3 = xa;
            int y3 = yb + (ya - yb) / 2 + 3;
            int x4 = xa + (xb - xa) / 8;
            int y4 = yb + (ya - yb) / 2 - 3;
            int dem = y3 - y4;
            if (dem > 0) {
                for (int i = 0; i <= dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3--;
                }
            } else {
                for (int i = 0; i <= -dem; i++) {
                    line(g2d, new Diem2d(x3, y3), new Diem2d(x4, y3));
                    y3++;
                }
            }
        }

    }
}
