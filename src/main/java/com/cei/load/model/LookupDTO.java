package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LookupDTO.
 */

@Getter
@Setter
public class LookupDTO {

  /** The id. */  
  private String id;

  /** The name. */  
  private String name;

  /**
   * Instantiates a new lookup DTO.
   */
  public LookupDTO() {

  }

  /**
   * Instantiates a new lookup DTO.
   *
   * @param id
   *          the id
   * @param name
   *          the name
   */
  public LookupDTO(String id, String name) {
    this.id = id;
    this.name = name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LookupDTO other = (LookupDTO) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

}
