# Vending Machine Kata README
***

1. Language: Java
2. Additional Framework(s): JUnit 4
3. IDE: Eclipse
4. Approach: Test-Driven Design (TDD)
5. Dependencies: [Link to Raw build.gradle file](https://raw.githubusercontent.com/Brent-Milan/vending-machine-kata/master/build.gradle)
6. To test: run /.gradlew

## Description:

I approached this project in a similar manner to the 'BabySitter kata', but I incorporated feedback I received such as deeper extraction of methods and not creating an untested console menu. Instead, I focused on the back-end logic and creating the necessary classes to solve the problem in a thoughtful way.

Quick description of key classes in this project:

1. BankController: all logic associated with Coin inventory levels, identifying Coins, and refunding change.

2. DisplayController:  all logic associated with updating the notification display on the vending machine.

3. Coin object: (updated) a simple object representing a coin. Has size and diameter attributes, but value is determined by the machine (specifically the BankController class) identifying each object.

4. CoinRepository: (updated) formerly multiple classes that held instances of Coin subclasses. Simplified to a single repository class that holds Coin objects. BankController uses multiple instances of this for different Coin denominations and inventories.

At one point, BankController and DisplayController were one very bloated class named 'VendingMachine', but it was responsible for far too many things and exceedingly complex, so I performed a large refactor on the project to unmarry the logic into two separate classes with clarified roles and dedicated test classes. 

## 9/24 Update:

Coin object updated. No longer a superclass, but instead has methods to instantiate itself with attributes indentifying it as a quarter, dime, etc. All redundant subclasses eliminated. 

All repository classes reworked to a single Coin repository after the demise of the Coin subclasses.

Project is now much slimmer and all remaining tests are back in the green.


