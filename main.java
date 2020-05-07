import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println(findLengthOfLastWord(" some    word     "));
        System.out.println(reverseString("reverse now y'all"));
        String[] inputArr = new String[] {"like", "listen", "lit"};
        System.out.println(findlongestCommonPrefix(inputArr));
    }

    public static int findLengthOfLastWord(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String[] inputArr = input.split("(\\s|\\n|\\r)");
        return inputArr[inputArr.length - 1].length();
    }

    public static String reverseString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
        }
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
}