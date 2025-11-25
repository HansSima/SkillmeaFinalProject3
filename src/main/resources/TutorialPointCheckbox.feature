Feature: TutorialPointCheckbox

  #REQ-C2
  Scenario: Automaticke zaskrtavani/odskrtavani checkboxu
    Given Uzivatel se nachazi na strance s checkboxy
    When Uzivatel klikne na tlacitko plus pro rozbaleni checkboxu
    And Uzivatel klikne na checkbox s id "c_bf_1"
    And Uzivatel klikne na checkbox s id "c_bf_2"
    Then Nadrazeny checkbox s id "c_bs_1" je zaskrtnut
    When Uzivatel klikne na checkbox s id "c_bf_1"
    Then Nadrazeny checkbox s id "c_bs_1" je odskrtnut

  #REQ-C1
  Scenario Outline: Kliknutim na checkbox dojde k jeho zaskrtnuti
    Given Uzivatel se nachazi na strance s checkboxy
    When Uzivatel klikne na checkbox s id "<idCheckboxu>"
    Then Nadrazeny checkbox s id "<idCheckboxu>" je zaskrtnut

    Examples:
      | idCheckboxu |
      | c_bs_1      |
      | c_bs_2      |
