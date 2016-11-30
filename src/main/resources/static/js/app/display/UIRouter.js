define(['dojo/_base/declare',
        'dijit/_WidgetBase',
        'dijit/_TemplatedMixin',
        'dijit/_WidgetsInTemplateMixin',
        'dojo/request',
        'dojo/topic',
        'dojo/dom-construct',
        'dojo/dom',
        'dojo/dom-attr',
        'dojo/_base/array',
        'dojo/html',
        'dojo/_base/lang',
        'dojo/on',
        'dijit/layout/ContentPane'
        ], function(declare, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, request, topic, domConstruct, dom, domAttr, array, html, lang, on, ContentPane) {
	
		return declare('app/display/UIRouter', [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, ContentPane], {
	
			subscriptions : []
			
			, postMixInProperties : function() {
				
				this.subscriptions.push(topic.subscribe('Menu/UIRouter/Display', lang.hitch(this, this._display)));
			}
		
			, destroy: function() {
				
				this.subscriptions.forEach(function(handle) {
					
					handle.remove();
				});
            
				this.inherited(arguments);
			}
			
			, _display : function(template) {
				
				this.set("href", "./"+template+".html");
			}
		});
});