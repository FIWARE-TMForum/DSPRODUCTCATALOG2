package org.tmf.dsmapi.catalog.resource;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tmf.dsmapi.commons.Utilities;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "28",
 *     "href": "http://serverlocation:port/slaManagement/serviceLevelAgreement/28",
 *     "name": "Standard SLA"
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class ServiceLevelAgreement implements Serializable {
    public final static long serialVersionUID = 1L;

    /*
    @Column(name = "SLA_ID", nullable = true)
    private String id;

    @Column(name = "SLA_HREF", nullable = true)
    private String href;

    @Column(name = "SLA_NAME", nullable = true)
    private String name;   

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */

    @Column(name = "SLA_UPDATES", nullable = true)
    private int updates;
    
    @Column(name = "SLA_UPDATES_PERIOD", nullable = true)
    private String updatesPeriod;

    @Column(name = "SLA_RESPTIME", nullable = true)
    private int respTime;

    @Column(name = "SLA_RESPTIME_UNIT", nullable = true)
    private String respTimeUnit;

    @Column(name = "SLA_DELAY", nullable = true)
    private int delay;

    @Column(name = "SLA_DELAY_UNIT", nullable = true)
    private String delayUnit;

    public ServiceLevelAgreement() {
    }

    public int getUpdates() {
        return updates;
    }

    public void setUpdates(int updates) {
        this.updates = updates;
    }

    public String getUpdatesPeriod() {
        return updatesPeriod;
    }

    public void setUpdatesPeriod(String updatesPeriod) {
        this.updatesPeriod = updatesPeriod;
    }

    public int getRespTime() {
        return respTime;
    }

    public void setRespTime(int respTime) {
        this.respTime = respTime;
    }

    public String getRespTimeUnit() {
        return respTimeUnit;
    }

    public void setRespTimeUnit(String respTimeUnit) {
        this.respTimeUnit = respTimeUnit;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getDelayUnit() {
        return delayUnit;
    }

    public void setDelayUnit(String delayUnit) {
        this.delayUnit = delayUnit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        /*
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.href != null ? this.href.hashCode() : 0);
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        */
        hash = 67 * hash + (this.updates != 0 ? Integer.valueOf(updates).hashCode() : 0);
        hash = 67 * hash + (this.updatesPeriod != null ? this.updatesPeriod.hashCode() : 0);
        hash = 67 * hash + (this.respTime != 0 ? Integer.valueOf(respTime).hashCode() : 0);
        hash = 67 * hash + (this.respTimeUnit != null ? this.respTimeUnit.hashCode() : 0);
        hash = 67 * hash + (this.delay != 0 ? Integer.valueOf(delay).hashCode() : 0);
        hash = 67 * hash + (this.delayUnit != null ? this.delayUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final ServiceLevelAgreement other = (ServiceLevelAgreement) object;
        if (Utilities.areEqual(this.updates, other.updates) == false) {
            return false;
        }

        if (Utilities.areEqual(this.updatesPeriod, other.updatesPeriod) == false) {
            return false;
        }

        if (Utilities.areEqual(this.respTime, other.respTime) == false) {
            return false;
        }

        if (Utilities.areEqual(this.respTimeUnit, other.respTimeUnit) == false) {
            return false;
        }

        if (Utilities.areEqual(this.delay, other.delay) == false) {
            return false;
        }

        if (Utilities.areEqual(this.delayUnit, other.delayUnit) == false) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ServiceLevelAgreement{" + "updates rate =" + updates + "/" + updatesPeriod +
         ", response time =" + respTime + " " + respTimeUnit +  ", delay =" + delay + " " + delayUnit + '}';
    }

    
    public static ServiceLevelAgreement createProto() {
        ServiceLevelAgreement ServiceLevelAgreement = new ServiceLevelAgreement();

        ServiceLevelAgreement.updates = 50;
        ServiceLevelAgreement.updatesPeriod = "period";
        ServiceLevelAgreement.respTime = 100;
        ServiceLevelAgreement.respTimeUnit = "respTimeUnit";
        ServiceLevelAgreement.delay = 100;
        ServiceLevelAgreement.delayUnit = "delayUnit";

        return ServiceLevelAgreement;
    }
    
}
