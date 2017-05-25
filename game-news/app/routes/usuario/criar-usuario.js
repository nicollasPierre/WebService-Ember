import Ember from 'ember';

export default Ember.Route.extend({
  actions: {
    criarUsuario() {
      var campos_preenchidos = true;
      var nome = document.getElementById('nome').value;
      var senha = document.getElementById('senha').value;
      var email = document.getElementById('email').value;
      var confirmaSenha = document.getElementById('confirmar_senha').value;



      if(nome == ''){
        campos_preenchidos = false;
        document.getElementById('nome').required = true;
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
          $.ajax({
            headers: {
                'Accept': 'text/plain',
                'Content-Type': 'application/json'
            },
            url: "http://localhost:8080/WebService/usuarios",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify( {
                        "email": email,
                        "id": "1",
                        "senha": senha,
                        "tp_usuario": {
                            "id": "3",
                            "nome": "comum"
                        },
                        "username": nome
                    }
                  ),
            dataType: "json",
            success: (result) => {
                switch (result) {
                    case true:
                        break;
                    default:
                }
            },
            error: (xhr, ajaxOptions, thrownError) => {
              alert(xhr.status);
              alert(thrownError);
            }
        });
      }
    }
  }
});
