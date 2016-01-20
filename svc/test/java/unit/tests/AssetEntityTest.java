package tests;

import static org.junit.Assert.assertEquals;
import models.persistence.entities.AssetEntity;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by a614407 on 19/01/2016.
 */
public class AssetEntityTest {

    AssetEntity assetEntity = new AssetEntity();

    @Test
    public void testSetIdReturnsId()
    {
        assetEntity.setId(11);
        assertEquals(assetEntity.getId(),11);
    }

    @Test
    public void testSetAssetOwnerReturnsAssetOwner()
    {
        assetEntity.setAsset_owner("Rob");
        assertEquals(assetEntity.getAsset_owner(), "Rob");
    }

    @Test
    public void testSetAssetTypeReturnsAssetType()
    {
        assetEntity.setAsset_type("Type Of Asset");
        assertEquals(assetEntity.getAsset_type(), "Type Of Asset");
    }

    @Test
    public void testAdditionalInformationReturnsAdditionalInformation ()
    {
     assetEntity.setAdditional_information("Info");
        assertEquals(assetEntity.getAdditional_information(), "Info");
    }
}
