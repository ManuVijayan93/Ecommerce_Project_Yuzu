var myapp = angular.module("myapp", []).controller(
		"productController",
		function($scope, $http) {
			alert("productController  called");
			// To get all products
			$scope.getAllProducts = function() {
				alert("getAllProducts called");
				$http.get('http://localhost:8080/ecommerce/getProductsList')
				
						.success(function(data) {
							$scope.products = data;
						})
			}

		});