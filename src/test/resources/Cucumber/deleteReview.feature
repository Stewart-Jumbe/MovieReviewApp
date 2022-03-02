Feature: Delete a Review that already exists for a Movie
  As a person I want to delete an existing review for a movie
  Scenario: A review was left on the wrong film and needs to be deleted
    Given I want to delete an existing review
    When An existing review is deleted
    Then the review should be removed from the movie it was left on

