package models.services.assets;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.AssetEntity;
import models.services.ServiceOperation;
import play.Logger;
import javax.inject.Inject;

/**
 * Created by a614407 on 20/01/2016.
 */
public class UpdateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateAssetServiceOperation.class);

    private AssetDao dao;

    @Inject
    public UpdateAssetServiceOperation(AssetDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        AssetEntity asset= getAssetEntity(jsonRequest);

        dao.update(asset);

        return jsonRequest;
    }

    private AssetEntity getAssetEntity(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ID_PROPERTY).textValue());

        AssetEntity asset = dao.find(id);

        asset.setId(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ID_PROPERTY).longValue());

        asset.setAdditional_information(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ADDITIONAL_INFO_PROPERTY).textValue());

        asset.setAsset_owner(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_OWNER_PROPERTY).textValue());

        asset.setAsset_type(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_TYPE_PROPERTY).textValue());


        return asset;
    }
}
