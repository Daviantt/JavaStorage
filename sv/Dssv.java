package Sv;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Dssv {
    private int n;
    private Sv[] dssv;
    Scanner sc = new Scanner(System.in);

    public Dssv(){
        n = 0;
        dssv = null;
    }
    public Dssv(Sv[] ds,int n){
        this.n = n;
        this.dssv = ds;
    }
    public Dssv(Dssv dssv1){
        n = dssv1.n;
        dssv = dssv1.dssv;
    }

    public int getn(){
        return n;
    }
    public Sv[] getds(){
        return dssv;
    }
    public void setn(int a){
        n = a;
    }
    public void setds(Sv[] dssv1){
        dssv = dssv1;
    }

    public void docFile(){
        dssv = new Sv[0];
        File file = new File("Sv/dssv.txt");
        int c = 0;

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String dong = sc.nextLine();
                if(dong.isEmpty()) continue;
                String[] t = dong.split(",");
                String ma = t[0].trim();
                String ho = t[1].trim();
                String ten = t[2].trim();
                String gt = t[3].trim();
                String ns = t[4].trim();
                String loai = null;
                if(t[5].trim().isEmpty()) loai = "lt";
                else loai = "cq";
                if(loai == "cq"){
                    int drl = Integer.parseInt(t[5].trim());
                    dssv = Arrays.copyOf(dssv,dssv.length + 1);
                    dssv[c] = new Svcq(ma,ho,ten,gt,ns,drl);
                }else if(loai == "lt"){
                    int ntn = Integer.parseInt(t[6].trim());
                    String nganh = t[7].trim();
                    dssv = Arrays.copyOf(dssv, dssv.length + 1);
                    dssv[c] = new Svlt(ma,ho,ten,gt,ns,ntn,nganh);
                }
                
                c++;
            }
            n = dssv.length;
        }catch(FileNotFoundException e){
            System.out.println("Loi!");
        }
    }

    public void Nhapsv(){
        System.out.print("Nhap so sinh vien: ");
        n = sc.nextInt();
        dssv = new Sv[n];
        int choice;
        for(int i = 0;i < n;i++){
            Sv tmp;
            while(true){
                System.out.println("1. Sinh vien chinh quy");
                System.out.println("2. Sinh vien lien thong");
                System.out.print("Nhap lua chon: ");
                choice = sc.nextInt();
                sc.nextLine();
                if(choice == 1){
                    tmp = new Svcq();
                }else{
                    tmp = new Svlt();
                }
                tmp.Nhap();
                if(ktmasvduynhat(tmp.getMsv())){
                    dssv[i] = tmp;
                    break;
                }else{
                    System.out.println("Ma sinh vien da ton tai!. Vui long nhap lai");
                }
            }
        }
    }

    public void Xuatsv(){
        System.out.println("So sinh vien hien co la: " + n);
        System.out.printf("%-10s %-20s %-10s %-10s %-14s %-10s %-10s %-10s", "Masv","Ho","Ten","Gioi tinh","Ngay sinh","DRL","NamTN","Nganh");
        for(int i = 0;i < n;i++){
            dssv[i].Xuat();
        }
    }

    public boolean ktmasvduynhat(String msv){
        for(int i = 0;i < dssv.length;i++){
            if(dssv[i] != null && msv.equals(dssv[i].getMsv())) return false;
        }
        return true;
    }
    
    public void themsv(){
        int choice = 0;
        Sv tmp;
        while(true){
            System.out.println("1. Sinh vien chinh quy");
            System.out.println("2. Sinh vien lien thong");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                tmp = new Svcq();
            }else{
                tmp = new Svlt();
            }
            tmp.Nhap();
            if(ktmasvduynhat(tmp.getMsv())){
                dssv = Arrays.copyOf(dssv,n + 1);
                dssv[n] = new Sv(tmp);
                n++;
                break;
            }else{
                System.out.println("Ma sinh vien da ton tai!. Vui long nhap lai");
            }
        }
    }

    public void themsv(Sv sv){
        n = dssv.length;
        dssv = Arrays.copyOf(dssv, n + 1);
        if(sv instanceof Svcq){
            dssv[n] = (Svcq) sv;
        }else if(sv instanceof Svlt){
            dssv[n] = (Svlt) sv;
        }
        n++;
    }

    public void Xoasv(){
        String k;
        k = sc.nextLine();
        for(int i = 0;i < n;i++){ 
            if(dssv[i].getMsv().equals(k)){
                for(int j = i;j < n - 1;j++){
                    dssv[j] = dssv[j + 1];
                }
                n--;
                dssv = Arrays.copyOf(dssv, n);
                System.out.println("Da xoa sinh vien co ma so: " + k);
                return;
            }
        }
    }

    public void Xoasv(String k){
        for(int i = 0;i < n;i++){ 
            if(dssv[i].getMsv().equals(k)){
                for(int j = i;j < n - 1;j++){
                    dssv[j] = dssv[j + 1];
                }
                n--;
                dssv = Arrays.copyOf(dssv, n);
                System.out.println("Da xoa sinh vien co ma so: " + k);
                return;
            }
        }
    }

    public void Timkiemtheomsv(){
        String msv;
        msv = sc.nextLine();
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s %-10s", "Masv","Ho","Ten","Gioi tinh","Ngay sinh","DRL","NamTN","Nganh");
        for(int i = 0;i < n;i++){
            if(dssv[i].getMsv().equals(msv)){
                dssv[i].Xuat();
            }
        }
    }

    public Sv Timkiemtheomsv(String msv){
        Sv dssv1 = new Sv();
        for(int i = 0;i < n;i++){
            if(dssv[i].getMsv().equals(msv)){
                dssv1 = dssv[i];
            }
        }
        return dssv1;
    }

    public void Timkiemsvtheoho(){
        String ho;
        ho = sc.nextLine();
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s %-10s", "Masv","Ho","Ten","Gioi tinh","Ngay sinh","DRL","NamTN","Nganh");
        for(int i = 0;i < n;i++){
            if(dssv[i].getHo().contains(ho)){
                dssv[i].Xuat();
            }
        }
    }

    public Sv[] Timkiemsvtheoho(String ho){
        int c = 0;
        Sv[] dssv1 = new Sv[0];
        for(int i = 0;i < n;i++){
            if(dssv[i].getHo().equals(ho)){
                dssv1 = Arrays.copyOf(dssv1, c + 1);
                dssv1[c] = new Sv(dssv[i]);
            }
        }
        return dssv1;
    }

    public void tksvdrl(int drl){
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s %-10s", "Masv","Ho","Ten","Gioi tinh","Ngay sinh","DRL","NamTN","Nganh");
        for(int i = 0;i < n;i++){
            if(dssv[i] instanceof Svcq){
                Svcq sv1 = (Svcq) dssv[i];
                if(sv1.getDrl() == drl){
                    sv1.Xuat();
                }
            }
        }
    }

    public Sv[] tksvdrl1(int drl){
        Sv[] dssv1 = new Sv[0];
        int c = 0;
        for(int i = 0;i < n;i++){
            if(dssv[i] instanceof Svcq){
                Svcq sv1 = (Svcq) dssv[i];
                if(sv1.getDrl() == drl){
                    dssv1 = Arrays.copyOf(dssv1, c + 1);
                    dssv1[c] = new Sv(dssv[i]);
                }
            }
        }
        return dssv1;
    }

    public void tksvlt(int ntnn){
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s %-10s", "Masv","Ho","Ten","Gioi tinh","Ngay sinh","DRL","NamTN","Nganh");
        for(int i = 0;i < n;i++){
            if(dssv[i] instanceof Svlt){
                Svlt sv1 = (Svlt) dssv[i];
                if(sv1.getNtn() == ntnn){
                    sv1.Xuat();
                }
            }
        }
    }

    public Sv[] tksvlt1(int ntnn){
        Sv[] dssv1 = new Sv[0];
        int c = 0;
        for(int i = 0;i < n;i++){
            if(dssv[i] instanceof Svlt){
                Svlt sv1 = (Svlt) dssv[i];
                if(sv1.getNtn() == ntnn){
                    dssv1 = Arrays.copyOf(dssv1, c + 1);
                    dssv1[c] = new Sv(dssv[i]);
                }
            }
        }
        return dssv1;
    }

    public void suasv(){
        int k;
        System.out.print("Hay nhap sinh vien can sua: ");
        k = sc.nextInt();
        sc.nextLine();
        System.out.println("1: Sua ma sinh vien" );
        System.out.println("2: Sua ho" );
        System.out.println("3: Sua ten" );
        System.out.println("4: Sua gioi tinh" );
        System.out.println("5: Sua ngay sinh" );
        if(dssv[k] instanceof Svcq){
            System.out.println("6: Sua diem ren luyen");
        }else if(dssv[k] instanceof Svlt){
            System.out.println("6: Sua nam tot nghiep");
            System.out.println("7: Sua nganh hoc");
        }
        System.out.print("Hay chon thuoc tinh chinh sua: ");
        int choice = sc.nextInt();
        System.out.print("Thong tin chinh sua: ");
        sc.nextLine();
        String s;
        s = sc.nextLine();
        switch (choice) {
            case 1:
                dssv[k].setMsv(s);
                break;
            case 2:
                dssv[k].setHo(s);
                break;
            case 3:
                dssv[k].setTen(s);
                break;
            case 4:
                dssv[k].setGT(s);
                break;
            case 5:
                dssv[k].setNS(s);
                break;
            case 6:
                if(dssv[k] instanceof Svcq){
                    Svcq sv1 = (Svcq) dssv[k];
                    sv1.setDrl(Integer.parseInt(s));
                    dssv[k] = sv1;
                }else if(dssv[k] instanceof Svlt){
                    Svlt sv1 = (Svlt) dssv[k];
                    sv1.setNtn(Integer.parseInt(s));
                }
                break;
            case 7:
                Svlt sv1 = (Svlt) dssv[k];
                sv1.setNganh(s);
                dssv[k] = sv1;
                break;
            default:
                break;
            }
    }

    public int[] thongketuoi(){
        int[] cnt = new int[3];
        for(int i = 0;i < n;i++){
            if(dssv[i].tuoi() == 20) cnt[0]++;
            else if(dssv[i].tuoi() < 20) cnt[1]++;
            else cnt[2]++;
        }
        System.out.println("--------------------- Thong ke tuoi ----------------------");
        System.out.printf("%-20s %-20s %-20s", "Bang 20","Duoi 20","Tren 20");
        System.out.printf("\n%-20d %-20d %-20d", cnt[0],cnt[1],cnt[2]);
        return cnt;
    }

    public Sv[] timkiemtuoi(){
        Sv[] dssv1 = new Sv[n];
        int c = 0;
        int choice = 0;
        System.out.print("1. Thong ke sinh vien duoi 20 tuoi");
        System.out.print("2. Thong ke sinh vien tren 20 tuoi");
        System.out.print("3. Thong ke sinh vien bang 20 tuoi");
        System.out.print("Nhap lua chon: ");
        choice = sc.nextInt();
        if(choice == 1){
            for(int i = 0;i < n;i++){
                if(dssv[i].tuoi() < 20) dssv1[c++] = new Sv(dssv[i]);
            }
        }else if(choice == 2){
            for(int i = 0;i < n;i++){
                if(dssv[i].tuoi() > 20) dssv1[c++] = new Sv(dssv[i]);
            }
        }else if(choice == 3){
            for(int i = 0;i < n;i++){
                if(dssv[i].tuoi() == 20) dssv1[c++] = new Sv(dssv[i]);
            }
        }
        return dssv1;
    }

    public int[] thongkegt(){
        int[] cnt = new int[2];
        for(int i = 0;i < n;i++){
            if(dssv[i].getGT().equals("Nam")) cnt[0]++;
            else cnt[1]++;
        }
        System.out.println("--------------------- Thong ke gioi tinh ----------------------");
        System.out.printf("%-10s %-10s", "Nam","Nu");
        System.out.printf("\n%-10d %-10d", cnt[0],cnt[1]);
        return cnt;
    }

    public Sv[] timkiemgt(){
        Sv[] dssv1 = new Sv[n];
        int c = 0;
        int choice;
        System.out.print("1. Thong ke sinh vien gioi tinh Nam");
        System.out.println("2. Thong ke sinh vien gioi tinh Nu");
        System.out.print("Nhap lua chon: ");
        choice = sc.nextInt();
        if(choice == 1){
            for(int i = 0;i < n;i++){
                if(dssv[i].getGT().equals("Nam")) dssv1[c++] = new Sv(dssv[i]);
            }
        }else if(choice == 2){
            for(int i = 0;i < n;i++){
                if(dssv[i].getGT().equals("Nu")) dssv1[c++] = new Sv(dssv[i]);
            }
        }
        return dssv1;
    }

    public void xeploaidrl(){
        int[] cnt =  new int[6];
        for(int i = 0;i < 6;i++){
            cnt[i] = 0;
        }
        for(int i = 0;i < n;i++){
            if(dssv[i] instanceof Svcq){
                Svcq sv1 = (Svcq) dssv[i];
                if(sv1.getDrl() >= 90) cnt[0]++;
                else if(sv1.getDrl() >= 80 && sv1.getDrl() < 90) cnt[1]++;
                else if(sv1.getDrl() >= 65 && sv1.getDrl() < 80) cnt[2]++;
                else if(sv1.getDrl() >= 50 && sv1.getDrl() < 65) cnt[3]++;
                else if(sv1.getDrl() >= 35 && sv1.getDrl() < 50) cnt[4]++;
                else if(sv1.getDrl() < 35) cnt[5]++;
            }
        }
        System.out.printf("%-15s %-10s %-10s %-15s %-10s %-10s", "Xuat sac","Gioi","Kha","Trung binh","Yeu","Kem");
        System.out.printf("\n%-15s %-10s %-10s %-15s %-10s %-10s",cnt[0],cnt[1],cnt[2],cnt[3],cnt[4],cnt[5]);
    }

    public Sv[] timkiemdrl(){
        Sv[] dssv1 = new Sv[n];
        int c = 0;
        System.out.println("1. Xep loai sinh vien gioi");
        System.out.println("2. Xep loai sinh vien kha");
        System.out.println("3. Xep loai sinh vien trung binh");
        System.out.println("4. Xep loai sinh vien yeu");
        System.out.print("Nhap lua chon: ");
        int choice = sc.nextInt();
        if(choice == 1){
            for(int i = 0;i < n;i++){
                if(dssv[i] instanceof Svcq){
                    Svcq sv1 = (Svcq) dssv[i];
                    if(sv1.getDrl() >= 80) dssv1[c++] = new Sv(dssv[i]);
                }
            }
        }else if(choice == 2){
            for(int i = 0;i < n;i++){
                if(dssv[i] instanceof Svcq){
                    Svcq sv1 = (Svcq) dssv[i];
                    if(sv1.getDrl() >= 60 && sv1.getDrl() < 80) dssv1[c++] = new Sv(dssv[i]);
                }
            }
        }else if(choice == 3){
            for(int i =0;i < n;i++){
                if(dssv[i] instanceof Svcq){
                    Svcq sv1 = (Svcq) dssv[i]; 
                    if(sv1.getDrl() >= 50 && sv1.getDrl() < 60) dssv1[c++] = new Sv(dssv[i]);
                }
            }
        }else if(choice == 4){
            for(int i =0;i < n;i++){
                if(dssv[i] instanceof Svcq){
                    Svcq sv1 = (Svcq) dssv[i]; 
                    if(sv1.getDrl() < 50) dssv1[c++] = new Sv(dssv[i]);
                }
            }
        }
        return dssv1;
    }
}
