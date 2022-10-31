Feature: Verify GET method on reqres.in

  Scenario Outline: Verify email for <userNumber> user on <pageNumber> page
    Given For endpoint "/api/users" and <pageNumber> page
    Then For <userNumber> user I should see the the email as <email>
    Examples:
    |pageNumber |userNumber |email                        |
    |1          |0          |"george.bluth@reqres.in"     |
    |1          |1          |"janet.weaver@reqres.in"     |
    |1          |2          |"emma.wong@reqres.in"        |
    |1          |3          |"eve.holt@reqres.in"         |
    |1          |4          |"charles.morris@reqres.in"   |
    |1          |5          |"tracey.ramos@reqres.in"     |
