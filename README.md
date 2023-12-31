# Employee_CRUD_MVC

This application is of simple CRUD operations such as : 
1. Register Employee
2. Find Employee
3. Update Employee
4. Delete Employee
5. Show All Employee
6. Exit

Steps to run this Standalone Application :

Step 1: Download this file, Unzip it.
Step 2: Import it in your IDE. Make sure your IDE supports java. (JDK)
Step 3: Have a related database. 
       ~ My database Name: employee
       ~ Consists of 2 tables, user table is for login credentials. 
        user:
      ---------------------
      | name  | password  |
      ---------------------     
      |       |           |

       ~ employee table is to perform CRUD operations.
        employee:
      -------------------------  
      | id   | name  | salary |
      -------------------------
      |      |       |        |


Step 4: Make sure about mysql-connector-java-8.0.26.jar in your Referenced Libraries (version is optional).
Step 5: Finally, set DbUtil inside the package com.botree.util     
Step 6: Thats it! Run as Java application.
