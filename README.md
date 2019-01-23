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
    
    注意：在使用@Scheduled注解的类头或主启动类头要使用@EnableScheduling注解开启定时任务
    
## 04-spring-boot-druid
SpringBoot整合阿里巴巴的druid数据源连接数据库

## 05-spring-boot-mybatisplus
SpringBoot整合MyBatisPlus操作数据库

## 06-spring-boot-rabbitmq
SpringBoot整合RabbitMQ消息队列，实现消息的发送接收    
