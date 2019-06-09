# LoanApplication version 1.0  
### Date : 09/06/2019

## Description
-------------------

* This test is simulation of simple Quote servivce.
* We have a service which consists of different Lenders which have availbale balance to lend with a specific rate. The service is lending money based on borrower request and the amount of loan should be the sum of lenders available balance with the lowest rate. Lowest rate is essential becuase this service should work in a competitive business.
* The application includes testing all servicing methods.
* We have a csv file to initially set up input data. 
* The application get a csv file and a Loan requested amount then calculate the TotalRepayment,MonthlyRepayment and InterestRate successfully.
* It checks all the input, that is getting from the csv file.
* It also checks the requested amount's range and value.

## Assumptions
-------------------
* We are not allowed to assign any zero or negative value to the balance of the Lenders.
* Also we are not allowed to assign any zero or negative value to the rate of the Lenders' balance.
* _Assumption_ : In case of any negative result, we will send an alarming message to the user and stop adding the lender to the list of lenders.
* Lenders have name and balance in addition to rate, and the name is mandatory for the customer in this application. 
* _Assumption_ : We assumed that in case of equal rates, sorted the lender list based on lower available balance of the lenders.
* _Assumption_ : we assume that all the decimal values rounded UP

## About Project
---------------------------

- It is developed by Java language
- The project uses the JDK 8 
- It is essencial to install Maven before running the project
- It is tested with Junit 4.11 or higher
- Copy the quote.exe to a path then Run the project with this command quote.exe [D:\ \path\ \market.csv] 1000
- _Attention_ : the path should be with ' \ \ ' instead of ' \ '  and it is the path of Market.csv file
- _Advice_ : to run the application easier we suggested that copy the csv file in the same path of the quote.exe file then it is not needed to enter the path just the name of csv file would be enough 

for more information you can contact:
--------------------------------------
maryam.karandish4@gmail.com
+98 936 769 3346

