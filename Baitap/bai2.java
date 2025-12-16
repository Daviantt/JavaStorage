//2. Viết chương trình nhập chiều dài, chiều rộng hình chữ nhật, xuất chu vi, diện tích của hình chữ nhật đó.

package Baitap;

import java.util.*;

public class bai2 {
    
    public static void nhap(){
        float dai,rong;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        dai = sc.nextFloat();
        System.out.print("Nhap chieu rong: ");
        rong = sc.nextFloat();
        
        System.out.println("Chu vi: " + ((dai + rong) * 2));
        System.out.println("Dien tich: " + (dai * rong));
        sc.close();
    }

    public static void main(String[] args){
        nhap();
    }
}
