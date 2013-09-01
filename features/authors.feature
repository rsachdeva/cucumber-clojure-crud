Feature: Authors
  Author Club List operations

Background:
  Given Authors list is set up as "Alex,Craig,Luke,Rohit,Ryan,Stuart"

Scenario: add name and check in the list
  When I add name "Justin"
  And I request name "Justin"
  Then I should get "Your name Justin IS in the Authors Club"

Scenario: delete name and check in the list
  When I delete name "Craig"
  And I request name "Craig"
  Then I should get "Your name Craig IS NOT in the Authors Club"

Scenario: add, delete name and check in the list added, removed, existing
  When I add name "Justin"
  And I delete name "Craig"
  When I request name "Craig"
  Then I should get "Your name Craig IS NOT in the Authors Club"
  When I request name "Justin"
  Then I should get "Your name Justin IS in the Authors Club"
  When I request name "Ryan"
  Then I should get "Your name Ryan IS in the Authors Club"

  