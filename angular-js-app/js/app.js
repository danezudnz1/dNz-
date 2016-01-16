var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/laptop';

    $scope.laptopuri = [];
    $scope.fields = [];
    $scope.laptop = {};


    $scope.lpt = {};
    $scope.editLpt = {};



    $http.get(url).then(function successCallback(response) {

        $scope.laptopuri = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.laptopuri);
        //console.log($scope.fields);

    });


    $scope.addLaptop = function(laptop) {
        laptop.id = parseInt(laptop.id);
        console.log(laptop.id);
        $http({
            method: 'POST',
            url: url,
            data: laptop
        }).then(function successCallback(response) {
            console.log(response);
            $scope.laptopuri.push(laptop);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteLaptop = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.laptopuri = $scope.laptopuri.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateLpt = function(lpt) {
        $scope.editLpt = lpt;
    };


    $scope.updateLpt = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editLpt
        }).then(function successCallback(response) {
            $scope.editLpt = {};
            console.log(response);
            // $scope.laptopuri.push($scope.editlpt);
            // done.
        }, function errorCallback(response) {
            $scope.editLpt = {};
            console.log(response);
        });
    };

}]);

app.controller('2HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/telefon';

    $scope.telefoane = [];
    $scope.fields = [];
    $scope.telefon = {};


    $scope.tlf = {};
    $scope.editTlf = {};



    $http.get(url).then(function successCallback(response) {

        $scope.telefoane = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.telefoane);
        //console.log($scope.fields);

    });


    $scope.addTelefon = function(telefon) {
        telefon.id = parseInt(telefon.id);
        console.log(telefon.id);
        $http({
            method: 'POST',
            url: url,
            data: telefon
        }).then(function successCallback(response) {
            console.log(response);
            $scope.telefoane.push(telefon);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteTelefon = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.telefoane = $scope.telefoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateTlf = function(tlf) {
        $scope.editTlf = tlf;
    };


    $scope.updateTlf = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editTlf = {};
            console.log(response);
            // $scope.telefoane.push($scope.editTlf);
            // done.
        }, function errorCallback(response) {
            $scope.editTlf = {};
            console.log(response);
        });
    };

}]);


app.controller('3HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/student';

    $scope.studenti = [];
    $scope.fields = [];
    $scope.telefon = {};


    $scope.stud = {};
    $scope.editStud = {};



    $http.get(url).then(function successCallback(response) {

        $scope.studenti = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.studenti);
        //console.log($scope.fields);

    });


    $scope.addStudent = function(student) {
        student.id = parseInt(student.id);
        console.log(student.id);
        $http({
            method: 'POST',
            url: url,
            data: student
        }).then(function successCallback(response) {
            console.log(response);
            $scope.studenti.push(student);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteStudent = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.studenti = $scope.studenti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateStud = function(stud) {
        $scope.editStud =stud;
    };


    $scope.updateStud = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editStud
        }).then(function successCallback(response) {
            $scope.editStud = {};
            console.log(response);
            // $scope.studenti.push($scope.editTlf);
            // done.
        }, function errorCallback(response) {
            $scope.editStud = {};
            console.log(response);
        });
    };

}]);