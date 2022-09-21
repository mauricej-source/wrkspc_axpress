# American Express - Technical Assessment
Coding Task for Software Engineer Candidates
The following task will allow you to demonstrate your ability to deliver
readable, maintainable and testable code. As an agile organization, we are
applying equal emphasis on assessing both your problem solving and testing
abilities.

Be prepared to present your solution over conversation that will lead to
questions around design decisions, rationale and future expansion.
The exercise is to demo your technical skills and takes most candidates a few
hours; please don’t spend a huge amount of time making it perfect.
    • Please complete the following task with the language and libraries you
    feel comfortable with.

    • Use git to version control the code and once complete, send us a link to
    the Github (or similar) repository via the recruitment agent
    Instructions: Complete the steps in order. At each step build the simplest
    possible solution which meets the requirement. Tag and git commit after
    each step so that your approach is clear.

Step 1: Build an Orders Service
    • Build a service that’s able to receive simple orders of shopping goods via a REST API
    • Apples cost 60 cents and oranges cost 25 cents
    • The service should return a summary of the order, including the cost of the order
    • Add unit tests that validate your code

Step 2: Simple offer
    • The shop decides to introduce two new offers
    • buy one get one free on Apples
    • 3 for the price of 2 on Oranges
    • Update your functions & unit tests accordingly

Step 3: Store and retrieve orders
    • The service should now store the orders that a customer submits
    • There should be an endpoint to get a particular order based on its ID
    • There should be an endpoint to get all orders
    • This store does not have to be to disk
    • Update your functions & unit tests accordingly