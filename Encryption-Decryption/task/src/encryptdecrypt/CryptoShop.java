package encryptdecrypt;

//Create an appropriate encrytor or decryptor
public class CryptoShop extends CryptoFactory {
    @Override
    public Cryptor createCryptor(String mode, String arg){
        if (mode.equals("dec"))
            if (arg.equals("unicode")){
                return new UnicodeDecryptor();
            } else {
                return new ShiftDecryptor();
            } else {
            if (arg.equals("unicode")){
                return new UnicodeEncryptor();
            } else {
                return new ShiftEncryptor();
            }
        }
    }
}
