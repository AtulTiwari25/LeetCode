class Solution {
    class Trie {
        Map<String, Trie> children = new HashMap<>();
        String name;
        String serial = "";
    }

    Map<String, Integer> serialCount = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();

        // 1. Trie build karo
        for (List<String> path : paths) {
            Trie cur = root;
            for (String folder : path) {
                cur.children.putIfAbsent(folder, new Trie());
                cur = cur.children.get(folder);
                cur.name = folder;
            }
        }

        //yaha pe subtree serialize karo
        serialize(root);

        // yaha se result collect ho raha hain
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(Trie node) {
        if (node.children.isEmpty()) return "";

        List<String> subs = new ArrayList<>();
        for (Trie child : node.children.values()) {
            String ser = serialize(child);
            subs.add("(" + child.name + ser + ")");
        }
        Collections.sort(subs); // order consistent hain ki nahi ensure karo
        node.serial = String.join("", subs);
        serialCount.put(node.serial, serialCount.getOrDefault(node.serial, 0) + 1);
        return node.serial;
    }

    private void collectPaths(Trie node, List<String> path, List<List<String>> result) {
        for (Trie child : node.children.values()) {
            if (serialCount.getOrDefault(child.serial, 0) > 1) continue;
            path.add(child.name);
            result.add(new ArrayList<>(path));
            collectPaths(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}