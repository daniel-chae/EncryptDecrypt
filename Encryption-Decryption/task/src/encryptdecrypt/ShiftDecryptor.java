package encryptdecrypt;

//Product with decryptor with shift logic
public class ShiftDecryptor implements Cryptor {
    @Override
    public char[] encryptOrDecrypt(char[] charSet, int shift) {
        char[] resultSet = new char[charSet.length];
        for (int i = 0; i < charSet.length; i++){
            if (Character.isAlphabetic(charSet[i])){
                int intCharacter = (int)charSet[i];
                if ((intCharacter>=65 && intCharacter<=90)){
                    if (intCharacter - (shift % 26) < 65){
                        resultSet[i] = (char)(91 + (intCharacter - (shift % 26)) - 65);
                    } else {
                        resultSet[i] = (char)(intCharacter - shift);
                    }
                } else {
                    if (intCharacter - (shift % 26) < 97){
                        resultSet[i] = (char)(123 + (intCharacter - (shift % 26)) - 97);
                    } else {
                        resultSet[i] = (char)(intCharacter - shift);
                    }
                }
            } else {
                resultSet[i] = charSet[i];
            }
        }
        return resultSet;
    }
}
