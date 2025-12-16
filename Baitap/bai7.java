//7. Viết chương trình nhập số tự nhiên N, xuất kết quả :
// a. Các số tự nhiên <=N và tổng của chúng
// b. Các số tự nhiên chẵn <=N và tổng của chúng
// c. Các số tự nhiên lẻ <=N và tổng của chúng
// d. Các số tự nhiên là số nguyên tố <=N và tổng của chúng
// e. N số nguyên tố đầu tiên

package Baitap;

import java.util.*;

public class bai7 {

    public int tongNhoHonN(int n){
        int tong = 0;
        for(int i = 0;i <= n;i++){
            tong += i;
        }

        return tong;
    }

    public int tongNhoHonChanN(int n){
        int tong = 0;
        for(int i = 0;i <= n;i++){
            if(i % 2 == 0){
                tong += i;
            }
        }

        return tong;
    }

    public int tongNhoHonLeN(int n){
        int tong = 0;
        for(int i = 0;i <= n;i++){
            if(i % 2 == 1){
                tong += i;
            }
        }

        return tong;
    }

    public boolean ktsonguyento(int n){
        if(n < 2) return false;
        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public int tongNhoHonSNTN(int n){
        int tong = 0;
        for(int i = 0;i <= n;i++){
            if(ktsonguyento(i)){
                tong += i;
            }
        }

        return tong;
    }
    
    public void xuatNSNTdautien(int n){
        int cnt = 0;
        System.out.print(n + " so nguyen to dau tien la: ");
        for(int i = 0;i <= Math.sqrt(Integer.MAX_VALUE);i++){
            if(ktsonguyento(i)){
                cnt++;
                System.out.print(i + " ");
            }
            if(cnt == n){
                return;
            }
        }
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        sc.close();

        System.out.println("Các số tự nhiên <=N và tổng của chúng: " + tongNhoHonN(n));
        System.out.println("Các số tự nhiên chan <=N và tổng của chúng: " + tongNhoHonChanN(n));
        System.out.println("Các số tự nhiên le <=N và tổng của chúng: " + tongNhoHonLeN(n));
        System.out.println("Các số tự nhiên so nguyen to <=N và tổng của chúng: " + tongNhoHonSNTN(n));
        xuatNSNTdautien(n);
    }

}