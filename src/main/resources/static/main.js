let selected_dice = [false, false, false, false, false];
let selected_dice_values = [0, 0, 0, 0, 0];

/*let number_of_shuffles = 3;
let shuffle_button = null;
function initializeCounters() {
    shuffle_button = document.getElementById("#shuffel-btn");
    shuffle_button.value = number_of_shuffles;
}*/

function resetTransition() {
    this.classList.remove("dice-fade");
}

//Shuffle the dice and set the images accordingly
function shuffelDices() {
    // if (number_of_shuffles > 0) {
    //     number_of_shuffles -= 1;
    //     this.setAttribute("value", "" + number_of_shuffles);

    let dice_red_array = ['one-red.png', 'two-red.png', 'three-red.png', 'four-red.png', 'five-red.png', 'six-red.png'];
    for (let i = 1; i <= 5; i++) {
        if (!selected_dice[i - 1]) {
            let random_index = Math.floor(Math.random() * dice_red_array.length);
            let dice_name = dice_red_array[random_index];
            let img = document.getElementById("dice-" + i);
            img.src = '/media/dice/' + dice_name;
            img.classList.add("dice-fade");
            img.addEventListener("animationend", resetTransition);
            selected_dice_values[i - 1] = random_index;

        }
    }
    // }
}

//Toggle the green checkmark beside the red dice
function toggleCheckMark(index) {
    let checkMarkId = "checkmark-" + (index + 1);
    let checkMark = document.getElementById(checkMarkId);
    if (checkMark.style.display === "none") {
        checkMark.style.display = "block";
        selected_dice[index] = true;
    } else {
        checkMark.style.display = "none";
        selected_dice[index] = false;
    }
}