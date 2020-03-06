var app = angular.module("promotionApp", []);

app.controller("promotionCtrl", function($scope, $http){
	 $scope.statenames = [
		 "Select states",
		    "Florida",
		   "Georgia",
		   "New Jersey",
		   "California",
		   "Texas",
		   "Maryland",
		   "louisana",
		   "Washington",
		   "Massachusetts",
		   "Puerto Rico"
		  ];
	 $scope.militarystatus = [
		 "Retired",
		 "Working"
	 ];
	$scope.promotions = {
		name:"",
		state:"",
		age:"",
		militaryManStatus:"",
		startDate:"",
		endDate:""		
	};
	$scope.getPromotions = function(){
		$http({
			method:'POST',
			url:'/sendData',
			data: angular.toJson($scope.promotions),
			headers:{'Content-Type':'application/json'}
		}).then(function success(response){
			console.log(response.data);
		}, 
			function error(response){
				console.log("error found");
				console.log(response.data);
		})	
	}
	
});
//<i class="fas fa-search-location prefix grey-text"></i>
//<select id="form2" ng-options="item for item in statenames" ng-model="customer.state" class="browser-default custom-select">
//</select>

//<input type="text" id="form4" ng-model="customer." class="form-control">
//<label for="form4">Military man</label>