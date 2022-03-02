Feature: Add a new Review for a Movie I watched
  As a person I want to be add a new review for a movie
  Scenario: My review isn't added to the movie i watched
    Given I want to add a new review
    When A new review is added
    Then the review should be added to the movie and saved

