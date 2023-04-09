package Classes;

public class CashBack extends Promotion {
    private double cashBack;
    private final String nama = "CashBackAsyik";
    public CashBack() {
        super();
    }

    public double getCashBack() {
        return this.cashBack;
    }

    public String getNama() {
        return nama;
    }

    public void promoCashBack(Order order, Pelanggan pelanggan) throws Exception {
        double harga = order.getTotalHarga();
        this.cashBack = 0;

        if (!isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (!isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else if (harga >= 50000 && harga < 75000) {
            this.cashBack += 3000;
        } else if (harga >= 75000 && harga < 10000) {
            this.cashBack += 5000;
        } else if (harga >= 100000) {
            this.cashBack += 7000;
        }
    }

    public void promoCashBackMember(Order order, Pelanggan pelanggan) throws Exception {
        double harga = order.getTotalHarga();
        this.cashBack = 0;

        if (!isCustomerEligible(pelanggan)) {
            throw new Exception("Anda bukan member!");
        } else if (!isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (!isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else if (harga >= 50000 && harga < 75000) {
            this.cashBack += 5000;
        } else if (harga >= 75000 && harga < 10000) {
            this.cashBack += 8000;
        } else if (harga >= 100000) {
            this.cashBack += 10000;
        }
    }

}
