/*// app/routes.js

var ProductList = require('./models/productlist');
var ProductDetail = require('./models/productdetail');

var MongoJS = require("mongojs");

//var db = MongoJS.connect("mongodb://localhost:27017/buy123", ["products.television", "products.cars", "products.routers"]);
var db = MongoJS.connect("mongodb://localhost:27017/buy123");



module.exports = function(app) {

	// server routes ===========================================================
	// handle things like api calls
	// authentication routes

	app.get('/store/products', function(req, res) {
		console.log(req);
		db.products.find(function(err, products) {
			if (err || !products) {
				res.send(err);
				console.log("\nNo products found");
			} else {
				res.json(products);
				products.forEach(function(product) {
					console.log(product);
				});
			}
		});
	});

	app.get('/api/televisionslist', function(req, res) {
		console.log(req);
		db.products.television.find(function(err, television) {
			if (err || !television) {
				res.send(err);
				console.log("\nNo television found");
			} else {
				res.json(television);
				television.forEach(function(television) {
					console.log(television);
				});
			}
		});
	});

	app.get('/api/carslist', function(req, res) {
		console.log(req);
		db.products.cars.find(function(err, car) {
			if (err || !car) {
				res.send(err);
				console.log("\nNo car found");
			} else {
				res.json(car);
				car.forEach(function(car) {
					console.log(car);
				});
			}
		});
	});

	app.get('/api/routerslist', function(req, res) {
		console.log(req);
		db.products.routers.find(function(err, router) {
			if (err || !router) {
				res.send(err);
				console.log("\nNo router found");
			} else {
				res.json(router);
				router.forEach(function(router) {
					console.log(router);
				});
			}
		});
	});

	// route to handle creating (app.post)
	// route to handle delete (app.delete)

	// frontend routes =========================================================
	// route to handle all angular requests
	app.get('*', function(req, res) {
		res.sendfile('./public/index.html'); // load our public/index.html file
	});

};
*/