
var listaCargaHoraria = [];

var adicionarCargaHoraria = document.querySelector("#adicionar-cargaH")
adicionarCargaHoraria.addEventListener("click",async function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona") 
    console.log(form);
    var cargaHoraria = obtemCargaHoraria(form);
    listaCargaHoraria.push(cargaHoraria);

    console.log(listaCargaHoraria);

    form.reset();

});
var botaoEnviar = document.querySelector("#botao-enviar");
botaoEnviar.addEventListener("click",async function(event) {
    event.preventDefault();

    var form = document.querySelector("#form-adiciona");

    var Medico = obtemMedicoDoFormulario(form);

    try{
    await axios.post("http://localhost:8080/medico", Medico);
    alert ("Médico Cadastrado com sucesso");

    }catch (e){
        console.log(e);

        alert("Tente Novamente Médico não cadastrado");


    }
    
    form.reset();


});

function obtemCargaHoraria(form){

    var Medico = {
       
        agendaForm:{
            tempoMedConsulta:form.tempomedio.value,
            cargaHorariasForm:[
                {
                    diaSemana:form.diaSemana.value,
                    horarioAtendimentoForm:[
                        {
                            inicio:form.inicio.value,
                            fim:form.fim.value,
                            salasForm:[
                                {
                                    nome:form.sala.value
                                }
                            ]
                        }
                    ]
                }
            ]

        }

    }
    return Medico;
}

function obtemMedicoDoFormulario(form) {


    var Medico = {

        funcionarioForm:{
            pessoa:{
                nome: form["nome-completo"].value,
                datanascimento: form["data-nascimento"].value,
                cpf: form.cpf.value,
                rg: form.rg.value,
                enderecosForm: [ 
                    {
                        ruaav: form.rua.value,
                        numero: form.numero.value,
                        bairro:form.bairro.value,
                        cidade:form.cidade.value,
                        UF:form.uf.value,
                        cep:form.cep.value,
                    }
                ],
                telefonesForm: [
                    {
                        dd:form.dd.value,
                        numero:form.numero.value,
                    }
                ]
            },

            loginSistema:{ 
                email:form.email.value,
                senha:form.senha.value,
                perfilsForm:[
                    {
                        perfil:form.perfil.value,
                    }
                ]
            },

            despesasForm:[
                {
                nomeDespesa: form.despesa.value,
                valor: form.valor.value,
                recorrente: form.recorrente.value
                }
            ],
        
            
        },

        conselhoForm:{
            nomeConselho:form.nomeConselho.value,
            numeroConselho: form.numeroConselho.value,

        },

        agendaForm:{
            tempoMedConsulta:form.tempomedio.value,
            cargaHorariasForm:[
                {
                    diaSemana:form.diaSemana.value,
                    horarioAtendimentoForm:[
                        {
                            inicio:form.inicio.value,
                            fim:form.fim.value,
                            salasForm:{
                                    nome:form.sala.value
                                }
                        }
                    ]
                }
            ]

        }


    }

    return Medico;
}


function montaTr(Medico) {
    var MedicoTr = document.createElement("tr");
    MedicoTr.classList.add("Medico");

    clienteTr.appendChild(montaTd(Medico.diaSemana,Medico.inicio, Medico.fim,
    Medico.tempomedio,Medico.sala, "SEGUNDA"));
    clienteTr.appendChild(montaTd(cliente.bombona, "info-bombona"));
    clienteTr.appendChild(montaTd(cliente.frequencia, "info-frequencia"));
    clienteTr.appendChild(montaTd(cliente.status, "info-status"));
    clienteTr.appendChild(montaTd(cliente.valor, "info-valor"));

    return  MedicoTr;
}

function montaTd(dado, classe) {
    var td = document.createElement("td");
    td.classList.add(classe);
    td.textContent = dado;

    return td;
}