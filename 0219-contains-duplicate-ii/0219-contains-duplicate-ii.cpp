class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k){
        // we will create a map for handling multiple occurences of a number
        unordered_map<int,int> map;
        int i = 0; // windowStart
        int j = 0; // windowEnd

        for(int j=0; j<nums.size(); j++){
            // CASE 1: If the given condition is exceeded, then remove element from the beginning. i.e, shrink the 
            // window
            if(j > k){
                map[nums[i]]--; // decrement the frequency of it in the map
                i++; // shrink the window
            }

            // CASE 2: If the condition is met, then return true
            if(map[nums[j]] > 0){
                return true;
            }

            // CASE 3: If none of the above 2 conditions are matched, then simply insert the element into the map
            // and increment its frequency.
            map[nums[j]]++;
        }
        return false;
    }
};