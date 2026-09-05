class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;
        int i = 0;
        while(i < 32){
            int bit = 0;
            int num1 = (a >> i) & 1;
            int num2 = (b >> i) & 1;

            if(num1 == 1 && num2 == 1){
                if(carry == 1) bit = 1;
                carry = 1;
            } else if((num1 == 1 || num2 == 1) && carry == 1){
                carry = 1;
            } else {
                bit = num1 | num2 | carry;
                carry = 0;
            }
            System.out.println(bit);
            sum = sum | (bit << i);
            i++;
        }
        // if(carry == 1)
        return sum;
    }
}
