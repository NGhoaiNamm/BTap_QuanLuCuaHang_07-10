package QuanLyCH.model.sanpham;

public abstract class SanPham {
    protected String ma;
    protected String ten;
    protected double gia;
    protected int soLuongTon;


    public SanPham(String ma, String ten, double gia) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
    }
    public abstract void hienThiThongTin();

    public double getGia(){
        return gia;
    }

    public String getTen(){
        return ten;
    }

}