package encryptdecrypt;

// Factory pattern is used
// Cryptor interface defines an interface for products
// Each Cryptor product must implement encrypOrDecrypt method with concrete algorithm
public interface Cryptor {
    char[] encryptOrDecrypt(char[] charSet, int shift);
}
