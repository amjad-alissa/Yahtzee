let selected_dice = [false, false, false, false, false];
let selected_row = null;
let shuffel_count = 3;

$(document).onload (function () {
    let shuffel_button = document.getElementById("shuffel-btn");
    shuffel_button.setAttribute("value", "" + shuffel_count);
})


function resetTransition() {
    this.classList.remove("dice-fade");
}

//Toggle the green checkmark beside the red dice
function toggleCheckMark(index) {
    let checkMarkId = "checkmark-" + index;
    let checkMark = document.getElementById(checkMarkId);
    checkMark.classList.toggle("checkmark-selected");
    selected_dice[index - 1] = checkMark.classList.contains("checkmark-selected");
}

function shuffelDices() {
    $(document).ready(function () {
        $("#shuffel-btn").click( function () {

            // Enable the button commit after a shuffel has been made
            let commit_button = document.getElementById("commit-btn");
            commit_button.classList.remove("commit-btn-disabled");

            $.ajax({
                url:"/player/randomShuffel",
                cache: false,
                data: "selectedDices=" + selected_dice,
                success: function (responseData) {
                    for (let index = 1; index <= 5; index++) {
                        if (!selected_dice[index - 1]) {
                            let img = document.getElementById("" + index);
                            img.src = responseData["diceSourceImages"][index - 1];
                            img.classList.add("dice-fade");
                            img.addEventListener("animationend", resetTransition);
                        }
                    }
                    for (let index = 1; index <= 6; index++) {
                        let predict_point = document.getElementById("upper-predict-cell-" + index);
                        predict_point.innerHTML = responseData["pointsUpperSection"][index - 1];
                    }

                    for (let index = 1; index <= 7; index++) {
                        let predict_point = document.getElementById("lower-predict-cell-" + index);
                        predict_point.innerHTML = responseData["pointsLowerSection"][index - 1];
                    }
                }
            });
        });
    })
}

function highlightSelectedRow(row) {
    let upper_table = document.getElementById("upper-table");
    let lower_table = document.getElementById("lower-table");

    //remove the highlight of the other rows which are nor yet selected
    // for the upper table
    removeHighlightFromElements(upper_table);

    //remove the highlight of the other rows which are nor yet selected
    // for the lower table
    removeHighlightFromElements(lower_table);

    // highlight the clicked row
    if (!row.classList.contains("row-selected")) {
        selected_row = row;
        row.classList.toggle("row-highlighted");

        //highlight the cells for this row
        $( "td", row).each(function () {
                this.classList.toggle("cell-highlighted");
        })
    }


    // alert(rowId);
}

function removeHighlightFromElements(table) {
    $("tr", table).each(function () {
        let row = this;
        if (!row.classList.contains("row-selected") && row.classList.contains("row-highlighted")) {
            row.classList.remove("row-highlighted");
            $( "td", row).each(function () {
                this.classList.toggle("cell-highlighted");
            })
        }
    })
}

// add styles to the selected row and make it unselectable
function styleSelectedRow() {
    selected_row.classList.add("row-selected");
    $( "td", selected_row).each(function () {
        this.classList.toggle("cell-selected");
    })
}

function commitShuffel() {
    styleSelectedRow();



/*    $(document).ready(function () {
        $("#commit-btn").click( function () {
            $.ajax({
                url:"/player/commitShuffel",
                cache: false,
                data: "selectedDices=" + selected_dice,
                success: function (randomDices) {
                    for (let i = 1; i <= 5; i++) {
                        if (!selected_dice[i - 1]) {
                            let img = document.getElementById(i);
                            img.src = randomDices[i - 1];
                            img.classList.add("dice-fade");
                            img.addEventListener("animationend", resetTransition);
                        }
                    }
                }
            });
        });
    });*/
}

