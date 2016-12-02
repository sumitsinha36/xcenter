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
        'dojo/on',
        'dojo/dom-style',
        'dojo/parser'
        ], function(declare, _WidgetBase, _TemplatedMixin, request, topic, domConstruct, dom, domAttr, array, html, lang, on, domStyle, parser) {
	
		return declare('app/display/Menu', [_WidgetBase, _TemplatedMixin], {
			
			templateString : "<div class='${userClass}' data-dojo-attach-point='menu'>" +
							 	
							 "</div>"
			
			, userClass : ''
				
			, activeMenu : []
				
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
					
					var t = [];
					
					array.forEach(data.menu, function(menuData) {
						
						var node = domConstruct.toDom("<div aria-hidden='true' class='menu_item'><div  class='" + menuData.style +"'></div>" + menuData.name + "</div>");
						
						if(t.length == 0) {

							html.set(that.menu, node, {parseContent: true});
							t = that.menu.childNodes;
						} else {
							
							var s = domConstruct.toDom("");
							array.forEach(t, function(n) {
								
								s.appendChild(n);
							});
							s.appendChild(node);
							
							html.set(that.menu, s, {parseContent: true});
							t = that.menu.childNodes;
						}
						
							
						
						
						on(node, "click", lang.partial(that._click, [menuData.template, that]));
					});
					
				}, function(error) {
					
				});
			}
			
			, _click : function(data, e) {
				
				if(data[1].activeMenu.length > 0) {
					
					var previousNode = data[1].activeMenu.pop();
					domStyle.set(previousNode, 'background', '#222222');
				}
				
				domStyle.set(e.target, 'background', '#FF5722');
				
				data[1].activeMenu.push(e.target);
				
				topic.publish("Menu/UIRouter/Display", [data[0]]);
			}
			
		});
	
});