<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
    
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <meta equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Angular Material style sheet -->
  	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
  	<link href="./css/comunioserver.css" type="text/css" rel="stylesheet">
</head>
<body ng-app="ComunioServer" ng-controller="GetPageData" ng-cloak>
  
  
  <!-- Angular Material requires Angular.js Libraries -->
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular-route.js"></script> 
  	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
  	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.6.0/angular-material-icons.min.js"></script>
	
  	<!-- Angular Material Library -->
  	<script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
  	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.6.0/angular-material-icons.min.js"></script>
  	<script src="./js/comunioserver.js"></script>
  	
	<h1 class="md-display-1">Hello World!</h1>
 
	<div ng-cloak>
  		<md-content>
    		<md-tabs md-dynamic-height md-border-bottom>
      			<md-tab label="one">
			        <md-content ng-controller="AppCtrl" class="md-padding">
				       	<h1 class="md-display-2">{{ displayedPlayer }}</h1>
						<div layout="column" style="height:100%;" ng-cloak>
	  						<section layout="row" flex>
	    						<md-sidenav class="md-sidenav-left md-whiteframe-z2" md-component-id="left" md-is-locked-open="$mdMedia('gt-md')">
	      							<md-toolbar layout="row" class="md-theme-indigo" ng-controller="LeftCtrl">
	        							<md-button flex="10" ng-click="close()" class="md-primary" hide-gt-md>
	          								<ng-md-icon icon="arrow_back" style="fill: white"></ng-md-icon>
	        							</md-button>
	        							<h1 flex class="md-toolbar-tools">Sidenav Left</h1>
	      							</md-toolbar>
	      							<md-content layout-padding>
	        							<p>Selected Value: <span class="radioValue">{{ selectedPlayer }}</span> </p>
									    <md-radio-group ng-model="selectedPlayer">
									    	<md-radio-button value="{{ clasificationOption.option }}" class="md-primary">{{ clasificationOption.display }}</md-radio-button>
									    	<div ng-repeat="participant in participants">
									      		<md-radio-button value="{{ participant.table_name }}">{{ participant.name }}</md-radio-button>
									    	</div>
									    </md-radio-group>
	      							</md-content>
	    						</md-sidenav>
	    						<md-content flex layout-padding>
	      							<div layout="column" layout-fill layout-align="top left">
	        							<div>
	          								<md-button class="md-raised md-primary" ng-click="toggleLeft()" class="md-primary" hide-gt-md>Toggle left</md-button>
	        							</div>
	        							<div class="slide-animate" ng-include="template.url"></div>
	      							</div>
	      							<div flex></div>
	    						</md-content>
	    					</section>
						</div>
			        </md-content>
			    </md-tab>
      			<md-tab label="two">
        			<md-content class="md-padding">
          				<h1 class="md-display-2">Tab Two</h1>
	  					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla venenatis ante augue. Phasellus volutpat neque ac dui mattis vulputate. Etiam consequat aliquam cursus. In sodales pretium ultrices. Maecenas lectus est, sollicitudin consectetur felis nec, feugiat ultricies mi. Aliquam erat volutpat. Nam placerat, tortor in ultrices porttitor, orci enim rutrum enim, vel tempor sapien arcu a tellus. Vivamus convallis sodales ante varius gravida. Curabitur a purus vel augue ultrices ultricies id a nisl. Nullam malesuada consequat diam, a facilisis tortor volutpat et. Sed urna dolor, aliquet vitae posuere vulputate, euismod ac lorem. Sed felis risus, pulvinar at interdum quis, vehicula sed odio. Phasellus in enim venenatis, iaculis tortor eu, bibendum ante. Donec ac tellus dictum neque volutpat blandit. Praesent efficitur faucibus risus, ac auctor purus porttitor vitae. Phasellus ornare dui nec orci posuere, nec luctus mauris semper.</p>
      					<p>Morbi viverra, ante vel aliquet tincidunt, leo dolor pharetra quam, at semper massa orci nec magna. Donec posuere nec sapien sed laoreet. Etiam cursus nunc in condimentum facilisis. Etiam in tempor tortor. Vivamus faucibus egestas enim, at convallis diam pulvinar vel. Cras ac orci eget nisi maximus cursus. Nunc urna libero, viverra sit amet nisl at, hendrerit tempor turpis. Maecenas facilisis convallis mi vel tempor. Nullam vitae nunc leo. Cras sed nisl consectetur, rhoncus sapien sit amet, tempus sapien.</p>
      					<p>Integer turpis erat, porttitor vitae mi faucibus, laoreet interdum tellus. Curabitur posuere molestie dictum. Morbi eget congue risus, quis rhoncus quam. Suspendisse vitae hendrerit erat, at posuere mi. Cras eu fermentum nunc. Sed id ante eu orci commodo volutpat non ac est. Praesent ligula diam, congue eu enim scelerisque, finibus commodo lectus.</p>
        			</md-content>
      			</md-tab>
      			<md-tab label="three">
        			<md-content class="md-padding">
          				<h1 class="md-display-2">Tab Three</h1>
          				<p>Integer turpis erat, porttitor vitae mi faucibus, laoreet interdum tellus. Curabitur posuere molestie dictum. Morbi eget congue risus, quis rhoncus quam. Suspendisse vitae hendrerit erat, at posuere mi. Cras eu fermentum nunc. Sed id ante eu orci commodo volutpat non ac est. Praesent ligula diam, congue eu enim scelerisque, finibus commodo lectus.</p>
        			</md-content>
      			</md-tab>
    		</md-tabs>
  		</md-content>
	</div> 
</body>
</html>
