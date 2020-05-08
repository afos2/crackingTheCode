import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        // largest 3
        Integer[] input = new Integer[] {1, 23, 12, 9, 30, 2, 50};
        Integer k = 3;
        Integer[] res = findLargestThree(input, k);
        for (int i=0; i<k; i++) {
            System.out.println(res[i]);
        }

        // triplets
        int[] input2 = new int[] {3, 1, 4, 6, 5};
        System.out.println(findTriplets(input2));

        // length of last word
        System.out.println(findLengthOfLastWord(" some    word     "));
        
        // reverse string
        System.out.println(reverseString("reverse now y'all"));
        
        // longest common prefix
        String[] inputArr = new String[] {"like", "listen", "lit"};
        System.out.println(findlongestCommonPrefix(inputArr));

        // majority element
        input = new Integer[] {3,3,3,3,3,3,3,3,3,3,4,5,6,4,34,2,3,3,4,3,2,3,2,2,4,41};
        majorityElement(input);

        // Fizz Buzz
        List<String> result = fizzBuzz(15);
        for (int i=0; i<result.size(); i++) {
            System.out.print(result.get(i)+ " ");
        }
    }

    public static Integer[] findLargestThree(Integer[] values, Integer k) {
        Integer[] revSortedValues = values;
        Arrays.sort(revSortedValues, Collections.reverseOrder());
        return Arrays.copyOfRange(revSortedValues, 0, k);
    }

    public static Boolean findTriplets(int[] values) {
        Boolean hasPythag = false;
        for(int i=0; i<values.length; i++) {
          double a2 = Math.pow(values[i], 2);

          for(int j=i+1; j<values.length; j++) {
            double b2 = Math.pow(values[j], 2);

            for(int k=j+1; k<values.length; k++) {
              double c2 = Math.pow(values[k], 2);

              if((a2+b2) == c2 || (a2+c2) == b2 || (b2+c2) == a2) {
                hasPythag = true;
                break;
              }
            }
          }
        }
        return hasPythag;
    }

    public static int findLengthOfLastWord(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        // split by new string, line or return
        String[] inputArr = input.split("(\\s|\\n|\\r)");
        return inputArr[inputArr.length - 1].length();
    }

    public static String reverseString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        // Add all characters to builder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
        }
        // Reverse order and retrun string
        return sb.reverse().toString();
    }

    public static String findlongestCommonPrefix(String[] input) {
        if (input == null || input.length == 0) {
            return "";
        }
        // setup
        String prefix = "";
        int count = 0;
        boolean doesContain = true;
        // get reference word
        String word = input[0];
        while (doesContain) {
            // get next prefix if available
            String nextPrefix = "";
            nextPrefix = word.substring(0, count);
            for (int j = 1; j < input.length; j++) {
                // check if all words in set contain new prefix
                if (!input[j].startsWith(nextPrefix)) {
                    doesContain = false;
                    break;
                } else {
                    doesContain = true;
                }
            }
            if (doesContain) {
                // set to new prefix
                prefix = nextPrefix;
                count++;
                if (count > word.length())
                    break;
            }
        }
        return prefix;
    }

    public static void majorityElement(Integer[] elements) {
        if(elements == null || elements.length == 0) {
            return;
        }
        double threshold = elements.length / 2 ;
        Map<Integer, Integer> collectionCount = new HashMap();
        for(Integer element:elements) {
            if(collectionCount.containsKey(element)) {
                Integer count = collectionCount.get(element);
                count++;    
                collectionCount.replace(element, count);
            } else {
                collectionCount.put(element, 1);
            }
        }

        collectionCount.forEach((element, count) -> {
            if (count > threshold) {
                System.out.println("Majority element: " +element);
            }
        });
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res =  new ArrayList();
        for(int i=1; i<=n; i++) {
            if(i%3 == 0 && i%5==0) {
                res.add("FizzBuzz");
            } else if (i%5==0) {
                res.add("Buzz");
            } else if (i%3==0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}