@saucedemo
Feature: User wants to Web Saucedemo

    Scenario Outline: User successfully login
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        Examples:
            | username      | password    |
            | standard_user | secret_sauce|

    Scenario Outline: User failed login
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user see error login message
        Examples:
            | username    | password    |
            | expert_user | secret_sauce|

    Scenario Outline: User filter product by Price Low to High
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        When user click filter product by price low to high
        Then user see product from price low to high
        Examples:
            | username      | password    |
            | standard_user | secret_sauce|

    Scenario Outline: User choose 3 product
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        When user choose Sauce Labs Onesie
        And user choose Sauce Labs Bike Light
        And user choose Sauce Labs Backpack
        Then user see three products in icon basket
        Examples:
            | username      | password    |
            | standard_user | secret_sauce|

    Scenario Outline: User remove one of product
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        When user choose Sauce Labs Onesie
        And user choose Sauce Labs Bike Light
        And user choose Sauce Labs Backpack
        Then user see three products in icon basket
        When user remove Sauce Labs Onesie
        Then user see two products in icon basket
        Examples:
            | username      | password    |
            | standard_user | secret_sauce|

    Scenario Outline: User remove all products in basket
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        And user choose Sauce Labs Bike Light
        And user choose Sauce Labs Backpack
        Then user see two products in icon basket
        When user click icon basket
        And user remove Sauce Labs Bike Light
        And user remove Sauce Labs Backpack
        Then user click button checkout
        And user input in field firstname "<first_name>"
        And user input in field lastname "<last_name>"
        And user input in field postalcode "<postal_code>"
        And user click button continue
        And user see total price
        And user click button finish
        And user successfully orders
        And user click button back home
        Examples:
            | username      | password    | first_name | last_name | postal_code |
            | standard_user | secret_sauce| kuya       | kuyi      | 13210       |

    Scenario Outline: User finish to checkout
        Given user on login page saucedemo
        When user input in field username "<username>"
        And user input in field password "<password>"
        Then user click button login
        And user successfully login
        And user choose Sauce Labs Bike Light
        And user choose Sauce Labs Backpack
        Then user see two products in icon basket
        When user click icon basket
        Then user click button checkout
        And user input in field firstname "<first_name>"
        And user input in field lastname "<last_name>"
        And user input in field postalcode "<postal_code>"
        And user click button continue
        And user see total price
        And user click button finish
        And user successfully orders
        And user click button back home
        Examples:
            | username      | password    | first_name | last_name | postal_code |
            | standard_user | secret_sauce| kuya       | kuyi      | 13210       |