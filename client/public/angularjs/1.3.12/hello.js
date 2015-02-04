angular.module('helloApp', [])
    .controller('HelloController', ['$scope', '$http', function ($scope, $http) {
        $http.get('http://rest-service.guides.spring.io/greeting')
            .success(function (data) {
                $scope.greeting = data;
            });
    }]);