class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int n = candies.length;

        int max = Integer.MIN_VALUE;

        for (int num : candies){
            max = Math.max(num,max);
        }

        for (int num : candies){
            list.add(num + extraCandies >= max);
        }
        
        return list;
    }
}