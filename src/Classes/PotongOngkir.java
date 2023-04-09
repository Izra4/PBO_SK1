package Classes;

public class PotongOngkir extends Promotion {
    private double totalOngkir;
    private final String nama = "OngkirAsyik";
    public PotongOngkir() {
        super();
    }

    public double getTotalOngkir() {
        return totalOngkir;
    }

    public String getNama() {
        return nama;
    }

    public void promoOngkir(Order order, Pelanggan pelanggan) throws Exception {
        double ongkir = order.getOngkir();

        if (!isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (!isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            this.totalOngkir = ongkir - (ongkir * 0.01);
        }
    }

    public void promoOngkirMember(Order order, Pelanggan pelanggan) throws Exception {
        double ongkir = order.getOngkir();

        if (!isCustomerEligible(pelanggan)) {
            throw new Exception("Anda bukan member!");
        } else if (!isShippingFeeEligible(order)) {
            throw new Exception("Ongkir tidak memenuhi");
        } else if (!isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            this.totalOngkir = ongkir - (ongkir * 0.01);
        }
    }
}
