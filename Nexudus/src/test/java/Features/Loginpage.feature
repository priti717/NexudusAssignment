Feature:Login page

  @Sanity
  Scenario Outline:Login unsuccessful in Nexudus website
    Given Login page is visible URL "https://dashboard.nexudus.com/"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Click on Sign in
  Then close the driver

    Examples:
      | Email            | Password |
      | bad@example.com  |badpassword |

  @Sanity
  Scenario Outline:Login successful in Nexudus website
    Given Login page is visible URL "https://dashboard.nexudus.com/"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Successful sign in
    Then close the driver



    Examples:
      | Email            | Password |
      | adrian+1004930927@nexudus.com   |4efPNc*LM3-6q0 |


  @Sanity
  Scenario Outline:Add and delete a product from the products list
    Given Login page is visible URL "https://dashboard.nexudus.com/billing/products"
    When Enter valid Email address "<Email>"
    And Enter valid password "<Password>"
    And Successful sign in
    #And navigate to "https://dashboard.nexudus.com/billing/products"
    And Add the Product and fill the details name "<Name>","<Description>" and "<Price>" fields


    Examples:
      | Email                           | Password      |Name|Description|Price|
      | adrian+1004930927@nexudus.com   |4efPNc*LM3-6q0 |test1|Verify automation test is working for additional product.|10|