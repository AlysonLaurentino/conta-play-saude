var buscar = document.querySelector("#buscarParceria");
var tabelas = document.querySelector("#tabela-parcerias");

buscar.addEventListener("click",async function(event) {
    event.preventDefault();

    tabelas.innerHTML= "";

   var tokenRecuperado =  localStorage.getItem("TokenPlaySaude");
   
   if(tokenRecuperado == null){
    window.location.href = "login.html";

   }

   const config = {
    headers: { Authorization: tokenRecuperado}
    };

  
    axios.get("http://www.playsaude.com.br:8080/parceria", config)
    .then(parceriaDados => { 

        var dado = parceriaDados.data;

    var parcerias = dado;
    
     parcerias.forEach(function(parceria){

    adicionaNoBloco(parceria);
    
    
    });

    }).catch(erro => {
        console.log(erro);
        if(erro.response.status === 403){
            localStorage.removeItem("TokenPlaySaude");
            window.location.href = "login.html";

        }

    })
    

    function montaUL(parceria){

        var endereco = parceria.endereco.logradouro+", "+parceria.endereco.numero+", "+parceria.endereco.cep+", "+parceria.endereco.bairro+", "+
        parceria.endereco.municipio+"-"+parceria.endereco.uf+"."
       
        var parceriaUL = document.createElement("ul");
        parceriaUL.classList.add("parceria");

        var imagem = document.createElement("img");
       // imagem.src= "hhttp://www.playsaude.com.br:8080/dawlond/"+parceria.nomeFotoLogo;
       imagem.src = "Playnasparcerias.jpg";



        var informacao = document.createElement("div");
        informacao.className="bloco";
    
        informacao.appendChild(montali(parceria.nomeFantasia, "nomeFantasia"));
        informacao.appendChild(montali(parceria.descricaoPromocao, "descricaoPromocao"));
        informacao.appendChild(montali("Endereço: "+endereco, "endereco"));

        var todosTelefones = [];

        parceria.telefones.forEach(telefone => {

            if(telefone.dd != null && telefone.numero != null){
                var tel = "("+telefone.dd+") "+telefone.numero+" "
        
                todosTelefones.push(tel);
                }    

        
        })

        informacao.appendChild(montali("Telefone: "+todosTelefones.join(" | "), "telefone"));


        var imagemBloco= document.createElement("div");
        imagemBloco.className="bloco";
    
        imagemBloco.appendChild(imagem);


        var linhaBloco = document.createElement("div");
        linhaBloco.className="linha-horizontal";
        linhaBloco.appendChild(imagemBloco);
        linhaBloco.appendChild(informacao);

        parceriaUL.appendChild(linhaBloco);

        return   parceriaUL;
    }
    
    function montali(dado, classe) {
        var li = document.createElement("li");
        li.classList.add(classe);
        li.textContent = dado;
    
        return li;
    }

    function adicionaNoBloco(parceria) {
        var parceriaUL = montaUL(parceria);
        var bloco = document.querySelector("#tabela-parcerias");
        bloco.appendChild(parceriaUL);
    }
});
