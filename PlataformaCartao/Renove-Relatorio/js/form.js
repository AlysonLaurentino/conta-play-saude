var botaoAdicionar = document.querySelector("#adicionar-cliente");
botaoAdicionar.addEventListener("click",async function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var cliente = obtemClienteDoFormulario(form);

    var erros = validaClientes(cliente);

    if (erros.length > 0) {
        exibeMensagensDeErro(erros);

        return ;
    }
    var resposta = await axios.post("http://localhost:8080/vendaconvertida", cliente);
    var dado = resposta.data;
    adicionaClienteNaTabela(dado);


    form.reset();

    var mensagensErro = document.querySelector("#mensagens-erro");
    mensagensErro.innerHTML = "";

});

function obtemClienteDoFormulario(form) {


    var cliente = {
        nomeCliente: form.nomeCliente.value,
        bombona: form.bombona.value,
        frequencia: form.frequencia.value,
        status: form.status.value,
        valor: form.valor.value,
        Obs: form.value,
        
    }

    return cliente;
}

function montaTr(cliente) {
    var clienteTr = document.createElement("tr");
    clienteTr.classList.add("cliente");

    clienteTr.appendChild(montaTd(cliente.nomeCliente, "info-nome"));
    clienteTr.appendChild(montaTd(cliente.bombona, "info-bombona"));
    clienteTr.appendChild(montaTd(cliente.frequencia, "info-frequencia"));
    clienteTr.appendChild(montaTd(cliente.status, "info-status"));
    clienteTr.appendChild(montaTd(cliente.valor, "info-valor"));
    clienteTr.appendChild(montaTd(cliente.Obs, "info-obs"));
    clienteTr.setAttribute('idCliente', cliente.id);
    //clienteTr.appendChild(montaTd(cliente.id, "info-id"));

    return  clienteTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}

function validaClientes(cliente) {

    var erros = [];

    if (cliente.nomeCliente.length == 0) {
        erros.push("O nome não pode ser em branco");
    }

    if (cliente.bombona.length == 0) {
        erros.push("A bombona não pode ser em branco");
    }


    if (cliente.frequencia.length == 0) {
        erros.push("A frequencia não pode ser em branco");
    }

    if (cliente.status.length == 0) {
        erros.push("A status não pode ser em branco");
    }

    if (cliente.valor.length == 0) {
        erros.push("A valor não pode ser em branco");
    }

 

    return erros;
}

function exibeMensagensDeErro(erros) {
    var ul = document.querySelector("#mensagens-erro");
    ul.innerHTML = "";

    erros.forEach(function(erro) {
        var li = document.createElement("li");
        li.textContent = erro;
        ul.appendChild(li);
    });
}

function adicionaClienteNaTabela(cliente) {
    var clienteTr = montaTr(cliente);
    var tabela = document.querySelector("#tabela-clientes");
    tabela.appendChild(clienteTr);
}
