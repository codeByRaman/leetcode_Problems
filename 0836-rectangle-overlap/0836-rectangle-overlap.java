class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
         return rec1[0] < rec2[2] &&   // rec1 left < rec2 right
               rec2[0] < rec1[2] &&   // rec2 left < rec1 right
               rec1[1] < rec2[3] &&   // rec1 bottom < rec2 top
               rec2[1] < rec1[3];
    }
}