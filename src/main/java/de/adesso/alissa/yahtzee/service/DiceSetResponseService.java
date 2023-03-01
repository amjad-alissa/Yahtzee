package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.business.DiceSetResponse;

public class DiceSetResponseService {
    public DiceSetResponse createDiceSetResponse(final PointsCalculatorService pointsCalculatorService,
                                                 final DiceSetService diceSetService,
                                                 final boolean[] selectedDices) {

        final DiceSetResponse diceSetResponse = new DiceSetResponse();
        diceSetService.updateSelectedDices(selectedDices);
        final int[] diceValues = diceSetService.getDiceValues();
        diceSetResponse.setDiceIconSource(diceSetService.getDiceSourceImages());
        diceSetResponse.setPointsLowerSection(pointsCalculatorService.calculateResultsForLowerSection(diceValues));
        diceSetResponse.setPointsUpperSection(pointsCalculatorService.calculateResultsForUpperSection(diceValues));

        return diceSetResponse;
    }
}
