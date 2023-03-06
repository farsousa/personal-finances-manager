function openDialog(dialogName) {
   document.getElementById("overlay").style.display = "block";
   document.getElementById("" + dialogName).style.display = "block";
}

function closeDialog(dialogName) {
   document.getElementById("overlay").style.display = "none";
   document.getElementById("" + dialogName).style.display = "none";
}

var selectedChips = {};

function selectChip(chip) {
   var groupId = chip.parentElement.id;
   if (selectedChips[groupId] != null) {
      selectedChips[groupId].classList.remove("selected");
   }
   chip.classList.add("selected");
   selectedChips[groupId] = chip;
}


