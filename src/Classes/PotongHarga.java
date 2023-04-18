package Classes;

public class PotongHarga extends Promotion {
    private double totalDiskon;
    private final String nama = "DiskonAsyik";
    public PotongHarga() {
        super();
    }

    public double getDiskon() {
        return totalDiskon;
    }

    public String getNama() {
        return nama;
    }

    public void promoDiskon(Order order, Pelanggan pelanggan) throws Exception {
        double diskon = order.getTotalHarga();

        if (isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            this.totalDiskon = diskon-(diskon * 0.01);
        }
    }

    public void promoDiskonMember(Order order, Pelanggan pelanggan) throws Exception {
        double diskon = order.getTotalHarga();

        if (!isCustomerEligible(pelanggan)) {
            throw new Exception("Anda bukan member!");
        } else if (isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            this.totalDiskon = diskon-(diskon * 0.03);
        }
    }
}
