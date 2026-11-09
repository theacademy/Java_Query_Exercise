### Assignment Status: ![](https://github.com/theacademy/Java_Factorial/actions/workflows/factorial.yaml/badge.svg?branch=main)

# Java_Query_Exercise
## Problem Statement

Using what you learned about databases and queries, apply the following functionality in the relevant methods 
to produce the desired results.

The database tables are set up as follows:
```
CREATE TABLE student (
  sid int AUTO_INCREMENT PRIMARY KEY,
  fName varchar(255) DEFAULT NULL,
  lName varchar(255) DEFAULT NULL
);

CREATE TABLE teacher (
  tid int AUTO_INCREMENT PRIMARY KEY,
  tFName varchar(255) DEFAULT NULL,
  tLName varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL
);

CREATE TABLE course (
  cid int AUTO_INCREMENT PRIMARY KEY,
  courseName varchar(255) DEFAULT NULL,
  courseDesc varchar(255) DEFAULT NULL,
  teacherId int DEFAULT NULL
);

CREATE TABLE course_student (
  student_id int,
  course_id int
);
```

The methods you will implement are located within the dao package, in the SchoolDaoImpl.java file. All methods need
the query implemented to function correctly. Be sure to follow the directions for the query instructions.

1. allStudents(): Write a query that returns all students (first name, last name only) sorted by last name.
2. CS_Courses(): Write a query that lists the course name and course description for all courses in the Computer Science department.
3. teacherCountByDept(): Write a query that displays the department and the total number of teachers assigned to each department.
4. studentsPerClass(): Write a query that lists the name of the course and the total number of students enrolled in that course.
5. addStudent(): Write a query to add the student Robert Dylan to the student table.
6. addStudentToClass(): Write a query to add Robert Dylan to CS148
7. editCourseDescription(): Write a query to change the course description for course CS305 to `Advanced Python with Flask`
8. deleteTeacher(): Write a query to remove Lewis Carroll as a teacher.

## Instructions

Update only the existing SchoolDaoImpl.java class in the starter code provided. Do not change the code in any other file provided.

Update the class as necessary to implement the queries, adding new code only inside the comment blocks provided and within the quotes of the statement: `String sql = "";`

For each method listed above, do not replace any of the return statements.  Only add code inside the comment blocks provided.

Focus on one method (query statement) at a time. After committing the code and verifying that the test for that method passes, start work on the next method. 

Submit the URL for your repository to the Engage assignment only after the code passes all tests. 

## Steps to Solve the Problem

### Step 1: Verify the Setup Requirements
- Clone the repository to your local machine and open it in your selected IDE.
- Verify that you have Java version 17 or higher installed on your machine.

### Step 3: Solve the Problem
Read the problem statement carefully to be sure youOpen the indicated .java file on your computer. Make changes only to that file.

The .java file includes comments to indicate where you should add your code.
- All new code must be added inside the placeholders provided.
- Do not delete the placeholder comments.
- Do not change any existing code elsewhere in the project.
- Do not alter existing class names, interface names, method signatures, or attribute names.
- Use Java naming conventions for the code you create.
The placeholders for your code will look like:


    //YOUR CODE STARTS HERE


    //YOUR CODE ENDS HERE


All new code should be added inside these placeholders. You may add additional lines of code as necessary, but do not remove the placeholder comments.

### Step 4: Submit Your Work
1. Code solutions to the problem statements and run the code in the local IDE to check it as you work.
2. Incrementally commit the changes to the repository, labeling each commit numerically (Commit1, Commit2, etc.).
    - The number of commits can be as high as necessary; commit as frequently as you wish.
3. Each commit will be tested automatically against the relevant test cases. Open the repository in GitHub to view the test results.
    - A checkmark indicates that a ALL tests passed.
    - An X indicates that at least 1 test failed.
4. If any test fails, return to the local code to make corrections or add more code, then recommit the changes.
5. When the code passes all tests, commit one more time, labeling the last commit as "final commit."
6. Copy the URL for the GitHub repository and submit it to your instructor.

---
## Using h2 Database
* The h2 database is an open-source lightweight Java database.  
* It is a relational database management system written in Java. It can be embedded in Java applications or run in the client-server mode. The database is fast, open-source, and supports standard SQL.  
* It is used in this project to store and retrieve data for the school database. 
  * The h2 database is included in the project dependencies, so you do not need to install it separately. 
  * The database is initialized with the provided schema and data when the application starts. 
  * The database is stored in memory, so it will be reset every time the application is restarted. 
* You can use the h2 console to view and manipulate the database. The h2 console is a web-based interface that allows you to run SQL queries and view the results.  
* You can access the h2 console by navigating to http://localhost:8080/h2-console in your web browser. 
* The default username is "sa" and the password is empty. The JDBC URL is "jdbc:h2:mem:testdb". 
* You can use the h2 console to verify that your queries are working correctly and to explore the database schema and data. 
* You can also use the h2 console to run the queries you implemented in the SchoolDaoImpl.java file and see the results.