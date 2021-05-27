package files;

/**
 * Codigo tomado principalmente desde las instrucciones del proyecto
 * Clase que ayuda a transformar desde int a binario y de binario a int
 */

public class BinaryToInt {
    public static int toInt(String bin) {
        if (binToInt (bin.charAt(0)) == 0) {
            return positiveBinToInt(bin);
        } else {
            return negativeBinaryToInt(bin) - 1;
        }
    }

    private static int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -binToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w+= (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    private static int positiveBinToInt(String bin) {
        int w = 0;
        for (int i = bin.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * binToInt(bin.charAt(i));
        }
        return w;
    }

    private static int binToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    public static String intToBin(int n) {
        String bin = "";
        if (n > 0) {
            bin += "0";
            bin += Integer.toBinaryString(n);
        } else {
            bin = Integer.toBinaryString(n);
        }
        return bin;
    }
}
