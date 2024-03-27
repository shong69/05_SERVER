//유효성 검사 객체 생성
const checkObj = {
    "inputId" : false, //아이디
    "inputPw" : false, //비밀번호
    "inputPwConfirm" : false, //비번 확인
    "inputName" : false //닉네임
}; 


//아이디 유효성 검사
const inputId = document.getElementById("inputId");

inputId.addEventListener("change", function(){

    const regExp = /^[a-z][\w!@#$%^&*_-]{5,13}$/; //소문자 시작(1글자) + 나머지(5~13글자)=6~14글자

    if(regExp.test(this.value)){
        this.style.backgroundColor= "green";
        this.style.color = "white";

        checkObj.inputId= true;
    }else{
        this.style.backgroundColor= "red";
        this.style.color = "white";

        checkObj.inputId= false;
    }
})


const inputPw = document.getElementById("inputPw");
const inputPwConfirm=document.getElementById("inputPw2");
inputPwConfirm.addEventListener("keyup",function(){

    if(inputPw.value.length==0){
        this.value = "";
        alert("비밀번호를 먼저 입력해주세요");

        inputPw.focus(); //비밀번호 칸으로 커서 이동

        checkObj.inputPw = false;
    }
})

const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function(){

    if((inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    }else{

        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.inputPwConfirm = false;
    }
});
//비번, 비번확인란 각가 입력할 때마다 확인하도록 각자 작성해줌
inputPwConfirm.addEventListener("keyup", function(){

    if((inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    }else{

        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.inputPwConfirm = false;
    }
});

//닉네임 유효성 검사 (2~5글자 한글만 가능하도록)

const inputName = document.getElementById("inputName");

inputName.addEventListener("change", function(){
    const regExp = /^[가-힣]{2,5}$/;

    const nameMessage= document.getElementById("nameMessage");

    if(regExp.test(this.value)){
        nameMessage.innerText="정상입력";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.inputName = true;
    }else{
        nameMessage.innerText="2~5글자 한글만 입력하세요";
        nameMessage.classList.add("remove");
        nameMessage.classList.remove("confirm");
        checkObj.inputName = false;
    }
});






//최종적으로 유효성 검사 객체인 checkObj 안에 있는 모든 value 값이 true인지 확인해주는 함수
//만약 모두 true->서버로 submit
//만약 하나라도 false면 -> 유효성 검사가 완료되지 않았습니다 노출
function validate() {

    for(let key in checkObj){
        if(!checkObj[key]){
            alert("유효성 검사가 완료되지 않았습니다");
            return false;
        }
    }
    return true;
}

