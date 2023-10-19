import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] digits = {1,9,9};
        System.out.println("Digits = " + Arrays.toString(sol.plusOneV1(digits)));
    }
    public int[] plusOne(int[] digits) {
        StringBuilder nums = new StringBuilder();
        for (int elt : digits) {
            nums.append(elt);
        }
        BigInteger newDigit = new BigInteger(String.valueOf(nums));
        newDigit = newDigit.add(BigInteger.ONE);
        String newDigitString = String.valueOf(newDigit);
        char[] digitStringCharArray = newDigitString.toCharArray();
        int[] newArray = new int[digitStringCharArray.length];
        for (int i = 0; i < digitStringCharArray.length; i++) {
            newArray[i] = digitStringCharArray[i] - 48;
        }
        return newArray;
    }
    public int[] plusOneV1(int[] digits){
        int carry =  1;
        int length = digits.length;
        for (int i = length - 1; i >= 0 ; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if(carry == 0) break;
        }
        if(carry > 0){
            int[] result = new int[length + 1];
            result[0] = carry;
            System.arraycopy(digits,0, result, 1, length);
            return result;
        }else{
            return digits;
        }
    }
}
