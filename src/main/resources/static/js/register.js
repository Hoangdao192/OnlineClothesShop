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
    if (!isUsernameValid(usernameInput.value)) {
        valid = false;
        usernameInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Username is not valid</p>
            </div>`
    }
    if (!isEmailValid(emailInput.value)) {
        valid = false;
        emailInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Email is not valid</p>
            </div>`
    }

    if (!isPasswordValid(passwordInput.value)) {
        valid = false;
        passwordInputExpansion.innerHTML =
            `<div class="expansion error active">
                <img src="images/error.svg" alt="Error">
                <p class="message">Password is not valid.</p>
            </div>`
    }

    if (!isPasswordMatch(passwordInput.value, rePasswordInput.value)) {
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

function isUsernameValid(username) {
    if (username.length < 6 || username.length > 30) {
        console.log("false length");
        return false;
    }

    if (username.indexOf(" ") != -1) {
        console.log(username.indexOf(" "));
        console.log("contain space");
        return false;
    }

    for (let i = 0; i < username.length; ++i) {
        let char = username.toUpperCase()[i];
        if (!((char >= 'A' && char <= 'Z') || (char >= '0' && char <= '9'))) {
            console.log("false character");
            return false;
        }
    }
    return true;
}

function isEmailValid(email) {
    if (email.length == 0) {
        return false;
    }
    return true;
}

function isPasswordMatch(password, reEnterPassword) {
    return password === reEnterPassword;
}

function isPasswordValid(password) {
    if (password.length < 10 || password.length > 100) {
        return false;
    }
    if (password.indexOf(" ") != -1) {
        return false;
    }
    return true;
}