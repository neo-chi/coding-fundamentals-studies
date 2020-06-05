package permutation;

import java.util.List;
import java.util.ArrayList;

/**
* Hello world!
*
*/
public class Solution {
        public static void main(String[] args) {
                String s1 = "hello";
                String s2 = "hellk";
                isPermutation(s1, s2);
        }

        /**
         * Returns true if s2 is a permutation of s1.
         * @param s1 first word
         * @param s2 second word
         * @return boolean true if s2 is a permutation of s1.
         */
        public static boolean isPermutation(String s1, String s2) {
                // brute force
                List<Character> s1UniqueChars = new ArrayList<Character>();
                List<Character> s2UniqueChars = new ArrayList<Character>();
                // 1. ensure s1 and s2 have same number of characters
                // otherwise, they are not permutations.
                boolean hasEquivalentNumberOfCharacters = false; // assume they do not...
                if (s1.length() == s2.length()) {
                        hasEquivalentNumberOfCharacters = true;
                }
                if (hasEquivalentNumberOfCharacters) {
                        // now record each unique character in both s1 and s2.
                        for (int i = 0; i < s1.length(); i++) {
                                Character s1Character = s1.charAt(i);
                                System.out.println("Checking " + s1Character + " in " + s1);
                                // list is initially empty... first character must always go into the list
                                if (i == 0) {
                                        System.out.println("Adding the first character to list: " + s1Character);
                                        s1UniqueChars.add(s1.charAt(0));
                                } else {
                                        // now lets compare every other character in s1 to all characters in s1UniqueChars
                                        for (int j = 0; j < s1UniqueChars.size(); j++) {
                                                System.out.println(s1Character + " == " + s1UniqueChars.get(j) + " ?");
                                                // If we find a match, break this loop and continue searching
                                                if (s1Character.equals(s1UniqueChars.get(j))) {
                                                        System.out.println(s1Character + " is already in the list... going to next character");
                                                        break;
                                                }
                                                // if we reach the end of the unique characters list without a match, add the s1 character to the uniques list.
                                                if (j == s1UniqueChars.size() - 1 &&
                                                s1Character != s1UniqueChars.get(j)
                                                ) {
                                                        System.out.println(s1Character + " is NOT in the list.. adding to list");
                                                        s1UniqueChars.add(s1Character);
                                                        break;
                                                }
                                        }
                                 }
                       }
                        // now record each unique character in both s1 and s2.
                        for (int i = 0; i < s2.length(); i++) {
                                Character s2Character = s2.charAt(i);
                                System.out.println("Checking " + s2Character + " in " + s2);
                                // list is initially empty... first character must always go into the list
                                if (i == 0) {
                                        System.out.println("Adding the first character to list: " + s2Character);
                                        s2UniqueChars.add(s2.charAt(0));
                                } else {
                                        // now lets compare every other character in s2 to all characters in s2UniqueChars
                                        for (int j = 0; j < s2UniqueChars.size(); j++) {
                                                System.out.println(s2Character + " == " + s2UniqueChars.get(j) + " ?");
                                                // If we find a match, break this loop and continue searching
                                                if (s2Character.equals(s2UniqueChars.get(j))) {
                                                        System.out.println(s2Character + " is already in the list... going to next character");
                                                        break;
                                                }
                                                // if we reach the end of the unique characters list without a match, add the s2 character to the uniques list.
                                                if (j == s2UniqueChars.size() - 1 &&
                                                s2Character != s2UniqueChars.get(j)
                                                ) {
                                                        System.out.println(s2Character + " is NOT in the list.. adding to list");
                                                        s2UniqueChars.add(s2Character);
                                                        break;
                                                }
                                        }
                                 }
                       }
                       System.out.println(s1UniqueChars);
                       System.out.println(s2UniqueChars);
                        // then we get the quantity of each unique character for both s1 and s2...
                } else {
                        return false; // these are not permutations because
                        // they do not have the same number of characters.
                }
                return true;
        }
}
