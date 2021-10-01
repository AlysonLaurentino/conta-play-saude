var buscarlojas = document.querySelector("#buscar-lojas");
var tabelas = document.querySelector("#tabela-loja");



buscarlojas.addEventListener("click",async function(event) {
    event.preventDefault();

    tabelas.innerHTML= "";

    var tokenRecuperado =  localStorage.getItem("TokenPlaySaude");
   
   if(tokenRecuperado == null){
    window.location.href = "login.html";

   }

   const config = {
    headers: { Authorization: tokenRecuperado}
    };

    axios.get("http://www.playsaude.com.br:8080/loja", config)
    .then(lojasDados => {

    var dado = lojasDados.data;

    var Lojas = dado;
    
     Lojas.forEach(function(loja){

    adicionaNoBloco(loja);
    
    });

    }).catch(erro => {
    console.log(erro);
    if(erro.response.status === 403){
        localStorage.removeItem("TokenPlaySaude");
        window.location.href = "login.html";

    }
    })


    function montaUL(loja){

        var endereco = loja.endereco.logradouro+", "+loja.endereco.numero+", "+loja.endereco.cep+", "+loja.endereco.bairro+", "+
        loja.endereco.municipio+"-"+loja.endereco.uf+"."
       
        var lojaUL = document.createElement("ul");
        lojaUL.classList.add("loja");

        var imagem = document.createElement("img");
        //imagem.src= "http://www.playsaude.com.br:8080/dawlond/"+loja.nomeFotoLogo;
        imagem.src = "Playnasaude1.jpg";

        var informacao = document.createElement("div");
        informacao.className="bloco";
    
        informacao.appendChild(montali(loja.nomeFantasia, "nomeFantasia"));
        informacao.appendChild(montali(loja.descricaoPromocao, "descricaoPromocao"));
        informacao.appendChild(montali("Endereço "+ endereco, "endereco"));
        informacao.appendChild(montali("Horario de Funcionamento "+ loja.funcionamento, "funcionamento"));
       
        var todosTelefones = [];

        loja.telefones.forEach(telefone => {

            if(telefone.dd != null && telefone.numero != null){
            var tel = "("+telefone.dd+") "+telefone.numero+" "
    
            todosTelefones.push(tel);
            }

        })

        informacao.appendChild(montali("Telefone: "+todosTelefones.join(" | "), "telefone"));


        // var todasCategorias = [];

         loja.categorias.forEach(categoria => {
             console.log(categoria);

        //     if(categoria!=null){
        //     todasCategorias.push(categoria);
        //     }
         })

        // informacao.appendChild(montali("Serviços: "+todasCategorias.join(" | "), "servico"));

        var imagemBloco= document.createElement("div");
        imagemBloco.className="bloco";

        imagemBloco.appendChild(imagem);

        var linhaBloco = document.createElement("div");
        linhaBloco.className="linha-horizontal";
        linhaBloco.appendChild(imagemBloco);
        linhaBloco.appendChild(informacao);

        lojaUL.appendChild(linhaBloco);

        return  lojaUL;
    }
    
    function montali(dado, classe) {
        var li = document.createElement("li");
        li.classList.add(classe);
        li.textContent = dado;
    
        return li;
    }

    function adicionaNoBloco(loja) {
        var lojaUL = montaUL(loja);
        var bloco = document.querySelector("#tabela-loja");
        bloco.appendChild(lojaUL);
    }

   

});
