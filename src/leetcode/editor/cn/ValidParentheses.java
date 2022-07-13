//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3383 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        boolean valid = solution.isValid2("{[]}()()(){([])}");
        System.out.println("valid: " + valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (null == s || "".equals(s)) {
                return false;
            }
            int first = "(".charAt(0);
            int firstOther = ")".charAt(0);
            int second = "[".charAt(0);
            int secondOther = "]".charAt(0);
            int third = "{".charAt(0);
            int thirdOther = "}".charAt(0);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int asic = s.charAt(i);
                if (i == 0 || stack.size() == 0 || first == asic || second == asic || third == asic) {
                    stack.add(asic);
                } else {
                    Integer temp = stack.peek();
                    if (((asic == firstOther && temp != first)
                            || (asic == secondOther && temp != second)
                            || (asic == thirdOther && temp != third))) {
                        stack.add(asic);
                    } else {
                        stack.pop();
                    }
                }
            }
            return stack.size() == 0;
        }

        public boolean isValid2(String s) {
            if (null == s || "".equals(s)) {
                return false;
            }
            HashMap<Character, Character> chars = new HashMap<>() {
                {
                    put(')', '(');
                    put(']', '[');
                    put('}', '{');
                }
            };
            LinkedList<Character> characters = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);
                if (!chars.containsKey(charAt)) {
                    characters.push(charAt);
                } else {
                    if (characters.isEmpty() || characters.peek() != chars.get(charAt)) {
                        return false;
                    }
                    characters.pop();
                }
            }
            return characters.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}