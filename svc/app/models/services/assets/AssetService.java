package models.services.assets;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import javax.inject.Inject;

/**
 * Created by a614407 on 20/01/2016.
 */
public class AssetService extends Service {

    private CreateAssetServiceOperation createAssetServiceOperation;

    private ListAssetsServiceOperation listAssetsServiceOperation;

    private UpdateAssetServiceOperation updateAssetServiceOperation;

    private GetAssetServiceOperation getAssetServiceOperation;

    private DeleteAssetServiceOperation deleteAssetServiceOperation;

    private JSONHelper jsonHelper;

    @Inject
    public AssetService(UnavailableServiceOperation unavailableServiceOperation,
                        CreateAssetServiceOperation createAssetServiceOperation,
                        ListAssetsServiceOperation listAssetsServiceOperation,
                        UpdateAssetServiceOperation updateAssetServiceOperation,
                        GetAssetServiceOperation getAssetServiceOperation,
                        DeleteAssetServiceOperation deleteAssetServiceOperation,
                        JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.createAssetServiceOperation = createAssetServiceOperation;
        this.getAssetServiceOperation = getAssetServiceOperation;
        this.updateAssetServiceOperation = updateAssetServiceOperation;
        this.listAssetsServiceOperation = listAssetsServiceOperation;
        this.deleteAssetServiceOperation = deleteAssetServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listAssetsServiceOperation.execute(jsonHelper.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateAssetServiceOperation.execute(jsonResource);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return getAssetServiceOperation.execute(identifier);
    }

    @Override
    public JsonNode delete(JsonNode identifier)
    {
        return deleteAssetServiceOperation.execute(identifier);
    }
}
