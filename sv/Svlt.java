package chuong4.Sv;

import java.util.Scanner;

public class Svlt extends Sv {
    private int ntn;
    private String nganh;
    Scanner sc = new Scanner(System.in);

    public Svlt(String msv,String ho,String ten,String gt,String ns,int ntn,String nganh){
        super(msv,ho,ten,gt,ns);
        this.ntn = ntn;
        this.nganh = nganh;
    }
    
    public Svlt(){
        super();
        ntn = 0;
        nganh = "";
    }

    public Svlt(Svlt sv){
        super((Sv)sv);
        ntn = sv.ntn;
        nganh = sv.nganh;
    }

    public int getNtn() {
        return ntn;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNtn(int ntn) {
        this.ntn = ntn;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override public void Nhap(){
        super.Nhap();
        System.out.print("Nhap nam tot nghiep: ");
        ntn = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap nganh: ");
        nganh = sc.nextLine();
    }

    @Override public void Xuat(){
        super.Xuat();
        System.out.printf("%-10s %-10s %-10s","",ntn,nganh);
    }
    
}
