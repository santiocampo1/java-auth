// Call the dataTables jQuery plugin
$(document).ready(function () {
    // on ready
});


// POST user.
const registerUser = async () => {
    let data = {};

    data.name = document.querySelector('#txtName').value;
    data.lastName = document.querySelector('#txtLastName').value;
    data.email = document.querySelector('#txtEmail').value;
    data.password = document.querySelector('#txtPassword').value;
    data.confirmPassword = document.querySelector('#txtRepeatPassword').value;

    let repeatPassword = document.querySelector('#txtRepeatPassword').value;

    if (repeatPassword != data.password) {
        alert('Passwords do not match');
        return;
    }


    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const users = await request.json();


}