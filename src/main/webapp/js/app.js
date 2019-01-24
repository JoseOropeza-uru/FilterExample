function $(id){
    return document.getElementById(id);
}

function login() {
    if ($('ced').value.trim()!=""&&$('password').value.trim()!=""){
        let body = {
            ced:$('ced').value.trim(),
            password:$('password').value.trim()
        };
        fetch("./session",{body:JSON.stringify(body),method:"POST"}).then((res)=>res.json()).then(data=>{
            console.log(data);
        })
    } else{
        alert("Campos incompletos.")
    }
}

function logout(){
    fetch("./logout").then(res=>res.json()).then(data=>console.log(data));
}

function getSession(){
    fetch("./session-info").then(res=>res.json()).then(data=>console.log(data));
}

$('login').addEventListener('click',login);
$('logout').addEventListener('click',logout);
$('getSession').addEventListener('click',getSession);
