"use strict";
 +
 +(function () {
 +    /**
 +     * Manages individual assets within a ng-repeat set
 +     */
 +    angular.module('app')
 +        .controller("asset",
 +        ["$state", "assetRepository", AssetItemCtrl]);
 +
 +    function AssetItemCtrl($state, assetRepository) {
 +        var vm = this;
            // name constant - for trace and debugging
 +        vm.controllerName = "assetItemController";
 +
 +        vm.delete = function (asset) {
 +            var waitingDialog;
 +            BootstrapDialog.confirm({
 +                message: 'Are you sure that you want to delete this asset?',
 +                type: BootstrapDialog.TYPE_WARNING,
 +                btnOKLabel: 'Delete!',
 +                btnOKClass: 'btn-warning',
 +                callback: function (confirmed) {
 +                    if (confirmed) {
 +                        waitingDialog = BootstrapDialog.show({
 +                            message: 'Please wait - Deleting asset'
 +                        });
 +                        assetRepository.deleteAsset(asset).then(function () {
 +                            waitingDialog.close();
 +                        }, function (error) {
 +                            // TODO error
 +                        });
 +                    }
 +                }
 +            })
 +        };
 +
 +        vm.amend = function (asset) {
 +           //TODO amend
 +        };
 +    }
 +
 +}());
