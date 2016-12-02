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
        'dojo/_base/lang'
        ], function(declare, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, request, topic, domConstruct, dom, domAttr, array, html, lang) {
	
		return declare('app/display/Employee', [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
	
			templateString : "<div class='newemployee_form'>" +
								"<p class='mobile' style='display: inline-block;'>" +
									"<label class='fa fa-mobile field' for='mobile' style='margin-left: 5px;position: absolute;margin-top: 15px;'></label>" +
									"<input type='text' name='mobile' placeholder='mobile number'/>" +
								"</p><br/><br/>" +
								
								"<p class='fullName' style='display: inline-block;'>" +
									"<label class='fa fa-pencil field' for='mobile' style='margin-left: 5px;position: absolute;margin-top: 15px;'></label>" +
									"<input type='text' name='fullName' placeholder='full name'/>" +
								"</p><br/><br/>" +
								
								"<p class='roles' style='display: inline-block;'>" +
									"<label class='fa fa-users field' for='mobile' style='margin-left: 5px;position: absolute;margin-top: 15px;'></label>" +
									"<select>" +
										"<option value='USER'>User</option>" +
										"<option value='ADMIN'>Admin</option>" +
									"</select>" +
								"</p><br/><br/>" +
								
								"<p class='email' style='display: inline-block;'>" +
									"<label class='fa fa-envelope field' for='mobile' style='margin-left: 5px;position: absolute;margin-top: 15px;'></label>" +
									"<input type='email' name='email' placeholder='email id'/>" +
								"</p><br/><br/>" +
								
								"<p class='profilepic' style='display: inline-block;'>" +
									"<input type='text' name='image' data-dojo-attach-point='file_name' placeholder='browse profile picture' style='display: inline-block;' readonly/>" +
									"<label class='fa fa-upload field' for='mobile' style='margin-left: -17px; position: absolute; margin-top: 20px; color: #FFFFFF;'></label>" +
									"<input type='file' name='file' data-dojo-attach-point='file' data-dojo-attach-event='onchange : _fileSelect' accept='image/jpeg'/>" +
								"</p><br/><br/>" +
								
								"<button class='button'>Create Employee</button>" +
								
							 "</div>"
								
			, _fileSelect : function() {
				
				this.file_name.value = this.file.files[0].name;
			}
		});
});
	