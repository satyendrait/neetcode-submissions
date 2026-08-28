class Solution {
    public String encode(List<String> strs) {
        if (strs == null)
            return null;
        if (strs.size() == 0)
            return "";
        String header = "";
        String strings = "";
        for (String str : strs) {
            header += str.length() + ",";
            strings += str;
        }
        return header.substring(0, header.length() - 1) + "#" + strings;
    }

    public List<String> decode(String str) {
        if (str == null)
            return null;
        if (str.length() == 0)
            return new ArrayList();

        int idx = str.indexOf("#");
        String header = str.substring(0, idx);
        String strings = str.substring(idx + 1);
        List<String> res = new ArrayList();
        String[] sizes = header.split(",");
        int startIdx = 0;
        idx++;
        for (String st : sizes) {
            int len = Integer.parseInt(st);
            String d = str.substring(idx, idx + len);
            System.out.println(len + " , " + d);
            res.add(d);
            idx += len;
        }
        return res;
    }
}
