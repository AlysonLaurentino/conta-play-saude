var buscarlojas = document.querySelector("#buscar-lojas");
var tabelas = document.querySelector("#tabela-lojas");
var logo = document.querySelector("#logolojas");


buscarlojas.addEventListener("click",async function(event) {
    event.preventDefault();

    tabelas.innerHTML= "";
   
    var lojasDados = await axios.get("http://localhost:8080/loja");
    var dado = lojasDados.data;

    var Lojas = dado;
    console.log(Lojas);    
    
     Lojas.forEach(function(loja){

    adicionaNoBloco(loja);

  
    
    });

    function montaUL(loja){
       
        var lojaUL = document.createElement("ul");
        lojaUL.classList.add("loja");

        var imagem = document.createElement("img");
        imagem.src= "http://localhost:8080/dawlond/"+loja.nomeFotoLogo;
    
        lojaUL.appendChild(montali(loja.nomeFantasia, "info-padrao"));
        lojaUL.appendChild(montali(loja.funcionamento, "info-padrao"));
        lojaUL.appendChild(montali(loja.precoConsulta, "info-padrao"));
       // lojaUL.appendChild(montali(loja.endereco, "info-padrao"));
      //  lojaUL.appendChild(montali(loja.categorias, "info-padrao"));
      //  lojaUL.appendChild(montali(loja.telefones, "info-padrao"));
        lojaUL.appendChild(imagem);
       // lojaTr.appendChild(montaTd(loja.precoConsulta, "info-padrao"));

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
        var bloco = document.querySelector("#tabela-lojas");
        bloco.appendChild(lojaUL);
    }

    function montaTr(loja) {
       
        var lojaTr = document.createElement("tr");
        lojaTr.classList.add("loja");
    
        lojaTr.appendChild(montaTd(loja.nomeFantasia, "info-padrao"));
        lojaTr.appendChild(montaTd(loja.funcionamento, "info-padrao"));
       // lojaTr.appendChild(montaTd(loja.precoConsulta, "info-padrao"));

        return  lojaTr;
    }
    
    function montaTd(dado, classe) {
        var td = document.createElement("td");
        td.classList.add(classe);
        td.textContent = dado;
    
        return td;
    }

    function adicionaNaTabela(loja) {
        var lojaTr = montaTr(loja);
        var tabela = document.querySelector("#tabela-lojas");
        tabela.appendChild(lojaTr);
    }



});
