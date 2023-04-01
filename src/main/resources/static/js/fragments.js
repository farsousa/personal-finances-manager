var selectedChips = {};

function selectChip(chip, linkedRadioName) {
   var groupId = chip.parentElement.id;
   if (selectedChips[groupId] != null) {
      selectedChips[groupId].classList.remove("selected");
   }
   chip.classList.add("selected");
   selectedChips[groupId] = chip;

   const radio = document.getElementById(linkedRadioName);
   radio.checked  =true;
