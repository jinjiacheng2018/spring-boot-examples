package com.tgram.sboot.model;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/3/14 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/3/14 16:37
 */
public class Employee
{
    
    private Integer empId;
    
    private String empName;
    
    public Employee()
    {
    }
    
    public Employee(Integer empId, String empName)
    {
        this.empId = empId;
        this.empName = empName;
    }
    
    public Integer getEmpId()
    {
        return empId;
    }
    
    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }
    
    public String getEmpName()
    {
        return empName;
    }
    
    public void setEmpName(String empName)
    {
        this.empName = empName;
    }
    
    @Override
    public String toString()
    {
        return "Employee{" + "empId=" + empId + ", empName='" + empName + '\'' + '}';
    }
}
