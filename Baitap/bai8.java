//8. Viết chương trình nhập số tự nhiên N, nhập N phần tử của mảng a, xuất kết quả
//a. Các phần tử của mảng a và tổng của chúng
//b. Các phần tử chẵn của mảng a và tổng của chúng
//c. Các phần tử lẻ của mảng a và tổng của chúng
//d. Các phần tử là số nguyên tố của mảng a và tổng của chúng
//e. Thêm 1 phần tử mới vào mảng
//f. Xoá phần tử thứ k của mảng a
//g. nhập 1 số x, kiểm tra x có trong mảng a không, nếu có thì trả về vị trí của x trong mảng a

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int [100];
        for(int i = 0;i < n;i++){
            b[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        //n = themphantu(b, n, x);
        //xuat(b, n);
        //int k = sc.nextInt();
        /*n = xoaphantu(b,n,k);
        xuat(b,n);*/
        timvitri(b,n,x);
        sc.close();
    }
    public static Boolean snt(int n){
        if(n <= 2) return false;
        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void xuat(int[] b,int n){
        for(int i = 0;i < n;i++){
            System.out.print(b[i] + " ");
        }
    }
    public static void xuattong(int[] b,int n){
        int S = 0;
        for(int i = 0;i < n;i++){
            System.out.println(b[i]);
            S += b[i];
        }
        System.out.println(S);
    }
    public static void xuatchan(int[] b,int n){
        int S = 0;
        for(int i = 0;i < n;i++){
            if(b[i] % 2 == 0){
                System.out.println(b[i]);
                S += b[i];
            }
        }
        System.out.println(S);
    }
    public static void xuatle(int[] b,int n){
        int S = 0;
        for(int i = 0;i < n;i++){
            if(b[i] % 2 == 1){
                System.out.println(b[i]);
                S += b[i];
            }
        }
        System.out.println(S);
    }
    public static void xuatsnt(int[] b,int n){
        int S = 0;
        for(int i = 0;i < n;i++){
            if(snt(b[i])){
                System.out.println(b[i]);
                S += b[i];
            }
        }
        System.out.println(S);
    }
    public static int themphantu(int[] b,int n,int x){
        n += 1;
        b[n - 1] = x;
        return n;
    }
    public static int xoaphantu(int[] b,int n,int k){
        for(int i = k;i < n;i++){
            b[i] = b[i + 1];
        }n--;
        return n;
    }
    /*public static void timvitri(int[] b,int n,int x){
        int c = 0;
        int[] cnt = new int [100];
        for(int i = 0;i < n;i++){
            if(b[i] == x){
                cnt[c] = i;
                c++;
            }
        }
        System.out.print("so " + x + " tim thay o vi tri thu: ");
        for(int i = 0;i < c;i++){
            System.out.print(cnt[i] + " ");        
        }
    }*/
    public static void timvitri(int[] b,int n,int x){
        System.out.print("so " + x + " tim thay o vi tri thu: ");
        for(int i = 0;i < n;i++){
            if(b[i] == x){
                System.out.print(i + " ");
            }
        } 
    }
}