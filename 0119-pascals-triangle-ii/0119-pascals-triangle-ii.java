class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        /** In pascal's triangle every row starts with 1 */
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            /** new row will be created according to previous row */
            List<Integer> newRowAdded = new ArrayList<>();
            /** it would always start with 1 */
            newRowAdded.add(1);
            /** iterate j over the size of row */
            for (int j = 1; j < row.size(); j++) {
                newRowAdded.add(row.get(j - 1) + row.get(j));
            }
            /** end with 1 */
            newRowAdded.add(1);
            /** for further iteration update the row with the prevous row */
            row = newRowAdded;
        }
        return row;
    }
}