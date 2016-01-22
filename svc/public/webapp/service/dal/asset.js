"use strict";

(function () {

    angular.module("app").service("assetDal", ["dal", assetDal]);

    function assetDal (dal) {

        this.getAsset = function () {
            return dal.http.GET("asset");
        };

        this.saveAsset = function (assetToSave) {
            projectToSave.status = "In progress";
            return dal.http.POST("asset", assetToSave);
        };

        this.updateAsset = function (assetToUpdate) {
            return dal.http.PUT("asset/", assetToUpdate);
        };

        this.deleteAsset = function (assetToDelete) {
            return dal.http.DELETE("asset/", assetToDelete);
        };
    }
}());