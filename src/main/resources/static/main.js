let selected_dice = [false, false, false, false, false];


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
            $.ajax({
                url:"/player/randomShuffel",
                cache: false,
                data: "selectedDices=" + selected_dice,
                success: function (responseData) {
                    for (let i = 1; i <= 5; i++) {
                        if (!selected_dice[i - 1]) {
                            let img = document.getElementById(i);
                            img.src = responseData["diceSourceImages"][i - 1];
                            img.classList.add("dice-fade");
                            img.addEventListener("animationend", resetTransition);
                        }
                    }
                    for (let i = 1; i <= 6; i++) {
                        let predict_point = document.getElementById("upper-predict-cell-" + i);
                        predict_point.innerHTML = responseData["pointsUpperSection"][i - 1];
                    }

                    for (let i = 1; i <= 7; i++) {
                        let predict_point = document.getElementById("lower-predict-cell-" + i);
                        predict_point.innerHTML = responseData["pointsLowerSection"][i - 1];
                    }
                }
            });
        });
    })
}

/*function commitShuffel() {
    $(document).ready(function () {
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
    });
}*/

