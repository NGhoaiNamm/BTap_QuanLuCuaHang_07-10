package QuanLyCH;
import QuanLyCH.model.order.*;
import QuanLyCH.model.sanpham.*;
import QuanLyCH.model.thanhtoan.*;


// Chuong trinh chinh de test he thong
public class Main {
    public static void main(String[] args) {
        // Tao danh sach san pham
        System.out.println("===== TAO SAN PHAM =====");
        SanPham sp1 = new SanPhamDienTu("SP001", "iPhone 15", 25000000, "123456789012345", 12);
        SanPham sp2 = new SanPhamDienTu("SP002", "Samsung Galaxy S24", 20000000, "987654321098765", 12);
        SanPham sp3 = new SanPhamThucPham("SP003", "Sua tuoi Vinamilk", 30000, "31/12/2025");
        SanPham sp4 = new SanPhamThucPham("SP004", "Banh mi sandwich", 15000, "08/10/2025");
        
        sp1.hienThiThongTin();
        sp2.hienThiThongTin();
        sp3.hienThiThongTin();
        sp4.hienThiThongTin();
        
        System.out.println("\n===== DON HANG 1 - TIEN MAT =====");
        // Tao don hang 1 - Thanh toan tien mat
        DonHang donHang1 = new DonHang("Nguyen Van A");
        donHang1.themSanPham(sp1);
        donHang1.themSanPham(sp3);
        donHang1.chonPhuongThucThanhToan(new TienMat());
        donHang1.thanhToan();
        
        System.out.println("===== DON HANG 2 - THE TIN DUNG =====");
        // Tao don hang 2 - Thanh toan the tin dung
        DonHang donHang2 = new DonHang("Nguyen Van B");
        donHang2.themSanPham(sp2);
        donHang2.themSanPham(sp4);
        donHang2.chonPhuongThucThanhToan(new TheTinDung("1234567890123456"));
        donHang2.thanhToan();
        
        System.out.println("===== DON HANG 3 - VI MOMO =====");
        // Tao don hang 3 - Thanh toan Momo
        DonHang donHang3 = new DonHang("Tran Thi C");
        donHang3.themSanPham(sp1);
        donHang3.themSanPham(sp2);
        donHang3.themSanPham(sp3);
        donHang3.chonPhuongThucThanhToan(new Momo("0901234567"));
        donHang3.thanhToan();
    }
}