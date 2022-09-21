import UserChecking from "./UserChecking.js";

let loginForm = document.querySelector(".loginForm");
let usernameInput = document.querySelector(".usernameInput input");
let passwordInput = document.querySelector(".passwordInput input");
let usernameInputExpansion = document.querySelector(".usernameInput .expansionContainer");
let passwordInputExpansion = document.querySelector(".passwordInput .expansionContainer");
loginForm.onsubmit = (event) => {
    event.preventDefault();
    usernameInputExpansion.innerHTML = "";
    passwordInputExpansion.innerHTML = "";
    let valid = true;
    if (!UserChecking.isUsernameValid(usernameInput.value)) {
        valid = false;
        usernameInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Username is not valid</p>
            </div>`
    }

    if (!UserChecking.isPasswordValid(passwordInput.value)) {
        valid = false;
        passwordInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Password is not valid.</p>
            </div>`
    }

    if (valid) {
        loginForm.submit();
    }
}