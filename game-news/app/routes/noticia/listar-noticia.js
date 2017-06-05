import Ember from 'ember';

export default Ember.Route.extend({
  model(){
    Ember.$.ajax({
           type: "GET",
           crossDomain: true,
           dataType: "json",
           url: "http://localhost:8080/WebService/noticia",
           success: function(data){
            data = JSON.parse(JSON.stringify(data));
            if(data.noticia instanceof Array){
              Array.from(data.noticia).forEach(function(item, index){
                document.getElementById('noticias').innerHTML +=
                /*"<article><ul>"
                +"<li><a class=\"mdl-navigation__link\" href=\'http://localhost:4200/noticia/gerenciar-noticia/"+item.id+"\'><h3>"+item.titulo+"</h3></a>"+item.categorias.nome+"</li>"
                +"<li><p>"+item.conteudo+"</p></li>"
                +"</ul></article>";*/

                "<tr>"
                +"<td><a class=\"mdl-navigation__link\" href=\'http://localhost:4200/noticia/gerenciar-noticia/"+item.id+"\'><h3>"+item.titulo+"</h3></a></td>"
                +"<td><h6>"+item.categorias.nome+"</h6></td></tr>"
                +"<tr><td><p>"+item.conteudo+"</p></td></tr>"
                +"<tr><td><hr/></td</tr>";
              });
            }else{
              document.getElementById('noticias').innerHTML += "<h1>"+data.noticia.titulo+"</h1>"
              +"<h4>"+data.noticia.categorias.nome+"</h4> <a href=\'http://localhost:4200/noticia/gerenciar-noticia/"+data.noticia.id+"><i class=\"material-icons\">mode_edit</i></a><br>"
              +"<p>"+data.noticia.conteudo+"</p>"
              +"<hr />";
            }
          },
           error: (xhr, ajaxOptions, thrownError) => {
             alert(xhr.status);
             alert(thrownError);
             data = '';
           }
        });
  }
});
