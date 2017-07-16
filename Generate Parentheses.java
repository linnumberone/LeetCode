public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        generateOneByOne(result, sb, n, n);
        
        return result;
    }
    
    public void generateOneByOne(List<String> list, StringBuilder sb, int left, int right) {
        if(left > right)
            return;
        if(left > 0) { // put left first
            generateOneByOne(list, sb.append("("), left - 1, right);
            sb.setLength(sb.length() - 1); // since we already complete left first, we need to clean sb
        }
        if(right > 0) { // put right first
            generateOneByOne(list, sb.append(")"), left, right - 1);
            sb.setLength(sb.length() - 1);
        }
        if(left == 0 && right == 0) {
            list.add(sb.toString());
            // return;
        }
    }
}
