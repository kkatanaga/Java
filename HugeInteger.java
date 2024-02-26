public class HugeInteger {
    final static int INT_SIZE = 40;
    private int[] hugeInt;
    private int digits;
    private boolean negative;
    private boolean doubleOp;
    private boolean swapped;

    public HugeInteger() {
        hugeInt = new int[INT_SIZE];
        this.digits = 0;
        negative = false;
        doubleOp = false;
        swapped = false;
    }

    public void parse(String input) {
        int input_length = input.length();
        if (input_length > INT_SIZE)
            return;

        this.digits = input_length;
        int string_index, int_index;
        for (string_index = input.length()-1, int_index = INT_SIZE-1; string_index > 0; --string_index, --int_index) {
            hugeInt[int_index] = input.charAt(string_index) - '0';
        }

        char firstChar = input.charAt(string_index);

        if (firstChar == '-') {
            negative = true;
            this.digits--;
        } else {
            hugeInt[int_index] = firstChar - '0';
        }
    }

    public HugeInteger add(HugeInteger other) {
        if ( !other.doubleOp && (!negative && other.negative || negative && !other.negative) ) {
            other.negative = !other.negative;
            other.doubleOp = true;
            return this.subtract(other);
        }

        HugeInteger result = new HugeInteger();
        
        int carry = 0, temp = 0;
        for (int i = INT_SIZE-1; i >= 0; --i) {
            temp = hugeInt[i] + other.hugeInt[i] + carry;

            carry = temp / 10;
            result.hugeInt[i] = temp % 10;
        }

        result.countDigits();
        return result;
    }

    public HugeInteger subtract(HugeInteger other) {
        if ( !other.doubleOp && (!negative && other.negative || negative && !other.negative) ) {
            other.negative = !other.negative;
            other.doubleOp = true;
            return this.add(other);
        }
        if (!swapped && (digits < other.digits || (this.compareTo(other) < 0 && !negative) ) ) {
            other.swapped = true;
            return other.subtract(this);
        }

        HugeInteger result = new HugeInteger();
        
        int borrow = 0;
        for (int i = INT_SIZE-1; i > 0; --i) {
            if (borrow > 0) {
                borrow--;
                hugeInt[i]--;
            }

            if (hugeInt[i] < other.hugeInt[i]) {
                borrow++;
                result.hugeInt[i] = (10 + hugeInt[i]) - other.hugeInt[i];
            }
            else 
                result.hugeInt[i] = hugeInt[i] - other.hugeInt[i];

        }

        if (other.doubleOp) {
            other.negative = !other.negative;
            other.doubleOp = false;
        }
        
        result.countDigits();
        return result;
    }

    private void countDigits() {
        int i;
        for (i = 0; hugeInt[i] == 0; ++i) {
        }
        for (; i < INT_SIZE; ++i, ++digits) {
        }
    }

    public String toString() {
        String output = "";
        if (negative == true) {
            output += "-";
        }

        for (int i = INT_SIZE - digits; i < INT_SIZE; ++i) {
            output += Integer.toString(hugeInt[i]);
        }

        return output;
    }

    public int compareTo(HugeInteger other) {
        if (negative == false && other.negative == true)
            return 1;
        else if (negative == true && other.negative == false)
            return -1;
        
        for (int i = 0; i < INT_SIZE; ++i) {
            if (hugeInt[i] != other.hugeInt[i]) {
                if (hugeInt[i] > other.hugeInt[i] && negative == false)
                    return 1;
                else
                    return -1;
            }
        }
        return 0;
    }
}