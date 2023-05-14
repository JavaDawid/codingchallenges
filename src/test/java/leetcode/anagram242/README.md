# ANAGRAM

**DESCRIPTION**

This repository contains a simple Java program for checking if two words are anagrams. An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

The tasks of the program is return **true** if both string 
- have this same letters
- have this same quantity letters


 and return **false** if 
 - both arguments are incorrect

**USAGE**

Here is a basic example of how to use the **Anagram** class:
       
        @Test
        public void shouldCheckThatWordIsAnagram() {
        Anagram anagram = new Anagram();
        
        String correctWord = "anagram";
        String rearrangingWord = "nagaram";
        
        anagram.isAnagram(correctWord, rearrangingWord);
        
        Assertions.assertTrue(true);
    }
In this example, "nagaram" is an anagram of "anagram", so the isAnagram method returns true.
