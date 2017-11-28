# Discount-calculator
This is a java project that calculates discounts for the customers.

Detailed problem statement can be found in "Discount Calculator.docx".

List of folders
====================================================
A) "release": this folder contains executable jar built from the source code, and required input files. "Option 1" of running this application refers to this folder.

B) "source/DiscountCalculator": this folder contains the source code of the application. This application can be built using Maven. "target" folder will be generated under this folder which will contain executable jar file. "Option 2" of running this application refers to this folder.


The solution is built on following logic:
=====================================================
The apparel store is run on an inventory. Inventory contains a list of products. Each product has a category and associated with a brand. One category can have sub-categories. 

Discount can be offered at brand level or at categories level. When discount for a product is calculated, highest of all available discounts (at category, parent-category, brand etc.) is being considered. Discounts are NOT clubbed together. Same logic of calculating discount is explained in the problem statement "Discount Calculator.docx".

Builder pattern is used to build these classes from corresponding source files (.txt). 
Separation-of-concern (SOC) is main principle considered to build this solution.

The model of the application comprises of following java classes: Inventory, Brand, Category, Product and Customer
All builder classes implements com.sg.gsc.interview.tanb.discalc.model.Builder interface.

A product selects its brand-discount or category-discount, whichever is higher. Corresponding method is getDiscountAmount(). It returns its discounted price from getDiscountedPrice().

A category compares its discount (zero if there is no discount) with its parent's discount. It returns the higher of the two. Corresponding method is getDiscountPercent().

The customer object calculates its total cost of purchase by summing up discounted price of its products. Corresponding method is getCostOfPurchase().

Package "com.sg.gsc.interview.tanb.discalc.exceptions" contains all exception classes. All excecptions are unchecked, runtime exceptions.

Input files are read by Java nio classes. Corresponding package is "com.sg.gsc.interview.tanb.discalc.io".

How to provide inputs to this application
=====================================================
The application is run by running DiscountCalculator-1.0.0-SNAPSHOT.jar. This application assumes following four input files:

A) Brands.txt
-------------------
This file contains list of brands and associated discounts (if any). Each line represents one brand and follows the format: <brand-name>, <discount-percent>
discount-percent is a number only.
If there is no discount, keep that blank.

B) Categories.txt
--------------------
This file contains list of categories, parent-category and associated discounts (if any). Each line represents one category and follows the format: <category-name>, <parent-category name>, <discount-percent>
discount-percent is a number only.
If there is no discount, please keep that blank.
If there is no parent-category, please keep that blank.

C) ProductList.txt
-------------------------
This file contains list of products, their categories, brands and prices. Each line represents one product and follows the format: <product-id>, <brand-name>, <category name>, <price>
product-id is a positive integer. Zero won't be accepted.
price is a number only.

D) CustomerPurchases.txt
--------------------------
This file contains list of products purchased by the customers. Each line represents one customer and contains comma-separated list of <product-id>


How to run:
=====================================================
The runnable jar assumes all input files, as mentioned above, in same folder where the jar is present. Output will be present in generated log file "DiscountCalculator.log"

Option 1: run directly the runnable jar
--------------------------------------------
This option assumes Java 1.8 to be present in the system and in classpath.

Steps:
-----------------
1. Go to "release" folder.

2. Run DiscountCalculator-1.0.0-SNAPSHOT.jar using the command: "java -jar DiscountCalculator-1.0.0-SNAPSHOT.jar"

Please note that sample input files are already supplied in this folder.
Output will be present in the log file: DiscountCalculator.log

Option 2: Build the source and run
--------------------------------------------
This option assumes Maven 3.x and Java 1.8 to be present in the system and in classpath.

Steps:
-------------------
1. Go to source/DiscountCalculator. 
pom.xml will be present under this folder.

2. Build the application using the command: "mvn clean install". This will also run junit test cases.
Please note here that all those .txt files under "source/DiscountCalculator" folder are required for running test cases.
"target" folder will be created under "source/DiscountCalculator". The runnable jar DiscountCalculator-1.0.0-SNAPSHOT.jar will be present there.

3. This runnable jar can be copied in to any folder or directly from "target" folder. All four input files should be present in same folder, in order to run the jar.
