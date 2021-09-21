var botaoEnviar = document.querySelector("#botao-enviar");
botaoEnviar.addEventListener("click",async function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var loginForm = obtemLoginDoFormulario(form);
 
    try{
    var token = await axios.post("http://www.playsaude.com.br:8080/auth", loginForm);
    var dado = token.data;

    var somaToken= dado.tipo+" "+dado.token;

    localStorage.setItem('TokenPlaySaude', somaToken);

    console.log(somaToken);

    alert ("Logado com sucesso");

    }catch (e){
        console.log(e);

        alert("Não foi possível logar");


    }
    
    form.reset();


});

function obtemLoginDoFormulario(form) {


    var login = {

                email: form.email.value,
                senha:form.senha.value,
                

        
    }

    return login;
}
