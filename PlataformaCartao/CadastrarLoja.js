var botaoEnviar = document.querySelector("#botao-enviar");
botaoEnviar.addEventListener("click",async function(event) {
    event.preventDefault();

    var tokenRecuperado =  localStorage.getItem("TokenPlaySaude");
   
   if(tokenRecuperado == null){
    window.location.href = "login.html";

   }

    var foto = document.querySelector("#arquivos").files[0];

    var form = document.querySelector("#form-adiciona");

    var loja = obtemLojaDoFormulario(form);
 

    var formData =  new FormData();
    formData.append("lojaForm", JSON.stringify(loja));
    formData.append("foto", foto);

    fetch('http://www.playsaude.com.br:8080/loja', {
            method: 'POST',
            body: formData,
            headers: new Headers({
                'Authorization': tokenRecuperado, 
              }) 
        })
        .then(response => {
            if(!response.ok)
                throw new Error("não foi possível completar cadastro");

            return response.text();
        })
        .then(data => alert(data))

    }

 );

function obtemLojaDoFormulario(form) {

    var tels= []
    for(var i = 0; i<form.tel.length;i++){
        tels.push({
    
            telefone:form.tel[i].value,
            eWhatsApp:form.eWhatsApp[i].value,
        })
    
    }
    
    var categorias= []
    for(var i = 0; i<form.categoria.length;i++){
        categorias.push({
    
            titulo:form.categoria[i].value,
    
        })
    }
    
    var loja = {

                nomeFantasia: form.fantasia.value,
                funcionamento:form.funcionamento.value,
                descricaoPromocao: form.descricaoPromo.value,
                endereco: 
                    {
                        logradouro: form.logradouro.value,
                        numero: form.numero.value,
                        bairro:form.bairro.value,
                        municipio:form.municipio.value,
                        uf:form.uf.value,
                        cep:form.cep.value,
                        complemento:form.complemento.value
                    },

                    telefonesForm: tels,

                    categorias: categorias,        
    }

    return loja;
}
