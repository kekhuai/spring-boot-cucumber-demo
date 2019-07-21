package com.example.cucumberdemo;

import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java8.En;

class IsItFriday {
  static String isItFriday(String today) {
    if ("Friday".equals(today)) {
      return "TGIF";
    }
    return "Nope";
  }
}

public class StepDefs implements En {

  private String today;
  private String actualAnswer;

  public StepDefs() {
    Given("today is {string}", (String today) -> {
      this.today = today;
    });

    When("I ask whether it's Friday yet", () -> {
      actualAnswer = IsItFriday.isItFriday(today);
    });

    Then("I should be told {string}", (String expectedAnswer) -> {
      assertThat(actualAnswer).isEqualTo(expectedAnswer);
    });
  }

}
