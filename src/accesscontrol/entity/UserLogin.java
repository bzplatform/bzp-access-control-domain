package accesscontrol.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {
  @Id
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @OneToOne
  private User user;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "password", nullable = false)
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (user != null && user.getId() != null ? user.getId().hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
if (!(object instanceof UserLogin)) {
      return false;
    }
    UserLogin other = (UserLogin) object;
    if (user != null && other != null && (this.user.getId() != other.user.getId() && (this.user.getId() == null || !this.user.getId().equals(other.user.getId())))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.semanticprogrammer.app.accesscontrol.persistence.UserLogin[userId=" + (user == null ? "" : user.getId()) + "]";
  }
}