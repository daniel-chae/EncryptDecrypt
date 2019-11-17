package encryptdecrypt;

//Product with encryptor with unicode logic
public class UnicodeEncryptor implements Cryptor {
    @Override
    public char[] encryptOrDecrypt(char[] charSet, int shift) {
        char[] resultSet = new char[charSet.length];
        int encrypted = 0;
        for (int i=0; i<charSet.length; i++){
            encrypted = (int)charSet[i] + shift % 127;
            resultSet[i] = (char)encrypted;
        }
        return resultSet;
    }
}
