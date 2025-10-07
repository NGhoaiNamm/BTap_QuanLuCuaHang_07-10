package QuanLyCH.model.sanpham;

public class SanPhamThucPham extends SanPham  {
    private String hanSuDung;

    public SanPhamThucPham(String ma, String ten, double gia, String hanSuDung) {
        super(ma, ten, gia);
        this.hanSuDung = hanSuDung;
    }
    @Override
    public void hienThiThongTin() {
        System.out.println("SP TP: "+ ten + ", Gia: " + gia + ", Han Su Dung: " + hanSuDung);
    }
}
