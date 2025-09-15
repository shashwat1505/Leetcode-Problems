class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int fre[] = new int[26];
        int cnt=0;
        boolean flag=true;
        for(char ch : brokenLetters.toCharArray())fre[ch-'a']++;
        for(char ch : text.toCharArray()){
            if(ch==' '){
               if(flag)cnt++;
               flag=true;
            }
            if(ch!=' ' && fre[ch-'a']>0){
                flag=false;
            }
        }
        return (flag) ? cnt+1 : cnt;
    }
}