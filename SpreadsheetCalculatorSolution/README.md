# Spreadsheet-calculator

This is a java project that
i) reads values from 'stdin'
ii) evaluates the inputs and populates the spreadsheet,
iii) prints the spreadsheet in 'stdout'

Detailed problem statement can be found in "Spreadsheet Calculator test.pdf".

The solution supports following inputs:
1) numbers including negative numbers,
ii) Numeric expression,
iii) Cell reference,
iv) Expression containing cell-reference

The solution does not support increment or decrement operator (++ or --).

How to run:
=====================================================
Option 1: run directly the runnable jar
--------------------------------------------
This option assumes Java 1.8 to be present in the system and in classpath.

Steps:
-----------------
Go to "release" folder.
Run SpreadsheetCalculator-1.0.0-SNAPSHOT.jar using the command: "java -jar SpreadsheetCalculator-1.0.0-SNAPSHOT.jar"
Provide required inputs.
Output will be present in console as well as in the log file: SpreadsheetCalculator.log

Option 2: Build the source and run
--------------------------------------------
This option assumes Maven 3.x and Java 1.8 to be present in the system and in classpath.

Steps:
-------------------
Go to "source/SpreadheetCalculator" folder. 
pom.xml should be present under this folder.
Build the application using the command: "mvn clean install". This will also run junit test cases.
"target" folder will be created under "source/SpreadheetCalculator" folder. The runnable jar SpreadsheetCalculator-1.0.0-SNAPSHOT.jar will be present there.
This runnable jar can be copied in to any folder or directly run from "target" folder using the command: "java -jar SpreadsheetCalculator-1.0.0-SNAPSHOT.jar"
Provide required inputs.
Output will be present in console as well as in the log file: SpreadsheetCalculator.log

The solution is built on following logic:
=====================================================
Spreadsheet is implemented by com.redmart.interview.tanb.model.SpreadSheet. Data is stored in a 2-dimensional array.
com.redmart.interview.tanb.model.Expression class evaluates postfix expression.
com.redmart.interview.tanb.model.Digraph implements a directed graph. This is used to identify a cycle.
com.redmart.interview.tanb.util.PatternUtil helps in identifying different types of inputs. Regular expression is used.
com.redmart.interview.tanb.util.IndexMapper helps in mapping between cell-reference like 'A1' and spreadsheet row,column like [0][0].
com.redmart.interview.tanb.util.CyclicReferenceValidator checks for cycles in cell-references. It uses directed graph to identify a cycle.

LOGGING
=================================================
The solution uses Apache log4j for logging. Output is sent to both console and the log file. Log level is set at "info". 
In order to see more detailed log, please change this log level to "debug" at src/main/resources/log4j2.xml and rebuild the application.