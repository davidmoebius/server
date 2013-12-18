/*
 * Copyright (C) 2013 tarent AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.osiam.storage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Address Entity
 */
@Entity
@Table(name = "scim_address")
public class AddressEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column
    @Enumerated(EnumType.STRING)
    private CanonicalAddressTypes type;

    @Column
    private String formatted;

    @Column
    private String streetAddress;

    @Column
    private String locality;

    @Column
    private String region;

    @Column
    private String postalCode;

    @Column
    private String country;

    @Column(name = "postgresql_does_not_like_primary")
    private Boolean primary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getType() {
        if (type != null) {
            return type.toString();
        }
        return null;
    }

    public void setType(String type) {
        if (type != null) {
            this.type = CanonicalAddressTypes.valueOf(type);
        }
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((formatted == null) ? 0 : formatted.hashCode());
        result = prime * result + ((locality == null) ? 0 : locality.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((primary == null) ? 0 : primary.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override                             // NOSONAR : Cyclomatic complexity can't be reduced
    public boolean equals(Object obj) {   // NOSONAR : Sadly this method is that long
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AddressEntity other = (AddressEntity) obj;
        if (country == null) {
            if (other.country != null) {
                return false;
            }
        } else if (!country.equals(other.country)) {
            return false;
        }
        if (formatted == null) {
            if (other.formatted != null) {
                return false;
            }
        } else if (!formatted.equals(other.formatted)) {
            return false;
        }
        if (locality == null) {
            if (other.locality != null) {
                return false;
            }
        } else if (!locality.equals(other.locality)) {
            return false;
        }
        if (postalCode == null) {
            if (other.postalCode != null) {
                return false;
            }
        } else if (!postalCode.equals(other.postalCode)) {
            return false;
        }
        if (primary == null) {
            if (other.primary != null) {
                return false;
            }
        } else if (!primary.equals(other.primary)) {
            return false;
        }
        if (region == null) {
            if (other.region != null) {
                return false;
            }
        } else if (!region.equals(other.region)) {
            return false;
        }
        if (streetAddress == null) {
            if (other.streetAddress != null) {
                return false;
            }
        } else if (!streetAddress.equals(other.streetAddress)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    public enum CanonicalAddressTypes {
        work, home, other
    }
}