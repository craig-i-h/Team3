package tests;
import models.persistence.dao.impl.AssetDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.MockitoLogger;

import javax.persistence.EntityManager;
import javax.validation.constraints.AssertFalse;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by a614407 on 19/01/2016.
 */
public class AssetDaoTest {

    AssetDaoTestBuilder testBuilder = new AssetDaoTestBuilder();

    @Test
    public void testCreateAsset()
    {
        testBuilder.AssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        assetDao.create(assetEntity);

        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testDeleteAsset()
    {
        testBuilder.AssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        assetDao.create(assetEntity);
        assetDao.delete(assetEntity);

        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testUpdateAsset()
    {
        testBuilder.AssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        assetDao.create(assetEntity);
        assetDao.update(assetEntity);

        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testFindAsset()
    {
        testBuilder.AssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        assetDao.create(assetEntity);
        assetDao.find(assetEntity);

        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(assetEntity);
    }

    @Test
    public void testListAsset()
    {
        testBuilder.AssetTestObjects();
        AssetDao assetDao = new AssetDao(testBuilder.getMockEntityManagerProvider());
        AssetEntity assetEntity = testBuilder.getAsset();
        EntityManager mockEntityManager = testBuilder.getMockEntityManager();

        List<AssetEntity> assetEntities = assetDao.list();

        assertEquals(testBuilder.getMockResultList(), assetEntities);
    }
}
