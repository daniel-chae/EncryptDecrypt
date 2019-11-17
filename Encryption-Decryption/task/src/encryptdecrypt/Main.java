package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //variables to store execution arguments
        String mode = null; //enc or dec
        int shift = 0;
        String rawString = null; //string directly coming from argument
        String fileString = null; //string read from a file
        String out = null; //file out destination
        String algorithm = "shift";
        char[] charSet = null; //raw string or file string converted to char array

        //Set passed arguments to internal variables
        for (int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-mode":
                    if (args[i+1].equals("dec")){
                        mode = "dec";
                    } else {
                        mode = "enc";
                    }
                    break;
                case "-key":
                    shift = Integer.parseInt(args[i+1]);
                    break;
                case "-data":
                    rawString = args[i+1];
                    break;
                case "-in":
                    try {
                        fileString = new String(Files.readAllBytes(Paths.get(args[i+1])));
                    } catch (IOException e){
                        e.getMessage();
                    }
                    break;
                case "-out":
                    out = args[i+1];
                    break;
                case "-alg":
                    algorithm = args[i+1];
                    break;
                default:
                    break;
            }
        }

        //Set char array variable
        if (rawString == null && fileString == null){
            rawString = "";
            charSet = rawString.toCharArray();
        } else if (rawString != null){
            charSet = rawString.toCharArray();
        } else {
            charSet = fileString.toCharArray();
        }

        CryptoShop cryptoShop = new CryptoShop();
        cryptoShop.produceOutput(out, charSet, shift, mode, algorithm);
    }
}
