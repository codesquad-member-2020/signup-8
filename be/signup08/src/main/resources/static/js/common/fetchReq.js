const { URL, URLSearchParams } = require("url");

const fetchRequest = (url, data) => {
  const apiUrl = new URL(url);
  apiUrl.search = new URLSearchParams(data).toString();

  return fetch(apiUrl, {
    method: "GET",
    mode: "cors",
    cache: "no-cache",
    headers: {
      "Content-Type": "application/json"
    }
    // body: JSON.stringify(data)
  });
};

export { fetchRequest };
