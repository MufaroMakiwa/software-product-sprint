let userName = false, userEmail = false, subject = false, message = false;
let buttonDisabled = true;

const onNameChange = (element) => {
  value = element.value;
  value !== "" ? userName = true : userName = false;
  enableSubmitButton();
}

const onEmailChange = (element) => {
  value = element.value;
  value !== "" ? userEmail = true : userEmail = false;
  enableSubmitButton();
}

const onSubjectChange = (element) => {
  value = element.value;
  value !== "" ? subject = true : subject = false;
  enableSubmitButton();
}

const onMessageChange = (element) => {
  value = element.value;
  value !== "" ? message = true : message = false;
  enableSubmitButton();
}

const enableSubmitButton = () => {
  if (userName && userEmail && subject && message) {
    if (buttonDisabled) {
      // enable button
      document.getElementById("submit_button").disabled = false;
    }
  } else {
    if (!buttonDisabled) {
      // disable button
      document.getElementById("submit_button").disabled = true;
    }
  }
}

