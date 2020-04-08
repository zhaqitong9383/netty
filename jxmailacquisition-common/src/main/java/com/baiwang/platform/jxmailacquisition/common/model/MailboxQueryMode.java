package com.baiwang.platform.jxmailacquisition.common.model;

import com.baiwang.platform.jxmailacquisition.common.contants.BaseContants;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class MailboxQueryMode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long tenantId;
    private Long orgId;
    private Long userId;
    private String emailAddress;
    private String emailPassword;
    private String emailAddUsername;
    private Date emailAddDatetime;
    private Boolean enterpriseMailbox;
    private String lastLoginUsername;
    private Date lastLoginDatetime;
    private Date lastCollectDatetime;
    private String creater;
    private Date createDatetime;
    private String modifyUser;
    private Date modifyDatetime;
    private int pageNo;
    private int pageSize;


    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress == null ? null : StringUtils.stripToNull(emailAddress);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : StringUtils.stripToNull(emailAddress);
    }

    public String getEmailPassword() {
        return emailPassword == null ? null : StringUtils.stripToNull(emailPassword);
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword == null ? null : StringUtils.stripToNull(emailPassword);
    }

    public String getEmailAddUsername() {
        return emailAddUsername == null ? null : StringUtils.stripToNull(emailAddUsername);
    }

    public void setEmailAddUsername(String emailAddUsername) {
        this.emailAddUsername = emailAddUsername == null ? null : StringUtils.stripToNull(emailAddUsername);
    }

    public Date getEmailAddDatetime() {
        return emailAddDatetime;
    }

    public void setEmailAddDatetime(Date emailAddDatetime) {
        this.emailAddDatetime = emailAddDatetime;
    }

    public Boolean getEnterpriseMailbox() {
        return enterpriseMailbox;
    }

    public void setEnterpriseMailbox(Boolean enterpriseMailbox) {
        this.enterpriseMailbox = enterpriseMailbox;
    }

    public String getLastLoginUsername() {
        return lastLoginUsername == null ? null : StringUtils.stripToNull(lastLoginUsername);
    }

    public void setLastLoginUsername(String lastLoginUsername) {
        this.lastLoginUsername = lastLoginUsername == null ? null : StringUtils.stripToNull(lastLoginUsername);
    }

    public Date getLastLoginDatetime() {
        return lastLoginDatetime;
    }

    public void setLastLoginDatetime(Date lastLoginDatetime) {
        this.lastLoginDatetime = lastLoginDatetime;
    }

    public Date getLastCollectDatetime() {
        return lastCollectDatetime;
    }

    public void setLastCollectDatetime(Date lastCollectDatetime) {
        this.lastCollectDatetime = lastCollectDatetime;
    }

    public String getCreater() {
        return creater == null ? null : StringUtils.stripToNull(creater);
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : StringUtils.stripToNull(creater);
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getModifyUser() {
        return modifyUser == null ? null : StringUtils.stripToNull(modifyUser);
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : StringUtils.stripToNull(modifyUser);
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo <= 0 ? BaseContants.PAGE_HELPER_DEFAULT_PAGE_NUMBER : pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? BaseContants.PAGE_HELPER_DEFAULT_MINIMUM_NUMBER_OF_PER_PAGE : (pageSize > BaseContants.PAGE_HELPER_DEFAULT_MAXIMUM_NUMBER_OF_PER_PAGE ? BaseContants.PAGE_HELPER_DEFAULT_MAXIMUM_NUMBER_OF_PER_PAGE : pageSize);
    }
}
