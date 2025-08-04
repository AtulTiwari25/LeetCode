class Solution {
public:
    int numDistinct(string s, string t) {
        // I have written down the code cleanly so that everyone can understand.
        using ull = uint64_t;

        // cnt[i] stores the number of ways to form t[0..i] as a subsequence of s
        vector<ull> cnt(t.size(), 0);

        // Optimization: use fixed-size array instead of unordered_map for better cache and speed
        // mp[c] stores all positions of character `c` in string t
        array<vector<int>, 256> mp;
        for (int i = 0; i < t.size(); i++) {
            mp[t[i]].push_back(i);
        }

        // Now iterate over each character of s
        for (int i = 0; i < s.size(); i++) {
            // Check if current character s[i] appears in t
            auto& positions = mp[s[i]];
            if (!positions.empty()) {
                // Traverse the positions in reverse to avoid overwriting values in cnt[]
                for (int x = positions.size() - 1; x >= 0; --x) {
                    int pos = positions[x];

                    if (pos == 0) {
                        // If it’s the first character of t, every match means a new subsequence start
                        cnt[0]++;
                    } else {
                        // Extend all subsequences that already formed t[0..pos-1] to now form t[0..pos]
                        cnt[pos] += cnt[pos - 1];
                    }
                }
            }
        }

        // Final count of all distinct subsequences that form t is stored at cnt[t.size()-1]
        return cnt[t.size() - 1];
    }
};