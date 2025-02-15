import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Block {
    private List<Transaction> transactions;
    private String hash;
    private String previousHash;
    public int nonce;

    // Default constructor
    public Block() {
        this.transactions = new ArrayList<>();
    }

    // Parameterized constructor
    public Block(String previousHash) {
        this.transactions = new ArrayList<>();
        this.previousHash = previousHash;
    }

    // Getter for transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setter for transactions
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Method to add a transaction
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    // Getter for hash
    public String getHash() {
        return hash;
    }

    // Setter for hash
    public void setHash(String hash) {
        this.hash = hash;
    }

    // Getter for previousHash
    public String getPreviousHash() {
        return previousHash;
    }

    // Setter for previousHash
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    // Override toString() for a meaningful string representation
    @Override
    public String toString() {
        return "Block{" +
                "nonce=" + nonce +
                ", transactions=" + transactions +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                '}';
    }

    // Override equals() and hashCode() for proper object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(transactions, block.transactions) &&
                Objects.equals(hash, block.hash) &&
                Objects.equals(previousHash, block.previousHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions, hash, previousHash);
    }
}