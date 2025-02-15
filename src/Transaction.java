import java.util.Objects;

public class Transaction {
    private String sender;
    private String receiver;
    private String amount;
    private String transactionTime;

    // Default constructor
    public Transaction() {}

    // Parameterized constructor
    public Transaction(String sender, String receiver, String amount, String transactionTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.transactionTime = transactionTime;
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    // Override toString() for a meaningful string representation
    @Override
    public String toString() {
        return "Transaction{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionTime='" + transactionTime + '\'' +
                '}';
    }

    // Override equals() and hashCode() for proper object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(sender, that.sender) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(transactionTime, that.transactionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver, amount, transactionTime);
    }
}