class Solution {
    int highest(int n){
int a=1;
for(int i=3;i<=n;i*=3){
    a=i;
    if(i>n) break;
}

    return a;

}
public:
    bool checkPowersOfThree(int n) {
        unordered_set<int> st;
        while(n!=0){
            int a=highest(n);
            cout<<a<<endl;
            if(st.find(a)==st.end())
            st.insert(a);
            else {
                return false;
            }
            n=n-a;
            if(n==0) return true;

        }
return false;
    }
};