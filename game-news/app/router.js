import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('usuario', function() {
    this.route('criar-usuario');
    this.route('gerenciar-usuario');
    this.route('editar-usuario', function() {
      this.route('show', { path: '/:usuario_id' });
    });
  });

  this.route('noticia', function() {
    this.route('listar-noticia');
    this.route('gerenciar-noticia', function() {
      this.route('criar-noticia');
      this.route('editar-noticia', { path: '/:noticia_id' });
    });
  });
});

export default Router;
