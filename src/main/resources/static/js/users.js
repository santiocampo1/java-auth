// Call the dataTables jQuery plugin
$(document).ready(function () {
  uploadUsers();
  $('#users').DataTable();
});

const uploadUsers = async () => {
  const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const users = await request.json();

  let listHtml = '';
  for (let user of users) {
    let userHtml = '<tr><td>' + user.id + '</td><td>' + user.name + '</td><td>' + user.email + '</td><td>' + user.phone + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
    listHtml += userHtml;
  }

  console.log(users);


  document.querySelector('#users tbody').outerHTML = listHtml;
}