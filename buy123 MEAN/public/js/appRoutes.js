angular.module('appRoutes', []).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

	$routeProvider

	.when('/', {
		templateUrl: 'views/home.html',
		controller: 'MainCtrl'
	})

	.when('/store/:products', {
		templateUrl: 'views/products.html',
		controller: 'ProductsCtrl'
	})

	.when('/store/:products/:id', {
		templateUrl: 'views/productdetail.html',
		controller: 'ProductsDetailCtrl'
	})

	$locationProvider.html5Mode(true);

}]);
