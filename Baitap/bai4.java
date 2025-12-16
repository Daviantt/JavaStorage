//4. Viết chương trình nhập số nguyên N, kiểm tra  và xuất kết quả N là số chằn/lẻ

package Baitap;

import java.util.*;

public class bai4 {
    public static void nhap(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap n: ");
        n = sc.nextInt();

        switch (n % 2) {
            case 1:
                System.out.println(n + " la so le!");
                break;
            case 0:
                System.out.println(n + " la so chan!");
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void main(String[] args){
        nhap();
    }
}
