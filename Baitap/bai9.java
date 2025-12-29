//9. Viết chương trình nhập chuỗi s, xuất kết quả:
// a. Độ dài của s
// b. Xoá bỏ khoảng trắng thừa của s
// c. Đếm số từ của s và xuất mỗi từ nằm trên 1 dòng
// d. nhập số tự nhiên k, xuất k ký tự bên trái của s, k kí tự bên phải của s
// e. nhập số tự nhiên k, n, xuất n kí tự của s kể từ vị trí k

import java.util.Scanner;

public class bai9 {
    public void main(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); 
        dodai(s);
        System.out.println(xoakhoangtrang(s));
        demsotu(s);
        intutraiphai(s,3);
        inNkytu(s, 3, 5);
        sc.close();
    }
    
    public void dodai(String s){
        System.out.println(s.length());
    }

    public String xoakhoangtrang(String a){
        String s = a;
        s = s.trim();
        String b = "";
        Boolean kt = false;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' '){
                if(!kt){
                    b += ' ';
                    kt = true;
                }
            }else{
                b += s.charAt(i);
                kt = false;
            }
        }
        return b;
    }

    public void demsotu(String s){
        int cnt = 0;
        String regex = "[,\\.\\s]";
        String[] arr = s.trim().split(regex);
        for(String a : arr){
            cnt++;
            System.out.println(a);
        }
        System.out.println(cnt);
    }
    public void intutraiphai(String s,int k){
        String regex = "[,\\.\\s]";
        String[] arr = s.trim().split(regex);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        if(k > arr.length){
            System.out.println("k lon hon so tu trong chuoi");
        }else{
            for(int i = 0;i < k;i++){
                a.append(arr[i]).append(" ");
            }
            System.out.println(a);
            for(int i = arr.length - k;i < arr.length;i++){
                b.append(arr[i]).append(" ");
            }
            System.out.println(b);
        }
    }
    public void inNkytu(String s,int k,int n){
        if((k + n) > s.length()){
            System.out.println("khong the in du ky tu");
        }else{
            for(int i = k;i < k + n;i++){
                System.out.print(s.charAt(i));
            }
        }
    }
    public void xuat(String s){
        System.out.println(s);
    }
}
