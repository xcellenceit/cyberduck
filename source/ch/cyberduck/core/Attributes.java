package ch.cyberduck.core;

import org.apache.log4j.Logger;

/*
 *  Copyright (c) 2007 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

/**
 * @version $Id: IAttributes.java 2821 2007-02-07 09:56:57Z dkocher $
 */
public abstract class Attributes {
    private static Logger log = Logger.getLogger(Attributes.class);

    public abstract int getType();

    /**
     * @return The length of the file
     */
    public abstract double getSize();

    /**
     * @return The time the file was last modified in millis UTC or -1 if unknown
     */
    public abstract long getModificationDate();

    public abstract void setModificationDate(long millis);

    /**
     * @return The time the file was created in millis UTC or -1 if unknown
     */
    public abstract long getCreationDate();

    public abstract void setCreationDate(long millis);

    /**
     * @return The time the file was last accessed in millis UTC or -1 if unknown
     */
    public abstract long getAccessedDate();

    public abstract void setAccessedDate(long millis);

    /**
     * @return The file permission mask or null if unknown
     */
    public abstract Permission getPermission();

    public abstract void setPermission(Permission permission);

    /**
     * @return True if this path denotes a directory or is a symbolic link pointing to a directory
     */
    public abstract boolean isDirectory();

    /**
     * @return True if this path denotes a regular file or is a symbolic link pointing to a regular file
     */
    public abstract boolean isFile();

    /**
     * @return True if this path denotes a symbolic link.
     * @warn Returns false for Mac OS Classic Alias
     */
    public abstract boolean isSymbolicLink();

    /**
     * @see Path.FILE_TYPE
     * @see Path.DIRECTORY_TYPE
     * @see Path.SYMBOLIC_LINK_TYPE
     * @see #isDirectory()
     * @see #isFile()
     * @see #isSymbolicLink()
     * @param i
     */
    public abstract void setType(int i);

    public abstract void setSize(double size);

    public abstract void setOwner(String owner);

    public abstract void setGroup(String group);

    public abstract String getOwner();

    public abstract String getGroup();

    /**
     *
     * @return true if executable for user, group and world
     */
    public boolean isExecutable() {
        Permission perm = this.getPermission();
        if(null == perm) {
            log.warn("Unknown permissions");
            return true;
        }
        return perm.getOwnerPermissions()[Permission.EXECUTE]
                || perm.getGroupPermissions()[Permission.EXECUTE]
                || perm.getOtherPermissions()[Permission.EXECUTE];
    }

    /**
     *
     * @return true if readable for user, group and world
     */
    public boolean isReadable() {
        Permission perm = this.getPermission();
        if(null == perm) {
            log.warn("Unknown permissions");
            return true;
        }
        return perm.getOwnerPermissions()[Permission.READ]
                || perm.getGroupPermissions()[Permission.READ]
                || perm.getOtherPermissions()[Permission.READ];
    }

    /**
     *
     * @return true if writable for user, group and world
     */
    public boolean isWritable() {
        Permission perm = this.getPermission();
        if(null == perm) {
            log.warn("Unknown permissions");
            return true;
        }
        return perm.getOwnerPermissions()[Permission.WRITE]
                || perm.getGroupPermissions()[Permission.WRITE]
                || perm.getOtherPermissions()[Permission.WRITE];
    }
}
