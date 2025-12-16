//6. Viết chương trình nhập số tự nhiên N, kiểm tra  và xuất kết quả N là số nguyên tố hay không.

package Baitap;

import java.util.*;

public class bai6 {
    public static void nhap(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        sc.close();

        if(n < 2){
            System.out.println(n + " khong la so nguyen to!");
            return;
        }

        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0){
                System.out.println(n + " khong la so nguyen to!");
                return;
            }
        }
        System.out.println(n + " la so nguyen to!");
    }

    public static void main(String[] args){
        nhap();
    }
}
