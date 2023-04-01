function openDialog(dialogName, formName) {
	const dialog = document.querySelector('#' + dialogName);
	const overlay = dialog.querySelector('#overlay');
	const forms = dialog.querySelectorAll('form');
	
	
	console.log(forms)
	console.log(overlay)
	console.log(dialog)
	
	overlay.setAttribute('style', 'display: block');
	dialog.setAttribute('style', 'display: block');
	forms.forEach((form, index) => {
		if(formName === form.id) {
			form.setAttribute('style', 'display: block');
		}else {
			form.setAttribute('style', 'display: none');
		}
	})
}

function closeDialog(dialogName) {
	const dialog = document.querySelector('#' + dialogName);
	const overlay = dialog.querySelector('#overlay');
	const forms = dialog.querySelectorAll('form');
	
	overlay.setAttribute('style', 'display: none');
	dialog.setAttribute('style', 'display: none');
	forms.forEach((form, index) => {
		form.setAttribute('style', 'display: none');
	})
}

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
}


