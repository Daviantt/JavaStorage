package chuong4.Sv;

import java.util.Scanner;

public class Svcq extends Sv{
    public int drl;
    Scanner sc = new Scanner(System.in);

    public Svcq(){
        super();
        drl = 0;
    }

    public Svcq(String msv,String ho,String ten,String gt,String ns,int drl){
        super(msv,ho,ten,gt,ns);
        this.drl = drl;
    }

    public Svcq(Svcq sv){
        super((Sv)sv);
        drl = sv.drl;
    }

    public int getDrl() {
        return drl;
    }

    public void setDrl(int drl) {
        this.drl = drl;
    }

    @Override public void Nhap(){
        super.Nhap();
        System.out.print("Nhap diem ren luyen: ");
        drl = sc.nextInt();
    }

    @Override public void Xuat(){
        super.Xuat();
        System.out.printf("%-10s", drl);
    }
}
    
