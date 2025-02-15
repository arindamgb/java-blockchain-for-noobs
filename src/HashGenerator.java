import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class HashGenerator {
    public static String generateSHA256Hash(Object obj) {
        Objects.requireNonNull(obj, "Input object cannot be null");

        try {
            String input = obj.toString();
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            // Explicitly use UTF-8 encoding
            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
            byte[] hashBytes = sha256.digest(inputBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}