import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<FunctionLog> stack = new Stack<>();
        int[] res = new int[n];
        logs.stream().forEach(log -> {
            String[] logInfo = log.split(":");

            int id = Integer.valueOf(logInfo[0]);
            String state = logInfo[1];
            int time = Integer.valueOf(logInfo[2]);

            FunctionLog f = new FunctionLog(id, time);

            if (state.equals("start")) {
                stack.push(f);
            } else if (state.equals("end")) {
                // pop stack time-push stack time + 1
                int exclusiveTime = f.getTime() - stack.peek().getTime() + 1;
                res[stack.pop().getId()] += exclusiveTime;

                if (!stack.isEmpty()) {
                    res[stack.peek().getId()] -= exclusiveTime;
                }
            }
        });
        return res;
    }
}

class FunctionLog {
    private int id;
    private int time;

    public FunctionLog(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return this.id;
    }

    public int getTime() {
        return this.time;
    }
}