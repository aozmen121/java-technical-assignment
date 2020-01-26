# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

Running Project:

As this is a maven project you can use the following command to run the tests:

    mvn test

Notes: 

* Utilize TDD to first start implementing the discount handlers.
* Added mocking library for mocking and stubbing dependencies.
* Added commons library to use some utility functions.

Assumptions to consider:

* Did not modify the existing code base and test cases to uphold the OOP principles.
* However most of the time was taken up by how to apply uniqueness to the items without breaking the existing tests.
* Managed to complete buy one get one free feature but did not have enough time for the rest.
* Was going to consider refactoring the buy one get one free discount implementation to be more efficient but run out of time :(

My thoughts are:

* Was considering in using Factory pattern to handle creating of different types of items without exposing the creation logic to the client. Which meant I would require to extend to different types of items. Not sure if that's ok?
* In combination I was considering to use strategy design pattern to handle different types of discounts being applied during run time once the discount strategy context is set. However this started coming to my mind as i was completing the first discount implementation.
* Was not sure if the weighed items would be considered as discounted items. 
* I tried to break down the components and test them individually then considered adding some integration tests. But not enough time.
* Need to consider priority levels for different discount options and at what state does each one apply.
* Could even consider Criteria pattern to group together items to apply various discounts onto. (But not 100% convinced its the right approach).
 