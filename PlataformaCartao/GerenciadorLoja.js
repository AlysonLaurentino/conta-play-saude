var botaoEnviar = document.querySelector("#botao-enviar");
botaoEnviar.addEventListener("click",async function(event) {
    event.preventDefault();

    var foto = document.querySelector("#arquivos").files[0];

    var form = document.querySelector("#form-adiciona");

    var loja = obtemLojaDoFormulario(form);
 

    var formData =  new FormData();
    formData.append("lojaForm", JSON.stringify(loja));
    formData.append("foto", foto);

    fetch('http://localhost:8080/loja', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if(!response.ok)
                throw new Error("não foi possível completar cadastro");

            return response.text();
        })
        .then(data => alert(data))

    }

//     try{
//     await axios.post("http://localhost:8080/loja", formData);
//     alert ("Loja Cadastrada com sucesso");

//     }catch (e){
//         console.log(e);

//         alert("Tente Novamente Loja não cadastrado");


//     }
    
//     form.reset();


 );


function obtemLojaDoFormulario(form) {


    var loja = {

                nomeFantasia: form.fantasia.value,
                funcionamento:form.funcionamento.value,
                precoConsulta: form.precoConsulta.value,
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

                telefonesForm: [
                    {
                        telefone:form.tel.value,
                        eWhatsApp:form.eWhatsApp.value,
                       
                    }],

                categorias: [
                    {
                        titulo:form.categoria.value
                    }

                ]

        
    }

    return loja;
}

