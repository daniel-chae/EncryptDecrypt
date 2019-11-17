package encryptdecrypt;

//Product with encryptor with shift logic
public class ShiftEncryptor implements Cryptor {
    @Override
    public char[] encryptOrDecrypt(char[] charSet, int shift) {
        char[] resultSet = new char[charSet.length];
        for (int i = 0; i < charSet.length; i++){
            if (Character.isAlphabetic(charSet[i])){
                int intCharacter = (int)charSet[i];
                if ((intCharacter>=65 && intCharacter<=90)){
                    if (intCharacter + (shift % 26) > 90){
                        resultSet[i] = (char)((((intCharacter + shift % 26) - 90))+ 64);
                    } else {
                        resultSet[i] = (char)(intCharacter + (shift % 26));
                    }
                } else {
                    if (intCharacter + (shift % 26) > 122){
                        resultSet[i] = (char)((((intCharacter + shift % 26) - 122)) + 96);
                    } else {
                        resultSet[i] = (char)(intCharacter + shift);
                    }
                }
            } else {
                resultSet[i] = charSet[i];
            }
        }
        return resultSet;
    }
}
