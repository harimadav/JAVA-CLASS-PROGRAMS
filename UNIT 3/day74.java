class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalsum=0;
        for(int i =0;i<arr.length;i++){
            int left =i+1;
            int right = arr.length -i;
            int totalsubarrays=left*right;
            int odds=(totalsubarrays+1)/2;
            int cont = arr[i]* odds;
            totalsum+=cont;
        }
        return totalsum;
    }
}
