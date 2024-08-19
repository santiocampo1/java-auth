// Call the dataTables jQuery plugin
$(document).ready(function () {
    // on ready
});


// POST user.
const login = async () => {
    let data = {};

    data.email = document.querySelector('#txtEmail').value;
    data.password = document.querySelector('#txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const response = await request.text();

    if (response == 'OK') {
        window.location.href = 'users.html'
    } else {
        alert("Credentials are not valid. Please try again.");
    }


}