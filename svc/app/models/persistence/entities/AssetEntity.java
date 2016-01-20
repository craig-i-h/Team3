package models.persistence.entities;

import javax.persistence.*;

/**
 * Created by a614407 on 19/01/2016.
 */
@Table(name = "asset")
@Entity
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "asset_owner", nullable = false)
    private String asset_owner;

    @Column(name = "asset_type", nullable = false)
    private String asset_type;

    @Column(name = "additional_information", nullable = false)
    private String additional_information;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsset_owner() {
        return asset_owner;
    }

    public void setAsset_owner(String asset_owner) {
        this.asset_owner = asset_owner;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }
}
