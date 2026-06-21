class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        // Split path by '/'
        String[] parts = path.split("/");



        // INPUT -->        /neetcode/practice//...///../courses
        // PARTS -->        "","neetcode", "practice", "",  "...", "", "", "..", "courses"

        for (String part : parts) {
            // Ignore empty strings (from //) and current directory "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            // Go to parent directory
            if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            // Valid directory name
            else {
                st.push(part);
            }
        }

        // If no directories left, return root
        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        // Build canonical path
        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.toString();
    }
}