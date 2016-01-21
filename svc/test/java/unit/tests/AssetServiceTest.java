package tests;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.UnavailableServiceOperation;
import models.services.assets.*;
import org.junit.*;
import org.junit.Assert.*;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

/**
 * Created by a614407 on 20/01/2016.
 */


public class AssetServiceTest {
    private AssetService assetService;
    private AssetServiceBuilder assetServiceBuilder;


    @Before
    public void init()
    {
        assetServiceBuilder = new AssetServiceBuilder();
        assetServiceBuilder.AssetTestServiceObject();

        assetService = new AssetService(
                new UnavailableServiceOperation(new JSONHelper()),
            assetServiceBuilder.getMockCreateAssetServiceOperation(),
            assetServiceBuilder.getMockListAssetServiceOperation(),
            assetServiceBuilder.getMockUpdateAssetServiceOperation(),
            assetServiceBuilder.getMockGetAssetServiceOperation(),
            assetServiceBuilder.getMockDeleteAssetServiceOperation(),
            new JSONHelper());
    }
    @Test
    public void testCreateAssetService()
    {
        JsonNode jsonNode = assetService.create(assetServiceBuilder.getMockJsonNode());
        assertEquals(assetServiceBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testListAssetService()
    {
        JsonNode jsonNode = assetService.list();
        assertEquals(new JSONHelper().toJson(""),jsonNode);
    }

    @Test
    public void testUpdateAssetService()
    {
        JsonNode jsonNode = assetService.update(assetServiceBuilder.getMockJsonNode());
        assertEquals(assetServiceBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testGetAssetService()
    {
        JsonNode jsonNode = assetService.find(assetServiceBuilder.getMockJsonNode());
        assertEquals(assetServiceBuilder.getMockJsonNode(), jsonNode);
    }

    @Test
    public void testDeleteAssetService()
    {
        JsonNode jsonNode = assetService.delete(assetServiceBuilder.getMockJsonNode());
        assertEquals(assetServiceBuilder.getMockJsonNode(), jsonNode);
    }
}




