import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 1;
        int n = s.length();
        set.add(s.charAt(left));
        while (right < n){
            if (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;

            }else {
                set.add(s.charAt(right));
                right ++ ;
            }
        }
        return right - left;
    }
}
