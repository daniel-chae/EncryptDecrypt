package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


abstract class CryptoFactory {
    abstract Cryptor createCryptor(String mode, String arg);

    public void produceOutput(String out, char[] charSet, int shift, String mode, String arg) {
        Cryptor cryptor = createCryptor(mode, arg);
        char[] resultSet = cryptor.encryptOrDecrypt(charSet, shift);
        if (out == null) {
            System.out.println(resultSet);
        } else {
            File file = new File(out);
            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (char ch : resultSet) {
                    printWriter.print(ch);
                }
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
        }
    }
}
