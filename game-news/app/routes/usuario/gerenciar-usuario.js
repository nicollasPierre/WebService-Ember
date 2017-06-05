import Ember from 'ember';


export default Ember.Route.extend({
model(){
  var data;
  Ember.$.ajax({
         type: "GET",
         crossDomain: true,
         dataType: "json",
         url: "http://localhost:8080/WebService/usuarios",
         success: function(data){
          data = JSON.parse(JSON.stringify(data));
          if(data.usuario instanceof Array){
            Array.from(data.usuario).forEach(function(item, index){
              document.getElementById('teste2').innerHTML += "<tr>" +
                "<td class=\"mdl-data-table__cell--non-numeric\">"+item.username +"</td>" +
                "<td class=\"mdl-data-table__cell--non-numeric\">"+item.email +"</td>" +
                "<td>"+item.tp_usuario.nome +"</td>" +
                "<td><a href='http://localhost:4200/usuario/editar-usuario/"+item.id+"'>Editar</a></td>" +
              "</tr>";
            });
          }else{
            document.getElementById('teste2').innerHTML += "<tr>" +
              "<td class=\"mdl-data-table__cell--non-numeric\">"+data.usuario.username +"</td>" +
              "<td class=\"mdl-data-table__cell--non-numeric\">"+data.usuario.email +"</td>" +
              "<td>"+data.usuario.tp_usuario.nome +"</td>" +
              "<td><a href='http://localhost:4200/usuario/editar-usuario/"+data.usuario.id+"'>Editar</a></td>" +
            "</tr>";
          }
        },
         error: (xhr, ajaxOptions, thrownError) => {
           alert(xhr.status);
           alert(thrownError);
           data = '';
         }
      });

      /*getJSON().then(function(json) {
        return json
      }, function(reason) {
        alert(reason);
      });*/

}



/*
$.ajax({
       type: "GET",
       crossDomain: true,
       dataType: "json",
       url: "http://localhost:8080/WebService/usuarios",
       success: function(data){
        return JSON.parse(JSON.stringify(data));
        },
       error: (xhr, ajaxOptions, thrownError) => {
         alert(xhr.status);
         alert(thrownError);
         return '';
       }
    });*/
  });


/*
  function getJSON() {
    return new Ember.RSVP.Promise(function(resolve, reject){
      Ember.$.ajax({
             type: "GET",
             crossDomain: true,
             dataType: "json",
             url: "http://localhost:8080/WebService/usuarios",
             success: function(data){
              resolve(JSON.parse(JSON.stringify(data)));
              },
             error: (xhr, ajaxOptions, thrownError) => {
               alert(xhr.status);
               alert(thrownError);
               reject(new Error('getJSON: `http://localhost:8080/WebService/usuarios` failed with status: [' + xhr.status + ']: '+ thrownError));
             }
          });
    });
  }
*/
