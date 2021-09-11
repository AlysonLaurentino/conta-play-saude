var cliente = document.querySelectorAll(".cliente");

var tabela = document.querySelector("#tabela-clientes");

tabela.addEventListener("dblclick", async function(event) {
 
       var linha = event.target.parentNode;

       var id = linha.getAttribute("idCliente");
       console.log(id);
       var resposta = await axios.delete("http://localhost:8080/vendaconvertida"+id);


             if(resposta.status == 200){
                linha.remove();

             }else{
                 alert("Não foi possível");
             }

       //var colunaLinha = linha.children;

    //    for(var i = 0; i<colunaLinha.length; i++){

    //      var th= colunaLinha[i];

    //      if(th.className == "info-id"){

    //          var id = th.innerHTML;

    //          var resposta = await axios.delete("http://localhost:8080/vendaconvertida/"+id);

    //          console.log(resposta);

    //          if(resposta.status == 200){
    //             linha.remove();

    //          }else{
    //              alert("Não foi possível");
    //          }

    //         break;
    //      }

    //    }
      
});


function recupera(clienteTr){
    var clienteId ={
        id: clienteTr.id.value,
    }

    return clienteId;
}
