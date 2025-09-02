class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // Step 1: Prepare numbers list and compute n!
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        k--; // Convert k to 0-based index
        StringBuilder result = new StringBuilder();

        // Step 2: Compute each digit of the result
        for (int i = 0; i < n; i++) {
            fact = fact / (n - i); // (n - i - 1)!
            int index = k / fact;  // Select index from the list
            result.append(numbers.get(index));
            numbers.remove(index); // Remove used number
            k = k % fact; // Update k for next position
        }

        return result.toString();
    }
}