import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import org.w3c.dom.Node;

class Solution {
    public boolean isMatch(String s, String p) {
        // Build FSA
        Node currentNode = generateFsa(stringToReverseStack(p));

        // Traverse FSA
        
        return false;
    }

    private Stack<Character> stringToReverseStack(String p) {
        Stack<Character> stack = new Stack<>();
        Char[] pattern = p.toCharArray();
        int length = p.length();

        for (int i = length-1; i >= 0; i--) {
            stack.push(pattern[i]);
        }
        return stack;
    }

    private Node generateFsa(Stack<Character> stack) {
        char currentChar, nextChar;
        Node current = new Node(null, null, null, null);

        while(!stack.empty()) {
            currentChar = stack.pop();
            if (!stack.empty()) {
                nextChar = stack.pop();

                if ( (nextChar == '.' && !stack.empty() && stack.peek() == '*') || 
                     (nextChar != '*')
                ) {
                    // put the char back
                    stack.push(nextChar); 
                    // just process current char
                    return new Node(currentChar, generateFsa(stack), null, false); 
                } else {
                    return (stack.empty()) 
                    ? new Node(currentChar, null, null, true)
                    : new Node(currentChar, null, generateFsa(stack), false);
                }

            } else {
                return new Node(currentChar, null, null, true);
            }
        }
    }

    public record Node (Character character, Node transitions, Node epsilonTransitions, boolean isEnd)
    {}
}