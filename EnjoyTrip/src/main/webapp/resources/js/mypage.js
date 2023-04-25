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
	if(document.getElementById('name').value != null){
		let name = document.getElementById('name').value;
		document.getElementById('Name-print').innerHTML = `${name}`;
	}
}
function changeId() {
	if(document.getElementById('id').value != null){
		let id = document.getElementById('id').value;
		document.getElementById('id-print').innerHTML = `${id}`;
	}
}
function changeEmail() {
	if(document.getElementById('email').value != null){
		let email = document.getElementById('email').value;
		document.getElementById('email-print').innerHTML = `${email}`;
	}
}
function changePw() {
	if(document.getElementById('pw').value != null){
		let pw = document.getElementById('pw').value;
		let pwStar = '';
		for (let i = 0; i < pw.length; i++)
			pwStar += '*';
		document.getElementById('pw-print').innerHTML = pwStar;
	}
}
