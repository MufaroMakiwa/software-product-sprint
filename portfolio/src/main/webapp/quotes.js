let messages = null;

const getMessages = async () => {
  const responseFromServer = await fetch('/hello');
  messages = await responseFromServer.json();
  addToPage();
}


const addToPage = () => {
  // Pick a random greeting.
  const quote = messages[Math.floor(Math.random() * messages.length)];

  // Add message to DOM
  const helloContainer = document.getElementById('server-text-container');
  helloContainer.innerText = quote;
}


/**
 * Get a random message from the server and add it to the page
 */
const getRandomMessage = async () => {
  (messages === null) ? getMessages() : addToPage();
}