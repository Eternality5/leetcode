import java.util.HashMap;

class Solution {
    public boolean isMatch(String s, String p) {
        // Build FSA
        HashMap<String, HashSet> fsa = new HashMap<>();

    
        // Traverse FSA
        HashSet<String> currentNodes = new HashSet<>();
        return false;
    }

    class Node {
        HashSet<Node> epsilonTransitions;
        MultiMap<String, Node> transitions;
        Character character;
    }
}