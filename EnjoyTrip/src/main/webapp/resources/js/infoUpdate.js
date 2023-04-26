let isUseId = true;
let pwSame = false;
var signUpBtn = document.querySelector("#btn-signup");
var updateBtn = document.querySelector("#updateBtn");

window.onload = function() {
	changeInfo();
};


function changeInfo() {
	console.log("갱신");
	changeName();
	changeId();
	changeEmail();
	changePw();
}

function changeName() {
	if (document.getElementById('name').value != null) {
		let name = document.getElementById('name').value;
		document.getElementById('Name-print').innerHTML = `${name}`;
	}
}
function changeId() {
	if (document.getElementById('id').value != null) {
		let id = document.getElementById('id').value;
		document.getElementById('id-print').innerHTML = `${id}`;
	}
}
function changeEmail() {
	if (document.getElementById('email').value != null) {
		let email = document.getElementById('email').value;
		document.getElementById('email-print').innerHTML = `${email}`;
	}
}
function changePw() {
	if (document.getElementById('pw').value != null) {
		let pw = document.getElementById('pw').value;
		let pwStar = '';
		for (let i = 0; i < pw.length; i++)
			pwStar += '*';
		document.getElementById('pw-print').innerHTML = pwStar;
	}
}

// 비밀번호 일치 확인
function isEqualPw() {
	let pw1 = document.querySelector("#pw").value;
	let pw2 = document.querySelector("#pw2").value;
	let pResultDiv = document.querySelector("#pwcheck-result");
	if (pw1 != pw2) {
		pResultDiv.textContent = "비밀번호가 일치하지 않습니다.";
		pwSame = false;
	} else {
		pResultDiv.textContent = "비밀번호가 일치합니다.";
		pwSame = true;
	}
	console.log("check");
	if(signUpBtn) activeSignup();
	if(updateBtn) activeUpdate();
	changeInfo();
}

// 아이디존재여부 확인
function isValidId(root){
	let id = document.querySelector("#id").value;
	let resultDiv = document.querySelector("#idcheck-result");
	console.log(id)
    $.ajax({
        type: 'GET',
        url: '/user/idcheck',
        data: { id: id },
        success: function(response) {
            if (response === 'available') {
                // 아이디가 사용 가능한 경우
		 		resultDiv.textContent = "사용 가능한 아이디입니다: "+ id;
		 		isUseId = false;
            } else {
                // 아이디가 이미 사용 중인 경우
		 		resultDiv.textContent = "이미 존재하는 아이디입니다: "+ id;
		 		isUseId = true;
            }
        }
    });
 	if(signUpBtn) activeSignup();
	if(updateBtn) activeUpdate();
 	changeInfo();
}

// 회원가입버튼 활성화 여부
function activeSignup(){
  if(document.querySelector("#id") != null) {
    if(!isUseId && pwSame){
    	signUpBtn.disabled=false;
    }else{
    	signUpBtn.disabled=true;
    }
  }
}
	
// 회원가입버튼 활성화 여부
function activeUpdate() {
	if (pwSame) {
		updateBtn.disabled = false;

	} else {
		updateBtn.disabled = true;
	}
}