README contains description two programs. Table of contents help you move around the file.
## TABLE OF CONTENTS ##
 * <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#recrutiment-algorithms"> Recrutiment algorithms </a>
 
 * <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#tic-tac-toe"> Tic-Tac-Toe </a>

# RECRUTIMENT ALGORITHMS #

## TABLE OF CONTENTS ##
* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#description"> Description </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#dependencies"> Dependencies </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#testing"> Testing </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#running-tests"> Runing testing </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#licence"> Licence </a>

#### DESCRIPTION ####
In repository <i><b>scr/test/java/leetcode</b></i> you can find a set of task and algorithms that you can get at recruitment meeting. In each package with task you find class with solution and test class. Under can you find short description about each tasks with link to the LeetCode.


-  <b> Valid Anagram </b>
Check if two words are anagrams, where an anagram is a word or phrase formed by rearranging the letters of a different word or phrase.

    https://leetcode.com/problems/valid-anagram/


- <b> Fibonacci Numbers</b>
  Calculate Fibonacci numbers, where each number is found by adding up the two numbers before it.

    https://leetcode.com/problems/fibonacci-number/

- <b> First Unique Character in a String </b>
 Find the first non-repeating character in an input string.

  https://leetcode.com/problems/first-unique-character-in-a-string/

- <b>Fizz Buzz</b>
  Implement the game returning FizzBuzz, Fizz, Buzz for specific number conditions.

  https://leetcode.com/problems/fizz-buzz/


- <b>Increase</b>
Multiply two integers without using the multiplication sign.


- <b>Find Second largest element in an array</b>
Given an array of integers, find the second-largest element in the array.

  https://www.geeksforgeeks.org/find-second-largest-element-array/

- <b>Longest Common Prefix</b>
 Find the longest common prefix from an array of strings. If there is no common prefix, return the empty string "".

  https://leetcode.com/problems/longest-common-prefix/


- <b>Palindrome Number</b>
  Check if an integer is a palindrome, meaning it reads the same forwards and backwards.

   https://leetcode.com/problems/palindrome-number/


  
- <b> Reverse String </b>
Reverse a character array.

    https://leetcode.com/problems/reverse-string/


- <b>Sort Characters By Frequency</b>

 Sort the letters in an input string by their frequency in decreasing order.

    https://leetcode.com/problems/sort-characters-by-frequency/

- <b>Two Sum</b>
Given an array of integers and a target integer, find two numbers in the array that add up to the target and return their indices.

  https://leetcode.com/problems/two-sum/

- <b>Valid Parentheses</b>
given a string "s" containing just the characters '(', ')', '{', '}', '[', ']', determine if the input string is valid. Open brackets mus be closed by the same type of brackets and closed in the correct order.

  https://leetcode.com/problems/valid-parentheses/

#### DEPENDENCIES ####

- JUnit Jupiter (org.junit.jupiter:junit-jupiter-engine:5.9.2) for testing.


#### TESTING ####

All my algorithms code has tests. JUnit was used to write tests 


#### RUNNING TESTS ####

To run the tests for the recruitment algorithms, you should have a development environment set up with JUnit support. Below are the general steps to run the tests:

1. <b>Clone the Repository:</b> If you haven't already, clone this repository to your local machine using Git:

   ```bash
   git clone https://github.com/JavaDawid/codingchallenges
   
2. <b>Ensure JUnit is Configured:</b> Make sure that JUnit Jupiter is properly configured in your project. If it's not, you can add it as a dependency to your project build file (e.g., pom.xml for Maven). You can find the dependency information in the **"DEPENDENCIES"** section of this README.

3. <b>Run the Tests:</b> Navigate to the test packet <b><i>leetcode</i></b>. Right-click on the test class file and select "Run".

   ![test run](https://github.com/JavaDawid/codingchallenges/assets/122672760/3e16f388-c7f1-4e65-a30c-b34f0a9c52e5)


### LICENCE ###

The algorithms used in this repository are the property of LeetCode (https://leetcode.com). Remember that these tasks are protected by LeetCode's copyright.


   # Tic-Tac-Toe #

### TABLE OF CONTENTS ###

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#description-1"> Description </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#instalation"> Instalation </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#usage"> Usage </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#testing-1"> Testing </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#test-coverage-reports"> Test Coverage Raport </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#dependencies-1"> Dependencies </a>

* <a href="https://github.com/JavaDawid/codingchallenges/blob/master/README.md#licence-1"> Licence </a>

#### DESCRIPTION ####

It's a popular 3X3 strategic board game for two players. In my version also you can play with player AI vs player AI. 
![1](https://github.com/JavaDawid/codingchallenges/assets/122672760/67fc84b1-d1c4-4409-b022-76ee6b0c5ee9)


#### INSTALATION ####


1. If you haven't already, clone the Tic-Tac-Toe repository to your local machine using Git. Open your terminal and run the following command:
      

           git clone https://github.com/JavaDawid/codingchallenges


 ![x1](https://github.com/JavaDawid/codingchallenges/assets/122672760/b1152c6e-78b8-4beb-95c0-7860d2ed9011)

 

 ![x2](https://github.com/JavaDawid/codingchallenges/assets/122672760/6546b460-c158-476f-8dcc-9af6f4b13720)

2. Replace the 'pom.xml' and 'src'. Inside the codingchallenges directory, you'll find a pom.xml file and a src directory. These contain project configuration and source code. If you want to use this project as a starting point for your development, replace your existing pom.xml and src directory code from download repositorium. Under it's correct screan how should look everything.

![x5](https://github.com/JavaDawid/codingchallenges/assets/122672760/5959983f-6d9c-4422-8987-0ad52ccb3837)

    
#### USAGE ####
Choose class <i>main</i> and run game (screan higher). On begining you can choose with game you want play. If you choose option with human you must keep that format input data 

![x7](https://github.com/JavaDawid/codingchallenges/assets/122672760/5f234966-1da4-4aa7-b497-0e78b02374da)


#### TESTING ####

Tests for Tic-Tac-Toe are localised in *test* package. All class contains personalized test names so you easy can see what kind of code is tested. Test class contains enviroment *Mockito* so copy file pom.xml is nesesary. Run test class is in the same way like runing game.

![x8](https://github.com/JavaDawid/codingchallenges/assets/122672760/4c31baf2-bef2-4a76-8cce-cc17321bdcb0)

All test have positive results.

![correct tests](https://github.com/JavaDawid/codingchallenges/assets/122672760/72273681-edc6-4700-8d5d-f41ff67f4bef)

# Test coverage reports #

![test coverage](https://github.com/JavaDawid/codingchallenges/assets/122672760/9dbe40e5-0e1c-4ce3-b60f-748157482435)



#### DEPENDENCIES ####

   - org.junit.jupiter.junit-jupiter-params:5.10.0 (JUnitParams)
   - org.mockito.mockito-junit-jupiter:5.3.1 (Mockito)
   - org.mockito.mockito-core:5.3.1 (Mockito)
   - org.projectlombok.lombok:1.18.28 (Lombok)


### LICENCE ###

The Tic-Tac-Toe project is released under the Apache License, Version 2.0 (https://www.apache.org/licenses/LICENSE-2.0). Please refer to the LICENSE file for details.

