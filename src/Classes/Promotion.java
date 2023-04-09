package Classes;

import java.time.LocalDate;
import java.util.Random;

public abstract class Promotion implements Applicable,Comparable {
    private int promoCode;
    private LocalDate mulai;
    private LocalDate berakhir;
    private int jumlahPromo = 0;


    public Promotion() {
        Random random = new Random();
        this.promoCode = random.nextInt(100);
        this.mulai = LocalDate.now();
        this.berakhir = LocalDate.now().plusDays(3);
        this.jumlahPromo++;
    }

    public int getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(int promoCode) {
        this.promoCode = promoCode;
    }

    public LocalDate getMulai() {
        return mulai;
    }

    public void setMulai(LocalDate mulai) {
        this.mulai = mulai;
    }

    public LocalDate getBerakhir() {
        return berakhir;
    }

    public void setBerakhir(LocalDate berakhir) {
        this.berakhir = berakhir;
    }

    @Override
    public boolean isCustomerEligible(Pelanggan pelanggan) {
        return pelanggan.isMember();
    }

    @Override
    public boolean isMinimumPriceEligible(Order order) {
        return order.getTotalHarga()>=50000;
    }

    @Override
    public boolean isShippingFeeEligible(Order order) {
        return order.getOngkir() >= 5000;
    }

    @Override
    public double totalCashBack(Order order,CashBack cashBack) {
        return cashBack.getCashBack();
    }

    @Override
    public double totalDiskon(Order order,PotongHarga potongHarga) {
        return potongHarga.getDiskon();
    }

    @Override
    public double totalOngkir(Order order,PotongOngkir potongOngkir) {
        return potongOngkir.getTotalOngkir();
    }



    @Override
    public void compareTo(Order order,PotongOngkir potongOngkir,PotongHarga potongHarga,CashBack cashBack) {
        String[] listPromo = new String[this.jumlahPromo];
        int count = 0;

        if (totalDiskon(order,potongHarga) > totalOngkir(order,potongOngkir) || totalDiskon(order, potongHarga) > totalCashBack(order, cashBack)) {
            listPromo[count] = potongHarga.getNama();
            count++;
        } else if (totalOngkir(order, potongOngkir) > totalDiskon(order, potongHarga) || totalOngkir(order, potongOngkir) > totalCashBack(order, cashBack)) {
            listPromo[count] = potongOngkir.getNama();
            count++;
        } else if (totalCashBack(order, cashBack) > totalDiskon(order, potongHarga) || totalCashBack(order, cashBack) > totalOngkir(order, potongOngkir)) {
            listPromo[count] = cashBack.getNama();
            count++;
        }
        System.out.print("Daftar Promo: ");
        for (int i = 0; i < count; i++) {
            System.out.print(listPromo[i] + " ");
        }
        System.out.println();
    }
}