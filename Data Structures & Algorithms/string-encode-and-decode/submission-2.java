class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return null;
        }

        String output = "";
        for (String str : strs) {
            output += str+"!@!";
        }
        return output;
    }

    public List<String> decode(String str) {
        if (str == null) {
            return List.of();
        }
        List<String> output = Arrays.asList(str.split("!@!"));

        return output.size() > 0 ? output : List.of("");
    }
}
