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
		//On v�rifie que les champs sexe et centre d'in�r�t sont selectionn�s
		if ($scope.sexe == "" || $scope.sexe == null || $scope.interet == "" || $scope.interet == null )
		{
			alert("Vous devez s�lectionner un sexe et un centre d'inter�t.");
			return;
		}
		
    	$http.get('/api/geek/RechercheGeek/' + $scope.sexe + '/' + $scope.interet.libelle).success(function(Utilisateur) {
            $scope.geeks = Utilisateur;
            
        //On v�rifie qu'il y a bien un geek repertori� au centre d'interet selectionn�
        if(Utilisateur == null || Utilisateur == ""){
        	alert("Aucun geek repertori� avec ce centre d'inter�t.");
			return;
        }
            
        });
    };  
	  
});