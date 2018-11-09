## SpringBoot继承MyBatis步骤
1.导入MyBatis的起步以及连接数据库的依赖

    <!-- 导入MyBatis的起步依赖 -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.2</version>
    </dependency>

    <!-- 导入连接数据库的依赖 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    
2.在application.yml配置文件中配置连接数据源的属性以及sql映射文件位置

    <!-- 连接数据库的数据源信息，注意使用最新的myslq的驱动配置的url，不配置会报错 -->
    spring:
      datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
        username: root
        password: root
    
    <!-- sql映射文件 -->
    mybatis:
      mapper-locations: classpath:mapper/*.xml

3.创建Dao层，注意需要在Dao接口层添加@Mapper注解，或者在注启动类使用@MapperScan("dao所有的包名")注解