Feature: Authors
  Author Club List addition and check

Background:
  Given Authors list is set up as "Alex,Craig,Luke,Rohit,Ryan,Stuart"

Scenario: add name and check in the list
  When I add name "Justin"
  And I request name "Justin"
  Then I should get "Your name Justin IS in the Authors Club"

Scenario: not in the list
  When I request name "Andy"
  Then I should get "Your name Andy IS NOT in the Authors Club"

Scenario: already in the list
  When I request name "Rohit"
  Then I should get "Your name Rohit IS in the Authors Club"