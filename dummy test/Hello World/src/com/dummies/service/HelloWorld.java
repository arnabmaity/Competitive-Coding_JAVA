package com.dummies.service;

public class HelloWorld {
    public static void main(String[] args) {
        new Solver().solve();
        Solver solver = new Solver();
        System.out.println(solver.solve(5, 7));
    }

}

class Solver {
    public void solve() {
        System.out.println("Hello World" + "\n" + "Dummies World");
        System.out.println(retString());
    }

    private String retString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hey returning from another private function");
        return stringBuilder.toString();
    }

    public String solve(long n, long m) {
//        System.out.println("Hello World " + n + "\n" + "Dummies World");
        return doAddition(n, m);
    }

    private String doAddition(long n, long m) {
        return "Addition result = " + (n + m);
    }
}
