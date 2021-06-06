package threeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        long testcases = sc.nextLong();
        for (long t = 0; t < testcases; t++) {
            int size = sc.nextInt();
            int[] intArray = new int[size];
            for (int i = 0; i < size; i++) {
                intArray[i] = sc.nextInt();
            }
//            Solver1 solver = new Solver1();
            Solver2 solver = new Solver2();
            System.out.println("Result Array : " + solver.threeSum(intArray));
        }
    }
}

class Solver1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> listMap = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            list.add(nums[i]);
            int count = listMap.containsKey(nums[i]) ? listMap.get(nums[i]) : 0;
            listMap.put(nums[i], count + 1);
        }
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<>();
        getThreeSum(list, listMap, size, result);
        return result;
    }

    private void getThreeSum(List<Integer> list, Map<Integer, Integer> listMap, int size, List<List<Integer>> result) {
        Set<List<Integer>> listSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int firstVal = list.get(i);
            for (int j = i + 1; j < size; j++) {
                int secondVal = list.get(j);
                int thirdVal = firstVal + secondVal;
                thirdVal = thirdVal * (-1);
                if (listMap.containsKey(thirdVal)) {
                    if (thirdVal == firstVal && thirdVal == secondVal) {
                        if (listMap.get(thirdVal) > 2) {
                            setResultSet(listSet, firstVal, secondVal, thirdVal);
                        }
                    } else {
                        if (thirdVal == firstVal || thirdVal == secondVal) {
                            if (listMap.get(thirdVal) > 1) {
                                setResultSet(listSet, firstVal, secondVal, thirdVal);
                            }
                        } else {
                            setResultSet(listSet, firstVal, secondVal, thirdVal);
                        }
                    }
                }
            }
        }
        for (List<Integer> resultList : listSet) {
            result.add(resultList);
        }
    }

    private void setResultSet(Set<List<Integer>> listSet, int firstVal, int secondVal, int thirdVal) {
        List<Integer> threeSumList = new ArrayList<>();
        threeSumList.add(firstVal);
        threeSumList.add(secondVal);
        threeSumList.add(thirdVal);
        Collections.sort(threeSumList);
        listSet.add(threeSumList);
    }
}

class Solver2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            list.add(nums[i]);
        }
//        Arrays.sort(nums);//Sorting integer array
        Collections.sort(list);
        getResultList(list, resultList, size);
        return resultList;
    }

    private void getResultList(List<Integer> list, List<List<Integer>> resultList, int size) {
        for (int i = 0; i < size; ) {
            int left = i + 1;
            int right = size - 1;
            int firstVal = list.get(i);
            while (left < size && left < right) {
                int secondVal = list.get(left);
                int thirdVal = list.get(right);
                if (firstVal + secondVal + thirdVal == 0) {
                    resultList.add(Arrays.asList(firstVal, secondVal, thirdVal));
                    while (left < size && secondVal == list.get(left)) {//move over duplicates of left
                        left++;
                    }
                    while (right > left && thirdVal == list.get(right)) {//move over duplicates of right
                        right--;
                    }
                } else {
                    if (firstVal + secondVal + thirdVal > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            while (i < size && firstVal == list.get(i)) {//move over duplicates of i
                i++;
            }
        }
    }
}
