import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {
    public static String stringChallenge(String[] strArr) {
        //n and k are strings of our arrays
        //n is first string which we should find
        //smallest substring in it
        //k is second string that all characters of it
        //should be in n
        String n = strArr[0];
        String k = strArr[1];

        //Check n contains k's characters or not
        boolean cont = contains(n, k);
        if (!cont) {
            System.out.println("First string cannot contains second string's characters");
            return "";
        }
        //I create 4 pointer(2 right, 2 left)
        int al = 0, ar =0;
        int left = 0;
        int right = 0;
        //this while is for finding best matching (smallest) substring
        while (right <= n.length()) {
            //if n doesn't contain we increase right pointer
            while (!contains(n.substring(left, right), k) && right < n.length()) {
                right++;
            }
            //if n contains we increase left pointer
            //to make substring small
            while (contains(n.substring(left + 1, right), k)) {
                left++;
            }
            //we can find desirable substring, but maybe in string1 (n)
            //can be smaller substring that's why we check it
            //with another two pointers
            if((al == 0 && ar == 0) || (right -left < ar - al)) {
                al = left;
                ar = right;
            }
            right++;
        }
        return n.substring(al, ar);
    }

    //Check n contains k's characters or not
    public static boolean contains(String s1, String s2) {
        //Add string1 characters to map as a key
        //and their counts as a value
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = map.getOrDefault(s1.charAt(i), 0);
            map.put(s1.charAt(i), count + 1);
        }
        //Check if map have s2 characters or not
        //and if map have them, decrease their count
        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i))) {
                return false;
            }
            Integer count = map.get(s2.charAt(i));
            count--;
            if (count < 0) {
                return false;
            }
            map.put(s2.charAt(i), count);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"ADOBECODEBANC", "ABC"};
        System.out.println(stringChallenge(strArr));
    }
}
