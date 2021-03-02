const getMessage = async () => {
  const responseFromServer = await fetch('/hello');
  const textFromResponse = await responseFromServer.text();
  console.log(textFromResponse);
  const helloContainer = document.getElementById('server-text-container');
  helloContainer.innerText = textFromResponse;
}