package com.StringManipulation;

import java.util.*;

public class StringManipulation {
    public static int countVowel(String input){
        var count = 0;
//        List<Character> vowels = new ArrayList<>();
//       vowels.add('a');
//       vowels.add('e');
//       vowels.add('i');
//       vowels.add('o');
//       vowels.add('u');
        String vowels = "aeiou";

        for(var chars:input.toLowerCase().toCharArray()) {
//            if(vowels.contains(Character.toString(chars)))
            if(vowels.indexOf(chars) != -1)
                count++;
        }
        return count;
    }
    public static String Reverser(String input){
        StringBuilder reversed = new StringBuilder();
        for(var i = input.length() -1;i >= 0;i--)
            reversed.append(input.charAt(i));
        return reversed.toString();
    }
    public static String Reverse(String input){
        var str = input.trim().split(" ");
        Collections.reverse(Arrays.asList(str));
        return String.join(" ",str);

//       StringBuilder reverse = new StringBuilder();
//       for(var i = str.length -1;i >= 0;i--)
//            reverse.append(str[i] + " ");
//
//        return reverse.toString().trim();
    }
    public static boolean isRotated(String input1,String input2){
        if(input1.length() != input2.length())
            return false;
        var array1 = input1.toCharArray();
        var array2 = input2.toCharArray();
        var count = 0;
        var j =0;
        for(var i = 0;i < array2.length;i++){
            while(array1[j] == array2[i]){
                if(i == array2.length -1) {
                    i = 0;
                    j++;
                }
                if(array1[j++] != array2[i++])
                    return false;
                count++;
                if(j == array1.length) {
                    j = array1.length-1;
                    i = i - 1;
                }
                if(count == array1.length -1 && array1[j] == array2[i])
                    return true;
            }
        }
        return false;
    }
    public static boolean isRotatable(String str1,String str2){
        return (str1.length() == str2.length() && (str1+str2).contains(str2));
    }
    public static String removeDuplicates(String input){
        StringBuilder output = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(var ch : input.toCharArray()){
            if(!set.contains(ch)) {
                set.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }
    public static char mostRepeated(String input){
        if(input == null|| input.isEmpty())
            throw new IllegalArgumentException();

        Map<Character,Integer> map = new HashMap<>();

        for(var ch : input.toCharArray()){
            if(!map.containsKey(ch))
                map.put(ch,1);
            else
                map.replace(ch,map.get(ch) + 1);
        }

        var max = 0;
        char ch = ' ';
        for(var key : map.keySet()){
            if(map.get(key) > max) {
                max = map.get(key);
                ch = key;
            }
        }
        return ch;
    }
    public static char mostOccured(String str){
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final var ASCII_SIZE  = 256;
        int[] ascii  = new int[ASCII_SIZE];
        for(var ch : str.toCharArray()){
            ascii[ch]++;
        }

        var max = 0;
        char result = ' ';
        for(var i = 0;i < ascii.length;i++) {
            if (ascii[i] > max) {
                max = ascii[i];
                result = (char)i;
            }
        }
        return  result;
    }

    public static String CapFirst(String input){
        if(input.trim().isEmpty())
            return "";
        var words = input
                .trim()
                .replaceAll(" +"," ")  //regex -> regular expressions;
                .split(" ");
        for(var i = 0;i < words.length;i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }
        return String.join(" ",words);
    }
    public static boolean isAnagram(String input1,String input2) {
//        if(input1.length() != input2.length())
//            return false;
        var letters1 = input1.toCharArray();

//        Arrays.sort(letters1);
        //or

        int k = 0;
        for (var i = 1; i < letters1.length; i++) {
            if (letters1[i] < letters1[i - 1]) {
                k = i;
                while (letters1[k] < letters1[k - 1]) {
                    swap(letters1, k, k - 1);
                    if (k != 1)
                        k--;
                }
            }
        }

        var letters2 = input2.toCharArray();

//        Arrays.sort(letters2);

        int j = 0;
        for(var i = 1;i < letters2.length;i++) {
            if (letters2[i] < letters2[i - 1]) {
                j = i;
                while (letters2[j] < letters2[j - 1]) {
                    swap(letters2, j, j - 1);
                    if(j!=1)
                        j--;
                }
            }
        }
        return (Arrays.equals(letters1,letters2));
    }
    private static void swap(char[] array,int first,int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static boolean isAnagram2(String input1,String input2){
        //solve either by 2 hashmap or 2 ascii array;
        char[] array1 = input1.toLowerCase().toCharArray();
        final var ENGLISH_ALPHABET = 26;
        int[] ascii1 = new int[ENGLISH_ALPHABET];
        for (char value : array1) ascii1[value - 'a']++;

        char[] array2 = input2.toLowerCase().toCharArray();
        int[] ascii2 = new int[ENGLISH_ALPHABET];
        for (char c : array2) ascii2[c - 'a']++;

        return Arrays.equals(ascii1,ascii2);
    }
    public static boolean isPalindrome(String input){
        var str = StringManipulation.Reverser(input);
        return input.equals(str);
    }

    // a faster approach:
    public static boolean isPalindrome2(String input){
        if(input.length() == 1)
            return false;
        var left = 0;
        var right = input.length() - 1;
        while(left < right){
            if(input.charAt(left++) != input.charAt(right--))
                return false;
        }
        return true;
    }
}
