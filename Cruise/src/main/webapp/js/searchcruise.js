var app = angular.module("cruiseApp", []);

app.controller("findcruiseCtrl", function($scope, $http, $window) {

	$scope.statenames = [ "Select states", "Florida", "Georgia", "New Jersey",
			"California", "Texas", "Maryland", "louisana", "Washington",
			"Massachusetts", "Puerto Rico" ];
	$scope.destinations = [ "Alaska", "Asia", "Australia & New Zealand",
			"Bahamas", "Bermuda", "Canada & New England", "Caribbean",
			"Europe", "Hawaii", "North America", "Pacific Northwest",
			"Panama Canal", "Repositioning", "South Pacific",
			"Speciality Cruises", "Transatlantic", "Transpacific" ];
	$scope.cruise = {
		_id : "",
		destination : "",
		state : "",
		departurePort : "",
		shipName : "",
		startDate : "",
		endDate : "",
	}
	$scope.findCruises = function() {
		console.log("Searching started!");
		console.log("cruises found!");

		$http(
				{
					method : 'GET',
					url : 'http://localhost:8066/api/cruises/'
							+ $scope.cruise.state + '/'
							+ $scope.cruise.destination,
					data : angular.toJson($scope.cruise),
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function success(response) {
			console.log(response.data);
			$scope.Cruises = response.data;
			// $scope.Cruises.startDate = new
			// Date($scope.Cruises.startDate);
			// $scope.Cruises.endDate = new Date($scope.Cruises.endDate);

		}, function error(response) {
			console.log("error found");
			console.log(response.data);
		});

	}
});
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

	}, function error(response) {
		console.log("error found");
		console.log(response.data);
	});
});
// $scope.Cruises.startDate = new Date($scope.Cruises.startDate);
// $scope.Cruises.endDate = new Date($scope.Cruises.endDate);
// ng-controller="displayCruiseCtrl"
