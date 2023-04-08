package Classes;

public class CashBack extends Promotion {
    public CashBack() {
        super();
    }

    public double promoCashBack(Order order, Pelanggan pelanggan) throws Exception {
        int cashBack = 0;

        if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else if (order.getTotalHarga() >= 50000 && order.getTotalHarga() < 75000) {
            cashBack = 3000;
        } else if (order.getTotalHarga() >= 75000 && order.getTotalHarga() < 10000) {
            cashBack = 5000;
        } else if (order.getTotalHarga() >= 100000) {
            cashBack = 7000;
        }
        return cashBack;
    }

    public double promoCashBackMember(Order order, Pelanggan pelanggan) throws Exception {
        int cashBack = 0;
        if (!isCustomerEligible(pelanggan)) {
            return -1;
        } else if (isShippingFeeEligible(order)) {
            return -1;
        } else if (isMinimumPriceEligible(order)) {
            throw new Exception("Minimal Transaksi harus 50000");
        } else if (order.getTotalHarga() >= 50000 && order.getTotalHarga() < 75000) {
            cashBack = 5000;
        } else if (order.getTotalHarga() >= 75000 && order.getTotalHarga() < 10000) {
            cashBack = 8000;
        } else if (order.getTotalHarga() >= 100000) {
            cashBack = 10000;
        }
        return cashBack;
    }

}
