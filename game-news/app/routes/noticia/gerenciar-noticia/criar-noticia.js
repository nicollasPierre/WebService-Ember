import Ember from 'ember';

export default Ember.Route.extend({
  actions: {
    criarNoticia(){
      var titulo = document.getElementById('titulo').value;
      var conteudo = document.getElementById('conteudo').value;
      var categoria = document.getElementById('categoria');
      var categoria_texto = categoria.options[categoria.selectedIndex].text;
		  var categoria_value = categoria.options[categoria.selectedIndex].value;

      if(titulo == '' || categoria == '' || conteudo == ''){
        alert("Campos não preenchidos")
      }else{
        Ember.$.ajax({
          headers: {
              'Accept': 'text/plain',
              'Content-Type': 'application/json'
          },
          url: "http://localhost:8080/WebService/noticia",
          type: "POST",
          crossDomain: true,
          data: JSON.stringify( {
                      "titulo": titulo,
                      "categorias": {
                                      "id:" : "3",
                                      "nome": categoria_texto
                                    },
                      "conteudo": conteudo,
                      "autor": {
                                  "id" : "4"/*,
                                  "email": "",
                                  "senha": "",
                                  "tp_usuario": {
                                      "id": "1",
                                      "nome": "postador"
                                  },
                                  "username": ""*/
                              }
                  }
                ),
          dataType: "text",
          success: (result) => {
              switch (result) {
                  case true:
                      alert(result);
                        this.replaceWith('noticia.listar-noticia');
                      break;
                  default:
                      alert(result);
                        this.replaceWith('noticia.listar-noticia');
              }
          },
          error: (xhr, ajaxOptions, thrownError) => {
            alert("ERROR: "+xhr.status+ "\n Descrição: "+thrownError);
          }
      });
      }
    }
  }
});
