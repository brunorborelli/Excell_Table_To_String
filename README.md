# Excell_Table_To_String
Write excel table to string

Simple algorithm I created to streamline an update that I needed to make at work on hundreds of lines in the database using data from an Excel spreadsheet.

The code takes an Excel spreadsheet from within your project, creates variables from the columns in the spreadsheet, 
and writes a string to a .txt file that will be created as soon as the project is executed. 

The return string can be customized, as well as the number of columns from the Excel spreadsheet that are read and transformed into a variable.

You may need to run "mvn clean install" in the console to download the dependencies.
