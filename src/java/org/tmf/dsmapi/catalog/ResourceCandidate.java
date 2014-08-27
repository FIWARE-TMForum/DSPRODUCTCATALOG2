package org.tmf.dsmapi.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "42",
 *     "version": 2.8,
 *     "href": "http://serverlocation:port/catalogManagement/resourceCandidate/42",
 *     "name": "Virtual Storage Medium",
 *     "description": "Virtual Storage Medium",
 *     "lastUpdate": "2013-04-19T16:42:23-04:00",
 *     "lifecycleStatus": "Active",
 *     "validFor": {
 *         "startDateTime": "2013-04-19T16:42:23-04:00",
 *         "endDateTime": "2013-06-19T00:00:00-04:00"
 *     },
 *     "category": [
 *         {
 *             "id": "12",
 *             "href": "http://serverlocation:port/catalogManagement/resourceCategory/12",
 *             "version": "2.0",
 *             "name": "Cloud offerings"
 *         }
 *     ],
 *     "serviceLevelAgreement": {
 *         "id": "28",
 *         "href": "http://serverlocation:port/slaManagement/serviceLevelAgreement/28",
 *         "name": "Standard SLA"
 *     },
 *     "resourceSpecification": {
 *         "id": "13",
 *         "href": "http://serverlocation:port/catalogManagement/resourceSpecification/13",
 *         "name": "specification 1",
 *         "version": "1.1"
 *     }
 * }
 *
 */
@Entity
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@IdClass(ResourceCandidateId.class)
@Table(name = "CRI_RESOURCE_CANDIDATE")
public class ResourceCandidate extends AbstractCatalogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static Logger logger = Logger.getLogger(ResourceCandidate.class.getName());

    @Embedded
    @ElementCollection
    @CollectionTable(name = "CRI_RESOURCE_R_CATEGORY", joinColumns = {
        @JoinColumn(name = "CATALOG_ID", referencedColumnName = "CATALOG_ID"),
        @JoinColumn(name = "CATALOG_VERSION", referencedColumnName = "CATALOG_VERSION"),
        @JoinColumn(name = "ENTITY_ID", referencedColumnName = "ID"),
        @JoinColumn(name = "ENTITY_VERSION", referencedColumnName = "VERSION")
    })
    private List<Reference> category;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "SLA_ID")),
        @AttributeOverride(name = "version", column = @Column(name = "SLA_VERSION")),
        @AttributeOverride(name = "href", column = @Column(name = "SLA_HREF")),
        @AttributeOverride(name = "name", column = @Column(name = "SLA_NAME")),
        @AttributeOverride(name = "description", column = @Column(name = "SLA_DESCRIPTION"))
    })
    private Reference serviceLevelAgreement;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "RESOURCE_SPEC_ID")),
        @AttributeOverride(name = "version", column = @Column(name = "RESOURCE_SPEC_VERSION")),
        @AttributeOverride(name = "href", column = @Column(name = "RESOURCE_SPEC_HREF")),
        @AttributeOverride(name = "name", column = @Column(name = "RESOURCE_SPEC_NAME")),
        @AttributeOverride(name = "description", column = @Column(name = "RESOURCE_SPEC_DESCRIPTION"))
    })
    private Reference resourceSpecification;

    public ResourceCandidate() {
    }

    public List<Reference> getCategory() {
        return category;
    }

    public void setCategory(List<Reference> category) {
        this.category = category;
    }

    public Reference getServiceLevelAgreement() {
        return serviceLevelAgreement;
    }

    public void setServiceLevelAgreement(Reference serviceLevelAgreement) {
        this.serviceLevelAgreement = serviceLevelAgreement;
    }

    public Reference getResourceSpecification() {
        return resourceSpecification;
    }

    public void setResourceSpecification(Reference resourceSpecification) {
        this.resourceSpecification = resourceSpecification;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 97 * hash + super.hashCode();

        hash = 97 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 97 * hash + (this.serviceLevelAgreement != null ? this.serviceLevelAgreement.hashCode() : 0);
        hash = 97 * hash + (this.resourceSpecification != null ? this.resourceSpecification.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) == false) {
            return false;
        }

        final ResourceCandidate other = (ResourceCandidate) object;
        if (Utilities.areEqual(this.category, other.category) == false) {
            return false;
        }

        if (Utilities.areEqual(this.serviceLevelAgreement, other.serviceLevelAgreement) == false) {
            return false;
        }

        if (Utilities.areEqual(this.resourceSpecification, other.resourceSpecification) == false) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ResourceCandidate{<" + super.toString() + ">, category=" + category + ", serviceLevelAgreement=" + serviceLevelAgreement + ", resourceSpecification=" + resourceSpecification + '}';
    }

    @Override
    @JsonIgnore
    public Logger getLogger() {
        return logger;
    }

    public void edit(ResourceCandidate input) {
        if (this == null || input == this) {
            return;
        }

        super.edit(input);

        if (this.category == null) {
            this.category = input.category;
        }

        if (this.serviceLevelAgreement == null) {
            this.serviceLevelAgreement = input.serviceLevelAgreement;
        }

        if (this.resourceSpecification == null) {
            this.resourceSpecification = input.resourceSpecification;
        }
    }

    @JsonIgnore
    public boolean isValid() {
        logger.log(Level.FINE, "ResourceCandidate:valid ()");

        if (super.isValid() == false) {
            return false;
        }

        return true;
    }

    @Override
    public void getEnclosedEntities(int depth) {
        if (depth <= AbstractEntity.MINIMUM_DEPTH) {
            return;
        }

        depth--;

        if (category != null) {
            for (Reference reference : category) {
                reference.getEnitty(Category.class, depth);
            }
        }

        if (resourceSpecification != null) {
            resourceSpecification.getEnitty(ResourceSpecification.class, depth);
        }
    }

    public static ResourceCandidate createProto() {
        ResourceCandidate resourceCandidate = new ResourceCandidate();

        resourceCandidate.setId("id");
        resourceCandidate.setVersion(1.3f);
        resourceCandidate.setHref("href");
        resourceCandidate.setName("name");
        resourceCandidate.setDescription("description");
        resourceCandidate.setLastUpdate(new Date ());
        resourceCandidate.setLifecycleStatus(LifecycleStatus.ACTIVE);
        resourceCandidate.setValidFor(TimeRange.createProto ());

        resourceCandidate.category = new ArrayList<Reference>();
        resourceCandidate.category.add(Reference.createProto());

        resourceCandidate.serviceLevelAgreement = Reference.createProto();
        resourceCandidate.resourceSpecification = Reference.createProto();

        return resourceCandidate;
    }

}
