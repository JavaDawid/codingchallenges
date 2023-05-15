# FIBONACCI #

This project contains a simple implementation of a Fibonacci Sequence Generator in Java, along with its corresponding unit tests using the JUnit 5 framework.

 #### **DESCRIPTION** ####
 
The Fibonacci Sequence is a series of numbers where a number is found by adding up the two numbers before it. Starting from 0 and 1, the sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21.
The **Fibonacci** class in this project contains a method ***fib(int n)*** witch return the **n** number in Fibonacci sequence.

#### **USAGE** ####

Here is a simple example how use the **Fibonacci** class
    
    Fibonacci fibonacci = new Fibonacci();
    int result = fibonacci.fib(5);  // result will be 5

#### **TESTING** ####

This project also contains **FibonacciTest** class with include unit test for the **Fibonacci** class.
All tests are located in the ***scr/test/java/leetcode***.
Each test case in **FibonacciTest** class test the ***fib(int n)*** method with different values of **n** and checks that result is like expected.
The tests use the JUnit 5 **Assertions** class to check the result.

#### **DEPENDENCIES** ####

- JUnit Jupiter (org.junit.jupiter:junit-jupiter-engine:5.9.2) for testing.
