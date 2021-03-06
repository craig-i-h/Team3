"use strict";

(function () {

    angular.module("app").service("itemRepository", ["$q", "$log", "itemDal", ItemRepo]);

    function ItemRepo($q, $log, itemDal) {

        var itemCache = [];
        console.log("This is item cache");

        this.getItems = function () {
            console.log("***Repository:Item getItems***");

            var deferred = $q.defer();
            itemDal.getItems().then(function (results) {
             console.log("***Repository in success the value of results is***");
              console.log(results);

                // This is a data change - broadcast events here if your application requires components communication
                itemCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        $log.debug("Repository:Item Instantiated");
    }
}());