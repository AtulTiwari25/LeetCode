class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();

        // thousands
        map.put(1000, "M"); map.put(2000, "MM"); map.put(3000, "MMM");
        // hundreds
        map.put(100, "C"); map.put(200, "CC"); map.put(300, "CCC"); map.put(400, "CD");
        map.put(500, "D"); map.put(600, "DC"); map.put(700, "DCC"); map.put(800, "DCCC"); map.put(900, "CM");
        // tens
        map.put(10, "X"); map.put(20, "XX"); map.put(30, "XXX"); map.put(40, "XL");
        map.put(50, "L"); map.put(60, "LX"); map.put(70, "LXX"); map.put(80, "LXXX"); map.put(90, "XC");
        // ones
        map.put(1, "I"); map.put(2, "II"); map.put(3, "III"); map.put(4, "IV");
        map.put(5, "V"); map.put(6, "VI"); map.put(7, "VII"); map.put(8, "VIII"); map.put(9, "IX");

        if(map.containsKey(num)) return map.get(num);
        String str_ = Integer.toString(num);
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i< str_.length(); i++){
            if(str_.charAt(i) != '0') li.add((Character.getNumericValue(str_.charAt(i)))*((int) Math.pow(10,str_.length()-(i+1))));
        }

        StringBuilder result = new StringBuilder();
        for(int val: li){
            result.append(map.get(val));
        }
        return result.toString();

    }
}