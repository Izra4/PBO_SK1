package Classes;

public class PotongHarga extends Promotion {
    public PotongHarga() {
        super();
    }

    public double promoDiskon(Order order, Pelanggan pelanggan) throws Exception {
        if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            return (int) order.getTotalHarga() * 0.01;
        }
    }

    public double promoDiskonMember(Order order, Pelanggan pelanggan) throws Exception {
        if (!isCustomerEligible(pelanggan)) {
            return -1;
        } else if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else {
            return (int) order.getTotalHarga() * 0.03;
        }
    }
}
