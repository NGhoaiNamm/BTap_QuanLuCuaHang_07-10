package QuanLyCH.model.thanhtoan;

public class TheTinDung implements PhuongThucThanhToan {
    private String soThe;         
    
    // Ham khoi tao
    public TheTinDung(String soThe) {
        this.soThe = soThe;
    }
    
    @Override
    public void thanhToan(double soTien) {
        System.out.println("Thanh toan bang the tin dung thanh cong");
    }
}
