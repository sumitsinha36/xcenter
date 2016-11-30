define(['dojo/_base/declare',
        'dijit/_WidgetBase',
        'dijit/_TemplatedMixin',
        'dojo/request',
        'dojo/topic',
        'dojo/dom-construct',
        'dojo/dom',
        'dojo/dom-attr',
        'dojo/_base/array',
        'dojo/html',
        'dojo/_base/lang',
        'dojo/on'
        ], function(declare, _WidgetBase, _TemplatedMixin, request, topic, domConstruct, dom, domAttr, array, html, lang, on) {
	
		return declare('app/display/Menu', [_WidgetBase, _TemplatedMixin], {
			
			templateString : "<div class='${userClass}' data-dojo-attach-point='menu'>" +
							 	
							 "</div>"
			
			, userClass : ''
				
			, subscriptions : []
		
			, type : 'admin'
				
			, template : ''
				
			, constructor : function() {
				
			}
		
			, postMixInProperties : function() {
				
				
			}
			
			, postCreate : function() {
				
				this._GetMenu();
			}
			
			, _GetMenu : function() {
				
				var that = this;
				
				if(this.type === 'admin') {
					
					this.url = '/getAdminMenu'
				}
				
				request(this.url, {
					
					method : 'POST'
						
					, handleAs : 'json'
						
					, headers : {
						
						'X-CSRF-TOKEN' : domAttr.get(dom.byId('csrf'), 'content')
					}
				}).then(function(data) {
					
					array.forEach(data.menu, function(menuData) {
						
						var node = domConstruct.toDom("<div>" + menuData.name + "</div>");
						
						html.set(that.menu, node, {parseContent: true});
						
						on(node, "click", lang.partial(that._click, menuData.template));
					});
					
				}, function(error) {
					
				});
			}
			
			, _click : function(url, e) {
				
				topic.publish("Menu/UIRouter/Display", [url]);
			}
			
		});
	
});