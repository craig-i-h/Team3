package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.AssetEntity;

/**
 * Created by a614407 on 19/01/2016.
 */
public class AssetDao extends GenericDao<AssetEntity>
{

    @Inject
    public AssetDao(EntityManagerProvider emp)
    {
        super(emp);
    }

}
