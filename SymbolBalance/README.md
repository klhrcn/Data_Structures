🔧 SymbolBalance: A Java program that checks whether symbols in a source code file are properly balanced. This tool simulates a basic syntax checker by verifying matching pairs of:
* { } (curly braces)
* ( ) (parentheses)
* [  ] (square brackets)
* " " (string literals)
* /* */ (multi-line comments)

📌 Features:
* Reads a file character-by-character
* Uses a stack to track opening symbols
* Ignores content inside strings and block comments
* Returns a specific error type when an imbalance is detected
* Returns null if the file is perfectly balanced
