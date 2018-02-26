# Simple encrypt decrypt
This is a java program that encrypts and decrypts a file.

This program Crypto.java under "source" expects Java 7 or later.
Executable class file is already present under "release" folder.

In order to encrypt:
=====================================================
java -Doption="encrypt" -Dfile="file to be encrypted" Crypto

Crypto will generate "encrypted.txt", at the folder where the program is executed.

For example, if file to be encrypted is "/usr/abc.txt", then corresponding command will be: java -Doption="encrypt" -Dfile="/usr/abc.txt" Crypto

In order to decrypt:
=====================================================
java -Doption="decrypt" -Dfile="your encrypted file name" Crypto

Crypto will generate "decrypted.txt", at the folder where the program is executed.

For example, if file to be decrypted is "/usr/securedFile.txt", then corresponding command will be: java -Doption="decrypt" -Dfile="/usr/securedFile.txt" Crypto
