package com.gupao.springbootdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
	//运行，填数据库表名开始生成代码
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("ilyuc") // 作者
                .setOutputDir(projectPath + "/src/main/java") // 生成路径
                .setOpen(false)//生成后是否打开文件夹
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")  // 自定义service名
                .setMapperName("%sMapper") //自定义mapper名
                .setXmlName("%sMapper") //自定义xml名
                .setServiceImplName("I%sServiceImpl") //自定义serviceImpl名
                .setControllerName("%sController") //自定义controller名
                .setActiveRecord(false) // 不需要ActiveRecord特性的请改为false
                .setBaseResultMap(true)//生成基本的resultMap
                //.setSwagger2(true) //实体属性 Swagger2 注解
                .setBaseColumnList(true);//生成基本的SQL片段
        mpg.setGlobalConfig(config);

        //2. 数据源配置
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.3.23:3306/shop_goods?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("111111");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
//                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)//是否使用lombok注解方式
                .setEntityTableFieldAnnotationEnable(true) //实体类上面生成表名注解TableName，成员变量上字段名注解TableField
                .setInclude("category")         // 要生成文件的表,多个表就传数组
                .setRestControllerStyle(true)
        ;
        mpg.setStrategy(stConfig);

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.ilyuc.material") //父包名，路径为 com.ilyuc.material.controller
                .setController("controller") //controller包名
                .setService("service") //servcie包名
                .setMapper("dao") //dao包名
                .setEntity("entity") //实体类文件名
                .setXml("mapper"); //mapper.xml
        mpg.setPackageInfo(pkConfig);

        //5. 自定义模板
        TemplateConfig template = new TemplateConfig();
        template.setController("templates/mycontroller.java.vm")
//                .setService("templates/myservice.vm")
//                .setServiceImpl("templates/myserviceImpl.vm")
//                .setMapper("templates/mymapper.vm")
//                .setXml("templates/myxml.vm")
//                .setEntity("templates/myentity.vm")
        ;
        mpg.setTemplate(template);//或者注解掉使用默认模板

        mpg.execute();

    }

}
