"use strict";

(function () {


    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {

        var assetCache = [];
        console.log("This is asset cache");
        /**
         *
         * @param criteria
         * @returns {*}
         */
        this.getAssets = function (criteria) {
            $log.debug("Repository:Asset getAsset");

            var deferred = $q.defer();
            assetDal.getAssets(criteria).then(function (results) {

                // This is a data change - broadcast events here if your application requires components communication
                assetCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        /**
         * Create or update requirement.  A requirement with no ID is new.
         * @returns {{}}
         */
        this.saveAsset = function (assetToSave) {
            $log.debug("Repository:Asset - saveAsset");

            var deferred = $q.defer();
            var isUpdate = assetToSave.hasOwnProperty("id");


            $log.debug("isUpdate = " + isUpdate);
            $log.debug(JSON.stringify(assetToSave));

            assetDal.saveAsset(assetToSave).then(function (asset) {
                // Add newly created asset to cache
                if (!isUpdate) {
                    assetCache.push(asset);
                }
                deferred.resolve(asset);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        /**
         * Delete the given project
         * @param projectToDelete
         * @returns {*}
         */
        this.deleteAsset = function (assetToDelete) {
            $log.debug("Repository:Project - deleteAsset");

            var deferred = $q.defer();
            assetDal.deleteAsset(assetToDelete).then(function (asset) {
                _.remove(assetCache, {
                    id: assetToDelete.id
                });

                deferred.resolve(assetCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        $log.debug("Repository:Asset Instantiated");
    }
}());