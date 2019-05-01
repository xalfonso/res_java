var keycloak = new Keycloak({
  url: '',
  realm: '',
  clientId: ''
});

window.onload = function () {
  keycloak.init({onLoad: 'login-required'})
    .success(function () {

      if (keycloak.authenticated) {
        showUserdata();
      }
      document.body.style.display = 'block';
    });
};

function showUserdata() {

  if (keycloak.tokenParsed['given_name']) {
    document.getElementById('firstName').innerHTML = keycloak.tokenParsed['given_name'];
  }
  if (keycloak.tokenParsed['family_name']) {
    document.getElementById('lastName').innerHTML = keycloak.tokenParsed['family_name'];
  }
  if (keycloak.tokenParsed['preferred_username']) {
    document.getElementById('username').innerHTML = keycloak.tokenParsed['preferred_username'];
  }
  if (keycloak.tokenParsed['email']) {
    document.getElementById('email').innerHTML = keycloak.tokenParsed['email'];
  }

  document.getElementById('token-content').innerHTML = JSON.stringify(keycloak.tokenParsed, null, '    ');
}

function performUserAction() {
  performAction("user")
}

function performAdminAction() {
  performAction("admin");
}

function performAction(path) {
  var url = 'http://localhost:8082/'+path;

    var req = new XMLHttpRequest();
    req.open('GET', url, true);
    req.setRequestHeader('Accept', 'application/json');
    req.setRequestHeader('Authorization', 'Bearer ' + keycloak.token);

    req.onreadystatechange = function () {
        if (req.readyState == 4) {
            if (req.status == 200) {
                alert('Success. Data is ' + req.responseText);
            } else if (req.status == 403) {
                alert('Forbidden');
            } else {
                alert('Error is ' + req.status);
            }
        }
    }

    req.send();
}
