import Ember from 'ember';
var noticia_id;
export default Ember.Route.extend({
  model(params){
    noticia_id = params.noticia_id
    getNoticia()
  },
  actions: {
    alterarNoticia(){
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
            url: "http://localhost:8080/WebService/noticia/"+noticia_id,
            type: "PUT",
            crossDomain: true,
            data: JSON.stringify( {
                        "titulo": titulo,
                        "categorias": {
                                        "id" : categoria_value,
                                        "nome": categoria_texto
                                      },
                        "conteudo": conteudo,
                        "autor": {
                                    "id" : "4"
                                }
                    }
                  ),
            dataType: "text",
            success: (result) => {
                switch (result) {
                    case true:
                        alert('Noticia Alterada com sucesso');
                          this.replaceWith('noticia.listar-noticia');
                        break;
                    default:
                        alert(result);
                          this.replaceWith('noticia.listar-noticia');
                }
            },
            error: (xhr, ajaxOptions, thrownError) => {
              alert(xhr+": "+thrownError)
              this.replaceWith('noticia.listar-noticia');
            }
        });
      }
    },
    excluirNoticia(){
      Ember.$.ajax({
        headers: {
            'Accept': 'text/plain',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/WebService/noticia/"+noticia_id,
        type: "DELETE",
        crossDomain: true,
        dataType: "text",
        success: (result) => {
            switch (result) {
                case true:
                    alert('Noticia Excluida com sucesso');
                      this.replaceWith('noticia.listar-noticia');
                    break;
                default:
                    alert('Noticia Excluida com sucesso');
                      this.replaceWith('noticia.listar-noticia');
            }
        },
        error: (xhr, ajaxOptions, thrownError) => {
          alert(xhr.status);
          alert(thrownError);
        }
    });
    }

  }
});





function getNoticia(){
  Ember.$.ajax({
         type: "GET",
         crossDomain: true,
         dataType: "json",
         url: "http://localhost:8080/WebService/noticia/"+noticia_id,
         success: function(data){
          data = JSON.parse(JSON.stringify(data));
          document.getElementById('titulo').value = data.titulo;
          document.getElementById('conteudo').value = data.conteudo;
          document.getElementById('categoria').selectedIndex = data.categorias.id;
        },
         error: (xhr, ajaxOptions, thrownError) => {
           alert(xhr.status);
           alert(thrownError);
         }
      });
}
