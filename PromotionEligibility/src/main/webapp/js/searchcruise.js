var app = angular.module("cruiseApp", []);

app
		.controller(
				"findcruiseCtrl",
				function($scope, $http, $window) {

					$scope.statenames = [ "Select states", "Florida",
							"Georgia", "New Jersey", "California", "Texas",
							"Maryland", "Louisana", "Washington",
							"British Columbia", "Massachusetts", "Puerto Rico" ];
					$scope.destinations = [ "Alaska", "Asia",
							"Australia & New Zealand", "Bahamas", "Bermuda",
							"Canada & New England", "Caribbean", "Europe",
							"Hawaii", "North America", "Pacific Northwest",
							"Panama Canal", "Repositioning", "South Pacific",
							"Transatlantic", "Transpacific" ];
					$scope.cruise = {
						_id : "",
						state : "",
						destination : "",
						departurePort : "",
						shipName : "",
						cruiseDate : "",
						cruiseName : ""
					}

					$scope.findCruises = function() {
						console.log("Searching started!");
						$http(
								{
									method : 'GET',
									url : 'http://localhost:8066/api/cruisesAll/'
											+ $scope.cruise.state
											+ '/'
											+ $scope.cruise.destination
											+ '/'
											+ $scope.cruise.cruiseDate,
									data : angular.toJson($scope.cruise),
									headers : {
										'Content-Type' : 'application/json'
									}
								})
								.then(
										function success(response) {
											console.log(response.data);
											$scope.Cruises = response.data;
											console.log($scope.Cruises.length);
											if ($scope.Cruises.length == 0) {
												$scope.error = "No cruise on that particular day you are searching for";
												$scope.success = "";
											} else {
												$scope.success = "Here are the results...!";
												$scope.error = "";
											}
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

// Basic example
$(document).ready(function() {
	$('#dtBasicExample2').DataTable({
		"pagingType" : "simple" // "simple" option for 'Previous' and 'Next'
	// buttons
	// only
	});
	$('.dataTables_length').addClass('bs-select');
});
