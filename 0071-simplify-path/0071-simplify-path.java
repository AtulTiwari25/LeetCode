import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String dir : components) {
            if (dir.equals("") || dir.equals(".")) {
                continue; // skip empty or current directory
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // go back to parent directory
                }
            } else {
                stack.push(dir); // valid directory name
            }
        }

        // Build the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        Iterator<String> iter = stack.descendingIterator();
        while (iter.hasNext()) {
            simplifiedPath.append("/").append(iter.next());
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}