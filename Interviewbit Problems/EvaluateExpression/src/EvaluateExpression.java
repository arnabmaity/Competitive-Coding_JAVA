import java.util.*;

class EvaluateExpressionRPN {
    final String PLUS = "+";
    final String MINUS = "-";
    final String MULTIPLY = "*";
    final String DIVIDE = "/";
    public int solve(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<A.size();i++) {
            if (A.get(i).equals(PLUS) || A.get(i).equals(MINUS) || A.get(i).equals(MULTIPLY) || A.get(i).equals(DIVIDE)) {
                int operand2 = stack.peek();
                stack.pop();
                int operand1 = stack.peek();
                stack.pop();
                if(A.get(i).equals(PLUS)) {
                    stack.push((operand1 + operand2));
                }
                if(A.get(i).equals(MINUS)) {
                    stack.push((operand1 - operand2));
                }
                if(A.get(i).equals(MULTIPLY)) {
                    stack.push((operand1 * operand2));
                }
                if(A.get(i).equals(DIVIDE)) {
                    stack.push((operand1 / operand2));
                }
            }
            else {
                stack.push(Integer.parseInt(A.get(i)));
            }
        }
        return stack.peek();
    }
}


public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> A = new ArrayList<>();
        A.add("4");
        A.add("13");
        A.add("5");
        A.add("/");
        A.add("+");
        System.out.println(A);
        EvaluateExpressionRPN eval = new EvaluateExpressionRPN();
        System.out.println(eval.solve(A));
    }
}
