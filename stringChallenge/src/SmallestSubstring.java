
import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {
    public static String stringChallenge(String[] strArr) {
        String n = strArr[0];
        String k = strArr[1];
        boolean cont = contains(n, k);
        if (!cont) {
            System.out.println("First string cannot contains second string's characters");
            return "";
        }
        int al = 0, ar =0;
        int left = 0;
        int right = 0;
        while (right <= n.length()) {
            while (!contains(n.substring(left, right), k) && right < n.length()) {
                right++;
            }
            while (contains(n.substring(left + 1, right), k)) {
                left++;
            }
            if((al == 0 && ar == 0) || (right -left < ar - al)) {
                al = left;
                ar = right;
            }

            right++;
        }
        return n.substring(al, ar);
    }


    public static boolean contains(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = map.getOrDefault(s1.charAt(i), 0);
            map.put(s1.charAt(i), count + 1);
        }
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
        String[] strArr = new String[]{"acba", "ab"};
        System.out.println(stringChallenge(strArr));
    }
}
