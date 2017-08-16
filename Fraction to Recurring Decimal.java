public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 0
        if(numerator == 0) return "0";

        // sign
        StringBuilder res = new StringBuilder();
        
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // integer part
        res.append(num / den);
        num %= den;
        if(num == 0) return res.toString();
        
        // fraction part
        res.append(".");
        Map<Long, Integer> reminder = new HashMap<Long, Integer>();
        reminder.put(num, res.length());
        while(num != 0) {
            System.out.println(res.toString());
            num *= 10;
            res.append(num / den);
            num %= den;
            if(reminder.containsKey(num)) {
                int index = reminder.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else
                reminder.put(num, res.length());
        }
        
        return res.toString();
    }
}
