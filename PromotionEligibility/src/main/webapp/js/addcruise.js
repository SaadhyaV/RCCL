var app = angular.module("addCruiseApp", []);

app.controller("displayCruiseCtrl", function($scope, $http) {
	$http({
		method : 'GET',
		url : 'http://localhost:8066/api/cruises',
		headers : {
			'Content-Type' : 'application/json'
		}
	}).then(function success(response) {
		console.log(response.data);
		$scope.Cruises = response.data;
		console.log($scope.Cruises.length);
	}, function error(response) {
		console.log("error found");
		console.log(response.data);

	});

	$scope.statenames = [ "Select states", "Florida", "Georgia", "New Jersey",
			"California", "Texas", "Maryland", "Louisiana", "Washington",
			"British Columbia", "Massachusetts", "Puerto Rico" ];
	$scope.destinations = [ "Alaska", "Asia", "Australia & New Zealand",
			"Bahamasa", "Bermuda", "Canada & New England", "Caribbean",
			"Europe", "Hawaii", "North America", "Pacific Northwest",
			"Panama Canal", "Repositioning", "South Pacific", "Transatlantic",
			"Transpacific" ];
	$scope.ports = [ "Miami", "Tampa", "Boston", "New York", "Canada",
			"Hawaii", "Seattle", "Vancouver", "Orlando Port" ];
	// delete cruises
	$scope.deleteCruises = function(id) {
		console.log("Deleting id : " + id);
		$http({
			method : 'DELETE',
			url : 'http://localhost:8066/api/deleteCruises/' + id,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function success(response) {
			console.log(response.data);
			$window.location.reload();
		}, function error(response) {
			console.log("error found");
			console.log(response.data);
		});
	};
	// update cruises
	$scope.clickedCruise = {
		_id : "",
		state : "",
		destination : "",
		departurePort : "",
		shipName : "",
		cruiseDate : "",
		cruiseName : ""
	};

	$scope.selectCruises = function(x) {
		console.log(x);
		$scope.clickedCruise = x;
		$scope.clickedCruise.cruiseDate = new Date(
				$scope.clickedCruise.cruiseDate);
	}

	$scope.updateCruises = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8066/api/updatecruises',
			data : angular.toJson($scope.clickedCruise),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function success(response) {
			console.log(response.data);
			$window.location.reload();
		}, function error(response) {
			console.log("error found");
			console.log(response.data);

		});
	}

});

app.controller("addCruiseCtrl", function($scope, $http, $window) {
	$scope.statenames = [ "Select states", "Florida", "Georgia", "New Jersey",
			"California", "Texas", "Maryland", "Louisiana", "Washington",
			"British Columbia", "Massachusetts", "Puerto Rico" ];
	$scope.destinations = [ "Alaska", "Asia", "Australia & New Zealand",
			"Bahamasa", "Bermuda", "Canada & New England", "Caribbean",
			"Europe", "Hawaii", "North America", "Pacific Northwest",
			"Panama Canal", "Repositioning", "South Pacific", "Transatlantic",
			"Transpacific" ];
	$scope.ports = [ "Miami", "Tampa", "Boston", "New York", "Canada",
			"Hawaii", "Seattle", "Vancouver", "Orlando Port" ];
	$scope.cruise = {
		_id : "",
		state : "",
		destination : "",
		departurePort : "",
		shipName : "",
		cruiseDate : "",
		cruiseName : ""
	}
	$scope.setCruises = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8066/api/setcruises',
			data : angular.toJson($scope.cruise),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function success(response) {
			console.log(response.data);
			$scope.Cruises = response.data;
			$window.location.reload();
		}, function error(response) {
			console.log("error found");
			console.log(response.data);

		});

	}
});
