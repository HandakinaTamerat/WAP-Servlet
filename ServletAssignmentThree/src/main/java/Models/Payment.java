package Models;

import java.time.LocalDate;

public class Payment {
    private PaymentStatus status;
    private double amount;
    private LocalDate paymentDate;
    private String cardName;
    private String cardNumber;
    private String address1;
    private String email;
    private String phone;
    private int zipCode;
    private String expDate;

    public Payment(PaymentStatus status, double amount, LocalDate paymentDate,String address1, String cardName, String cardNumber, String email, String phone, int zipCode, String expDate) {
        this.status = status;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.email = email;
        this.phone = phone;
        this.zipCode = zipCode;
        this.expDate = expDate;
        this.address1=address1;
    }


    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
