package tests;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.assets.*;
import org.mockito.Mockito;

/**
 * Created by a614407 on 20/01/2016.
 */
public class AssetServiceBuilder {

    private AssetService mockAssetService;

    private JsonNode mockJsonNode;
    private CreateAssetServiceOperation mockCreateAssetServiceOperation;
    private GetAssetServiceOperation mockGetAssetServiceOperation;
    private UpdateAssetServiceOperation mockUpdateAssetServiceOperation;
    private ListAssetsServiceOperation mockListAssetServiceOperation;
    private DeleteAssetServiceOperation mockDeleteAssetServiceOperation;


    void AssetTestServiceObject() {

        mockJsonNode = Mockito.mock(JsonNode.class);
        mockCreateAssetServiceOperation = Mockito.mock(CreateAssetServiceOperation.class);
        mockGetAssetServiceOperation = Mockito.mock(GetAssetServiceOperation.class);
        mockUpdateAssetServiceOperation = Mockito.mock(UpdateAssetServiceOperation.class);
        mockListAssetServiceOperation = Mockito.mock(ListAssetsServiceOperation.class);
        mockDeleteAssetServiceOperation = Mockito.mock(DeleteAssetServiceOperation.class);

        Mockito.when(mockGetAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockUpdateAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockListAssetServiceOperation.execute(new JSONHelper().toJson(""))).thenReturn(new JSONHelper().toJson(""));
        Mockito.when(mockCreateAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockDeleteAssetServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
    }


    public CreateAssetServiceOperation getMockCreateAssetServiceOperation() {
        return mockCreateAssetServiceOperation;
    }

    public GetAssetServiceOperation getMockGetAssetServiceOperation() {
        return mockGetAssetServiceOperation;
    }

    public UpdateAssetServiceOperation getMockUpdateAssetServiceOperation() {
        return mockUpdateAssetServiceOperation;
    }

    public ListAssetsServiceOperation getMockListAssetServiceOperation() {
        return mockListAssetServiceOperation;
    }

    public DeleteAssetServiceOperation getMockDeleteAssetServiceOperation()
    {
        return mockDeleteAssetServiceOperation;
    }

    public JsonNode getMockJsonNode()
    {
        return mockJsonNode;
    }
}
