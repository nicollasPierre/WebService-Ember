import DS from 'ember-data';

export default DS.Model.extend({
    nome: DS.attr(),
    email: DS.attr(),
    username: DS.attr(),
    senha: DS.attr(),
    Tipo_usuario: DS.attr()
});
