"use strict";
(function () {

    angular.module("app")
        .controller("itemController",
        ["$log", "itemRepository", ItemCtrl]);

    function ItemCtrl ($log, itemRepository) {
        var vm = this;
        console.log("***Item controller loaded***");

        vm.controllerName = "itemController";

        itemRepository.getItems().then(function (results) {
            console.log("***Item controller in success the value of results is***");
            console.log(results);
            vm.items = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });
    }
}());