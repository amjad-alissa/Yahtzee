package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.elements.DiceSetResponse;

/**
 * The DiceSetResponseService serves as the service class for DiceSetResponse class.
 */
public class DiceSetResponseService {
    /**
     * Create createDiceSetResponse.
     *
     * @param pointsCalculatorService the points calculator service
     * @param diceSetService          the dice set service
     * @param selectedDices           the selected dices
     * @return the dice set response
     */
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
