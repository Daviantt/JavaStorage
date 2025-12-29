package chuong4.Sv;

import java.util.Scanner;

public class Qldssv {
    private Dssv ds1;
    Scanner sc = new Scanner(System.in);
    public Qldssv(){
        ds1 = new Dssv();
        ds1.docFile();
    }
    public Qldssv(Dssv ds2){
        ds1 = ds2;
        ds1.docFile();
    }
    public Qldssv(Qldssv s1){
        ds1 = s1.ds1;
        ds1.docFile();
    }

    public void menu(){
        int choice = 0;
        while(choice != 7){
            System.out.println("\n------------------------ QUAN LY DANH SACH SINH VIEN ------------------------" );
            System.out.println("1: Nhap sinh vien" );
            System.out.println("2: Xuat sinh vien" );
            System.out.println("3: Them sinh vien" );
            System.out.println("4: Xoa sinh vien" );
            System.out.println("5: Sua sinh vien");
            System.out.println("6: Tim kiem sinh vien" );
            System.out.println("7: Thong ke" );
            System.out.println("8: Xep loai drl");
            System.out.println("------------------------------------------------------------------------------" );
            System.out.print("Lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ds1.Nhapsv();
                    break;
                case 2:
                    ds1.Xuatsv();
                    break;
                case 3:
                    int choice1 = 0;
                    System.out.println("1.Nhap de them sv");
                    System.out.println("2.Them sv da co tham so");
                    choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            ds1.themsv();
                            break;
                        case 2:
                            Sv sv1 = new Sv("4","Nguyen","A","Nam","01/01/2000");
                            ds1.themsv(sv1);
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    sc.nextLine();
                    String msv = sc.nextLine();
                    ds1.Xoasv(msv);
                    break;
                case 5:
                    ds1.suasv();
                    break;
                case 6:
                    int choice2 = 0;
                    System.out.println("1: Tim kiem theo ma sinh vien" );
                    System.out.println("2: Tim kiem theo ten sinh vien" );
                    System.out.print("Lua chon: ");
                    choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.print("Nhap ma sinh vien can tim: ");
                            sc.nextLine();
                            ds1.Timkiemtheomsv();
                            break;
                        case 2:
                            System.out.print("Nhap ho sinh vien can tim: ");
                            sc.nextLine();
                            ds1.Timkiemsvtheoho();
                            break;
                        default:
                            System.out.println("Chi Nhap tu 1 -> 2");
                            break;
                    }
                    break;
                case 7:
                    int choice3 = 0;
                    System.out.println("1: Thong ke gioi tinh" );
                    System.out.println("2: Thong ke tuoi" );
                    choice3 = sc.nextInt();
                    if(choice3 == 1) ds1.thongkegt();
                    else if(choice3 == 2) ds1.thongketuoi();
                    else System.out.println("Chi Nhap tu 1 -> 2");
                    break;
                case 8:
                    ds1.xeploaidrl();
                    break;
                default:
                    System.out.println("Chi Nhap tu 1 -> 8");
                    break;
            }
        }
    }
}
