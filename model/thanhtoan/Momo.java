package QuanLyCH.model.thanhtoan;

public class Momo implements PhuongThucThanhToan {
    private String soDienThoai;
    
    public Momo(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    @Override
    public void thanhToan(double soTien) {
        System.out.println("Thanh toan qua Momo thanh cong ");
    }
}
