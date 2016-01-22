"use strict";

(function () {

    angular.module('app')
        .controller("assetController",
        ["assetRepository", AssetCtrl]);

    function AssetCtrl(assetRepository ) {
        var vm = this;

        vm.controllerName = "assetController";

        assetRepository.getAsset().then(function (results) {
             vm.assets = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());