function login(){
    let email = document.getElementById('email').value;
    let senha = document.getElementById('senha').value;
    if(email=="adm@adm123.com" && senha=="adm"){
        window.location.href = "/index.html"
        alert("LOGADO!")
    } else{
        alert("Usuário ou senha inválidos")
    }
}

var nomecadastro = document.getElementById('nomecadastro');
var usuariocadastro = document.getElementById('usuariocadastro');
var emailcadastro = document.getElementById('emailcadastro');
var senhacadastro = document.getElementById('senhacadastro');
var senhacadastroconfirm = document.getElementById('senhacadastroconfirm');
var dados = JSON.parse(localStorage.getItem("dadoscadastro"));

function cadastro(){

    if(senhacadastro.value != senhacadastroconfirm.value){
        alert("Senhas incompatíveis")
    } else{
        fetch("http://localhost:8081/cadastrar", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
          
            body: JSON.stringify({
                nome : nomecadastro.value,
                email : emailcadastro.value,
                senha : senhacadastro.value,
                usuario: usuariocadastro.value
            })
        }).then(function(res){console.log(res)})
          .catch(function(res){console.log(res)})
    
            localStorage.setItem("dadoscadastro", JSON.stringify(dados));
            window.location.href = "/SITE/index.html"
    }
    }

function limpar(){
    localStorage.clear();
}