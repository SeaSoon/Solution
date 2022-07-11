public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public static void main(String[] args) {
        String test = "ab c d";
        int i = lengthOfLongestSubstring2(test);
        System.out.print(i);
    }

    /**
     * 删除的时候不是把整个串全删了，要找到重复字符对应的index，把之前的全删了
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            String cStr = String.valueOf(c);
            if (result.toString().contains(cStr)) {
                String temp = result.toString();
                int index = temp.indexOf(cStr);
                int length = result.length();
                result.delete(0, index + 1);
                if (num < length) {
                    num = length;
                }
            }
            result.append(cStr);
            if (num < result.length()) {
                num = result.length();
            }
        }
        return num;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            System.out.print("index: " + index);
            // 计算起始位置，比如当前字符没出现过，那么last[index] + 1肯定为0，如果出现过，但是比start的位置靠前，那么起始位置还是start
            // 如果出现过，而且比start靠后，那么起始位置就变成了last[index] + 1，加1是因为不能重复，把前面出现过的那个字符去掉
            start = Math.max(start, last[index] + 1);
            // 这里就是算当前最大长度和新的最大长度哪个更大一点，留更大的
            res   = Math.max(res, i - start + 1);
            // 更新一下该字符出现的位置，下次计算以新位置为基准
            last[index] = i;
        }

        return res;
    }

    /**
     * 更简洁版
     */
    public static int lengthOfLongestSubstring3(String s) {
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i+1;
        }

        return res;
    }
}
