package accesscontrol.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.annotations.PrivateOwned;

@Entity
@Table(name = "user_")
public class User implements Serializable {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(name = "name", nullable = false)
   private String name;
   @Basic(optional = false)
   @Column(name = "active")
   private boolean active;   
   @Column(name = "remote_ip")
   private String remoteIp;
//  @Basic(fetch=FetchType.EAGER)
   @JoinTable(name = "user_role",
   joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id")},
   inverseJoinColumns = {
      @JoinColumn(name = "role_id", referencedColumnName = "id")
   })
   @ManyToMany(fetch = FetchType.LAZY)
   private List<Role> roleList;
   @JoinTable(name = "remote_user_role",
   joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "id")},
   inverseJoinColumns = {
      @JoinColumn(name = "role_id", referencedColumnName = "id")
   })
   @ManyToMany(fetch = FetchType.LAZY)
   private List<Role> remoteRoleList;
   @PrivateOwned
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
   private UserLogin login;

   public User() {
      active = true;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public List<Role> getRoleList() {
      if (roleList == null) {
         roleList = new ArrayList();
      }
      return roleList;
   }

   public void setRoleList(List<Role> roleList) {
      this.roleList = roleList;
   }

   public List<Role> getRemoteRoleList() {
      if (remoteRoleList == null) {
         remoteRoleList = new ArrayList();
      }
      return remoteRoleList;
   }

   public void setRemoteRoleList(List<Role> remoteRoleList) {
      this.remoteRoleList = remoteRoleList;
   }

   public UserLogin getLogin() {
      if (login == null) {
         login = new UserLogin();
         login.setUser(this);
      }
      return login;
   }

   public void setLogin(UserLogin login) {
      this.login = login;
   }

   public String getRemoteIp() {
      return remoteIp;
   }

   public void setRemoteIp(String remoteIp) {
      this.remoteIp = remoteIp;
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
      if (!(object instanceof User)) {
         return false;
      }
      User other = (User) object;
      if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "org.semanticprogrammer.app.accesscontrol.entity.User[id=" + id + "]";
   }
}
