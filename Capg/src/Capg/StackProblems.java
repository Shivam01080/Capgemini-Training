package Capg;
import java.util.*;

public class StackProblems {

   
    static Stack<Integer> resultHistory = new Stack<>();

    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    sb.append(st.pop());
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch))
                    sb.append(st.pop());
                st.push(ch);
            }
        }

        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.toString();
    }

    static int evaluatePostfix(String post) {
        Stack<Integer> st = new Stack<>();

        for (char ch : post.toCharArray()) {
            if (Character.isDigit(ch))
                st.push(ch - '0');
            else {
                int b = st.pop();
                int a = st.pop();
                switch (ch) {
                    case '+': st.push(a + b); break;
                    case '-': st.push(a - b); break;
                    case '*': st.push(a * b); break;
                    case '/': st.push(a / b); break;
                }
            }
        }
        return st.pop();
    }

    static int evaluateExpression(String exp) {
        String post = infixToPostfix(exp);
        int res = evaluatePostfix(post);
        resultHistory.push(res);
        return res;
    }

    static Integer undo() {
        if (!resultHistory.isEmpty())
            resultHistory.pop();
        return resultHistory.isEmpty() ? null : resultHistory.peek();
    }

   
    static class MinMaxStack {
        Stack<Long> st = new Stack<>();
        long min, max;

        void push(long x) {
            if (st.isEmpty()) {
                min = max = x;
                st.push(x);
            } else if (x < min) {
                st.push(2 * x - min);
                min = x;
            } else if (x > max) {
                st.push(2 * x - max);
                max = x;
            } else st.push(x);
        }

        long pop() {
            long t = st.pop();
            if (t < min) {
                long res = min;
                min = 2 * min - t;
                return res;
            }
            if (t > max) {
                long res = max;
                max = 2 * max - t;
                return res;
            }
            return t;
        }

        long getMin() { return min; }
        long getMax() { return max; }
    }

    static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String curr = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                count.push(k);
                result.push(curr);
                curr = "";
                k = 0;
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int times = count.pop();
                while (times-- > 0)
                    sb.append(curr);
                curr = sb.toString();
            } else curr += ch;
        }
        return curr;
    }

    static int largestRectangle(int[] h) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= h.length; i++) {
            int cur = (i == h.length) ? 0 : h[i];

            while (!st.isEmpty() && cur < h[st.peek()]) {
                int height = h[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        return max;
    }


    static int findCelebrity(int[][] M) {
        Stack<Integer> st = new Stack<>();
        int n = M.length;

        for (int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (M[a][b] == 1) st.push(b);
            else st.push(a);
        }

        int c = st.pop();
        for (int i = 0; i < n; i++)
            if (i != c && (M[c][i] == 1 || M[i][c] == 0))
                return -1;

        return c;
    }


    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);
            while (!q1.isEmpty())
                q2.add(q1.remove());
            Queue<Integer> t = q1;
            q1 = q2;
            q2 = t;
        }

        int pop() { return q1.remove(); }
    }

 
    static String removeInvalid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] remove = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(i);
            else if (ch == ')') {
                if (!st.isEmpty()) st.pop();
                else remove[i] = true;
            }
        }

        while (!st.isEmpty())
            remove[st.pop()] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!remove[i]) sb.append(s.charAt(i));

        return sb.toString();
    }


    static int[] stockSpan(int[] p) {
        int n = p.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && p[st.peek()] <= p[i])
                st.pop();
            span[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        return span;
    }


    static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int x = st.pop();
            sortStack(st);
            insertSorted(st, x);
        }
    }

    static void insertSorted(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x)
            st.push(x);
        else {
            int t = st.pop();
            insertSorted(st, x);
            st.push(t);
        }
    }

 

    static void simulateCalls(String[] calls) {
        Stack<String> st = new Stack<>();

        for (String c : calls) {
            if (c.equals("return")) {
                st.pop();
            } else {
                st.push(c);
            }
            System.out.println("Call Stack -> " + st);
        }
    }

    public static void main(String[] args) {

        System.out.println("Expression: " + evaluateExpression("(10+5)*2"));
        System.out.println("UNDO -> " + undo());

        System.out.println(decodeString("3[a2[b]]"));

        int[] hist = {6,2,5,4,5,1,6};
        System.out.println(largestRectangle(hist));

        System.out.println(removeInvalid("a)b(c)d"));

        int[] prices = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(stockSpan(prices)));

        Stack<Integer> s = new Stack<>();
        s.push(3); s.push(1); s.push(5);
        sortStack(s);
        System.out.println(s);

        String[] trace = {"main","login","validate","return","return"};
        simulateCalls(trace);
    }
}
