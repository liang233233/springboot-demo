package com.gupao.springbootdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/*****
 * @Author: 波波
 * @Description: 云商城:代码生成案例
 ****/
public class MyBatisPlusCode {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("huliang")
                .setOpen(false)  //是否打开
                .setIdType(IdType.AUTO)
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setFileOverride(true)  //文件覆盖
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setControllerName("%sController")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
        ;
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.3.23:3306/shop_goods?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("111111")
                .setDbType(DbType.MYSQL)
        ;
        mpg.setDataSource(dsc);

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.gupao.springbootdemo") //父包名，路径为 com.ilyuc.material.controller
                .setModuleName("code") // 单独文件夹
                .setController("controller") //controller包名
                .setService("service") //servcie包名
                .setServiceImpl("service.impl") //servcie包名
                .setEntity("model") //实体类文件名
                .setMapper("mapper") //dao包名
                .setXml("xml")//mapper.xml
        ;
        mpg.setPackageInfo(pkConfig);


        TemplateConfig template = new TemplateConfig();
        template.setController("templates/controller.java.vm")
//                .setService("templates/service.vm")
//                .setServiceImpl("templates/serviceImpl.vm")
//                .setMapper("templates/mapper.vm")
//                .setXml("templates/xml.vm")
//                .setEntity("templates/entity.vm")
        ;
        mpg.setTemplate(template);//或者注解掉使用默认模板


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
//        strategy.setTablePrefix(new String[] { "tb_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setInclude(new String[]{"category_brand"})// 需要生成的表
                // 写于父类中的公共字段
                .setSuperEntityColumns("id")

//        strategy.setTablePrefix(pc.getModuleName() + "_");

                //生成 @RestController 控制器
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)

                .setEntityTableFieldAnnotationEnable(true) //字段上生成注解
                //数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //数据库表字段映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // lombok
                .setEntityLombokModel(true)
                //逻辑删除字段名
                .setLogicDeleteFieldName("is_deleted")
                //去掉布尔值的is_前缀（确保tinyint(1)）
                .setEntityBooleanColumnRemoveIsPrefix(true)
                //restful api风格控制器
                .setRestControllerStyle(true)
        ;
        mpg.setStrategy(strategy);


        mpg.execute();


        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}


    }
}