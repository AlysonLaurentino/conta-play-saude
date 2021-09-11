var buscarCliente = document.querySelector("#buscar-clientes");
var tabelas = document.querySelector("#tabela-clientes");

buscarCliente.addEventListener("click",async function(event) {
    event.preventDefault();

    tabelas.innerHTML= "";
   
    var resposta = await axios.get("http://localhost:8080/pipeline");
    var dado = resposta.data;

    var vendas = dado;
    console.log(vendas);    
    
    vendas.forEach(function(venda){

    adicionaClienteNaTabela(venda);
    
    });



});
