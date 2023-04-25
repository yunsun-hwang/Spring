window.onload = function () {
    let logInOrNot = localStorage.getItem('login');
    console.dir(logInOrNot);
    if (logInOrNot === 'true') {
      document.querySelector('#member-btns-logout').setAttribute('style', 'display: none');
      document.querySelector('#member-btns-login').setAttribute('style', 'display: block');
      //   document.getElementById('member-btns-logout').style.display = 'none';
      //   document.getElementById('member-btns-login').style.display = 'block';
    } else {
      document.querySelector('#member-btns-logout').setAttribute('style', 'display: block');
      document.querySelector('#member-btns-login').setAttribute('style', 'display: none');
    }
  };
  
  // 로그인
  function login() {
    // 사용자 정보를 입력받는다.
    // var userid = prompt("아이디입력", "ssafy");
    var userid = document.getElementById('floatingInput').value;
    if (userid.length == 0) {
      alert('아이디 입력!!!');
      return;
    }
    // var userpass = prompt("비밀번호입력", "1234");
    var userpass = document.getElementById('floatingPassword').value;
    if (userpass.length == 0) {
      alert('비밀번호 입력!!!');
      return;
    }
    if (userid == 'ssafy' && userpass == '1234') {
      alert('로그인 성공!!!');
      localStorage.setItem('login', 'true');
      window.location.replace('index.html');
    } else {
      alert('아이디 또는 비밀번호 확인!!!');
    }
  }
  
  // 로그아웃
  function logout() {
    /* document.getElementById("profile_img").src = "img/profile.png";
        document.getElementById("header_nav_confirmon").style.display = "none";
        document.getElementById("header_nav_confirmoff").style.display = "block"; */
    // id가 profile_img인 element의 src 속성의 값을 img/noimg.png로 설정.
    localStorage.setItem('login', 'false');
    window.location.replace('index.html');
  }
  