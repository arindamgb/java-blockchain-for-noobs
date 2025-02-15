import java.util.ArrayList;
import java.util.List;

public class BitCoin {
    private Block openBlock;
    private List<Block> chain;

    // Constructor
    public BitCoin() {
        this.openBlock = new Block();
        this.chain = new ArrayList<>();
    }

    // Getter for openBlock
    public Block getOpenBlock() {
        return openBlock;
    }

    // Setter for openBlock
    public void setOpenBlock(Block openBlock) {
        this.openBlock = openBlock;
    }

    // Getter for chain
    public List<Block> getChain() {
        return chain;
    }

    // Setter for chain
    public void setChain(List<Block> chain) {
        this.chain = chain;
    }

    // Method to add a transaction to the open block
    public void addTransaction(Transaction transaction) {
        openBlock.addTransaction(transaction);
    }

    // Method to add the open block to the chain
    public String closeBlock() {
        // Generate the hash for the open block
        // openBlock.setHash(HashGenerator.generateSHA256Hash(openBlock));

        // Saved the re-calculation by adding mined hash in mineBlock() method, set it in openBlock object from 'this' object i.e. bitCoin object
        openBlock.setHash(this.getOpenBlock().getHash());
        //System.out.println(this.getOpenBlock().getHash());

        // Set the previous hash of the open block to the hash of the last block in the chain
        if (!chain.isEmpty()) {
            Block lastBlock = chain.get(chain.size() - 1);
            openBlock.setPreviousHash(lastBlock.getHash());
        }

        // Add the open block to the chain
        chain.add(openBlock);

        // Preserve the hash of the OpenBlock to return
        String closingHash = openBlock.getHash();

        // Create a new open block
        openBlock = new Block();

        // Return the hash of the block just closed
        return closingHash;
    }

    // Override toString() for a meaningful string representation
    @Override
    public String toString() {
        return "BitCoin{" +
                "openBlock=" + openBlock +
                ", chain=" + chain +
                '}';
    }
}