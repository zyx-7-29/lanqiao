package org.taru.configer;

import org.springframework.context.annotation.*;
import org.taru.test.A5;
import org.taru.test.DaYin;

/**
     *配置类  @Configuration  相当于一个XML  <bean id="daYin" class="prg.taru.test.DaYin" />
 */
@Configuration
@ComponentScan("org.taru.test")//告知 Configuration注解 在哪个位置
@Import({Applicqtion.class})  //导入  另一个配置类
@ImportResource({"classpath:applicationContext.xml"}) //导入 XML配置文件。配置类和配置文件可以混合使用。
public class Applicqtion {
    /**
     * 默认方法名为id 或者 name
     * @param pager
     * @return
     */
    @Bean //声明一个Bean
    @Scope("singleton") //设置为单例模式
    public DaYin daYin(A5 pager){ //A5  也必须是一个 bean。就是下方的那个。且这个参数是按照类型匹配的。
        DaYin d=new DaYin(); //建立依赖 。要new 一下  再将另一个Bean的方法传进去
        d.setPage(pager());
        return d;
    }

    @Bean
    public A5 pager(){
        return new A5();
    }
}
