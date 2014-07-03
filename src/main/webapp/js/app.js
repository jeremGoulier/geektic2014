var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});



app.controller('GeekCtrl', function($scope, $http) {    
    
	$scope.RenvoiListeInteret = function()
	{
		$http.get('/api/geek/ListeCentreInteret').success(function(interets) {
            $scope.interets = interets;
        });
	}
	
	$scope.RenvoiListeInteret();
	
	
	$scope.recherche = function()
    {
		//On vérifie que les champs sexe et centre d'inérêt sont selectionnés
		if ($scope.sexe == "" || $scope.sexe == null || $scope.interet == "" || $scope.interet == null )
		{
			alert("Vous devez sélectionner un sexe et un centre d'interêt.");
			return;
		}
		
    	$http.get('/api/geek/RechercheGeek/' + $scope.sexe + '/' + $scope.interet.libelle).success(function(Utilisateur) {
            $scope.geeks = Utilisateur;
            
        //On vérifie qu'il y a bien un geek repertorié au centre d'interet selectionné
        if(Utilisateur == null || Utilisateur == ""){
        	alert("Aucun geek repertorié avec ce centre d'interêt.");
			return;
        }
            
        });
    };  
	  
});