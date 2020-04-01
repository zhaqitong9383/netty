package com.baiwang.platform.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.byy.gegerator.MyFreemarkerTemplateEngine;
import com.byy.gegerator.RewriteOutFiles;
import java.util.HashMap;
import java.util.Scanner;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

/**
 * @program: CodeGenerator
 * @description: TODO
 * @author: shiqiang
 * @create: 2019-12-20 09:56
 **/
public class CodeGeneratorDemo {

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

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("shiqiang");
        gc.setFileOverride(true);
        //是否生成swagger注解
        gc.setSwagger2(true);
        gc.setOpen(false);
        //开启 BaseResultMap
        gc.setBaseResultMap(true);
        //开启 baseColumnList
        gc.setBaseColumnList(true);
        //实体命名方式
        //gc.setEntityName("%sEntity");
        //mapper 命名方式
        //gc.setMapperName("%sDao");
        //Mapper xml 命名方式
       // gc.setXmlName("%sMapper");
        //service 命名方式
        gc.setServiceName("%sServices");

        gc.setServiceImplName("%sServicesImpl");

        //controller 命名方式
        gc.setControllerName("%sController");
        //idType  这里默认NONE策略，先走全局配置策略生成，如果没有，需要自己手动输入。
        gc.setIdType(IdType.INPUT);
        gc.setEnableCache(false);
        //这里设置日期类型为Date类型
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.6.141:3306/bwadmin?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("localTest1717");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名，如：test"));
        pc.setParent(scanner("项目根路径，如：com.baiwang"));
        //pc.setParent("com.baiwang");
        pc.setPathInfo(new HashMap<>());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                /*Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);*/
            }
        };

        // 自定义输出配置
        cfg.setFileOutConfigList(RewriteOutFiles.getFileOutConfigs(projectPath,pc));
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
       // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setInclude("bw_error_code");
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setTablePrefix("bw_");
        //自定义转换实体实现
        strategy.setNameConvert(new INameConvert() {
            @Override
            public String entityNameConvert(TableInfo tableInfo) {
                return scanner("表名称:"+tableInfo.getName()+";输入实体名称，如：User");
            }

            @Override
            public String propertyNameConvert(TableField field) {
                return NamingStrategy.underlineToCamel(field.getName());
            }
        });
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new MyFreemarkerTemplateEngine(pc));
        mpg.execute();
    }
}
