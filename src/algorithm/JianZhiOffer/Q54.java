package algorithm.JianZhiOffer;

import java.util.HashMap;

public class Q54 {
    //Insert one char from stringstream
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch)
    {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < sb.length(); i++) {
            if (map.containsKey(sb.charAt(i))){
                map.put(sb.charAt(i),map.get(sb.charAt(i))+1);
            }else {
                map.put(sb.charAt(i),1);
            }
        }
        for (int i = 0; i <sb.length(); i++) {
            if (map.get(sb.charAt(i))==1) return sb.charAt(i);
        }
        return '#';
    }
}
