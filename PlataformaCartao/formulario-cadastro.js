
var pagina_atual = 1;

function proximoForm(ordemCrescente){
    //1. procurar quem está ativo e desabilitar a classe "Active". OK
    var fieldSetActive = document.querySelector(".active");
    fieldSetActive.className = "";

    //2. Trocar a pagina pega a atual soma mais 1. OK
    
    
    if(ordemCrescente){
        pagina_atual += 1;

    }else{
        pagina_atual -= 1;
    }

    //3. Procuro a próxima página atual e coloco a classe com valor =  "active"


    var proximaPagina = document.querySelector("#formulario-" + pagina_atual);

    proximaPagina.className = "active";

}


// 5. ao Clicar no botão #proximo-form ele deve chamar a próxoma pagina

var botaoProximo = document.querySelectorAll("#proximo-form");
botaoProximo.forEach(function(proximoBotao){
    proximoBotao.addEventListener("click",async function(event) {
        event.preventDefault();// desabilita os eventos do JS = não envia o formulario
    
        proximoForm(true);
    });
    
})

var botaoAnterior = document.querySelectorAll("#anterior-form");
botaoAnterior.forEach(function(botaoAnteriorBotao){
    botaoAnteriorBotao.addEventListener("click",async function(event) {
        event.preventDefault();// desabilita os eventos do JS = não envia o formulario
    
        proximoForm(false);
    });
    
})

