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

export default {
    isEmailValid,
    isPasswordValid,
    isPasswordMatch,
    isUsernameValid
}