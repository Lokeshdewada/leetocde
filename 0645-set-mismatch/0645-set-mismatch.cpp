class Solution {
public:
    //freq analysis
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int>freq((int)nums.size(), 0);
        vector<int>result;
        int dob;
        int none;
        for(int i =0; i < nums.size(); i++){
           freq[nums[i]-1]= freq[nums[i]-1] +1 ;
        }
        for(auto i : freq){
            cout << i << endl;
        }
        for(int i =0; i < freq.size(); i++){
            if(freq[i]!= 1){
                if(freq[i]== 2){
                    dob = i+1;
                }
                else{
                    none = i+1;
                }
            }
        }
        result.push_back(dob);
        result.push_back(none);
        return result;
    }
};