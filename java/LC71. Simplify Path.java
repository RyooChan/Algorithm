class Solution {
    public String simplifyPath(String path) {
        Stack stack = new Stack<String>();
        int skip = 0;

        String[] paths = path.split("/");

        for(int i=paths.length - 1; i>=0; i--) {
            String per = paths[i];

            if (per==null || per.equals("") || per.equals(".")) {
                continue;
            }

            if (per.equals("..")) {
                skip++;
                continue;
            }

            if (skip > 0) {
                skip--;
                continue;
            }
            stack.push(per);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append("/");
        }

        if(sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
