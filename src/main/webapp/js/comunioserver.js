(function(){

//http://stackoverflow.com/questions/18138504/angularjs-service-storing-http-results-to-prevent-requerying-is-there-a-bet
//http://stackoverflow.com/questions/12505760/processing-http-response-in-service?lq=1
//http://stackoverflow.com/questions/12505760/processing-http-response-in-service
//TODO quitar el ngroute
  var comunio = angular
    .module('ComunioServer', ['ngMaterial', 'ngRoute', 'ngMdIcons', 'datatables', 'ngResource'])
    .factory("appDataFactory", ['$http','$q', function($http, $q){
      
      var data = undefined;
      var last_request_failed = true;
      var promiseGetPageData = undefined;
      var interfaz = {
        urlBase : "http://localhost:8080/comunio/",
        urlRoot : "rest/services/",
        getPageDataMethodName : "get_page_data",
        getParticipantsMethodName : "get_participants",
        lenguaje : {
                      "thousands": ".",
                      "sProcessing":     "Procesando...",
                      "sLengthMenu":     "Mostrar _MENU_ registros",
                      "sZeroRecords":    "No se encontraron resultados",
                      "sEmptyTable":     "Ningún dato disponible en esta tabla",
                      "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                      "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
                      "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
                      "sInfoPostFix":    "",
                      "sSearch":         "Buscar:",
                      "sUrl":            "",
                      "sInfoThousands":  ",",
                      "sLoadingRecords": "Cargando...",
                      "oPaginate": {
                        "sFirst":    "Primero",
                        "sLast":     "Último",
                        "sNext":     "Siguiente",
                        "sPrevious": "Anterior"
                      },
                      "oAria": {
                        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                      }
                    },
        participants : [],
        classification : "",
        activeParticipants : "",
        selectedPlayer : undefined, 
        logs : "",
        clasificationOption : { option : 'clasificacion',
                                display : 'Clasificación'
                              },
        templates : [ { name: 'template1.html', url: './html/clasification.html'},
                      { name: 'template2.html', url: './html/participant.html'} ],
        getClassificationFromResponse: function (data){
          var activeParticipants = data.active_participants;
          var classification = new Array();
          for(var i=0; i<activeParticipants.length; i++){
            var score = data.scores[activeParticipants[i].table_name][data.current_round - 1];
            var row = {};
            row.position = i+1;
            row.name = activeParticipants[i].name;
            row.roundScore = score.round_score;
            row.roundScoreAssigned = score.round_score_assigned;
            row.generalScore = score.general_score;
            row.generalScoreAssigned = score.general_score_assigned * this.configuration.point_bonus;
            var participant = this.getParticipantByName(activeParticipants[i].table_name);
            row.salesMoney = participant.salesMoney;
            row.purchasesMoney = participant.purchasesMoney;
            row.gameMoney = participant.gameMoney;
            classification[i] = row;
          }
          return classification;
        },
        getPoints: function(name){
          for(var i=0; i<this.participants.length; i++){
            if(this.participants[i].name === name || this.participants[i].table_name === name){
              return this.scores[this.participants[i].table_name][this.current_round - 1].general_score_assigned;
            }
          }
        },
        fillMoney: function(){
          for(var i=0; i<this.participants.length; i++){
            this.participants[i].salesMoney = this.updateSales(this.participants[i].table_name);
            this.participants[i].purchasesMoney = this.updatePurchases(this.participants[i].table_name);
            this.participants[i].gameMoney = this.updateGameMoney(this.participants[i].table_name);
           
          }
        },
        updateSales: function(name){
          var sales = 0;
          for(var i=0; i<this.signings[name].sales.length; i++){
            sales += this.signings[name].sales[i].prize;
          }
          return sales;
        },
        updatePurchases: function(name){
          var purchases = 0;
          for(var i=0; i<this.signings[name].purchases.length; i++){
            purchases += this.signings[name].purchases[i].prize;
          }
          return purchases;
        },
        updateGameMoney: function(name){
          var gameMoney = {};
          gameMoney.goals = 0;
          gameMoney.goalkeeper = 0;
          gameMoney.torpeJornada = 0;
          gameMoney.torpeGeneral = 0;
          gameMoney.remoJugadores = 0;
          gameMoney.remoEquipos = 0;
          gameMoney.remoTrupitas = 0;
          gameMoney.specialBonus = 0;
          for(var i=0; i<this.scores[name].length; i++){
            gameMoney.goals += this.scores[name][i].goals * this.configuration.goal_bonus;
            gameMoney.goalkeeper += this.scores[name][i].goalkeeper * this.configuration.goalkeeper_bonus;
            gameMoney.torpeJornada += this.scores[name][i].round_bonus? this.configuration.round_bonus : 0;
            gameMoney.torpeGeneral += this.scores[name][i].general_bonus == 1? this.configuration.general_bonus : 0;
            gameMoney.remoJugadores += this.scores[name][i].player_penalty? this.configuration.max_players_penalty : 0;
            gameMoney.remoEquipos += this.scores[name][i].team_penalty? this.configuration.max_players_team_penalty : 0;
            gameMoney.remoTrupitas += this.scores[name][i].trupita_penalty? this.configuration.trupita : 0;
            gameMoney.specialBonus += this.scores[name][i].special_bonus;
          }
          return gameMoney;
        },
        getParticipantByName: function(name){
          for(var i=0; i<this.participants.length; i++){
            if(this.participants[i].name === name || this.participants[i].table_name === name){
              return this.participants[i];
            }
          }
        },
        getPageDataMethod : function() {
          if ( !promiseGetPageData  || last_request_failed) {
            var url = this.urlBase + this.urlRoot + this.getPageDataMethodName;
            promiseGetPageData = $http.get(url)
            .then(function(response) {
              //First function handles success
              last_request_failed = false;
              data = response.data;
              return data;
            }, function(response) {// error
              last_request_failed = true;
              return $q.reject(response);
            });
          }
          return promiseGetPageData;
        }
      }
      return interfaz;
    }])
    .controller('TabOneCtrl', ['$scope', '$timeout', '$mdSidenav', '$log', 'appDataFactory', 
      function ($scope, $timeout, $mdSidenav, $log, appDataFactory) {
      tabone = this;
      tabone.toggleLeft = buildDelayedToggler('left');
      tabone.toggleRight = buildToggler('right');
      tabone.isOpenRight = function(){
        return $mdSidenav('right').isOpen();
      };
      
      //$scope.template = $scope.templates[0];

      /**
       * Supplies a function that will continue to operate until the
       * time is up.
       */
      function debounce(func, wait, context) {
        var timer;
        return function debounced() {
          var context = tabone,
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
    }])
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
    .controller('SidenavCtrl', ['$scope', '$timeout', '$mdSidenav', '$log', function ($scope, $timeout, $mdSidenav, $log) {
      var sidenav = this;
      sidenav.close = function () {
        $mdSidenav('left').close()
          .then(function () {
            $log.debug("close LEFT is done");
          });
      };
      $scope.$watch('gpdf.selectedPlayer', function() {
        sidenav.close();
      });
    }])
    .controller('GetPageDataCtrl', ['$scope', '$filter', 'appDataFactory' , function($scope, $filter, appDataFactory) {
      var gpdf = this;
      appDataFactory.getPageDataMethod().then(function(d) {
        //lo almaceno en la factoría
        appDataFactory.current_round = d.current_round;
        appDataFactory.participants = d.participants;
        appDataFactory.activeParticipants = d.active_participants;
        appDataFactory.logs = d.logs;
        appDataFactory.scores = d.scores;
        appDataFactory.configuration = d.configuration;
        appDataFactory.signings = d.signings;
        appDataFactory.fillMoney();
        appDataFactory.classification = appDataFactory.getClassificationFromResponse(d);
        
        //Lo almaceno en el scope del controlador
        gpdf.participants = appDataFactory.participants;
        gpdf.classification = appDataFactory.classification;
        gpdf.activeParticipants = appDataFactory.active_participants;
        gpdf.logs = appDataFactory.logs;
        gpdf.clasificationOption = appDataFactory.clasificationOption;          
        gpdf.displayedPlayer = gpdf.clasificationOption.display;
        gpdf.signings = appDataFactory.signings;
        $scope.$watch('gpdf.selectedPlayer', function() {
          appDataFactory.selectedPlayer = gpdf.selectedPlayer;
          if( gpdf.selectedPlayer ===  gpdf.clasificationOption.option){
             gpdf.displayedPlayer =  gpdf.clasificationOption.display;
             gpdf.template = appDataFactory.templates[0];
          }else{
             gpdf.displayedPlayer = $filter('getByOption')(appDataFactory.participants, 'table_name', gpdf.selectedPlayer).name;
             gpdf.template = appDataFactory.templates[1];
          }
        });
        gpdf.selectedPlayer = gpdf.clasificationOption.option;

      });

      
    }])
    .controller('ClassificationTableCtrl', ['$scope', '$resource', 'DTOptionsBuilder', 'DTColumnDefBuilder', 'appDataFactory', function ($scope, $resource, DTOptionsBuilder, DTColumnDefBuilder, appDataFactory) {
      var vm = this;
      $scope.activeParticipants = appDataFactory.activeParticipants;
      $scope.classification = appDataFactory.classification;
      $scope.logs = appDataFactory.logs;
      $scope.maxLogs = 20;
      $scope.configuration = appDataFactory.configuration;
      $scope.points = appDataFactory.getPoints(appDataFactory.selectedPlayer);

      vm.dtOptions = {
        paginationType: 'full_numbers',
        displayLength: appDataFactory.activeParticipants.length,
        paging: false,
        stateSave: false,
        scrollCollapse: false,
        searching: false,
        ordering:  true, 
        "order": [[ 2, "desc"]],
        "jQueryUI":       true,
        "language": appDataFactory.lenguaje
      };

      vm.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(0).notSortable(),
        DTColumnDefBuilder.newColumnDef(1), 
        DTColumnDefBuilder.newColumnDef(2),
        DTColumnDefBuilder.newColumnDef(3)
      ];

      $scope.noLimits = function(){
        $scope.maxLogs = $scope.logs.length;
      };
      $scope.logsShowed = function(){
        return $scope.maxLogs === $scope.logs.length;
      };
    }])
    .controller('SpecificTableCtrl', ['$scope', '$resource', 'DTOptionsBuilder', 'appDataFactory', function ($scope, $resource, DTOptionsBuilder, appDataFactory) {
      var vm = this;
      $scope.scores = appDataFactory.scores[appDataFactory.selectedPlayer];
      $scope.goalsBonus = appDataFactory.configuration.goal_bonus;
      $scope.goalkeeperBonus = appDataFactory.configuration.goalkeeper_bonus;
      $scope.generalBonus = appDataFactory.configuration.general_bonus;
      $scope.roundBonus = appDataFactory.configuration.round_bonus;
      $scope.maxPlayerPenalty = appDataFactory.configuration.max_players_penalty;
      $scope.maxPlayersTeamPenalty = appDataFactory.configuration.max_players_team_penalty;
      $scope.trupita = appDataFactory.configuration.trupita;
      $scope.configuration = appDataFactory.configuration;
      $scope.$watch('gpdf.selectedPlayer', function() {
        $scope.scores = appDataFactory.scores[appDataFactory.selectedPlayer];
        for(var i=0; i<appDataFactory.participants.length; i++){
          if(appDataFactory.participants[i].table_name === appDataFactory.selectedPlayer){
            $scope.participant = appDataFactory.participants[i];
            break;
          }
        }
        $scope.signings = appDataFactory.signings[appDataFactory.selectedPlayer];
        $scope.maxSigningsIterator = $scope.signings.purchases.length>$scope.signings.sales.length? $scope.signings.purchases.length : $scope.signings.sales.length; 
        
        $scope.points = appDataFactory.getPoints(appDataFactory.selectedPlayer);
      });

      $scope.$watch('gpdf.signings', function() {
        $scope.signings = appDataFactory.signings[appDataFactory.selectedPlayer];
        $scope.maxSigningsIterator = $scope.signings.purchases.length>$scope.signings.sales.length? $scope.signings.purchases.length : $scope.signings.sales.length; 
      });

     

      vm.dtOptions = {
        paginationType: 'full_numbers',
        displayLength: appDataFactory.activeParticipants.length,
        paging: false,
        stateSave: false,
        scrollCollapse: false,
        searching: false,
        ordering:  false, 
        "autoWidth": true,
        "jQueryUI":       true,
        "language": appDataFactory.lenguaje
      };

      $scope.getTimes=function(){
           return new Array($scope.maxSigningsIterator);
      };
      
    }])
    ;

})();