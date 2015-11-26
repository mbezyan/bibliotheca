/**
 * 
 */
package bibliotheca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="Asset_Type")
public abstract class Asset implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "Asset_Id")
	private Long assetId;
	private String barcode;
	@Column(name = "Asset_Type")
	private String assetType;
	
	public String getAssetType() {
		return assetType;
	}

	public Asset() {
	}
	
	public Asset(String barcode) {
		this.barcode = barcode;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
}
