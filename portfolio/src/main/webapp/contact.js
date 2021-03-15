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

const loadMessages = () => {
  fetch('/list-messages').then((response) => {
    response.json().then((messages) => {
      const messagesContainer = document.getElementById('messages_container');

      for (let message of messages) { 
        messagesContainer.appendChild(getMessageComponent(message));
      }
    })
  })
}

const getMessageComponent = message => {
  let container = document.createElement("div");
  
  // add span for name
  let nameSpan = document.createElement("div")
  nameSpan.innerHTML = "Name: " + message.name;

  // add span for subject
  let subjectSpan = document.createElement("div");
  subjectSpan.innerHTML = "Subject: " + message.subject;

  // add span for message
  let messageSpan = document.createElement("div");
  messageSpan.innerHTML = "Message: " + message.message;

  // add empty space underneath
  let space = document.createElement("br");

  // add elements to container
  container.appendChild(nameSpan);
  container.appendChild(subjectSpan);
  container.appendChild(messageSpan);
  container.appendChild(space);
  return container;
}

loadMessages();