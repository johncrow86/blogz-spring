package org.launchcode.blogz.models;

import java.util.Objects;

public abstract class Entity {

	private final int UID;
	private static int totalEntity = 0;
	
	public Entity() {
		totalEntity++;
		UID = totalEntity;
	}
	
	public int getUID() {
		return UID;
	}
	
	@Override
	public boolean equals(Object o) {
		
	    // self check
	    if (this == o)
	        return true;
	    
	    // null check
	    if (o == null)
	        return false;
	    
	    // type check and cast
	    if (!(o instanceof Entity))
	        return false;
	    
	    Entity e = (Entity) o;
	    
	    // field comparison
	    return Objects.equals(UID, e.UID);
	}
}