package Classes;

public class PotongOngkir extends Promotion {
    public PotongOngkir() {
        super();
    }

    public double promoOngkir(Order order, Pelanggan pelanggan) throws Exception {
        int ongkir = order.getOngkir();

        if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        }
        return (int) ongkir * 0.01;
    }

    public double promoOngkirMember(Order order, Pelanggan pelanggan) throws Exception {
        int ongkir = order.getOngkir();
        if (!isCustomerEligible(pelanggan)) {
            return -1;
        } else if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        }
        return (int) ongkir * 0.03;
    }
}
