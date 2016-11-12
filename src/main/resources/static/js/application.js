var app = angular.module('xcenter', []);

app.directive('appDrawer', function() {
	return {
		restrict : 'E'
			
		, controller : function($scope, $http) {
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			$http({
				method: 'POST',
				url : '/getAllMenu'
			}).then(function(response) {
				console.log(response);
			}, function(error) {
				console.log(error);
			});
		}
	
		, template : "<div>" +
					 "</div"
	};
});