package QuanLyCH.model.sanpham;

import javax.print.DocFlavor.STRING;

public class SanPhamDienTu extends SanPham {
    private String imei;
    private int baoHanh;

    public SanPhamDienTu(String ma, String ten, double gia, String imei, int baoHanh) {
        super(ma, ten, gia);
        this.imei = imei;
        this.baoHanh = baoHanh;
    }
    @Override
    public void hienThiThongTin() {
        System.out.println("SP DT: "+ ten + ", Gia: " + gia + ", Imei: " + imei + ", Bao Hanh: " + baoHanh + " thang");
    }
}
