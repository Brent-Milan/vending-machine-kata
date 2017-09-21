# Vending Machine Kata README
***

1. Language: Java
2. Additional Framework(s): JUnit 4
3. IDE: Eclipse
4. Approach: Test-Driven Design (TDD)
5. Dependencies: [Link to Raw build.gradle file]()

## Description:

I approached this project in a similar manner to the 'BabySitter kata', but I incorporated feedback I received such as deeper extraction of methods and not creating an untested console menu. Instead, I focused on the back-end logic and creating the necessary classes to solve the problem in a thoughtful way.

Quick description of key classes in this project:

1. BankController: all logic associated with Coin inventory levels, identifying Coins, and refunding change.

2. DisplayController:  all logic associated with updating the notification display on the vending machine.

3. Coin object: superclass of specific coin objects such as Quarter, Dime, etc. Does not know value, only has attributes.

4. Coin repository: various classes that represent the coin queues the vending machine bank will use to house Coin inventory for change.

At one point, BankController and DisplayController were one very bloated class named 'VendingMachine', but it was responsible for far too many things and exceedingly complex, so I performed a large refactor on the project to unmarry the logic into two separate classes with clarified roles. 

#Ideas for Further Improvement

BankController and DisplayController could be broken down further to even smaller, concise classes.


