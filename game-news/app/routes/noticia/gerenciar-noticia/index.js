import Ember from 'ember';

export default Ember.Route.extend({
  beforeModel(){
    this.replaceWith("noticia.gerenciar-noticia.criar-noticia");
  }
});
