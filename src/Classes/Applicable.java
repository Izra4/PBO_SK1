package Classes;

public interface Applicable {
    public boolean isCustomerEligible(Pelanggan pelanggan);
    public boolean isMinimumPriceEligible(Order order);
    public boolean isShippingFeeEligible(Order order);
    public double totalDiskon(Order order);
    public double totalCashBack(Order order);
    public double totalOngkir(Order order);
}
