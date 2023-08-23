// sign in
document.getElementById("signin").addEventListener("click", (e) => {
  e.preventDefault();
  console.log("helloo");

  const email = document.getElementById("email").value;
  const password = document.getElementById("pwd").value;

  if (email == "" || password == "") {
    alert("NOT VALID!");
  } else {
    const user = {
      email: email,
      password: password,
    };
    console.log(email, password);
    const url = "http://localhost:8081/login";
    const xhr = new XMLHttpRequest();
    xhr.open("POST", url);

    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.setRequestHeader("Content-Type", "application/json");

    // xhr.onreadystatechange = () => {
    //   if (xhr.status == 200 && xhr.readyState == 4) {
    //     const response = JSON.parse(xhr.responseText);
    //     console.log(response);
    //     if (response == null) {
    //       alert("NOT VALID!");
    //     } else {
    //       window.location.href = "welcome.html";
    //     }
    //   }
    // };
    xhr.onreadystatechange = (e) => {
      if (xhr.status == 200 && xhr.readyState == 4) {
        const response = JSON.parse(xhr.responseText);
        e.preventDefault();
        console.log(response);
        window.location.href = "welcome.html";
      }
    };
    xhr.send(JSON.stringify(user));
  }
});
