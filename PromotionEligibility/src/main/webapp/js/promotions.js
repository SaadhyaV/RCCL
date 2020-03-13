var app = angular.module("promotionApp", []);

app.controller("displayPromotionCtrl", function($scope, $http){
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
	$http({
		method:'GET',
		url:'http://localhost:8065/api/promotions',
		headers:{'Content-Type':'application/json'}
	}).then(function success(response){
		console.log(response.data);
		$scope.promotionsData = response.data;
	}, 
		function error(response){
			console.log("error found");
			console.log(response.data);	
	});
	$scope.deletePromotions = function(id){
		console.log("Deleting id : "+id);
		$http({
			method:'DELETE',
			url:'http://localhost:8065/api/deletepromotions/'+ id,
			headers:{'Content-Type':'application/json'}
		}).then(function success(response){
			console.log(response.data);	
			$window.location.reload();
		}, 
			function error(response){
				console.log("error found");
				console.log(response.data);
				
		});	
	};
	$scope.clickedPromotions = {
			id : "",
	        promotionName : "",
	        promotionState : "",
	        promotionValidFrom : "",
	        promotionExpiresAt : "",
	        discountAmount : ""
	};
	
	$scope.selectPromotion = function(x){
		console.log(x);
		$scope.clickedPromotions = x;
		$scope.clickedPromotions.startDate = new Date($scope.clickedPromotions.startDate);
		$scope.clickedPromotions.endDate = new Date($scope.clickedPromotions.endDate);
	}
	
	
	$scope.updatePromotions = function(){
		$http({
			method:'POST',
			url:'http://localhost:8065/api/updatepromotions',
			data:angular.toJson($scope.clickedPromotions),
			headers:{'Content-Type':'application/json'}
		}).then(function success(response){
			console.log(response.data);	
			$window.location.reload();
		}, 
			function error(response){
				console.log("error found");
				console.log(response.data);
				
		});	
	}

	
});

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
		promotionName:"",
		promotionState:"",
		discountAmount:"",
		startDate:"",
		endDate:""		
	};
	$scope.setPromotions = function(){
		$http({
			method:'POST',
			url:'http://localhost:8065/api/setpromotions',
			data: angular.toJson($scope.promotions),
			headers:{'Content-Type':'application/json'}
		}).then(function success(response){
			console.log(response.data);
//			$scope.promotionsData = response.data;
		}, 
			function error(response){
				console.log("error found");
				console.log(response.data);
		});	
	};
		
});
