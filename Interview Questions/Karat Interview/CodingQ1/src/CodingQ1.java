/*

We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

badge_records_1 = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Steve",    "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Paul",     "exit"],
  ["Paul",     "exit"]
]
forgot badge out / forgot badge in
["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]

Other test cases:

badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_4 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
]

Expected output: ["Paul"], ["Paul"]

n: length of the badge records array





*/

import java.io.*;
import java.util.*;

class Solver {
    public List<List<String>> solve(String[][] badgeRecords) {
        List<List<String>> result = new ArrayList<>();
        List<String> forgotIn = new ArrayList<>();
        List<String> forgotOut = new ArrayList<>();
        Set<String> fIn = new HashSet<>();
        Set<String> fOut = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<badgeRecords.length;i++) {
            String name = badgeRecords[i][0];
            String key = badgeRecords[i][1];
            String prevKey = "";
            if(map.containsKey(name)) {
                prevKey = map.get(name);
            }
            if((prevKey.isEmpty() && key=="exit") || (!prevKey.isEmpty() && prevKey=="exit" && key=="exit")) {
//         forgotIn.add(name);
                fIn.add(name);
            }
            map.put(name, key);

        }


        for (String name : fIn) {
//       System.out.println(name);
            forgotIn.add(name);
        }

        map.clear();

        for(int i=0;i<badgeRecords.length;i++) {
            String name = badgeRecords[i][0];
            String key = badgeRecords[i][1];
            String prevKey = "";
            if(map.containsKey(name)) {
                prevKey = map.get(name);
            }
            if (prevKey.isEmpty() && key=="exit") {
                map.put(name, key);
            }
            else {
                if (!prevKey.isEmpty() && prevKey=="enter" && key=="enter") {
                    fOut.add(name);
                }
                else {
                    map.put(name, key);
                }
            }
        }
        for(Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getValue()=="enter") {
                fOut.add(entry.getKey());
            }

        }
        for (String name : fOut) {
//       System.out.println(name);
            forgotOut.add(name);
        }


        result.add(forgotOut);
        result.add(forgotIn);
        return result;

    }
}


public class CodingQ1 {
    public static void main(String[] argv) {
        String badgeRecords1[][] = new String[][] {
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Martha",   "enter"},
                {"Steve",    "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "enter"},
                {"Paul",     "enter"},
                {"Curtis",   "exit"},
                {"Curtis",   "enter"},
                {"Paul",     "exit"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "exit"},
                {"Paul",     "enter"},
                {"Paul",     "enter"},
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Paul",     "enter"},
                {"Paul",     "exit"},
                {"Paul",     "exit"}
        };


        List<List<String>> result = new Solver().solve(badgeRecords1);

        System.out.println(result);

        String badgeRecords2[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        result = new Solver().solve(badgeRecords2);

        System.out.println(result);

        String badgeRecords3[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        result = new Solver().solve(badgeRecords3);

        System.out.println(result);


        String badgeRecords4[][] = new String[][] {
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
        };

        result = new Solver().solve(badgeRecords4);

        System.out.println(result);


    }
}
