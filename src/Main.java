import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        //String hash = HashGenerator.generateSHA256Hash("Hello World");
        //System.out.println("SHA-256 Hash: " + hash);

        BitCoin bitCoin = new BitCoin();

        // Transaction 1 with charge Transaction
        Transaction tx = new Transaction();
        tx.setSender("John Doe");
        tx.setReceiver("Zoe Saldana");
        tx.setAmount("100");
        tx.setTransactionTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        bitCoin.addTransaction(tx);

        Transaction tx_charge = new Transaction();
        tx_charge.setSender("John Doe");
        tx_charge.setReceiver("BitCoin Authority");
        tx_charge.setAmount("5");
        tx_charge.setTransactionTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        bitCoin.addTransaction(tx_charge);

        // Check the type as we need to pass Block in mineBlock
        // System.out.println(bitCoin.getOpenBlock().getClass().getName());

        // Send the 'Block openBlock' variable in 'BitCoin bitCoin' to mineBlock method
        Block minedBlock = mineBlock(bitCoin.getOpenBlock());

        // Assign the minedBlock to 'Block openBlock' variable in 'BitCoin bitCoin'
        System.out.println(minedBlock.toString());
        bitCoin.setOpenBlock(minedBlock);

        // Close the block by adding it to the Chain
        String closedWithHash = bitCoin.closeBlock();
        System.out.println("Closed With HASH: " + closedWithHash);





//        // Transaction 2 with charge Transaction
//        tx = new Transaction();
//        tx.setSender("Tom Cruise");
//        tx.setReceiver("Jane Doe");
//        tx.setAmount("200");
//        tx.setTransactionTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        bitCoin.addTransaction(tx);
//
//        tx_charge = new Transaction();
//        tx_charge.setSender("John Doe");
//        tx_charge.setReceiver("BitCoin Authority");
//        tx_charge.setAmount("10");
//        tx_charge.setTransactionTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        bitCoin.addTransaction(tx_charge);
//
//        bitCoin.closeBlock();
//
        System.out.println("Chain Now: " + bitCoin.getChain());
    }

    public static Block mineBlock(Block block) {
        // block.nonce = 0 assignment not needed as it starts from 0 by default
        // block.nonce = 0;
        while (true) {
            String hash = HashGenerator.generateSHA256Hash(block);
            if(hash.startsWith("0000")) {
                System.out.println("Trying nonce value: " + block.nonce + " Hash: " + hash);
                // Set the hash in block object to avoid re-calculation later
                block.setHash(hash);
                return block;
            }
            System.out.println("Trying nonce value: " + block.nonce + " Hash: " + hash);
            block.nonce++;
        }
    }
}
