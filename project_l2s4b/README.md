# The Myers-Briggs Type Indicator

## A Psychology Test Log

### *Description:* 
- **What will the application do?**  

   The application will allow users to take a simple psychology test, based on 
   the Myers-Briggs Type Indicator to find their personality type. Then, the application will store
   the results into a log, which can be viewed in detail or deleted.
   
- **Who will use it?**

    Curious people who would like to take tests to potentially find out something interesting
     about their personality. The tests are obviously not 100% accurate, but this 
     application intends for fun. The log allows multiple people to complete the test, so you may
     view the results of your friends.
     
- **Why is this project of interest to you?**

    Psychology tests were always interesting to me, it allows people to
    think about themselves when they read the results. Obviously, the results are almost
    never very accurate, but regardless, it does get people to compare themselves with it.
    By doing so, people do get to know themselves better to an extent. 

### *User Stories:*

- As a user, I want to be able to add a test result to the log

- As a user, I want to be able to remove a test result from the log

- As a user, I want to be able to view a list of the test results in the log

- As a user, I want to be able to select a result in the log and view the result in detail

- As a user, I want to be able to save my result log to file

- As a user, I want to be able to be able to load my result log from file 

### *Phase 4 - Task 2:*

- **Test and design a class in your model package that is robust** 

    I have at least one method that throws a checked exception in the findDescription() method in the Result class.

    I have one test for the case where the exception is expected and another where the exception is not expected
in the ResultTest class.

### *Phase 4 - Task 3:*

Refactoring was a struggle for me in this project. As I aimed for cohesion and made many classes,
a lot of coupling also occurred.
- One possibility to reduce coupling is to refactor everything into a whole GUI class.
- Many GUI classes keep their own field copy of Log, change it to pass Log in to get 
rid of local parameter.
- There is a lot of similarity regarding panel making, which can be refactored into helper methods.
- Look for other classes to make more robust, not just in the model package