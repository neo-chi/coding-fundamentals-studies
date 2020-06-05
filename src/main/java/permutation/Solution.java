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
                String s2 = "helll";
                isPermutation(s1, s2);

                String s3 = "abbabba";
                String s4 = "bbabbaa";
                isPermutation(s3, s4);
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
                        // now get the count of each character...
                        // COUNTUNIQUECHARS
                        // create arraylists with initial size of those of unique chars size
                        List<Integer> s1QuantityChars = new ArrayList<Integer>();
                        // then we get the quantity of each unique character for both s1 and s2...
                        // for each item in s1QuantityChars,
                        int s1uniqueCharsIdx = 0; // initialize loop persistent data
                        for (Character c : s1UniqueChars) {
                                int s1QuantityCounter = 0;
                                // compare to each character in s1
                                for (int i = 0; i < s1.length(); i++) {
                                        // if we find a match, increment count...
                                        if (c == s1.charAt(i)) {
                                                s1QuantityCounter++;
                                        } else {
                                                // continue searching...
                                        }
                                }
                                // now that we've searched the word
                                // set the counter of that letter to the number of times we found that character.
                                //s1QuantityChars.set(uniqueCharsIdx, s1QuantityCounter); // BROKEN
                                s1QuantityChars.add(s1uniqueCharsIdx, s1QuantityCounter);
                                s1uniqueCharsIdx++;
                                // proceed to the next letter...
                        }
                        List<Integer> s2QuantityChars = new ArrayList<Integer>();
                        // then we get the quantity of each unique character for both s2 and s2...
                        // for each item in s2QuantityChars,
                        int s2uniqueCharsIdx = 0; // initialize loop persistent data
                        for (Character c : s2UniqueChars) {
                                int s2QuantityCounter = 0;
                                // compare to each character in s2
                                for (int i = 0; i < s2.length(); i++) {
                                        // if we find a match, increment count...
                                        if (c == s2.charAt(i)) {
                                                s2QuantityCounter++;
                                        } else {
                                                // continue searching...
                                        }
                                }
                                // now that we've searched the word
                                // set the counter of that letter to the number of times we found that character.
                                //s2QuantityChars.set(uniqueCharsIdx, s2QuantityCounter); // BROKEN
                                s2QuantityChars.add(s2uniqueCharsIdx, s2QuantityCounter);
                                s2uniqueCharsIdx++;
                                // proceed to the next letter...
                        }
                        // view counter results...
                        System.out.println(s1QuantityChars);
                        System.out.println(s2QuantityChars);

                        // now, if both the uniqueChars list and quantityChars lists are equivalent,
                        // the words are permutations of each other
                        // return true
                        // else
                        // return false

                        // 1. get unique char from s1uniquechars
                        // 2. get index of s1unique char in s2unique char
                        // 3. compare count of those indices

                        int s1UniqueCharsIdx = 0;
                        for (Character c : s1UniqueChars) {
                                int s2QuantityIdx = s2UniqueChars.indexOf(c);
                                int s2Count = s2QuantityChars.get(s2QuantityIdx);
                                int s1Count = s1QuantityChars.get(s1UniqueCharsIdx);

                                String message = "s1: " + c + " -> " + s1Count;
                                System.out.println(message);
                                message = "s2: " + s2UniqueChars.get(s2QuantityIdx)  + " -> " + s2Count;
                                System.out.println(message);
                                s1UniqueCharsIdx++;

                                if (s1Count == s2Count) {
                                        continue;
                                } else {
                                        System.out.println(s2 + " IS NOT a permutation of " + s1);
                                        return false;
                                }
                        }
                        // if we make it to the end of this loop without returning, the two are permutations.
                        System.out.println(s2 + " IS a permutation of " + s1);
                        return true;

                } else {
                        System.out.println(s1 + " and " + s2 + " have different lengths.. they are NOT permutations of each other");
                        return false; // these are not permutations because
                        // they do not have the same number of characters.
                }
        }
}