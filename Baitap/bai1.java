//1. Viết chương trình nhập 2 số nguyên, xuất tổng, hiệu, tích, thương.

package Baitap;

import java.util.*;

public class bai1 {
    
    public static void nhap(){
        float a,b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen thu nhat: ");
        a = sc.nextFloat();
        System.out.print("Nhap so nguyen thu hai: ");
        b = sc.nextFloat();
        
        System.out.println("Tong: " + (a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + (a * b));
        System.out.println("Thuong: " + (a / b));
        sc.close();
    }

    public static void main(String[] args){
        nhap();
    }
}
