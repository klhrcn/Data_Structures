SpellChecker: A basic spell checker implemented using a hash table (HashSet) to efficiently detect misspelled words and generate spelling suggestions based on edit operations. This program reads a dictionary file (e.g., words.txt) and uses it to check spelling in an input text file. Words not found in the dictionary are reported as incorrect, and the program can generate suggestions using simple spelling correction techniques.

🚀 Features
* Loads dictionary words into a HashSet for O(1) lookup time
* Cleans and normalizes all input text (lowercase, remove punctuation)
* Detects incorrectly spelled words in an input file
* Generates spelling suggestions using:
  * Add one character
  * Remove one character
  * Swap adjacent characters
* Ensures unique suggestions using a Set<String>
