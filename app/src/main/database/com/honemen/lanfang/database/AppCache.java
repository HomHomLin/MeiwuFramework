package com.honemen.lanfang.database;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table APP_CACHE.
 */
public class AppCache {

    private Long id;
    /** Not-null value. */
    private String PackageId;
    private String Name;
    private Integer VersionCode;
    private String VersionName;
    private Long Size;
    private Boolean System;
    private String Path;
    private Long Date;
    private Boolean exportable;

    public AppCache() {
    }

    public AppCache(Long id) {
        this.id = id;
    }

    public AppCache(Long id, String PackageId, String Name, Integer VersionCode, String VersionName, Long Size, Boolean System, String Path, Long Date, Boolean exportable) {
        this.id = id;
        this.PackageId = PackageId;
        this.Name = Name;
        this.VersionCode = VersionCode;
        this.VersionName = VersionName;
        this.Size = Size;
        this.System = System;
        this.Path = Path;
        this.Date = Date;
        this.exportable = exportable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getPackageId() {
        return PackageId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPackageId(String PackageId) {
        this.PackageId = PackageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getVersionCode() {
        return VersionCode;
    }

    public void setVersionCode(Integer VersionCode) {
        this.VersionCode = VersionCode;
    }

    public String getVersionName() {
        return VersionName;
    }

    public void setVersionName(String VersionName) {
        this.VersionName = VersionName;
    }

    public Long getSize() {
        return Size;
    }

    public void setSize(Long Size) {
        this.Size = Size;
    }

    public Boolean getSystem() {
        return System;
    }

    public void setSystem(Boolean System) {
        this.System = System;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public Long getDate() {
        return Date;
    }

    public void setDate(Long Date) {
        this.Date = Date;
    }

    public Boolean getExportable() {
        return exportable;
    }

    public void setExportable(Boolean exportable) {
        this.exportable = exportable;
    }

}