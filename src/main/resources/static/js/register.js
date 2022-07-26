import UserChecking from "./UserChecking.js";

let signupForm = document.querySelector(".signupForm");
let usernameInput = document.querySelector(".usernameInput input");
let passwordInput = document.querySelector(".passwordInput input");
let rePasswordInput = document.querySelector(".rePasswordInput input");
let emailInput = document.querySelector(".emailInput input");
let usernameInputExpansion = document.querySelector(".usernameInput .expansionContainer");
let passwordInputExpansion = document.querySelector(".passwordInput .expansionContainer");
let rePasswordInputExpansion = document.querySelector(".rePasswordInput .expansionContainer");
let emailInputExpansion = document.querySelector(".emailInput .expansionContainer");
signupForm.onsubmit = (event) => {
    event.preventDefault();
    usernameInputExpansion.innerHTML = "";
    rePasswordInputExpansion.innerHTML = "";
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
    if (!UserChecking.isEmailValid(emailInput.value)) {
        valid = false;
        emailInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Email is not valid</p>
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

    if (!UserChecking.isPasswordMatch(passwordInput.value, rePasswordInput.value)) {
        valid = false;
        rePasswordInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Password is not match.</p>
            </div>`
    }
    if (valid) {
        signupForm.submit();
    }
}