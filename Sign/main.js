document.getElementById("signup").addEventListener("click", (e) => {
  e.preventDefault();
  // console.log('Hello...')
  document.getElementById("inputName").style.display = "flex";
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("pwd").value;
  const user = {
    // key(db_col_name:value(text_box_variable))
    name: name,
    email: email,
    password: password,
  };

  const url = "http://localhost:8081/users";
  const xhr = new XMLHttpRequest();
  xhr.open("POST", url);
  xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = () => {
    if (xhr.status == 200 && xhr.readyState == 4) {
      const response = JSON.parse(xhr.responseText);
      console.log(response);
      window.location.href = "welcome.html";
    }
  };
  xhr.send(JSON.stringify(user));
});
