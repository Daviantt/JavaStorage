//5. Viết chương trình nhập số nguyên N, kiểm tra và xuất kết quả N là số âm/zero/dương

package Baitap;

import java.util.*;

public class bai5 {
    public static void nhap(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap n: ");
        n = sc.nextInt();

        if(n > 0) System.out.println(n + " la so duong!");
        else if(n == 0) System.out.println(n + " la zero!");
        else System.out.println(n + " la so am!");
        sc.close();
    }

    public static void main(String[] args){
        nhap();
    }
}
