/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nm;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jay
 */
@Entity
@Table(name = "NM_USER", catalog = "", schema = "H")
@NamedQueries({
    @NamedQuery(name = "NmUser.findAll", query = "SELECT n FROM NmUser n")
    , @NamedQuery(name = "NmUser.findByUserid", query = "SELECT n FROM NmUser n WHERE n.userid = :userid")
    , @NamedQuery(name = "NmUser.findByUname", query = "SELECT n FROM NmUser n WHERE n.uname = :uname")
    , @NamedQuery(name = "NmUser.findByGender", query = "SELECT n FROM NmUser n WHERE n.gender = :gender")
    , @NamedQuery(name = "NmUser.findByDtid", query = "SELECT n FROM NmUser n WHERE n.dtid = :dtid")
    , @NamedQuery(name = "NmUser.findByBlid", query = "SELECT n FROM NmUser n WHERE n.blid = :blid")})
public class NmUser implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private BigDecimal userid;
    @Column(name = "UNAME")
    private String uname;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DTID")
    private BigInteger dtid;
    @Column(name = "BLID")
    private BigInteger blid;

    public NmUser() {
    }

    public NmUser(BigDecimal userid) {
        this.userid = userid;
    }

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        BigDecimal oldUserid = this.userid;
        this.userid = userid;
        changeSupport.firePropertyChange("userid", oldUserid, userid);
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        String oldUname = this.uname;
        this.uname = uname;
        changeSupport.firePropertyChange("uname", oldUname, uname);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public BigInteger getDtid() {
        return dtid;
    }

    public void setDtid(BigInteger dtid) {
        BigInteger oldDtid = this.dtid;
        this.dtid = dtid;
        changeSupport.firePropertyChange("dtid", oldDtid, dtid);
    }

    public BigInteger getBlid() {
        return blid;
    }

    public void setBlid(BigInteger blid) {
        BigInteger oldBlid = this.blid;
        this.blid = blid;
        changeSupport.firePropertyChange("blid", oldBlid, blid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NmUser)) {
            return false;
        }
        NmUser other = (NmUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nm.NmUser[ userid=" + userid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
