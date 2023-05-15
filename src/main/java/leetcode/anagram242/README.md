# ANAGRAM #

 #### **DESCRIPTION** ####

This repository contains a simple Java program for checking if two words are anagrams. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

The tasks of the program is return **true** if both string 
- have this same letters
- have this same quantity letters


 and return **false** if 
 - both arguments are incorrect

 #### **USAGE** ####

Here is a basic example of how to use the **Anagram** class:
       
    public static void main(String[] args) {
    Anagram anagramChecker = new Anagram();
    boolean result = anagramChecker.isAnagram("anagram", "nagram");
    System.out.println(result);  // true
    }

In this example, "nagaram" is an anagram of "anagram", so the isAnagram method returns true.

 #### **TESTING** ####

This project using Junit5 to testing. All tests are located in the ***scr/test/java/leetcode***. The **AnagramTest** class contains test for **Anagram**.
The tests use the JUnit 5 **Assertions** class to check the result.
Here is a basic example of a test:

    @Test
    public void shouldCheckThatWordIsAnagram() {
        //given
        Anagram anagram = new Anagram();
        String correctWord = "anagram";
        String rearrangingWord = "nagaram";
        
        //when
        anagram.isAnagram(correctWord, rearrangingWord);
        
        //then
        Assertions.assertTrue(true);
    }

#### **DEPENDENCIS** ####

- JUnit 5.9.2
