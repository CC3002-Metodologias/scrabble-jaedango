package files;

import java.math.BigInteger;

public class ScBinary {
    String value;
    public ScBinary(String bin) {
        if (bin.matches("^[01]+$")){
            this.value = bin;
        } else {
            if (bin.matches("^[0|1]+.[0|1]+$")){
                this.value = bin;
            }
            else {
                this.value = "Error";
            }
        }
    }

    @Override
    public String toString(){
        return this.value;
    }

    public ScString toScString() {
        return new ScString(this.toString());
    }

    public ScFloat toScFloat() {
        int intBits = new BigInteger(this.value, 2).intValue();
        return new ScFloat(Float.intBitsToFloat(intBits));
    }

    public ScInt toScInt() {
        int n;
        if (this.value.charAt(0) == 1) {
            n = 1;
        } else {
            n = -1;
        }
        String str = this.value.substring(1, this.value.length());
        return new ScInt(n * Integer.parseInt(str, 2));
    }

}
