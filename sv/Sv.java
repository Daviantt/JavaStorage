package sv;
import java.time.LocalDate;
import java.util.Scanner;

public class Sv {
    private String Msv;
    private String Ho;
    private String Ten;
    private String GT;
    private String NS;
    Scanner sc = new Scanner(System.in);
    
    public Sv(){
        Msv = Ho = Ten = GT = NS = null;
    }

    public String getMsv(){
        return Msv;
    }
    public String getHo(){
        return Ho;
    }
    public String getTen(){
        return Ten;
    }
    public String getGT(){
        return GT;
    }
    public String getNS(){
        return NS;
    }

    public void setMsv(String a){
        Msv = a; 
    }
    public void setHo(String H){
        Ho = H;
    }
    public void setTen(String t){
        Ten = t;
    }
    public void setGT(String g){
        GT = g;
    }
    public void setNS(String ns){
        NS = ns;
    }

    public Sv(String Msv,String Ho,String Ten,String GT,String NS){
        this.Msv = Msv;
        this.Ho = Ho;
        this.Ten = Ten;
        this.GT = GT;
        this.NS = NS;
    }

    public Sv(Sv sv){
        Msv = sv.Msv;
        Ho = sv.Ho;
        Ten = sv.Ten;
        GT = sv.GT;
        NS = sv.NS;
    }

    public void Nhap(){
        System.out.print("Nhap ma sinh vien: ");
        Msv = sc.nextLine();
        System.out.print("Ho: ");
        Ho = sc.nextLine();
        System.out.print("Ten: ");
        Ten = sc.nextLine();
        System.out.print("Gioi tinh: ");
        GT = sc.nextLine();
        System.out.print("Ngay sinh: ");
        NS = sc.nextLine();
    }
    
    public void Xuat(){
        System.out.printf("\n%-10s %-20s %-10s %-10s %-15s", Msv,Ho,Ten,GT,NS);
    }

    public int tuoi(){
        int year = LocalDate.now().getYear();
        return year - Integer.parseInt(NS.substring(6, 10));
    }
}
