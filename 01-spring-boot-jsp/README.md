## SpringBoot整合JSP的步骤
1.导入jsp的相关依赖，最好一起导入servet-api、jstl相关的依赖
    <!-- 引入SpringBoot内嵌的Tomcat对JSP的解析包 -->
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <!-- 导入对jsp的依赖 -->
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <!-- 导入servlet-api相关的依赖 -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>
    <!-- 导入jstl、jsp相关的依赖 -->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.1</version>
    </dependency>
    
2.在application.properties配置文件中配置jsp的视图展示
    spring.mvc.view.prefix=/WEB-INF/views/
    spring.mvc.view.suffix=.jsp
    
3.build中需要配置文件编译的信息(相当于把jsp页面打包进来)
    <!-- 配置编译目录，将文件编译到指定的目录下，就可以在运行入口类的时候访问jsp页面 -->
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.*</include>
        </includes>
      </resource>
      <resource>
        <directory>src/main/web</directory>
        <targetPath>META-INF/resources</targetPath>
        <includes>
          <include>**/*.*</include>
        </includes>
      </resource>
    </resources>
    
    ps: 编译完成查看之后，查看targer目录，会将配置都放在指定的目录下