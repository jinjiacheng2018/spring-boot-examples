# spring-boot-examples by jason
SpringBoot学习示例

## 01-spring-boot-jsp
SpringBoot整合JSP进行web开发

## 02-spring-boot-mybatis
SpringBoot整合MyBatis查询数据库

## 03-spring-boot-redis
SpringBoot整合MyBatis、Redis查询数据库,使用缓存
    
    定时任务示例:
    @EnableScheduling
    @Service(value = "employeeService")
    public class EmployeeServiceImpl implements EmployeeService {
        @Scheduled(cron = "*/5 * * * * ?")
        public void autoScheduled(){
            System.err.println("auto run....");
        }
    ｝
    
