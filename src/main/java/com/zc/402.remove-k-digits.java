import java.util.ArrayDeque;
import java.util.Deque;

import com.sun.tools.javac.util.StringUtils;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            int value = Character.getNumericValue(num.charAt(i));
            while (!deque.isEmpty() && k > 0 && value < deque.peekLast()) {
                deque.pollLast();
                k --;
            }
            deque.addLast(value);
        }
        for (int i = 0;i < k;i ++) {
            deque.pollLast();
        }

        while (!deque.isEmpty() && deque.getFirst() == 0) {
            deque.pollFirst();
        }
        if (deque.isEmpty()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String result = new RemoveKDigits().removeKdigits(num, k);
        System.out.println(result);
        num = "10200";
        k = 1;
        result = new RemoveKDigits().removeKdigits(num, k);
        System.out.println(result);
        num = "10";
        k = 1;
        result = new RemoveKDigits().removeKdigits(num, k);
        System.out.println(result);
    }
}
