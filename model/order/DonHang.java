package QuanLyCH.model.order;

import QuanLyCH.model.sanpham.*;
import QuanLyCH.model.thanhtoan.*;
import java.util.ArrayList;
import java.util.List;

public class DonHang {
    private String tenKhachHang;                   
    private List<SanPham> dsSanPham;                 
    private PhuongThucThanhToan phuongThuc;          

    public DonHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
        this.dsSanPham = new ArrayList<>();
    }
    
    public void themSanPham(SanPham sp) {
        dsSanPham.add(sp);
    }
    
    public void chonPhuongThucThanhToan(PhuongThucThanhToan phuongThuc) {
        this.phuongThuc = phuongThuc;
    }
    
    public double tinhTongTien() {
        double tong = 0;
        for (SanPham sp : dsSanPham) {
            tong += sp.getGia();
        }
        return tong;
    }
    
    public void thanhToan() {
        if (phuongThuc == null) {
            System.out.println("Chua chon phuong thuc thanh toan");
            return;
        }
        
        double tongTien = tinhTongTien();
        System.out.println("\n DON HANG ");
        System.out.println("Khach Hang: " + tenKhachHang);
        for (SanPham i : dsSanPham) {
            i.hienThiThongTin();
        }
        System.out.println("Tong tien: " + String.format("%.0f", tongTien) + " VND");
        System.out.println("---");
        phuongThuc.thanhToan(tongTien);
        System.out.println("====================\n");
    }
}