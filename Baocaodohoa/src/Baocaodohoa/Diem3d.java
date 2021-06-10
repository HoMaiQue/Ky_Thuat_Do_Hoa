package Baocaodohoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Diem3d {
    private int x, y, z;

    public Diem3d() {
    }

    public Diem3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    public Diem2d convert2d(){
        return new Diem2d((int)(x-y*Math.sqrt(2)/2), (int)(z-y*Math.sqrt(2)/2));
    }
}
