Feature: API feature 3
  Scenario: Verify user API
    Given I'm a admin to verify single resource

  Scenario: Verify test data
    Given I have the following test data
    """
    {
         "users": [
           {
             "name": "John",
             "age": 30
           },
          {
           "name": "Alice",
             "age":25
           }
         ]
       }
       """