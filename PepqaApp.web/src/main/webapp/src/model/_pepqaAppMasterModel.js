define([], function() {
    App.Model._PepqaAppMasterModel = Backbone.Model.extend({
     	initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('pepqaApp-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.PepqaAppModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.pepqaAppEntity,options);
            }
        }
    });

    App.Model._PepqaAppMasterList = Backbone.Collection.extend({
        model: App.Model._PepqaAppMasterModel,
        initialize: function() {
        }

    });
    return App.Model._PepqaAppMasterModel;
    
});