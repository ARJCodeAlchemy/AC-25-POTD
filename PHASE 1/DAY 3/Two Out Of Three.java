class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        //a question focusing primarly on using and understanding the functionalities of hashset

        //first storing the values of given arrays into set to remove internal duplicacy
        Set<Integer> set1 = new HashSet<>(); 
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        //taking final set that would store the intersection
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        for(int i = 0; i < nums3.length; i++){
            set3.add(nums3[i]);
        }

        List<Integer> ans = new ArrayList<>();
        //if an element of set1 is present in set2 or set3, that would make it to the finals
        for(int n : set1){
            if(set2.contains(n) || set3.contains(n)){
                set.add(n);
            }
        }
        //now only intersection of set2 and set3 is remainig
        for(int n : set2){
            if(set3.contains(n)){
                set.add(n);
            }
        }
        //from the final set storing it into arraylist.
        for(int n : set){
            ans.add(n);
        }
        return ans;
    }
}