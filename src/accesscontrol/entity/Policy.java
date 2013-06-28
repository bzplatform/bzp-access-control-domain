package accesscontrol.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Basic(optional = false)
   @Column(name = "application")
   private String application;
   @Basic(optional = false)
   @Column(name = "uri_expression")
   private String uriExpression;
   @Basic(optional = false)
   @Column(name = "effect")
   private String effect;
   @JoinColumn(name = "role_id")
   @ManyToOne(optional = false)
   private Role role;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getApplication() {
      return application;
   }

   public void setApplication(String application) {
      this.application = application;
   }

   public String getUriExpression() {
      return uriExpression;
   }

   public void setUriExpression(String uriExpression) {
      this.uriExpression = uriExpression;
   }

   public String getEffect() {
      return effect;
   }

   public void setEffect(String effect) {
      this.effect = effect;
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Policy)) {
         return false;
      }
      Policy other = (Policy) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "org.semanticprogrammer.app.accesscontrol.entity.Policy[id=" + id + "]";
   }

}
