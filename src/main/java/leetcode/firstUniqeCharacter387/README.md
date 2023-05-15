# **FIRST UNIQUE CHARACTER IN A STRING** #

This program contains a simple implementation of First Unique Character in a String in Java, along its corresponding unit test using the JUnit 5 framework.

#### **DESCRIPTION** ####

First Unique Character find the first non-repeating character. The **Character** class in this project contains a main method ***firstUniqChar(String s)*** witch return first non-repeating character but if does not exist **return -1**. The ***firstUniqChar(String s)*** method in the **Character** class works by creating a table of the string, represented as an array where the indices correspond to the letters of the alphabet and the values are the frequencies of these letters. It then iterates over the string, returning the index of the unique character.


#### **USAGE** ####

To use this code, create a instance of the **Character** class and call the method **firstUniqChar**.

Example:

    Character character = new Character();
    int index = character.firstUniqChar("example"); //return 1; it will be char 'x'

#### **TESTING** ####

The class **CharacterTest** includes a test case for the ***firstUniqChar(String s)*** method. All tests are located in the scr/test/java/leetcode.
It test various scenarios with different inputs. The tests use the JUnit 5 Assertions class to check the result.

#### **DEPENDENCIES** ####

- JUnit Jupiter (org.junit.jupiter:junit-jupiter-engine:5.9.2) for testing.
