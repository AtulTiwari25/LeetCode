import java.util.*;

class Solution {
    private int firstPlayer;
    private int secondPlayer;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        List<Integer> initial = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            initial.add(i);
        }
        int earliest = dfsEarliest(initial, 1);
        int latest = dfsLatest(initial, 1);
        return new int[]{earliest, latest};
    }

    private int dfsEarliest(List<Integer> current, int round) {
        int n = current.size();
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            int a = current.get(i);
            int b = current.get(n - 1 - i);
            if ((a == firstPlayer && b == secondPlayer) || (a == secondPlayer && b == firstPlayer)) {
                return round;
            }
        }

        List<Integer> fixedWinners = new ArrayList<>();
        List<int[]> flexibleMatches = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = current.get(i);
            int b = current.get(n - 1 - i);
            if (a == firstPlayer || a == secondPlayer) {
                fixedWinners.add(a);
            } else if (b == firstPlayer || b == secondPlayer) {
                fixedWinners.add(b);
            } else {
                flexibleMatches.add(new int[]{a, b});
            }
        }

        if (n % 2 == 1) {
            fixedWinners.add(current.get(m));
        }

        int minRound = Integer.MAX_VALUE;
        int k = flexibleMatches.size();
        for (int bit = 0; bit < (1 << k); bit++) {
            List<Integer> winners = new ArrayList<>(fixedWinners);
            for (int j = 0; j < k; j++) {
                int[] match = flexibleMatches.get(j);
                int winner = (bit & (1 << j)) != 0 ? match[0] : match[1];
                winners.add(winner);
            }
            Collections.sort(winners);
            minRound = Math.min(minRound, dfsEarliest(winners, round + 1));
        }
        return minRound;
    }

    private int dfsLatest(List<Integer> current, int round) {
        int n = current.size();
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            int a = current.get(i);
            int b = current.get(n - 1 - i);
            if ((a == firstPlayer && b == secondPlayer) || (a == secondPlayer && b == firstPlayer)) {
                return round;
            }
        }

        List<Integer> fixedWinners = new ArrayList<>();
        List<int[]> flexibleMatches = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = current.get(i);
            int b = current.get(n - 1 - i);
            if (a == firstPlayer || a == secondPlayer) {
                fixedWinners.add(a);
            } else if (b == firstPlayer || b == secondPlayer) {
                fixedWinners.add(b);
            } else {
                flexibleMatches.add(new int[]{a, b});
            }
        }

        if (n % 2 == 1) {
            fixedWinners.add(current.get(m));
        }

        int maxRound = Integer.MIN_VALUE;
        int k = flexibleMatches.size();
        for (int bit = 0; bit < (1 << k); bit++) {
            List<Integer> winners = new ArrayList<>(fixedWinners);
            for (int j = 0; j < k; j++) {
                int[] match = flexibleMatches.get(j);
                int winner = (bit & (1 << j)) != 0 ? match[0] : match[1];
                winners.add(winner);
            }
            Collections.sort(winners);
            maxRound = Math.max(maxRound, dfsLatest(winners, round + 1));
        }
        return maxRound;
    }
}