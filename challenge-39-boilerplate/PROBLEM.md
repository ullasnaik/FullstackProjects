## Problem Statement - TextAnalyzer v2.1

In this challenge you will use a binary tree data structure to implement a better Text Analyzer. Earlier you may have used a linked list to for this purpose. However, as you are aware search operations on large, linked lists can become inefficient. A tree delivers much better performance as you will see for yourself while tackling this challenge.

**Task 1** – Design a class called Word that can be used to store details of a word that is read from a text file. Apart from the word itself, the class should have an attribute to store the number of times the same word occurs in the file. Define appropriate constructors and getter & setter methods for this class. You may re-use the class that you have created earlier for this purpose.

**Task 2** – This task involves creating an appropriate model for the binary tree. Identify the classes that you will have to define so that the required binary tree can be constructed. 

**Task 3** – Now implement some of the methods that are considered an important part of the interface of a binary tree. Note you will need to decide in which class the methods 1 – 12 mentioned below have to be incorporated. 

1.	`v.left()` - Get the left child node if it exists, else null
2.	`v.right()` – Get the right child node if it exists, else null
3.	`v.hasLeft()` – True if v has a left child node
4.	`v.hasRight()` – True if v has a right child node
5.	`v.isInternal()` – True if v is an internal node
6.	`v.isExternal()` – True if v is an external node i.e. leaf node i.e. no child nodes
7.	`v.isRoot()` – True if v is the root node
8.	`size()` – Returns the number of elements (nodes) in the tree
9.	`isEmpty()` – True if it’s a null tree i.e. it has 0 nodes
10.	`v.insertLeft(e)` – Wraps the element e, and inserts it as the left child node of v. Will fail if the left child already exists
11.	`v.insertRight(e)` – Wraps the element e, and inserts it as the right child node of v. Will fail if the right child node already exists
12.	`addRoot(e)` – Wraps the element e and creates the root of the tree. Will fail if the root already exists

**Task 4** - This task involves reading a text file and storing all the words in memory using a binary tree data structure as per the class definitions you have created. Your word tree will look like the trees in Figures 5, 6, and 7. Use the interface methods that you have defined in Task 3 to ensure modularity of your program.

Once, you have read all the words in the file `daffodils.txt`, use a method called `showTree()` to show all the words that have been found. You will note that the output is nothing but the contents of the file.

Additionally, print the total number of words at the end.

**Task 5** – An issue that you may have noticed while completing Task 4 is that the binary tree contains the same word at different nodes of the tree depending upon where the word was used in the file. This is because you are creating a new node to hold each word that is read from the file. This will create problems during sorting & searching operations on this tree.

Implement a strategy such that the same word is not added more than once in the tree. Instead, the frequency count of the word should be stored along with it. After the first instance, if the word is encountered again in the input file, then only its count should be increment at the node where the word has been previously added in the tree.

How efficient is your algorithm? Use the `System.currentTimeMillis()` method from the Java util package to measure how much time it takes to insert a word into your binary tree now, in comparison to the insertion in Task 4. Explain what is happening?

Update your `showTree()` method so that it now displays the words along with their frequency count.

**Task 6** – Notice in the output displayed in Tasks 4 & 5, that the words are not shown in any specific order. They are simply displayed in the order in which they were found in the file. Now refactor your program so that the binary tree is constructed in such a way that when it is traversed appropriately, they will be shown in alphabetical order starting with the word “a” (if it exists in the file).

**Hint:** This task requires you to construct a Binary Search Tree. Binary trees have a special way of traversal that is in addition to the pre-order & post-order traversal that is applicable for general trees. 

**Task 7** – Write a method that shows the words in your binary tree in reverse alphabetical order.

**Task 8** – Write an additional method called `showFrequentWords()` that reads your alphabetically sorted binary tree and displays the words in descending order of frequency i.e. the word with the highest frequency is listed first, then the word with the next highest frequency, etc. If 2 words have the same frequency, they should be listed in alphabetical order.

