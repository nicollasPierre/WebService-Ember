import Ember from 'ember';
var path_parametro;
var data_usuario;
export default Ember.Route.extend({
  model(params){
    path_parametro = params;
    Ember.$.ajax({
           type: "GET",
           crossDomain: true,
           dataType: "json",
           url: "http://localhost:8080/WebService/usuarios/"+params.usuario_id,
           success: function(data){
            data = JSON.parse(JSON.stringify(data));
            data_usuario = data;
            document.getElementById('nome').value = data.username;
            document.getElementById('email').value = data.email;
            document.getElementById('senha').value = data.senha;

            },
           error: (xhr, ajaxOptions, thrownError) => {
             alert(xhr.status);
             alert(thrownError);
           }
        });
  },
  actions: {
    alterarUsuario(){
      alterarUsuario(data_usuario.tp_usuario.id, data_usuario.tp_usuario.nome)
    },
    transformarPostador(){
      data_usuario.tp_usuario.id = "1";
      data_usuario.tp_usuario.nome = "postador"
      alterarUsuario(data_usuario.tp_usuario.id, data_usuario.tp_usuario.nome)
    },
    remove(){
      Ember.$.ajax({
        headers: {
            'Accept': 'text/plain',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/WebService/usuarios/"+path_parametro.usuario_id,
        type: "DELETE",
        crossDomain: true,
        dataType: "json",
        success: (result) => {
            switch (result) {
                case true:
                    alert('Usuario Alterado com sucesso');
                    break;
                default:
                    alert('Usuario Alterado com sucesso');
            }
        },
        error: (xhr, ajaxOptions, thrownError) => {
          alert(xhr.status);
          alert(thrownError);
        }
    });
    this.replaceWith('usuario.gerenciar-usuario');
    }
  }

});

function alterarUsuario(tipo_usuario_id, tipo_usuario_nome){
  var campos_preenchidos = true;
  var nome = document.getElementById('nome').value;
  var senha = document.getElementById('senha').value;
  var email = document.getElementById('email').value;
  var confirmaSenha = document.getElementById('confirmar_senha').value;



  if(nome == ''){
    campos_preenchidos = false;
    document.getElementById('email').required = true;
  }

  if(email == ''){
    campos_preenchidos = false;
    document.getElementById('email').required = true;
  }

  if(senha == '' || confirmaSenha == '' || senha != confirmaSenha){
    campos_preenchidos = false;
    document.getElementById('senha').required = true;
    document.getElementById('confirmar_senha').required = true;
  }

  if(campos_preenchidos){
      Ember.$.ajax({
        headers: {
            'Accept': 'text/plain',
            'Content-Type': 'application/json'

        },
        url: "http://localhost:8080/WebService/usuarios/"+path_parametro.usuario_id,
        type: "PUT",
        crossDomain: true,
        data: JSON.stringify( {
                    "email": email,
                    "senha": senha,
                    "tp_usuario": {
                        "id": tipo_usuario_id,
                        "nome": tipo_usuario_nome
                    },
                    "username": nome
                }
              ),
        dataType: "text",
        success: (result) => {
            switch (result) {
                case true:
                    alert('Usuario Alterado com sucesso');
                    break;
                default:
                    alert('Usuario Alterado com sucesso');
            }
        },
        error: (xhr, ajaxOptions, thrownError) => {
          alert(xhr.status);
          alert(thrownError);
        }
    });
  }
}
