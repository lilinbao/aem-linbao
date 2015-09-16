

+function($){
	
	if($.registration == undefined){
		$.registration = function(){
			this.init();
		}
		$.registration.prototype = {
			
			init: function(){
				var self = this;
				self.actionForm = $('.login-form');
				self.btnSubmit  = $('#btn-submit');
				self.initValidator();
				self.actionForm.submit = function(){
					self.register();
				}
			},
			register: function(){
				var self = this;
				if(self.actionForm.valid()){
					self.actionForm.submit();
				}
			},
			initValidator: function(){
				var self = this;
				self.actionForm.validate({
					rules:{
						username:{
							required: true,
							minlength: 6,
							maxlength: 20
						},
						password: {
							required: true,
							minlength: 6,
							maxlength: 20
						}
					},
					messages:{
						username: {
							required: "Sorry, username is required, please enter the username!",
							minlength: "The username is required minlength length of 6! ",
							maxlength: "The username is too long"
						},
						password: {
							required: "Sorry, password is required, please enter the password!",
							minlength: "The password is required minlength of 6! ",
							maxlength: "The password is too long"
						}
					}
				})
			}
		}
	}
	
	
	$(document).ready(function(){
		var registration = new $.registration();
		
	})
}(jQuery)