class Solution {
    private int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a % b);
    }
    
    private int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }
    
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int num : nums) {
            while(st.size()>0 && gcd(st.peek(), num)>1) {
                num=lcm(st.peek(), num);
                st.pop();
            }
            st.add(num);
        }
        while(!st.isEmpty())result.add(st.pop());
        Collections.reverse(result);
        return result;
    }
}
