//3. Viết chương trình nhập bán kính hình tròn, xuất chu vi, diện tích của hình tròn đó.

package Baitap;

import java.util.*;

public class bai3 {
    
    public static void nhap(){
        float r;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ban kinh r: ");
        r = sc.nextFloat();
        
        System.out.println("Chu vi: " + (Math.PI * r * 2));
        System.out.println("Dien tich: " + (Math.PI * r * r));
        sc.close();
    }

    public static void main(String[] args){
        nhap();
    }
}
