class Yahtzee {
    static number_of_players = 2;
    static selected_row = null;
    static table_section = null;
    static selected_dice = [false, false, false, false, false];
    static shuffelCount = 3;


    //Toggle the green checkmark beside the red dice
    static toggleCheckMark(index) {
        let checkMarkId = "checkmark-" + index;
        let checkMark = document.getElementById(checkMarkId);
        checkMark.classList.toggle("checkmark-selected");
        Yahtzee.selected_dice[index - 1] = checkMark.classList.contains("checkmark-selected");
    }

    static shuffelDices() {
        this.shuffelCount -= 1;
        if (this.shuffelCount > -1) {
            let shuffel_count = document.getElementById("shuffel-count");
            shuffel_count.innerHTML = this.shuffelCount;
            Yahtzee.showRandomDice();
            Yahtzee.generateRandomDice();
        } else {
            alert("You can shuffel the dice only 3 times.");
        }
    }

    static generateRandomDice() {
        $(document).ready(function () {
            $.ajax({
                url: "/randomShuffel",
                cache: false,
                data: "selectedDices=" + Yahtzee.selected_dice,
                success: function (diceSetResponse) {
                    Yahtzee.processSelectedDice(diceSetResponse);
                    Yahtzee.registerPredictedPointsForUpperSection(diceSetResponse);
                    Yahtzee.registerPredictedPointsForLowerSection(diceSetResponse);
                }
            });
        });
    }

    static processSelectedDice(diceSetResponse) {
        let diceIconSource = diceSetResponse["diceIconSource"];
        for (let index = 0; index < diceIconSource.length; index++) {
            if (!Yahtzee.selected_dice[index]) {
                let img = document.getElementById('' + (index + 1));
                img.src = diceIconSource[index];
                img.classList.add("dice-fade");
                img.addEventListener("animationend", Yahtzee.resetTransition);
            }
        }
    }

    static registerPredictedPointsForUpperSection(diceSetResponse) {
        let pointsUpperSection = diceSetResponse["pointsUpperSection"];
        for (let index = 0; index < pointsUpperSection.length; index++) {
            let predict_point = document.getElementById("upper-predict-cell-" + (index + 1));
            predict_point.innerHTML = pointsUpperSection[index];
        }
    }

    static registerPredictedPointsForLowerSection(diceSetResponse) {
        let pointsLowerSection = diceSetResponse["pointsLowerSection"];
        for (let index = 0; index < pointsLowerSection.length; index++) {
            let predict_point = document.getElementById("lower-predict-cell-" + (index + 1));
            predict_point.innerHTML = pointsLowerSection[index];
        }
    }

// remove the animation from the dices after the shuffel
    static resetTransition() {
        this.classList.remove("dice-fade");
    }

    static highlightSelectedRow(row, section) {
        let upper_table = document.getElementById("upper-table");
        let lower_table = document.getElementById("lower-table");

        //remove the highlight of the other rows which are nor yet selected
        // for the upper table
        Yahtzee.removeHighlightFromElements(upper_table);

        //remove the highlight of the other rows which are nor yet selected
        // for the lower table
        Yahtzee.removeHighlightFromElements(lower_table);

        Yahtzee.highlightRow(row);
        Yahtzee.selected_row = row;
        Yahtzee.table_section = section;
    }

    static highlightRow(row) {
        row.classList.add("row-highlighted");
        //highlight the cells for this row
        $("td", row).each(function () {
            this.classList.add("cell-highlighted");
        })
    }

    static removeHighlightFromElements(table) {
        $("tr", table).each(function () {
            let row = this;
            if (!row.classList.contains("row-selected") && row.classList.contains("row-highlighted")) {
                row.classList.remove("row-highlighted");
                $("td", row).each(function () {
                    this.classList.remove("cell-highlighted");
                })
            }
        })
    }

// add styles to the selected row and make it unselectable
    static styleSelectedRow(row) {
        row.classList.add("row-selected");
        $("td", row).each(function () {
            this.classList.add("cell-selected");
        })
    }

    static commitDecision() {
        Yahtzee.styleSelectedRow(Yahtzee.selected_row);
        $(document).ready(function () {
            $("#commit-btn").click(function () {
                $.ajax({
                    url: "/commitDecision",
                    cache: false,
                    data: jQuery.param({
                        "rowLabel": Yahtzee.selected_row.getAttribute('id'),
                        "section": Yahtzee.table_section,
                        "playerId": sessionStorage.getItem('current_player')
                    }),
                    success: function (playerId) {
                        Yahtzee.loadScoreForCurrentPlayer();
                        Yahtzee.clearPredictionPoints('upper', 6);
                        Yahtzee.clearPredictionPoints('lower', 7);
                        setTimeout(function () {
                            Yahtzee.currentPlayer(playerId);
                        }, 3000);
                    }
                });
            });
        });
    }

    static addPlayerInputField() {
        if (Yahtzee.number_of_players <= 8) {
            document.getElementById("plus-sign-" + Yahtzee.number_of_players).classList.toggle("plus-icon-hidden");
            Yahtzee.number_of_players++;
            document.getElementById("plus-sign-" + Yahtzee.number_of_players).classList.toggle("plus-icon-hidden");
            document.getElementById("user-input-" + Yahtzee.number_of_players).classList.toggle("user-input-hidden");
            if (Yahtzee.number_of_players === 8) {
                document.getElementById("plus-sign-" + Yahtzee.number_of_players).classList.toggle("plus-icon-hidden");
            }
        }
    }

    static createPlayers() {
        sessionStorage.setItem('number-of-players', Yahtzee.number_of_players);
        const players_names = [];
        for (let index = 0; index < Yahtzee.number_of_players; index++) {
            const player_name = document.getElementById('name-' + (index + 1)).value;
            if (player_name !== null) {
                players_names[index] = player_name;
            }
        }

        $(document).ready(function () {
            $("#form-submit-btn").click(function () {
                $.ajax({
                    type: 'POST',
                    url: "/initializePlayers",
                    cache: false,
                    data: "playersNames=" + players_names,
                    success: function () {
                        window.location = '/startGame';
                    }
                });
            });
        });
        sessionStorage.setItem('current_player', '1');
    }

    static showAddPlayersForm() {
        document.getElementById("welcome-container").classList.toggle("hidden");
        document.getElementById("add-players-form").classList.toggle("hidden");

        //show the plus sign beside the name input field for the 2nd player
        $(document).ready(function () {
            document.getElementById("plus-sign-" + Yahtzee.number_of_players).classList.toggle("plus-icon-hidden");
            //hide all other input fields (from 3 to 8)
            for (let index = 3; index <= 8; index++) {
                document.getElementById("user-input-" + index).classList.toggle("user-input-hidden");
            }
        });
    }

    static currentPlayer(btn_id) {
        Yahtzee.highlightCurrentPlayer(btn_id);
        Yahtzee.clearScoreTable();
        Yahtzee.loadScoreForCurrentPlayer();
    }

    static highlightCurrentPlayer(btn_id) {
        sessionStorage.setItem('current_player', '' + btn_id);
        Yahtzee.number_of_players = sessionStorage.getItem('number-of-players');
        // remove the highlight from other player
        for (let i = 1; i <= Yahtzee.number_of_players; i++) {
            if (document.getElementById('name-' + i).classList.contains('player-selected')) {
                document.getElementById('name-' + i).classList.toggle('player-selected');
                document.getElementById('player-' + i).classList.toggle('player-tab-selected');
                break;
            }
        }
        if (!document.getElementById('name-' + btn_id).classList.contains('player-selected')) {
            document.getElementById('name-' + btn_id).classList.toggle('player-selected');
            document.getElementById('player-' + btn_id).classList.toggle('player-tab-selected');
        }
    }

    static resetShuffelCount() {
        this.shuffelCount = 3;
        let shuffel_count = document.getElementById("shuffel-count");
        shuffel_count.innerHTML = this.shuffelCount;
    }

    static loadScoreForCurrentPlayer() {
        $(document).ready(function () {
            $.ajax({
                type: 'POST',
                url: "/getScoreboardForCurrentPlayer",
                cache: false,
                data: "playerId=" + sessionStorage.getItem('current_player'),
                success: function (scoreBoard) {
                    Yahtzee.writeScoreForSection(scoreBoard["upperSection"], 'upper');
                    Yahtzee.writeTotalScoreForSection(scoreBoard["totalUpperSection"], 'upper');
                    Yahtzee.writeScoreForSection(scoreBoard["lowerSection"], 'lower');
                    Yahtzee.writeTotalScoreForSection(scoreBoard["totalLowerSection"], 'lower');
                }
            });
        });
    }

    static writeScoreForSection(sectionPoints, section) {
        for (let index = 0; index < sectionPoints.length; index++) {
            const score_element = sectionPoints[index];
            const row_selected = score_element["selected"];
            const score_cell = document.getElementById(section + '-score-cell-' + (index + 1));
            const row = score_cell.parentNode;
            if (row_selected) {
                Yahtzee.highlightRow(row);
                Yahtzee.styleSelectedRow(row);
            }
            score_cell.innerHTML = score_element["points"];
        }
    }

    static writeTotalScoreForSection(sectionPoints, section) {
        for (let index = 0; index < sectionPoints.length; index++) {
            const score_cell = document.getElementById('total-' + section + '-score-cell-' + (index + 1));
            score_cell.innerHTML = sectionPoints[index];
        }
    }

    static removeCheckMarks() {
        for (let index = 0; index < 5; index++) {
            let checkMarkId = "checkmark-" + (index + 1);
            let checkMark = document.getElementById(checkMarkId);
            if (checkMark.classList.contains("checkmark-selected")) {
                checkMark.classList.toggle("checkmark-selected");
                Yahtzee.selected_dice[index] = false;
            }
        }
    }

    static clearScoreTable() {
        let upper_table = document.getElementById("upper-table");
        let lower_table = document.getElementById("lower-table");

        Yahtzee.removeHighlightFromRow(upper_table);
        Yahtzee.removeHighlightFromRow(lower_table);

        Yahtzee.clearPredictionPoints('upper', 6);
        Yahtzee.clearPredictionPoints('lower', 7);

        Yahtzee.removeCheckMarks();
        Yahtzee.resetShuffelCount();
        Yahtzee.hideRandomDice();
    }

    static removeHighlightFromRow(table) {
        $("tr", table).each(function () {
            let row = this;
            if (row.classList.contains("row-highlighted")) {
                row.classList.remove("row-highlighted");
                row.classList.remove("row-selected");
                $("td", row).each(function () {
                    this.classList.remove("cell-highlighted");
                    this.classList.remove("cell-selected");
                })
            }
        })
    }

    static clearPredictionPoints(section, size) {
        for (let index = 0; index < size; index++) {
            let predict_point = document.getElementById(section + "-predict-cell-" + (index + 1));
            predict_point.innerHTML = 0;
        }
    }

    static hideRandomDice() {
        for (let index = 1; index <= 5; index++) {
            let dice = document.getElementById("" + index);
            dice.classList.add("dice-red-hidden");
        }
    }

    static showRandomDice() {
        for (let index = 1; index <= 5; index++) {
            let dice = document.getElementById("" + index);
            dice.classList.remove("dice-red-hidden");
        }
    }

    static showResultOverview() {
        let result_container = document.getElementById("result-container");
        result_container.classList.toggle("result-container-hidden");
    }

    static rankPlayers() {
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "/rank Players",
                cache: false,
                success: function (scoreBoard) {
                    Yahtzee.writeScoreForSection(scoreBoard["upperSection"], 'upper');
                    Yahtzee.writeTotalScoreForSection(scoreBoard["totalUpperSection"], 'upper');
                    Yahtzee.writeScoreForSection(scoreBoard["lowerSection"], 'lower');
                    Yahtzee.writeTotalScoreForSection(scoreBoard["totalLowerSection"], 'lower');
                }
            });
        });
    }
}