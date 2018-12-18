package com.tgram.sboot.core;

/**
 *<p> Description: 实体类 </p>
 *<p> Copyright: Copyright(c) 2018/12/18 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/18 16:20
 */
public abstract class Entity {

    private Integer offset;

    private Integer size;

    private Integer pageSize;

    private Integer pageNo;

    private Integer currentPage;

    public Integer getOffset()
    {
        if(offset == null && pageNo != null && pageSize != null)
            return (pageNo -1 ) * pageSize;
        else
            return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.pageSize = size;
        this.size = size;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.currentPage = pageNo;
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.size = pageSize;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.pageNo = currentPage;
        this.currentPage = currentPage;
    }
}
