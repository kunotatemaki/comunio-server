(function(){

  var urlComunio = {
    urlBase : "http://localhost:8080/comunio/",
    urlRoot : "rest/services/",
    getPageDataMethod : "get_participants"
  }
  
  var serverCalls = {
    getParticipants : function($scope, $http) {
        url = urlComunio.urlBase + urlComunio.urlRoot + urlComunio.getPageDataMethod;
        
        $http.get(url)
        .then(function(response) {
            //First function handles success
          $scope.participants = response.data.participants;
        }, function(response) {
          //Second function handles error
          $scope.content = "Something went wrong";
        });
      }

  }


  var comunio = angular
    .module('ComunioServer', ['ngMaterial', 'ngRoute', 'ngMdIcons' ])
    .controller('AppCtrl', function ($scope, $filter, $timeout, $mdSidenav, $log) {
      $scope.toggleLeft = buildDelayedToggler('left');
      $scope.toggleRight = buildToggler('right');
      $scope.isOpenRight = function(){
        return $mdSidenav('right').isOpen();
      };
      $scope.clasificationOption = {
        option : 'clasificacion',
        display : 'Clasificación'
      };
  	      
      $scope.selectedPlayer = $scope.clasificationOption.option;
      $scope.displayedPlayer;
      $scope.$watch('selectedPlayer', function() {
        if( $scope.selectedPlayer ===  $scope.clasificationOption.option){
           $scope.displayedPlayer =  $scope.clasificationOption.display;
           $scope.template = $scope.templates[0];
        }else{
           $scope.displayedPlayer = $filter('getByOption')($scope.participants, 'table_name', $scope.selectedPlayer).name;
           $scope.template = $scope.templates[1];
        }
      });
      
      $scope.templates =
        [ { name: 'template1.html', url: './html/clasification.html'},
          { name: 'template2.html', url: './html/participant.html'} ];
      //$scope.template = $scope.templates[0];

      /**
       * Supplies a function that will continue to operate until the
       * time is up.
       */
      function debounce(func, wait, context) {
        var timer;
        return function debounced() {
          var context = $scope,
              args = Array.prototype.slice.call(arguments);
          $timeout.cancel(timer);
          timer = $timeout(function() {
            timer = undefined;
            func.apply(context, args);
          }, wait || 10);
        };
      }
      /**
       * Build handler to open/close a SideNav; when animation finishes
       * report completion in console
       */
      function buildDelayedToggler(navID) {
        return debounce(function() {
          $mdSidenav(navID)
            .toggle()
            .then(function () {
              $log.debug("toggle " + navID + " is done");
            });
        }, 200);
      }
      function buildToggler(navID) {
        return function() {
          $mdSidenav(navID)
            .toggle()
            .then(function () {
              $log.debug("toggle " + navID + " is done");
            });
        }
      }
    })
    .filter('getByOption', function() {
      return function(input, fieldName, fieldValue) {
        var i=0, len=input.length;
        for (; i<len; i++) {
          if (input[i][fieldName] === fieldValue) {
            return input[i];
          }
        }
        return null;
      }
    })
    .controller('LeftCtrl', function ($scope, $timeout, $mdSidenav, $log) {
      $scope.close = function () {
        $mdSidenav('left').close()
          .then(function () {
            $log.debug("close LEFT is done");
          });
      };
    })
    .controller('GetPageData', function($scope, $http) {
      serverCalls.getParticipants($scope, $http);
      
      
    });

})();