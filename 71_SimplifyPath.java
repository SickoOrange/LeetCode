class Solution {
    public String simplifyPath(String path) {

        int i = 0;
        Stack<String> stack = new Stack<>();

        while (i < path.length()) {
            char ch = path.charAt(i);
            if (ch == '/') {
                StringBuffer buf = new StringBuffer();
                i++;
                while (i < path.length() && path.charAt(i) != '/') {
                    buf.append(path.charAt(i));
                    i++;
                }

                String pathString = buf.toString();
                if (pathString.equals("..")) {
                    // pop
                    if(!stack.isEmpty())
                    stack.pop();
                } else {
                    if (!pathString.equals(".") && !pathString.equals("")) {
                        stack.push(pathString);
                    }
                }

            }
        }

        // generate path string
        // generate path string
        if(stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        String[] res = new String[stack.size()];
        int j = res.length - 1;
        while (!stack.isEmpty()) {
            res[j] = stack.pop();
            j--;
        }
        for (int k = 0; k < res.length; k++) {
            builder.append("/");
            builder.append(res[k]);
        }
        return builder.toString();

    }
}