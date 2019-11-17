package encryptdecrypt;

//Product with decryptor with unicode logic
public class UnicodeDecryptor implements Cryptor {
    @Override
    public char[] encryptOrDecrypt(char[] charSet, int shift) {
        char[] resultSet = new char[charSet.length];
        int decrypted = 0;
        for (int i = 0; i < charSet.length; i++) {
            decrypted = (int) charSet[i] - shift % 127;
            if (decrypted > -1) {
                resultSet[i] = (char) decrypted;
            } else {
                resultSet[i] = (char) (128 + decrypted);
            }
        }
        return resultSet;
    }
}
