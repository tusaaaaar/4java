interface PaymentMode {
    void processPayment(double amount);
}

class CardPayment implements PaymentMode {
    public void processPayment(double amount) {
        System.out.println("This mode is of card: " + amount);
    }
}

class PayPalPayment implements PaymentMode {    
    public void processPayment(double amount) {
        System.out.println("This mode is of PayPal: " + amount);
    }
}

class UPIPayment implements PaymentMode {
    private String app;

    public UPIPayment(String app) {
        this.app = app;
    }

    public void processPayment(double amount) {
        System.out.println("This is UPI payment via " + app + " of amount " + amount);
    }
}

class POS {
    private PaymentMode mode;

    public void setPaymentMode(PaymentMode mode) {
        this.mode = mode;
    }

    public void processPayment(double amount) {
        if (mode != null) {
            mode.processPayment(amount);
        } else {
            System.out.println("No payment mode selected.");
        }
    }
}

public class three {
    public static void main(String[] args) {
        POS mode = new POS();

        mode.setPaymentMode(new CardPayment());
        mode.processPayment(200);

        mode.setPaymentMode(new PayPalPayment());
        mode.processPayment(350.0);

        mode.setPaymentMode(new UPIPayment("Google Pay"));
        mode.processPayment(5000.0);
    }
}

