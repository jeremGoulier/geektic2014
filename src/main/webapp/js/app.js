var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});



//Routage
app.config(['$routeProvider',
            function($routeProvider) {
              $routeProvider.
                when('/', {
                  templateUrl: 'view/main.html',
                })
                .when('/profil/:id', {
              	  templateUrl: 'view/profil.html?:id',
              	  controller: 'GeekCtrl'
                })
                .otherwise('/');
            }]);




app.controller('GeekCtrl', function($scope, $http, $routeParams) {   
	
	//Recup�re information d'un geek en fonction de son id
    $http.get('/api/geek/' + $routeParams.id).success(function(Utilisateurs) {
        $scope.Utilisateur = Utilisateurs;
 });
	
	//Retourne la liste des centres d'interet
	$scope.RenvoiListeInteret = function()
	{
		$http.get('/api/geek/ListeCentreInteret').success(function(interets) {
            $scope.interets = interets;
        });
	}
	$scope.RenvoiListeInteret();
	
	
	//Fonction de recherche
	$scope.recherche = function()
    {
		//On v�rifie que les champs sexe et centre d'in�r�t sont selectionn�s
		if ($scope.sexe == "" || $scope.sexe == null || $scope.interet == "" || $scope.interet == null )
		{
			alert("Vous devez selectionner un sexe et un centre d'interet.");
			return;
		}
		
    	$http.get('/api/geek/RechercheGeek/' + $scope.sexe + '/' + $scope.interet.libelle).success(function(Utilisateur) {
            $scope.geeks = Utilisateur;
            
        //On v�rifie qu'il y a bien un geek repertori� au centre d'interet selectionn�
        if(Utilisateur == null || Utilisateur == ""){
        	alert("Aucun geek repertorie avec ce centre d'interet.");
			return;
        }      
        });
    };  
	  
});