var botaoAdicionar = document.querySelector("#adicionar-pipeline");
botaoAdicionar.addEventListener("click",async function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona1");

    var cliente = obtemPipelineDoFormulario(form);

    //var erros = validaClientes(cliente);

    // if (erros.length > 0) {
    //     exibeMensagensDeErro(erros);

    //     return ;
    // }
    var resposta = await axios.post("http://localhost:8080/pipeline", cliente);
    var dado = resposta.data;
    adicionaClienteNaTabela(dado);


    form.reset();

   // var mensagensErro = document.querySelector("#mensagens-erro");
   // mensagensErro.innerHTML = "";

});

function obtemPipelineDoFormulario(form) {


    var cliente = {
        clienteNome: form.nome.value,
        uF: form.UF.value,
        proposta: form.proposta.value,
        servico: form.servico.value,
        valor: form.valor.value,
        colaborador: form.colaborador.value,
        status: form.status.value,
        data: form.data.value,
        frequencia: form.frequencia.value,
        
    }

    return cliente;
}

function montaTr(cliente) {
    var clienteTr = document.createElement("tr");
    clienteTr.classList.add("cliente");

    clienteTr.appendChild(montaTd(cliente.clienteNome, "info-cliente"));
    clienteTr.appendChild(montaTd(cliente.uF, "info-uF"));
    clienteTr.appendChild(montaTd(cliente.proposta, "info-proposta"));
    clienteTr.appendChild(montaTd(cliente.servico, "info-servico"));
    clienteTr.appendChild(montaTd(cliente.valor, "info-valor"));
    clienteTr.appendChild(montaTd(cliente.colaborador, "info-Colaborador"));
    clienteTr.appendChild(montaTd(cliente.status, "info-status"));
    clienteTr.appendChild(montaTd(cliente.data, "info-data"));
    clienteTr.appendChild(montaTd(cliente.frequencia, "info-frequencia"));
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
