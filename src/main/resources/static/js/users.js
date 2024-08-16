// Call the dataTables jQuery plugin
$(document).ready(function () {
  uploadUsers();
  $('#users').DataTable();
});


// GET all users.
const uploadUsers = async () => {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  const users = await request.json();

  let listHtml = '';

  for (let user of users) {
    let deleteButton = '<a href="#" onClick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let userHtml = '<tr><td>'
      + user.id + '</td><td>'
      + user.name + '</td><td>'
      + user.email + '</td><td>'
      + user.phone + '</td><td>'
      + deleteButton + '</td></tr>';

    listHtml += userHtml;
  }

  document.querySelector('#users tbody').outerHTML = listHtml;
}

// DELETE user by ID.
const deleteUser = async (id) => {

  if (!confirm('Are you sure you want to delete this user?')) {
    return;
  }

  const request = await fetch('api/users/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });

  location.reload();
}