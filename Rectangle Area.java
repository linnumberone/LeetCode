public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int botton = Math.max(B, F);
        int right = Math.max(left, Math.min(C, G));
        int top = Math.max(botton, Math.min(D, H));
        
        return area1 + area2 - (right - left) * (top - botton);         
    }
}
