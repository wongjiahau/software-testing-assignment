# TODO
## Part A
- [X] (a) Decision table  
- [X] (b) Appropriateness of test cases.

## Part B
- [ ] (a) Correctness of application code (2 classes).  
- [X] (b) Appropriate used of assertsXXX methods.  
- [X] (c) Using parameterised tests correctly  
- [X] (d) Invalid values are checked for in implemented code, and tests for invalid values are performed.  
- [ ] (e) Use of test doubles, mocks, spies or stubs for testing.  
- [X] (f) Combining test cases into test suites  
- [X] (g) Setting up some tests so that test values are read from a text file instead of hardcoding into test code
- [ ] (h) Perform integration testing after unit tests have been completed


## Teacher's explanation
- Input module will call charge module and charge module will call print request module
- Use mockito to stub the input module
- Use mockito to spy print request module to check number of calls, e.g. if there are 10 PR then 10 calls should be expected
- Input validation, invalid range of integer, gibberish input should throw exceptions
- Load test input from text files 

