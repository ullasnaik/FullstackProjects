## Problem Statement - TextAnalyzer v3.0

In this challenge you will use a binary tree data structure to implement a better Text Analyzer. Earlier you may have used a linked list to for this purpose. However, as you are aware search operations on large, linked lists can become inefficient. A tree delivers much better performance as you will see for yourself while tackling this challenge.

**Task 1** – Design a class called Word that can be used to store details of a word that is read from a text file. Apart from the word itself, the class should have an attribute to store the number of times the same word occurs in the file. Define appropriate constructors and getter & setter methods for this class. You may re-use the class that you have created earlier for this purpose.

**Task 2** – This task involves creating an appropriate model for the binary tree. Identify the classes that you will have to define so that the required binary tree can be constructed. 

**Task 3** - This task involves reading a text file and storing all the words in memory using a binary tree data structure as per the class definitions you have created. 

Once, you have read all the words in the file `daffodils.txt`, use a method called `showTree()` to show all the words that have been found. You will note that the output is nothing but the contents of the file.

Additionally, print the total number of words at the end.

**Task 4** – An issue that you may have noticed while completing Task 3 is that the binary tree contains the same word at different nodes of the tree depending upon where the word was used in the file. This is because you are creating a new node to hold each word that is read from the file. This will create problems during sorting & searching operations on this tree.

Implement a strategy such that the same word is not added more than once in the tree. Instead, the frequency count of the word should be stored along with it. After the first instance, if the word is encountered again in the input file, then only its count should be increment at the node where the word has been previously added in the tree.

How efficient is your algorithm? Use the `System.currentTimeMillis()` method from the Java util package to measure how much time it takes to insert a word into your binary tree now, in comparison to the insertion in Task 4. Explain what is happening?

Update your `showTree()` method so that it now displays the words along with their frequency count.

**Task 5** – Notice in the output displayed in Tasks 4, that the words are not shown in any specific order. They are simply displayed in the order in which they were found in the file. Now refactor your program so that the binary tree is constructed in such a way that when it is traversed appropriately, they will be shown in alphabetical order starting with the word “a” (if it exists in the file).

**Hint:** This task requires you to construct a Binary Search Tree. Binary trees have a special way of traversal that is in addition to the pre-order & post-order traversal that is applicable for general trees. 

**Task 6** – Write a method that shows the words in your binary tree in reverse alphabetical order.

**Task 7** – Write an additional method called `showFrequentWords()` that reads your alphabetically sorted binary tree and displays the words in descending order of frequency i.e. the word with the highest frequency is listed first, then the word with the next highest frequency, etc. If 2 words have the same frequency, they should be listed in alphabetical order.
